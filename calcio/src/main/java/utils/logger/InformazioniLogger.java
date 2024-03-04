package utils.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utils.ClassSingleton;

public class InformazioniLogger {
	
	private static final Logger logger = LogManager.getLogger(InformazioniLogger.class);
	private ClassSingleton singletonInstance;
	
	public InformazioniLogger() {
		this.singletonInstance = ClassSingleton.getInstance();
	}
	
	public void getLogInfo(String message, Object... info) {
		logger.info(message, info);
	}
	
	public void getLogDebug(String message, Object... debug) {
		logger.debug(message, debug);
	}
	
	public void getLogWarn(String message, Object... warn) {
		logger.warn(message, warn);
	}
	
	public void getLogError(String message, Object... error) {
		logger.error(message, error);
	}
	
	public void getLogFatal(String message, Object... fatal) {
		logger.fatal(message, fatal);
	}
	
}
