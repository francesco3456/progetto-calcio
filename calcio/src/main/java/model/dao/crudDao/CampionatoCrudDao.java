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

public class CampionatoCrudDao implements CrudDao<CampionatoBean> {
	
	DbConnection dbConn = new DbConnection();
	
	@Override
	public List<CampionatoBean> findAll() {
		
		Connection conn = dbConn.getConnection();
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
				campionato.setStagioneCampionato(rs.getDate("stagione"));
				campionato.setNumeroGiornateCampionato(rs.getInt("tot_giornate"));
				campionato.setBandieraCampionato((Blob) rs.getBlob("bandiera"));
				
				campionati.add(campionato);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return campionati;
	}
	
	public CampionatoBean findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		CampionatoBean campionato = new CampionatoBean();
		
		String query = "SELECT * FROM campionato WHERE id_campionato = ?";
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
				
				campionato.setIdCampionato(id);
				campionato.setNomeCampionato(rs.getString("nome"));
				campionato.setNazioneCampionato(rs.getString("nazione"));
				campionato.setInizioCampionato(rs.getTimestamp("inizio").toLocalDateTime());
				campionato.setFineCampionato(rs.getTimestamp("fine").toLocalDateTime());
				campionato.setStagioneCampionato(rs.getDate("stagione"));
				campionato.setNumeroGiornateCampionato(rs.getInt("tot_giornate"));
				campionato.setBandieraCampionato((Blob) rs.getBlob("bandiera"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return campionato;
	}
	
	public CampionatoBean update(Long id) {
		
		Connection conn = dbConn.getConnection();
		CampionatoBean campionato = new CampionatoBean();
		
		String query = "UPDATE FROM campionato SET nome = ?, nazione = ?, inizio = ?, fine = ?, stagione = ?, tot_giornate = ?, bandiera = ?, data_modifica = ? WHERE id_campionato = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, campionato.getNomeCampionato());
			ps.setString(2, campionato.getNazioneCampionato());
			ps.setTimestamp(3, Timestamp.valueOf(campionato.getInizioCampionato()));
			ps.setTimestamp(4, Timestamp.valueOf(campionato.getFineCampionato()));
			ps.setDate(5, new java.sql.Date(campionato.getStagioneCampionato().getTime()));
			ps.setInt(6, campionato.getNumeroGiornateCampionato());
			ps.setBlob(7, campionato.getBandieraCampionato());
			ps.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(9, id);			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return campionato;
	}
	
	public CampionatoBean insert() {
		
		Connection conn = dbConn.getConnection();
		CampionatoBean campionato = new CampionatoBean();
		
		String query = "INSERT INTO campionato (nome, nazione, inizio, fine, stagione, tot_giornate, bandiera, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, campionato.getNomeCampionato());
			ps.setString(2, campionato.getNazioneCampionato());
			ps.setTimestamp(3, Timestamp.valueOf(campionato.getInizioCampionato()));
			ps.setTimestamp(4, Timestamp.valueOf(campionato.getFineCampionato()));
			ps.setDate(5, new java.sql.Date(campionato.getStagioneCampionato().getTime()));
			ps.setInt(6, campionato.getNumeroGiornateCampionato());
			ps.setBlob(7, campionato.getBandieraCampionato());
			ps.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));	
			ps.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));	
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return campionato;
	}

	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		
		String query = "DELETE FROM campionato WHERE id_campionato = ?";
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
