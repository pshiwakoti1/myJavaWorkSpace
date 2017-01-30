package com.s3s.projects;

import org.apache.log4j.Logger;


public class Calculator {

	public static Logger logger = Logger.getLogger(Calculator.class);

	public int add(int x, int y){
		logger.debug("adding the message");
	return x + y;
	}
	
	public void showAlldebugs(){
		logger.info("info message");
		logger.warn("warn message");
	}
}
