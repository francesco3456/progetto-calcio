package model.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.bean.StatsCalciatoreBean;
import model.repositoryInterface.CrudRepository;
import utils.DbConnection;

public class StatsCrudRepository implements CrudRepository<StatsCalciatoreBean> {
	
	DbConnection dbConn = new DbConnection();

	@Override
	public List<StatsCalciatoreBean> findAll() {
		
		Connection conn = dbConn.getConnection();
		List<StatsCalciatoreBean> statsCalciatori = new ArrayList<>();
		
		String query = "SELECT * FROM stats_calciatore";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
				StatsCalciatoreBean statsCalciatore = new StatsCalciatoreBean();
				
				statsCalciatore.setIdStatsCalciatore(rs.getLong("id_stats"));
				statsCalciatore.setGolCalciatore(rs.getInt("gol_calciatore"));
				statsCalciatore.setAssistCalciatore(rs.getInt("assist_calciatore"));
				statsCalciatore.setIdCalciatore(rs.getLong("calciatore"));
				
				statsCalciatori.add(statsCalciatore);			
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return statsCalciatori;
	}

	@Override
	public StatsCalciatoreBean update(Long id) {
		
		Connection conn = dbConn.getConnection();
		StatsCalciatoreBean statsCalciatore = new StatsCalciatoreBean();
		
		String query = "UPDATE FROM stats_calciatore SET gol_calciatore = ?, assist_calciatore = ?, calciatore = ?, data_modifica = ? WHERE id_stats = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, statsCalciatore.getGolCalciatore());
			ps.setInt(2, statsCalciatore.getAssistCalciatore());
			ps.setLong(3, statsCalciatore.getIdCalciatore());
			ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(5, id);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return statsCalciatore;
	}

	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		
		String query = "DELETE FROM stats_calciatore WHERE id_stats = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
	}

	@Override
	public StatsCalciatoreBean insert() {
		
		Connection conn = dbConn.getConnection();
		StatsCalciatoreBean statsCalciatore = new StatsCalciatoreBean();
		
		String query = "INSERT INTO stats_calciatore (gol_calciatore, assist_calciatore, calciatore, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, statsCalciatore.getGolCalciatore());
			ps.setInt(2, statsCalciatore.getAssistCalciatore());
			ps.setLong(3, statsCalciatore.getIdCalciatore());
			ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return statsCalciatore;
	}

	@Override
	public StatsCalciatoreBean findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		StatsCalciatoreBean statsCalciatore = new StatsCalciatoreBean();
		
		String query = "SELECT * FROM stats_calciatore WHERE id_stats = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				statsCalciatore.setIdStatsCalciatore(rs.getLong("id_stats"));
				statsCalciatore.setGolCalciatore(rs.getInt("gol_calciatore"));
				statsCalciatore.setAssistCalciatore(rs.getInt("assist_calciatore"));
				statsCalciatore.setIdCalciatore(rs.getLong("calciatore"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return statsCalciatore;
	}

}
