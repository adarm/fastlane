package org.fastlane.stats;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FastlaneStats {

	public static void main(String[] args) {
	    ApplicationContext ctx = 
	    		new AnnotationConfigApplicationContext(SpringConfig.class);
	    
	}

}
