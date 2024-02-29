package utils.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InformazioniLogger {
	
	private static final Logger logger = LogManager.getLogger(InformazioniLogger.class);
	
	public void getLogInfo() {
		logger.info("log di info");
	}
	
	public void getLogDebug() {
		logger.debug("log di debug");
	}
	
	public void getLogWarn() {
		logger.warn("log di warn");
	}
	
	public void getLogError() {
		logger.error("log di error");
	}
	
	public void getLogFatal() {
		logger.fatal("log di fatal");
	}
	
}
