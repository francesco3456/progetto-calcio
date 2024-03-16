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
import model.dto.StatsCalciatoreDto;
import utils.DbConnection;
import utils.logger.InformazioniLogger;

public class StatsCrudDao implements CrudDao<StatsCalciatoreDto> {
	
	DbConnection dbConn = new DbConnection();
	InformazioniLogger logger = new InformazioniLogger();

	@Override
	public List<StatsCalciatoreDto> findAll() {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		List<StatsCalciatoreDto> statsCalciatori = new ArrayList<>();
		
		String query = "SELECT * FROM stats_calciatore";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
				StatsCalciatoreDto statsCalciatore = new StatsCalciatoreDto();
				
				statsCalciatore.setIdStatsCalciatore(rs.getLong("id_stats"));
				statsCalciatore.setGolCalciatore(rs.getInt("gol_calciatore"));
				statsCalciatore.setAssistCalciatore(rs.getInt("assist_calciatore"));
				statsCalciatore.setIdCalciatore(rs.getLong("calciatore"));
				
				statsCalciatori.add(statsCalciatore);			
			}
			
			logger.logInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
		return statsCalciatori;
	}

	@Override
	public StatsCalciatoreDto update(StatsCalciatoreDto statsCalciatore) {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		
		String query = "UPDATE stats_calciatore SET gol_calciatore = ?, assist_calciatore = ?, calciatore = ?, data_modifica = ? WHERE id_stats = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, statsCalciatore.getGolCalciatore());
			ps.setInt(2, statsCalciatore.getAssistCalciatore());
			ps.setLong(3, statsCalciatore.getIdCalciatore());
			ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(5, statsCalciatore.getIdStatsCalciatore());
			
			ps.executeUpdate();
			
			logger.logInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
		return statsCalciatore;
	}

	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		String query = "DELETE FROM stats_calciatore WHERE id_stats = ?";
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
	public StatsCalciatoreDto insert(StatsCalciatoreDto statsCalciatore) {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		
		String query = "INSERT INTO stats_calciatore (gol_calciatore, assist_calciatore, calciatore, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, statsCalciatore.getGolCalciatore());
			ps.setInt(2, statsCalciatore.getAssistCalciatore());
			ps.setLong(3, statsCalciatore.getIdCalciatore());
			ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
			
			ps.executeUpdate();
			
			logger.logInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
		return statsCalciatore;
	}

	@Override
	public StatsCalciatoreDto findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		StatsCalciatoreDto statsCalciatore = new StatsCalciatoreDto();
		
		String query = "SELECT * FROM stats_calciatore WHERE id_stats = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
			logger.logDebug("Id delle stats dei calciatori recuperato con successo.");
			
		} catch(SQLException e) {
			logger.logError("Errore nel recupero dell'Id delle stats del calciatore", e);
		}
		
		try {
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				statsCalciatore.setIdStatsCalciatore(rs.getLong("id_stats"));
				statsCalciatore.setGolCalciatore(rs.getInt("gol_calciatore"));
				statsCalciatore.setAssistCalciatore(rs.getInt("assist_calciatore"));
				statsCalciatore.setIdCalciatore(rs.getLong("calciatore"));
				
				logger.logInfo("Query eseguita con successo.");
			}
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
		return statsCalciatore;
	}

}
