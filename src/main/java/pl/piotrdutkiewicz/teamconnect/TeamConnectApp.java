package pl.piotrdutkiewicz.teamconnect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamConnectApp 
{
	private static final Logger logger = LogManager.getLogger(TeamConnectApp.class);

    public static void main( String[] args )
    {
    	logger.info("\n main()");
		logger.debug(" running main()");
    	SpringApplication.run(TeamConnectApp.class, args);    	
    }
}
