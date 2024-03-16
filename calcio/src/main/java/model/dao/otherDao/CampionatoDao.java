package model.dao.otherDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.CampionatoBean;
import utils.DbConnection;
import utils.logger.InformazioniLogger;

public class CampionatoDao {
	
	DbConnection dbConn = new DbConnection();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<String> findAllNomiCampionati() {
		
		Connection conn = dbConn.getConnection();
		logger.logInfo("Connesso al database");
		
		List<String> nomi = new ArrayList<>();
		
		String query = "SELECT nome FROM campionato";
		Statement st = null;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				CampionatoBean campionato = new CampionatoBean();
				
				campionato.setNomeCampionato(rs.getString("nome"));
				
				nomi.add(campionato.getNomeCampionato());			
			}
			
			logger.logInfo("Query eseguita con successo.");
			
		} catch(SQLException e) {
			logger.logError("Errore nella esecuzione della query", e);
		}
		
		dbConn.closeConnection(conn);
		logger.logInfo("Connessione al database terminata");
		
		return nomi;
	}

}
