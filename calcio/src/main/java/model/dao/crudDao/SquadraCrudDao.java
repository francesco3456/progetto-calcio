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

import java.sql.Blob;

import model.daoInterface.CrudDao;
import model.dto.SquadraDto;
import utils.DbConnection;
import utils.logger.InformazioniLogger;

public class SquadraCrudDao implements CrudDao<SquadraDto> {
	
	DbConnection dbConn = new DbConnection();
	InformazioniLogger logger = new InformazioniLogger();

	@Override
	public List<SquadraDto> findAll() {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		List<SquadraDto> squadre = new ArrayList<>();
		
		String query = "SELECT * FROM squadra";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				SquadraDto squadra = new SquadraDto();
				
				squadra.setIdSquadra(rs.getLong("id_squadra"));
				squadra.setNomeSquadra(rs.getString("nome"));
				squadra.setNazionalitaSquadra(rs.getString("nazionalità"));
				squadra.setNascitaSquadra(rs.getDate("nascita").toLocalDate());
				squadra.setStadioSquadra(rs.getString("stadio"));
				squadra.setCittaSquadra(rs.getString("città"));
				squadra.setStemmaSquadra((Blob) rs.getBlob("stemma"));
				
				squadre.add(squadra);
			}
			
			logger.logInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
		return squadre;
	}

	@Override
	public SquadraDto update(SquadraDto squadra) {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		
		String query = "UPDATE squadra SET nome = ?, nazionalità = ?, nascita = ?, stadio = ?, città = ?, stemma = ?, data_modifica = ? WHERE id_squadra = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, squadra.getNomeSquadra());
			ps.setString(2, squadra.getNazionalitaSquadra());
			ps.setDate(3, java.sql.Date.valueOf(squadra.getNascitaSquadra()));
			ps.setString(4, squadra.getStadioSquadra());
			ps.setString(5, squadra.getCittaSquadra());
			ps.setBlob(6, squadra.getStemmaSquadra());
			ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(8, squadra.getIdSquadra());
			
			ps.executeUpdate();
			
			logger.logInfo("Query eseguita con successo.");
			
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
		return squadra;
	}

	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		String query = "DELETE FROM squadra WHERE id_squadra = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
			ps.executeUpdate();
			
			logger.logInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
	}

	@Override
	public SquadraDto insert( SquadraDto squadra) {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		
		String query = "INSERT INTO squadra (nome, nazionalità, nascita, stadio, città, stemma, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, squadra.getNomeSquadra());
			ps.setString(2, squadra.getNazionalitaSquadra());
			ps.setDate(3, java.sql.Date.valueOf(squadra.getNascitaSquadra()));
			ps.setString(4, squadra.getStadioSquadra());
			ps.setString(5, squadra.getCittaSquadra());
			ps.setBlob(6, squadra.getStemmaSquadra());
			ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
			
			ps.executeUpdate();
			
			logger.logInfo("Query eseguita con successo.", squadra);
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
		return squadra;
	}

	@Override
	public SquadraDto findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		SquadraDto squadra = new SquadraDto();
		
		String query = "SELECT * FROM squadra WHERE id_squadra = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
			logger.logDebug("Id della squadra recuperato con successo.");
			
		} catch(SQLException e) {
			logger.logError("Errore nel recupero dell'Id della squadra", e);
		}
		
		try {
			rs = ps.executeQuery();
			
			while(rs.next()) {
			
			squadra.setIdSquadra(id);
			squadra.setNomeSquadra(rs.getString("nome"));
			squadra.setNazionalitaSquadra(rs.getString("nazionalità"));
			squadra.setNascitaSquadra(rs.getDate("nascita").toLocalDate());
			squadra.setStadioSquadra(rs.getString("stadio"));
			squadra.setCittaSquadra(rs.getString("città"));
			squadra.setStemmaSquadra((Blob) rs.getBlob("stemma"));
			
			logger.logInfo("Query eseguita con successo.");
			
			}
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
		return squadra;
	}

}
