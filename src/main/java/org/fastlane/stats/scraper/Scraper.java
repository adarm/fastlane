package org.fastlane.stats.scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scraper {
    Logger logger = LoggerFactory.getLogger(Scraper.class);

	public int scrapeIntValue(String url, String attKey, String attValue){
	    try {
			int i = -1;
	    	Document doc = Jsoup.connect(url).timeout(6000).get();
			Elements els = doc.getElementsByAttributeValue(attKey, attValue);
			String val = null;
			if (els != null && els.size() >0){
				Element e = els.get(0);
				val = e.html();
			}
			if (val != null && !val.isEmpty()){
				i = (Integer.valueOf(val)).intValue();
			}
			return i;
	    } catch (IOException e) {
			// TODO logger
			logger.error(e.getMessage(), e);
		}
		return -1;
	}
	
/*    public static void main(String args[]) throws IOException{
    	Scraper scraper = new Scraper();
    	int val = scraper.scrapeIntValue("https://www.fastlane.co.il/mobile.aspx", "id", "lblPrice");
    	System.out.println(val);
    }*/
}
