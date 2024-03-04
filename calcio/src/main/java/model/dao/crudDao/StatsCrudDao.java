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
		logger.getLogInfo("Connesso al database");
		
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
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return statsCalciatori;
	}

	@Override
	public StatsCalciatoreDto update(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		StatsCalciatoreDto statsCalciatore = new StatsCalciatoreDto();
		
		String query = "UPDATE FROM stats_calciatore SET gol_calciatore = ?, assist_calciatore = ?, calciatore = ?, data_modifica = ? WHERE id_stats = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, statsCalciatore.getGolCalciatore());
			ps.setInt(2, statsCalciatore.getAssistCalciatore());
			ps.setLong(3, statsCalciatore.getIdCalciatore());
			ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(5, id);
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return statsCalciatore;
	}

	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		String query = "DELETE FROM stats_calciatore WHERE id_stats = ?";
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
	public StatsCalciatoreDto insert() {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		StatsCalciatoreDto statsCalciatore = new StatsCalciatoreDto();
		
		String query = "INSERT INTO stats_calciatore (gol_calciatore, assist_calciatore, calciatore, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, statsCalciatore.getGolCalciatore());
			ps.setInt(2, statsCalciatore.getAssistCalciatore());
			ps.setLong(3, statsCalciatore.getIdCalciatore());
			ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return statsCalciatore;
	}

	@Override
	public StatsCalciatoreDto findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		StatsCalciatoreDto statsCalciatore = new StatsCalciatoreDto();
		
		String query = "SELECT * FROM stats_calciatore WHERE id_stats = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
			logger.getLogDebug("Id delle stats dei calciatori recuperato con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nel recupero dell'Id delle stats del calciatore", e);
		}
		
		try {
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				statsCalciatore.setIdStatsCalciatore(rs.getLong("id_stats"));
				statsCalciatore.setGolCalciatore(rs.getInt("gol_calciatore"));
				statsCalciatore.setAssistCalciatore(rs.getInt("assist_calciatore"));
				statsCalciatore.setIdCalciatore(rs.getLong("calciatore"));
				
				logger.getLogInfo("Query eseguita con successo.");
			}
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return statsCalciatore;
	}

}
