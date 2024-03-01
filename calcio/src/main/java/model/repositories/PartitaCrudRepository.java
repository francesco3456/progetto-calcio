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

import model.bean.PartitaBean;
import model.repositoryInterface.CrudRepository;
import utils.DbConnection;

public class PartitaCrudRepository implements CrudRepository<PartitaBean> {
	
	DbConnection dbConn = new DbConnection();

	@Override
	public List<PartitaBean> findAll() {
		
		Connection conn = dbConn.getConnection();
		List<PartitaBean> partite = new ArrayList<>();
		
		String query = "SELECT * FROM partita";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				PartitaBean partita = new PartitaBean();
			
				partita.setIdPartita(rs.getLong("id_partita"));
				partita.setRisultatoPartita(rs.getString("risultato"));
				partita.setDataPartita(rs.getTimestamp("data_partita").toLocalDateTime());
				partita.setIdSquadraCasa(rs.getLong("squadra_casa"));
				partita.setIdSquadraOspite(rs.getLong("squadra_ospite"));
				partita.setIdGiornata(rs.getLong("giornata"));
				
				partite.add(partita);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return partite;
	}

	@Override
	public PartitaBean update(Long id) {
		
		Connection conn = dbConn.getConnection();
		PartitaBean partita = new PartitaBean();
		
		String query = "UPDATE FROM partita SET risultato = ?, data_partita = ?, squadra_casa = ?, squadra_ospite = ?, giornata = ?, data_modifica = ? WHERE id_partita = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, partita.getRisultatoPartita());
			ps.setTimestamp(2, Timestamp.valueOf(partita.getDataPartita()));
			ps.setLong(3, partita.getIdSquadraCasa());
			ps.setLong(4, partita.getIdSquadraOspite());
			ps.setLong(5, partita.getIdGiornata());
			ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(7, id);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return partita;
	}

	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		
		String query = "DELETE FROM partita WHERE id_partita = ?";
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
	public PartitaBean insert() {
		
		Connection conn = dbConn.getConnection();
		PartitaBean partita = new PartitaBean();
		
		String query = "INSERT INTO partita (risultato, data_partita, squadra_casa, squadra_ospite, giornata, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, partita.getRisultatoPartita());
			ps.setTimestamp(2, Timestamp.valueOf(partita.getDataPartita()));
			ps.setLong(3, partita.getIdSquadraCasa());
			ps.setLong(4, partita.getIdSquadraOspite());
			ps.setLong(5, partita.getIdGiornata());
			ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return partita;
	}

	@Override
	public PartitaBean findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		PartitaBean partita = new PartitaBean();
		
		String query = "SELECT * FROM partita WHERE id_partita = ?";
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
			
			partita.setIdPartita(rs.getLong("id_partita"));
			partita.setRisultatoPartita(rs.getString("risultato"));
			partita.setDataPartita(rs.getTimestamp("data_partita").toLocalDateTime());
			partita.setIdSquadraCasa(rs.getLong("squadra_casa"));
			partita.setIdSquadraOspite(rs.getLong("squadra_ospite"));
			partita.setIdGiornata(rs.getLong("giornata"));
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		dbConn.closeConnection(conn);
		
		return partita;
	}

}
