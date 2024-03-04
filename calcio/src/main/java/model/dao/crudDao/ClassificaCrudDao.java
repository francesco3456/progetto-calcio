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
import model.dto.ClassificaDto;
import utils.DbConnection;
import utils.logger.InformazioniLogger;

public class ClassificaCrudDao implements CrudDao<ClassificaDto> {
	
	DbConnection dbConn = new DbConnection();
	InformazioniLogger logger = new InformazioniLogger();
	
	@Override
	public List<ClassificaDto> findAll() {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		List<ClassificaDto> punteggi = new ArrayList<>();
		
		String query = "SELECT * FROM classifica";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				ClassificaDto punteggio = new ClassificaDto();
				
				punteggio.setIdClassifica(rs.getLong("id_classifica"));
				punteggio.setPuntiSquadra(rs.getInt("punti"));
				punteggio.setGoalFattiSquadra(rs.getInt("gol_fatti"));
				punteggio.setGoalSubitiSquadra(rs.getInt("gol_subiti"));
				punteggio.setDifferenzaRetiSquadra(rs.getInt("differenza_reti"));
				punteggio.setVittorieSquadra(rs.getInt("win"));
				punteggio.setPareggiSquadra(rs.getInt("pari"));
				punteggio.setSconfitteSquadra(rs.getInt("lose"));
				punteggio.setIdSquadra(rs.getLong("squadra_fk"));
				
				punteggi.add(punteggio);
			}
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return punteggi;
	}
	
	@Override
	public ClassificaDto findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		ClassificaDto punteggio = new ClassificaDto();
		
		String query = "SELECT * FROM classifica WHERE id_classifica = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			
			logger.getLogDebug("Id della classifica recuperato con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nel recupero dell'Id della classifica", e);
		}
		
		try {
			rs = ps.executeQuery();
			
			punteggio.setIdClassifica(id);
			punteggio.setPuntiSquadra(rs.getInt("punti"));
			punteggio.setGoalFattiSquadra(rs.getInt("gol_fatti"));
			punteggio.setGoalSubitiSquadra(rs.getInt("gol_subiti"));
			punteggio.setDifferenzaRetiSquadra(rs.getInt("differenza_reti"));
			punteggio.setVittorieSquadra(rs.getInt("win"));
			punteggio.setPareggiSquadra(rs.getInt("pari"));
			punteggio.setSconfitteSquadra(rs.getInt("lose"));
			punteggio.setIdSquadra(rs.getLong("squadra_fk"));
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return punteggio;
	}
	
	@Override
	public ClassificaDto update(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		ClassificaDto punteggio = new ClassificaDto();
		
		String query = "UPDATE FROM classifica SET punti = ?, gol_fatti = ?, gol_subiti = ?, differenza_reti = ?, win = ?, pari = ?, lose = ?, squadra_fk = ?, data_modifica = ? WHERE id_classifica = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, punteggio.getPuntiSquadra());
			ps.setInt(2, punteggio.getGoalFattiSquadra());
			ps.setInt(3, punteggio.getGoalSubitiSquadra());
			ps.setInt(4, punteggio.getDifferenzaRetiSquadra());
			ps.setInt(5, punteggio.getVittorieSquadra());
			ps.setInt(6, punteggio.getPareggiSquadra());
			ps.setInt(7, punteggio.getSconfitteSquadra());
			ps.setLong(8, punteggio.getIdSquadra());
			ps.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(10, id);
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return punteggio;
	}
	
	@Override
	public ClassificaDto insert() {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		ClassificaDto punteggio = new ClassificaDto();
		
		String query = "INSERT INTO classifica (punti, gol_fatti, gol_subiti, differenza_reti, win, pari, lose, squadra_fk, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, punteggio.getPuntiSquadra());
			ps.setInt(2, punteggio.getGoalFattiSquadra());
			ps.setInt(3, punteggio.getGoalSubitiSquadra());
			ps.setInt(4, punteggio.getDifferenzaRetiSquadra());
			ps.setInt(5, punteggio.getVittorieSquadra());
			ps.setInt(6, punteggio.getPareggiSquadra());
			ps.setInt(7, punteggio.getSconfitteSquadra());
			ps.setLong(8, punteggio.getIdSquadra());
			ps.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(10, Timestamp.valueOf(LocalDateTime.now()));
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return punteggio;
	}
	
	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		String query = "DELETE FROM classifica WHERE id_classifica = ?";
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

}
