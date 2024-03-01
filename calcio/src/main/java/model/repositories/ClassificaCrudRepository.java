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

import model.bean.ClassificaBean;
import model.repositoryInterface.CrudRepository;
import utils.DbConnection;

public class ClassificaCrudRepository implements CrudRepository<ClassificaBean> {
	
	DbConnection dbConn = new DbConnection();
	
	@Override
	public List<ClassificaBean> findAll() {
		
		Connection conn = dbConn.getConnection();
		List<ClassificaBean> punteggi = new ArrayList<>();
		
		String query = "SELECT * FROM classifica";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				ClassificaBean punteggio = new ClassificaBean();
				
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
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return punteggi;
	}
	
	@Override
	public ClassificaBean findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		ClassificaBean punteggio = new ClassificaBean();
		
		String query = "SELECT * FROM classifica WHERE id_classifica = ?";
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
			
			punteggio.setIdClassifica(id);
			punteggio.setPuntiSquadra(rs.getInt("punti"));
			punteggio.setGoalFattiSquadra(rs.getInt("gol_fatti"));
			punteggio.setGoalSubitiSquadra(rs.getInt("gol_subiti"));
			punteggio.setDifferenzaRetiSquadra(rs.getInt("differenza_reti"));
			punteggio.setVittorieSquadra(rs.getInt("win"));
			punteggio.setPareggiSquadra(rs.getInt("pari"));
			punteggio.setSconfitteSquadra(rs.getInt("lose"));
			punteggio.setIdSquadra(rs.getLong("squadra_fk"));
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return punteggio;
	}
	
	@Override
	public ClassificaBean update(Long id) {
		
		Connection conn = dbConn.getConnection();
		ClassificaBean punteggio = new ClassificaBean();
		
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
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return punteggio;
	}
	
	@Override
	public ClassificaBean insert() {
		
		Connection conn = dbConn.getConnection();
		ClassificaBean punteggio = new ClassificaBean();
		
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
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return punteggio;
	}
	
	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		
		String query = "DELETE FROM classifica WHERE id_classifica = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
	}

}
