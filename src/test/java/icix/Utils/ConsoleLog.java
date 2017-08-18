package icix.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import icix.Utils.Log;

public class ConsoleLog {

  //private static final Logger log = Logger.getLogger(ConsoleLog.class.getSimpleName());
  
  private static final Logger log = LogManager.getLogger(ConsoleLog.class);

  public static void info(String message) {
    Log.info(message);
    Reporter.log(message);
    
  }

  public static void warn(String message) {
    Log.info(message);
    Reporter.log(message);
    
  }
}
