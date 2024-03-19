package model.dao.otherDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.ClassificaDto;
import model.dto.SquadraDto;
import utils.DbConnection;
import utils.logger.InformazioniLogger;

public class ClassificaDao {
	
	DbConnection dbConn = new DbConnection();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<Object> visualizzaClassifica(String nazionalita) {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		List<Object> punteggi = new ArrayList<>();
		
		String query = "SELECT c.punti, c.golFatti, c.goalSubiti, c.differenza_reti, c.win, c.lose, c.pari, s.nome FROM classifica c JOIN squadra s ON c.squadra_fk = s.id_squadra WHERE s.nazionalità = ?";
		PreparedStatement ps = null;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, nazionalita);
			
			logger.logDebug("Nazionalità della squadra recuperata con successo");
			
		} catch(SQLException e) {
			logger.logError("Errore nel recupero della nazionalità della squadra", e);
		}
		
		try {
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ClassificaDto punteggio = new ClassificaDto();
				SquadraDto squadra = new SquadraDto();
				
				punteggio.setPuntiSquadra(rs.getInt("punti"));
				punteggio.setGoalFattiSquadra(rs.getInt("golFatti"));
				punteggio.setGoalSubitiSquadra(rs.getInt("goalSubiti"));
				punteggio.setDifferenzaRetiSquadra(rs.getInt("differenza_reti"));
				punteggio.setVittorieSquadra(rs.getInt("win"));
				punteggio.setPareggiSquadra(rs.getInt("pari"));
				punteggio.setSconfitteSquadra(rs.getInt("lose"));
				
				squadra.setNomeSquadra(rs.getString("nome"));
				
				punteggi.add(punteggio);
				punteggi.add(squadra);
			}
			
			logger.logInfo("Query eseguita con successo");
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
		return punteggi;
	}

}
