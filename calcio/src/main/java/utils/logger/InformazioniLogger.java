package utils.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class InformazioniLogger {
	
	private static final Logger logger = LogManager.getLogger(InformazioniLogger.class);
	
	public InformazioniLogger() {}
	
	public void logInfo(String message, Object... info) {
		logger.info(message, info);
	}
	
	public void logDebug(String message, Object... debug) {
		logger.debug(message, debug);
	}
	
	public void logWarn(String message, Object... warn) {
		logger.warn(message, warn);
	}
	
	public void logError(String message, Object... error) {
		logger.error(message, error);
	}
	
	public void logFatal(String message, Object... fatal) {
		logger.fatal(message, fatal);
	}
	
}
