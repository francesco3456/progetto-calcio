package model.dao.otherDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dto.PartitaDto;
import utils.DbConnection;
import utils.logger.InformazioniLogger;

public class PartitaDao {

	DbConnection dbConn = new DbConnection();
	InformazioniLogger logger = new InformazioniLogger();

	public List<PartitaDto> findMatchDay() {

		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		List<PartitaDto> partite = new ArrayList<>();

		String query = "SELECT * FROM partita WHERE DATE(data_partita) = CURDATE()";
		Statement st = null;
		ResultSet rs;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				PartitaDto partita = new PartitaDto();

				partita.setIdGiornata(rs.getLong("giornata"));
				partita.setDataPartita(rs.getTimestamp("data_partita").toLocalDateTime());
				partita.setIdSquadraCasa(rs.getLong("squadra_casa"));
				partita.setRisultatoPartita(rs.getString("risultato"));
				partita.setIdSquadraOspite(rs.getLong("squadra_ospite"));

				partite.add(partita);
			}
			
			logger.logInfo("Query eseguita con successo");

		} catch (SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}

		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");

		return partite;
	}

	public List<PartitaDto> findMatchYesterDay() {

		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		List<PartitaDto> partite = new ArrayList<>();

		String query = "SELECT * FROM partita WHERE DATE(data_partita) = CURDATE() - INTERVAL 1 DAY";
		Statement st = null;
		ResultSet rs;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				PartitaDto partita = new PartitaDto();

				partita.setIdGiornata(rs.getLong("giornata"));
				partita.setDataPartita(rs.getTimestamp("data_partita").toLocalDateTime());
				partita.setIdSquadraCasa(rs.getLong("squadra_casa"));
				partita.setRisultatoPartita(rs.getString("risultato"));
				partita.setIdSquadraOspite(rs.getLong("squadra_ospite"));

				partite.add(partita);
			}
			
			logger.logInfo("Query eseguita con successo.");

		} catch (SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}

		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");

		return partite;
	}

	public List<PartitaDto> findMatchTomorrow() {

		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		List<PartitaDto> partite = new ArrayList<>();

		String query = "SELECT * FROM partita WHERE DATE(data_partita) = CURDATE() + INTERVAL 1 DAY";
		Statement st = null;
		ResultSet rs;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				PartitaDto partita = new PartitaDto();

				partita.setIdGiornata(rs.getLong("giornata"));
				partita.setDataPartita(rs.getTimestamp("data_partita").toLocalDateTime());
				partita.setIdSquadraCasa(rs.getLong("squadra_casa"));
				partita.setRisultatoPartita(rs.getString("risultato"));
				partita.setIdSquadraOspite(rs.getLong("squadra_ospite"));

				partite.add(partita);
			}
			
			logger.logInfo("Query eseguita con successo.");

		} catch (SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}

		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");

		return partite;
	}

}
