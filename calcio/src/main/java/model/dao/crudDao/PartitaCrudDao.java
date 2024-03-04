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

import model.bean.PartitaBean;
import model.daoInterface.CrudDao;
import utils.DbConnection;
import utils.logger.InformazioniLogger;

public class PartitaCrudDao implements CrudDao<PartitaBean> {
	
	DbConnection dbConn = new DbConnection();
	InformazioniLogger logger = new InformazioniLogger();

	@Override
	public List<PartitaBean> findAll() {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
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
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return partite;
	}

	@Override
	public PartitaBean update(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
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
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return partita;
	}

	@Override
	public void delete(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		String query = "DELETE FROM partita WHERE id_partita = ?";
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
	public PartitaBean insert() {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
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
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return partita;
	}

	@Override
	public PartitaBean findById(Long id) {
		
		Connection conn = dbConn.getConnection();
		logger.getLogInfo("Connesso al database");
		
		PartitaBean partita = new PartitaBean();
		
		String query = "SELECT * FROM partita WHERE id_partita = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setLong(1, id);
			
			logger.getLogDebug("Id della partita recuperato con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nel recupero dell'Id della partita", e);
		}
		
		try {
			rs = ps.executeQuery();
			
			partita.setIdPartita(rs.getLong("id_partita"));
			partita.setRisultatoPartita(rs.getString("risultato"));
			partita.setDataPartita(rs.getTimestamp("data_partita").toLocalDateTime());
			partita.setIdSquadraCasa(rs.getLong("squadra_casa"));
			partita.setIdSquadraOspite(rs.getLong("squadra_ospite"));
			partita.setIdGiornata(rs.getLong("giornata"));
			
			logger.getLogInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.getLogError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.getLogInfo("Connessione al database terminata");
		
		return partita;
	}

}
