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

import model.daoInterface.CrudDao;
import model.dto.SquadraDto;
import utils.DbConnection;

public class SquadraCrudDao implements CrudDao<SquadraDto> {
	
	DbConnection dbConn = new DbConnection();

	@Override
	public List<SquadraDto> findAll() {
		
		Connection conn = dbConn.getConnection();
		List<SquadraDto> squadre = new ArrayList<>();
		
		String query = "SELECT * FROM squadra WHERE id_squadra = ?";
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
				squadra.setNascitaSquadra(rs.getDate("nascita"));
				squadra.setStadioSquadra(rs.getString("stadio"));
				squadra.setCittaSquadra(rs.getString("città"));
				squadra.setStemmaSquadra((Blob) rs.getBlob("stemma"));
				
				squadre.add(squadra);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return squadre;
	}

	@Override
	public SquadraDto update(Long id) {
		
		Connection conn = dbConn.getConnection();
		SquadraDto squadra = new SquadraDto();
		
		String query = "UPDATE FROM squadra SET nome = ?, nazionalità = ?, nascita = ?, stadio = ?, città = ?, stemma = ?, data_modifica = ? WHERE id_squadra = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, squadra.getNomeSquadra());
			ps.setString(2, squadra.getNazionalitaSquadra());
			ps.setDate(3, new java.sql.Date(squadra.getNascitaSquadra().getTime()));
			ps.setString(4, squadra.getStadioSquadra());
			ps.setString(5, squadra.getCittaSquadra());
			ps.setBlob(6, squadra.getStemmaSquadra());
			ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(8, id);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return squadra;
	}

	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		
		String query = "DELETE FROM squadra WHERE id_squadra = ?";
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
	public SquadraDto insert() {
		
		Connection conn = dbConn.getConnection();
		SquadraDto squadra = new SquadraDto();
		
		String query = "INSERT INTO squadra (nome, nazionalità, nascita, stadio, città, stemma, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, squadra.getNomeSquadra());
			ps.setString(2, squadra.getNazionalitaSquadra());
			ps.setDate(3, new java.sql.Date(squadra.getNascitaSquadra().getTime()));
			ps.setString(4, squadra.getStadioSquadra());
			ps.setString(5, squadra.getCittaSquadra());
			ps.setBlob(6, squadra.getStemmaSquadra());
			ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return squadra;
	}

	@Override
	public SquadraDto findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		SquadraDto squadra = new SquadraDto();
		
		String query = "SELECT * FROM squadra WHERE id_squadra = ?";
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
			
			squadra.setIdSquadra(rs.getLong("id_squadra"));
			squadra.setNomeSquadra(rs.getString("nome"));
			squadra.setNazionalitaSquadra(rs.getString("nazionalità"));
			squadra.setNascitaSquadra(rs.getDate("nascita"));
			squadra.setStadioSquadra(rs.getString("stadio"));
			squadra.setCittaSquadra(rs.getString("città"));
			squadra.setStemmaSquadra((Blob) rs.getBlob("stemma"));
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return squadra;
	}

}
