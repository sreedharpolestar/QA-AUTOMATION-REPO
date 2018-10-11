package scriptResources;


import org.apache.commons.lang3.text.WordUtils;
// slf4j Logger has been utilized in this project
// Apache WordUtils to tidy up the error traces in the logs
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFactory extends ConfigFactory {

	public static Logger logger = null;

	public LoggingFactory() {
		LoggingFactory.setLogger(LoggerFactory.getLogger(this.getClass()));
	}

	private static void setLogger(Logger log) {
		logger = log;
	}

	public static void verbose(String verbose) {
		logger.info(verbose);
	}

	public static void error(String error) {
		logger.error(error);
	}

	public static void error(Exception error) {

		StackTraceElement[] traceMessageArray = error.getStackTrace();
		logger.error("************************************************************");
		logger.error("<<<Cause>>>   " + error.getCause() + " <<<>>>");
		logger.error("<<<Message>>> " + WordUtils.wrap(error.getMessage(), 60) + " <<<>>>");
		logger.error("codes where the test is failing as below >>>>>>>>>>>>>>>>>> ");
		for (StackTraceElement traceLine : traceMessageArray) {
			logger.error(traceLine.toString());
		}
		logger.error("<<<<< Trace Message end ");
		logger.error("************************************************************");
	}

}
