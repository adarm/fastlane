/**
 * 
 */
package org.fastlane.stats.scraper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.fastlane.stats.model.DataValue;
import org.fastlane.stats.repository.DataValuesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author amargalit
 *
 */
public class ScrapeExecutorImpl implements ScrapeExecutor {

	private static final String ATT_KEY = "id";
	private static final String ATT_VAL = "lblPrice";
	private static final int INTERVAL = 60000;
	
	  @Resource
	  private DataValuesRepository dataRepository;

	private final String url;	  
    Logger logger = LoggerFactory.getLogger(ScrapeExecutorImpl.class);
    
	public ScrapeExecutorImpl(String url) {
		this.url = url;
	}
	  
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	@Scheduled(fixedRate=INTERVAL)
	public void run() {
		Scraper scraper = new Scraper();
		int val = scraper.scrapeIntValue(url, ATT_KEY, ATT_VAL);
		long timestamp = System.currentTimeMillis();
		Date date=new Date(timestamp);
	    SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy hh:mm");
	    String dateText = df2.format(date);
	    logger.info(dateText+ " -- "+val);		// TODO: if -1 send email
		//System.out.println(timestamp + ": "+val);
		
		DataValue dv = new DataValue(timestamp, val);
		
		dataRepository.save(dv);
	}

}
