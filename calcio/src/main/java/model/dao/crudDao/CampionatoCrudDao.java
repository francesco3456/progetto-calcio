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

import com.mysql.cj.jdbc.Blob;

import model.bean.CampionatoBean;
import model.daoInterface.CrudDao;
import utils.DbConnection;
import utils.logger.InformazioniLogger;

public class CampionatoCrudDao implements CrudDao<CampionatoBean> {
	
	DbConnection dbConn = new DbConnection();
	InformazioniLogger logger = new InformazioniLogger();
	
	@Override
	public List<CampionatoBean> findAll() {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		List<CampionatoBean> campionati = new ArrayList<>();
		
		String query = "SELECT * FROM campionato";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				CampionatoBean campionato = new CampionatoBean();
				
				campionato.setIdCampionato(rs.getLong("id_campionato"));
				campionato.setNomeCampionato(rs.getString("nome"));
				campionato.setNazioneCampionato(rs.getString("nazione"));
				campionato.setInizioCampionato(rs.getTimestamp("inizio").toLocalDateTime());
				campionato.setFineCampionato(rs.getTimestamp("fine").toLocalDateTime());
				campionato.setStagioneCampionato(rs.getDate("stagione").toLocalDate());
				campionato.setNumeroGiornateCampionato(rs.getInt("tot_giornate"));
				campionato.setBandieraCampionato((Blob) rs.getBlob("bandiera"));
				
				campionati.add(campionato);
				
				logger.getLogInfo("Query eseguita con successo.");
			}
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return campionati;
	}
	
	public CampionatoBean findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		CampionatoBean campionato = new CampionatoBean();
		
		String query = "SELECT * FROM campionato WHERE id_campionato = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			
			logger.getLogDebug("Id del campionato recuperato con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nel recupero dell'Id del campionato", e);
		}
		
		try {
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				campionato.setIdCampionato(id);
				campionato.setNomeCampionato(rs.getString("nome"));
				campionato.setNazioneCampionato(rs.getString("nazione"));
				campionato.setInizioCampionato(rs.getTimestamp("inizio").toLocalDateTime());
				campionato.setFineCampionato(rs.getTimestamp("fine").toLocalDateTime());
				campionato.setStagioneCampionato(rs.getDate("stagione").toLocalDate());
				campionato.setNumeroGiornateCampionato(rs.getInt("tot_giornate"));
				campionato.setBandieraCampionato((Blob) rs.getBlob("bandiera"));
			}
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return campionato;
	}
	
	public CampionatoBean update(CampionatoBean campionato) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		
		String query = "UPDATE FROM campionato SET nome = ?, nazione = ?, inizio = ?, fine = ?, stagione = ?, tot_giornate = ?, bandiera = ?, data_modifica = ? WHERE id_campionato = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, campionato.getNomeCampionato());
			ps.setString(2, campionato.getNazioneCampionato());
			ps.setTimestamp(3, Timestamp.valueOf(campionato.getInizioCampionato()));
			ps.setTimestamp(4, Timestamp.valueOf(campionato.getFineCampionato()));
			ps.setDate(5, java.sql.Date.valueOf(campionato.getStagioneCampionato()));
			ps.setInt(6, campionato.getNumeroGiornateCampionato());
			ps.setBlob(7, campionato.getBandieraCampionato());
			ps.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(9, campionato.getIdCampionato());
			
			ps.executeUpdate();
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return campionato;
	}
	
	public CampionatoBean insert(CampionatoBean campionato) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		
		String query = "INSERT INTO campionato (nome, nazione, inizio, fine, stagione, tot_giornate, bandiera, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, campionato.getNomeCampionato());
			ps.setString(2, campionato.getNazioneCampionato());
			ps.setTimestamp(3, Timestamp.valueOf(campionato.getInizioCampionato()));
			ps.setTimestamp(4, Timestamp.valueOf(campionato.getFineCampionato()));
			ps.setDate(5, java.sql.Date.valueOf(campionato.getStagioneCampionato()));
			ps.setInt(6, campionato.getNumeroGiornateCampionato());
			ps.setBlob(7, campionato.getBandieraCampionato());
			ps.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));	
			ps.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));	
			
			ps.executeUpdate();
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return campionato;
	}

	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		String query = "DELETE FROM campionato WHERE id_campionato = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
			ps.executeUpdate();
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
	}
}
