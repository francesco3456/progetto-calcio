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

import model.bean.GiornataBean;
import model.daoInterface.CrudDao;
import utils.DbConnection;

public class GiornataCrudDao implements CrudDao<GiornataBean> {
	
	DbConnection dbConn = new DbConnection();

	@Override
	public List<GiornataBean> findAll() {
		
		Connection conn = dbConn.getConnection();
		List<GiornataBean> giornate = new ArrayList<>();
		
		String query = "SELECT * FROM giornata";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				GiornataBean giornata = new GiornataBean();
				
				giornata.setIdGiornata(rs.getLong("id_giornata"));
				giornata.setInizioGiornata(rs.getTimestamp("inizio").toLocalDateTime());
				giornata.setFineGiornata(rs.getTimestamp("fine").toLocalDateTime());
				
				giornate.add(giornata);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return giornate;
	}

	@Override
	public GiornataBean update(Long id) {
		
		Connection conn = dbConn.getConnection();
		GiornataBean giornata = new GiornataBean();
		
		String query = "UPDATE FROM giornata SET inizio = ?, fine = ?, data_modifica = ? WHERE id_giornata = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setTimestamp(1, Timestamp.valueOf(giornata.getInizioGiornata()));
			ps.setTimestamp(2, Timestamp.valueOf(giornata.getFineGiornata()));
			ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(4, id);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return giornata;
	}

	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		
		String query = "DELETE FROM giornata WHERE id_giornata = ?";
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
	public GiornataBean insert() {
		
		Connection conn = dbConn.getConnection();
		GiornataBean giornata = new GiornataBean();
		
		String query = "INSERT INTO giornata (inizio, fine, data_creazione, data_modifica) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setTimestamp(1, Timestamp.valueOf(giornata.getInizioGiornata()));
			ps.setTimestamp(2, Timestamp.valueOf(giornata.getFineGiornata()));
			ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return giornata;
	}

	@Override
	public GiornataBean findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		GiornataBean giornata = new GiornataBean();
		
		String query = "SELECT * FROM giornata WHERE id_giornata = ?";
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
			
			while (rs.next()) {
				
				giornata.setIdGiornata(rs.getLong("id_giornata"));
				giornata.setInizioGiornata(rs.getTimestamp("inizio").toLocalDateTime());
				giornata.setFineGiornata(rs.getTimestamp("fine").toLocalDateTime());
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return giornata;
	}

}