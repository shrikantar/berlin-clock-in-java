package com.ubs.opsit.interviews;


public class TimeConverterImpl implements TimeConverter, TimeValidator {

	private int hours;  
	private int minutes;  
	private int seconds;

	@Override
	public String convertTime(String aTime) {
		if(!validateInputTime(aTime)){
			return null;
		}
		StringBuffer berlinTime = new StringBuffer();  
		
		//First row lamps
		berlinTime.append(processLamps(seconds));
		berlinTime.append(TimeConverterConstants.LINE_SEPARATOR);  

		//Second row of hour lamps  
		berlinTime.append(processLamps(hours, hours / 5, TimeConverterConstants.RED_LAMP));
		berlinTime.append(TimeConverterConstants.LINE_SEPARATOR);  
		
		// Third row of hour lamps   
		berlinTime.append(processLamps(hours, hours % 5, TimeConverterConstants.RED_LAMP));  
		berlinTime.append(TimeConverterConstants.LINE_SEPARATOR);  
		
		//Fourth row of minute lamps  
		berlinTime.append(processLamps(minutes, minutes / 5,TimeConverterConstants.RED_LAMP,TimeConverterConstants.YELLOW_LAMP));  
		berlinTime.append(TimeConverterConstants.LINE_SEPARATOR);  
		
		//Fith row of minute lamps.  
		berlinTime.append(processLamps(minutes, minutes % 5, TimeConverterConstants.YELLOW_LAMP));  
		return berlinTime.toString();  

	}

	/*
	 * Method return YELLOW LAMPS If time modules of 2 is equal to 0. 
	 */
	@Override
	public String processLamps(int hours) {

		//Check if time multiple of 2 
		if (hours % 2 == 0) {  
			return TimeConverterConstants.YELLOW_LAMP;  
		} else {  
			return TimeConverterConstants.OFF_LAMP;  
		} 
	}

	/*
	 * Method return lamps consist of RED,YELLOW,OFF and combination of [RED and OFF] Lamps 
	 * or [YELLOW and OFF] Lamps.
	 */
	@Override
	public String processLamps(int hours, int numericValue, String strRedLamp, String strYellowLamp) {
		StringBuilder lamps = new StringBuilder(TimeConverterConstants.ELEVEN_OFF_LAMPS);  
		for (int i = 0; i < numericValue; i++) {  
			//Check if time multiple of 3
			if ((i + 1) % 3 == 0) {  
				lamps.replace(i, i + 1, strRedLamp);  
			} else {  
				lamps.replace(i, i + 1, strYellowLamp);  
			}  
		}  
		return lamps.toString();
	}

	/*
	 * Method return 4 lamps consist of RED, YELLOW, OFF and Combination of [RED and OFF] 
	 * or [YELLOW and OFF]
	 */
	@Override
	public String processLamps(int hours, int numericValue, String strLamp) {
		StringBuilder lamps = new StringBuilder(TimeConverterConstants.FOUR_OFF_LAMPS);  
		for (int i = 0; i < numericValue; i++) {  
			lamps.replace(i, i + 1, strLamp);  
		}  
		return lamps.toString();
	}

	@Override
	public boolean validateInputTime(String aTime) {
		if(aTime == null){
			throw new IllegalArgumentException(BLANK_TIME_ERROR);
		}
		String[] times = aTime.split(COLON, 3);

        if(times.length != 3){ 
        	throw new IllegalArgumentException(INVALID_TIME_ERROR);
        }

        hours = 0;
        minutes = 0;
        seconds = 0;
        
        try {
            hours = Integer.parseInt(times[0]);
            minutes = Integer.parseInt(times[1]);
            seconds = Integer.parseInt(times[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ALFA_NUMERIC_TIME_ERROR);
        }
        if (hours < 0 || hours > 24){
        	throw new IllegalArgumentException(HOURS_OUT_OFF_RANGE);
        }
        else if (minutes < 0 || minutes > 59){
        	throw new IllegalArgumentException(MINUTES_OUT_OFF_RANGE);
        }
        else if (seconds < 0 || seconds > 59){
        	throw new IllegalArgumentException(SECONDS_OUT_OFF_RANGE);
        }
        return true; 
	}
	
}
