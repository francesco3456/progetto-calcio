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

import model.dto.CalciatoreDto;
import model.daoInterface.CrudDao;
import utils.DbConnection;
import utils.logger.InformazioniLogger;

public class CalciatoreCrudDao implements CrudDao<CalciatoreDto> {

	InformazioniLogger logger = new InformazioniLogger();
	DbConnection dbConn = new DbConnection();
	

	@Override
	public List<CalciatoreDto> findAll() {

		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		List<CalciatoreDto> calciatori = new ArrayList<>();
		
		String query = "SELECT * FROM calciatore";
		Statement st = null;
		
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				CalciatoreDto calciatore = new CalciatoreDto();
				
				calciatore.setIdCalciatore(rs.getLong("id_calciatore"));
				calciatore.setNome(rs.getString("nome"));
				calciatore.setCognome(rs.getString("cognome"));
				calciatore.setEta(rs.getInt("età"));
				calciatore.setAltezza(rs.getDouble("altezza"));
				calciatore.setNazionalita(rs.getString("nazionalità"));
				calciatore.setPeso(rs.getInt("peso"));
				calciatore.setRuoloCalciatore(rs.getString("ruolo"));
				calciatore.setIdSquadra(rs.getLong("squadra"));
				
				calciatori.add(calciatore);
			}
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch (SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		        dbConn.closeConnection(conn);   
		        logger.getLogInfo("Connessione al database terminata");

		return calciatori;
	}
	
	@Override
	public CalciatoreDto findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		CalciatoreDto calciatore = new CalciatoreDto();
		
		String query = "SELECT * FROM calciatore WHERE id_calciatore = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			
			logger.getLogDebug("Id del calciatore recuperato con successo");
		
		} catch(SQLException e) {
			logger.getLogError("Errore nel recupero dell'Id del calciatore", e);
		}
		try {
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				calciatore.setIdCalciatore(id);
				calciatore.setNome(rs.getString("nome"));
				calciatore.setCognome(rs.getString("cognome"));
				calciatore.setEta(rs.getInt("età"));
				calciatore.setAltezza(rs.getDouble("altezza"));
				calciatore.setNazionalita(rs.getString("nazionalità"));
				calciatore.setPeso(rs.getInt("peso"));
				calciatore.setRuoloCalciatore(rs.getString("ruolo"));
				calciatore.setIdSquadra(rs.getLong("squadra"));
				
			}
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nell'esecuzione della query");
		}
		
		dbConn.closeConnection(conn);		
		logger.getLogInfo("Connessione al database terminata");
		
		return calciatore;
		
	}
	
	@Override
	public CalciatoreDto update(CalciatoreDto calciatore) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		
		String query = "UPDATE calciatore SET nome = ?, cognome = ?, età = ?, altezza = ?, nazionalità = ?, peso = ?, ruolo = ?, squadra = ?, data_modifica = ? WHERE id_calciatore = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, calciatore.getNome());
			ps.setString(2, calciatore.getCognome());
			ps.setInt(3, calciatore.getEta());
			ps.setDouble(4, calciatore.getAltezza());
			ps.setString(5, calciatore.getNazionalita());
			ps.setInt(6, calciatore.getPeso());
			ps.setString(7, calciatore.getRuoloCalciatore());
			ps.setLong(8, calciatore.getIdSquadra());
			ps.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
			ps.setLong(10, calciatore.getIdCalciatore());
			
			ps.executeUpdate();
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);	
		logger.getLogInfo("Connessione al database terminata");
		
		return calciatore;
	}
	
	@Override
	public CalciatoreDto insert(CalciatoreDto calciatore) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		
		String query = "INSERT INTO calciatore (nome, cognome, età, altezza, nazionalità, peso, ruolo, squadra, data_creazione, data_modifica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, calciatore.getNome());
			ps.setString(2, calciatore.getCognome());
			ps.setInt(3, calciatore.getEta());
			ps.setDouble(4, calciatore.getAltezza());
			ps.setString(5, calciatore.getNazionalita());
			ps.setInt(6, calciatore.getPeso());
			ps.setString(7, calciatore.getRuoloCalciatore());
			ps.setLong(8, calciatore.getIdSquadra());
			ps.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
			ps.setTimestamp(10, Timestamp.valueOf(LocalDateTime.now()));
			
			ps.executeUpdate();
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return calciatore;
	}
	
	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		String query = "DELETE FROM calciatore WHERE id_calciatore = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
			ps.executeUpdate();
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
	}
}
