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

import model.bean.AllenatoreBean;
import model.daoInterface.CrudDao;
import utils.DbConnection;

public class AllenatoreCrudDao implements CrudDao<AllenatoreBean>{
	
	DbConnection dbConn = new DbConnection();
	
	@Override
	public List<AllenatoreBean> findAll() {
		
		Connection conn = dbConn.getConnection();
		List<AllenatoreBean> allenatori = new ArrayList<>();
		
		String query = "SELECT * FROM allenatore";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				AllenatoreBean allenatore = new AllenatoreBean();
				
				allenatore.setIdAllenatore(rs.getLong("id_allenatore"));
				allenatore.setNome(rs.getString("nome"));
				allenatore.setCognome(rs.getString("cognome"));
				allenatore.setNazionalita(rs.getString("nazionalità"));
				allenatore.setEta(rs.getInt("età"));
				allenatore.setAltezza(rs.getDouble("altezza"));
				allenatore.setPeso(rs.getInt("peso"));
				allenatore.setIdSquadra(rs.getLong("squadra_fk"));
				
				allenatori.add(allenatore);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return allenatori;

	}
	
	@Override
	public AllenatoreBean findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		AllenatoreBean allenatore = new AllenatoreBean();
		
		String query = "SELECT * FROM allenatore WHERE id_allenatore = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			
		} catch(SQLException e) {
			
		}
		
		try {
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				allenatore.setIdAllenatore(id);
				allenatore.setNome(rs.getString("nome"));
				allenatore.setCognome(rs.getString("cognome"));
				allenatore.setNazionalita(rs.getString("nazionalità"));
				allenatore.setEta(rs.getInt("età"));
				allenatore.setAltezza(rs.getDouble("altezza"));
				allenatore.setPeso(rs.getInt("peso"));
				allenatore.setIdSquadra(rs.getLong("squadra_fk"));
			}
			
		} catch(SQLException e) {
			
		}
		
		dbConn.closeConnection(conn);
		
		return allenatore;
	}
	
	@Override
	public AllenatoreBean update(Long id) {
		
		Connection conn = dbConn.getConnection();
		AllenatoreBean allenatore = new AllenatoreBean();
		
		String query = "UPDATE allenatore SET nome = ?, cognome = ?, età = ?, altezza = ?, nazionalità = ?, peso = ?, squadra = ?, data_modifica = ? WHERE id_allenatore = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, allenatore.getNome());
			ps.setString(2, allenatore.getCognome());
			ps.setInt(3, allenatore.getEta());
			ps.setDouble(4, allenatore.getAltezza());
			ps.setString(5, allenatore.getNazionalita());
			ps.setInt(6, allenatore.getPeso());
			ps.setLong(7, allenatore.getIdSquadra());
			ps.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(9, id);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return allenatore;
	}
	
	@Override
	public AllenatoreBean insert() {
		
		Connection conn = dbConn.getConnection();
		AllenatoreBean allenatore = new AllenatoreBean();
		
		String query = "INSERT INTO allenatore (nome, cognome, nazionalità, età, altezza, peso, squadra_fk, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, allenatore.getNome());
			ps.setString(2, allenatore.getCognome());
			ps.setString(3, allenatore.getNazionalita());
			ps.setInt(4, allenatore.getEta());
			ps.setDouble(5, allenatore.getAltezza());
			ps.setInt(6, allenatore.getPeso());
			ps.setLong(7, allenatore.getIdSquadra());
			ps.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return allenatore;
	}
	
	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		
		String query = "DELETE FROM allenatore WHERE id_allenatore = ?";
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
