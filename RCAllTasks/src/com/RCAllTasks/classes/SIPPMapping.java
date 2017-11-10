package com.RCAllTasks.classes;

public class SIPPMapping {
	
	//switch case to map letter 1 of the sipp to the car type
	public static String letterOneSpec(char firstLetter)
	{
		String letterOneSpec = "";
		switch(firstLetter)
		{
		case 'M':
			return letterOneSpec = "Mini";
		case 'E':
			return letterOneSpec = "Economy";
		case 'C':
			return letterOneSpec = "Compact";
		case 'I':
			return letterOneSpec = "Intermediate";
		case 'S':
			return letterOneSpec = "Standard";
		case 'F':
			return letterOneSpec = "Full Size";
		case 'P':
			return letterOneSpec = "Premium";
		case 'L':
			return letterOneSpec = "Luxury";
		case 'X':
			return letterOneSpec = "Special";
		default:
				return letterOneSpec;			
		}//end switch
	}
	
	//switch case to map letter 2 of the sipp to the doors/car type
	public static String letterTwoSpec(char secondLetter)
	{
		String letterTwoSpec = "";
		switch(secondLetter)
		{
		case 'B':
			return letterTwoSpec = "2 Doors";
		case 'C':
			return letterTwoSpec = "4 Doors";
		case 'D':
			return letterTwoSpec = "5 Doors";
		case 'W':
			return letterTwoSpec = "Estate";
		case 'T':
			return letterTwoSpec = "Convertible";
		case 'F':
			return letterTwoSpec = "SUV";
		case 'P':
			return letterTwoSpec = "Pick Up";
		case 'V':
			return letterTwoSpec = "Passenger Van";
		default:
				return letterTwoSpec;			
		}//end switch
	}
	
	//switch case to map letter 3 of the sipp to the transmission type
	public static String letterThreeSpec(char thirdLetter)
	{
		String letterThreeSpec = "";
		switch(thirdLetter)
		{
		case 'M':
			return letterThreeSpec = "Manual";
		case 'A':
			return letterThreeSpec = "Automatic";
		default:
				return letterThreeSpec;			
		}//end switch
	}
	
	//switch case to map letter 4 of the sipp to the fuel/aircon
	public static String letterFourSpec(char fourthLetter)
	{
		String letterFourSpec = "";
		switch(fourthLetter)
		{
		case 'N':
			return letterFourSpec = "Petrol - No AC";
		case 'R':
			return letterFourSpec = "Petrol - AC";
		default:
				return letterFourSpec;			
		}//end switch
	}

}
