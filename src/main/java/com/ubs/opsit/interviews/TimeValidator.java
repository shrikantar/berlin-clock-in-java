package com.ubs.opsit.interviews;

public interface TimeValidator {
	
	//Time value validation constants 
	public String ALFA_NUMERIC_TIME_ERROR = "Time should be only numberic value.";
	public String BLANK_TIME_ERROR = "Time value is not provided.";
	public String INVALID_TIME_ERROR = "Invalid time provided, follow the format : HH:MM:SS.";
	public String HOURS_OUT_OFF_RANGE = "Invalid hours, provide valid hours between 0 to 23.";
	public String MINUTES_OUT_OFF_RANGE = "Invalid minutes, provide valid minutes between 0 to 59.";
	public String SECONDS_OUT_OFF_RANGE = "Invalid seconds, provide valid seconds between 0 to 59.";
	public String COLON = ":";
	
	public boolean validateInputTime(String aTime);
}
