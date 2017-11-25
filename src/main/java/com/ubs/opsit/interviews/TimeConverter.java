package com.ubs.opsit.interviews;

public interface TimeConverter {
	
	public String processLamps(int timeValue, int numericValue,String redLamp, String yellowLamp);
	public String processLamps(int timeValue, int numericValue, String lamp);
	public String processLamps(int timeValue);
	public String convertTime(String aTime);

}
