package model.dao.crudDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.daoInterface.CrudDao;
import model.dto.GiornataDto;
import utils.DbConnection;
import utils.logger.InformazioniLogger;

public class GiornataCrudDao implements CrudDao<GiornataDto> {
	
	DbConnection dbConn = new DbConnection();
	InformazioniLogger logger = new InformazioniLogger();

	@Override
	public List<GiornataDto> findAll() {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		List<GiornataDto> giornate = new ArrayList<>();
		
		String query = "SELECT * FROM giornata";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				GiornataDto giornata = new GiornataDto();
				
				giornata.setIdGiornata(rs.getLong("id_giornata"));
				giornata.setInizioGiornata(rs.getTimestamp("inizio").toLocalDateTime());
				giornata.setFineGiornata(rs.getTimestamp("fine").toLocalDateTime());
				
				giornate.add(giornata);
			}
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return giornate;
	}

	@Override
	public GiornataDto update(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		GiornataDto giornata = new GiornataDto();
		
		String query = "UPDATE FROM giornata SET inizio = ?, fine = ?, data_modifica = ? WHERE id_giornata = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setTimestamp(1, Timestamp.valueOf(giornata.getInizioGiornata()));
			ps.setTimestamp(2, Timestamp.valueOf(giornata.getFineGiornata()));
			ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(4, id);
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return giornata;
	}

	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		String query = "DELETE FROM giornata WHERE id_giornata = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
	}

	@Override
	public GiornataDto insert() {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		GiornataDto giornata = new GiornataDto();
		
		String query = "INSERT INTO giornata (inizio, fine, data_creazione, data_modifica) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setTimestamp(1, Timestamp.valueOf(giornata.getInizioGiornata()));
			ps.setTimestamp(2, Timestamp.valueOf(giornata.getFineGiornata()));
			ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogInfo("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return giornata;
	}

	@Override
	public GiornataDto findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		GiornataDto giornata = new GiornataDto();
		
		String query = "SELECT * FROM giornata WHERE id_giornata = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			
			logger.getLogDebug("Id della giornata recuperato con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nel recupero dell'Id della giornata", e);
		}
		
		try {
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				giornata.setIdGiornata(rs.getLong("id_giornata"));
				giornata.setInizioGiornata(rs.getTimestamp("inizio").toLocalDateTime());
				giornata.setFineGiornata(rs.getTimestamp("fine").toLocalDateTime());
				
				logger.getLogInfo("Query eseguita con successo.");
			}
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return giornata;
	}

}
