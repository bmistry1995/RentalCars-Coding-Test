package com.RCAllTasks.get;
import com.RCAllTasks.classes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("tasks")
public class AllTasks {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("part1")
	public String getPart1() throws JSONException
	{
		Response jsonResponse = new Response();
		ArrayList<Vehicle> vehicleList = jsonResponse.getVehicleList();
		
		//Comparator to compare the prices in ascending order
		Comparator<Vehicle> comparePriceAsc = new Comparator<Vehicle>()
		{

			@Override
			public int compare(Vehicle v1, Vehicle v2) {
				return Double.compare(v1.getPrice(), v2.getPrice());
			}
		};
		
		
		//sort the list based on price and print
		Collections.sort(vehicleList, comparePriceAsc);
		String result = "";
		for(Vehicle v:vehicleList)
		{
			result = result + " " + (vehicleList.indexOf(v)+1) + " " + v.getName() + " - " + v.getPrice();
			System.out.println(vehicleList.indexOf(v)+1 + " " + v.getName() + " - " + v.getPrice());
		}
		return result;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("part2")
	public String getPart2() throws JSONException
	{
		Response jsonResponse = new Response();
		ArrayList<Vehicle> vehicleList = jsonResponse.getVehicleList();
		
		//find correct mapping of each sipp letter and print out
		String letterOne, letterTwo, letterThree, letterFour;
		String result = "";
		for(Vehicle v: vehicleList)
		{
			letterOne = SIPPMapping.letterOneSpec(v.getSipp().charAt(0));
			letterTwo = SIPPMapping.letterTwoSpec(v.getSipp().charAt(1));
			letterThree = SIPPMapping.letterThreeSpec(v.getSipp().charAt(2));
			letterFour = SIPPMapping.letterFourSpec(v.getSipp().charAt(3));
			result = result + " " + (vehicleList.indexOf(v)+1) + " " + v.getName() + " - " + v.getSipp() + " - " + 
					letterOne + " - " + letterTwo + " - " + letterThree +
					" - " + letterFour;
			System.out.println(vehicleList.indexOf(v)+1 + " " + v.getName() + " - " + v.getSipp() + " - " + 
					letterOne + " - " + letterTwo + " - " + letterThree +
					" - " + letterFour);
		}
		
		return result;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("part3")
	public String getPart3() throws JSONException
	{
		Response jsonResponse = new Response();
		ArrayList<Vehicle> vehicleList = jsonResponse.getVehicleList();
		
		//Comparator to compare the ratings in descending order
		Comparator<Vehicle> compareRatingDesc = new Comparator<Vehicle>()
		{
			@Override
			public int compare(Vehicle v1, Vehicle v2) {
				// TODO Auto-generated method stub
				return Double.compare(v2.getSupRating(), v1.getSupRating());
			}
		};
		
		//sort the arraylist in desc order
		//loop through each of the type array and the array list
		//find the first element in arrayList which has the car type. once found, print and move to next car type
		Collections.sort(vehicleList, compareRatingDesc);
		char[] vehicleTypeArray = {'M', 'E', 'C', 'I', 'S', 'F', 'P', 'L', 'X'};
		String result = "";
		int resultOrder = 0;
		for(int i = 0; i < vehicleTypeArray.length; i++)
		{
			for(Vehicle v: vehicleList)
			{	
				if (vehicleTypeArray[i] == v.getSipp().charAt(0))
				{
					resultOrder++;
					result = result + " " + resultOrder + " " + v.getName() + " - " + SIPPMapping.letterOneSpec(v.getSipp().charAt(0)) + " - "
							+ v.getSupplier() + " - " + v.getSupRating();
					System.out.println(resultOrder + " " + v.getName() + " - " + SIPPMapping.letterOneSpec(v.getSipp().charAt(0)) + " - "
					+ v.getSupplier() + " - " + v.getSupRating());
					break;
				}
			}
		}
		
		return result;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("part4")
	public String getPart4() throws JSONException
	{
		Response jsonResponse = new Response();
		ArrayList<Vehicle> vehicleList = jsonResponse.getVehicleList();
		
		//Comparator to compare the overall vehicle score in descending order
		Comparator<Vehicle> compareSumOfScoreDesc = new Comparator<Vehicle>()
		{
			@Override
			public int compare(Vehicle v1, Vehicle v2) {
				// TODO Auto-generated method stub
				return Double.compare(v2.getSumOfScores(), v1.getSumOfScores());
			}
		};
		//do initial loop to find the vehicle score of each car. with this calculate the sum of scores
		//set the vehicle score and sum of scores to the current vehicle v in the arrayList
		int vehicleScore;
		double sumOfScores;
		for(Vehicle v: vehicleList)
		{
			vehicleScore = 0;
			sumOfScores = 0;
			if(v.getSipp().charAt(2) == 'M')
				vehicleScore += 1;
			else if (v.getSipp().charAt(2) == 'A')
				vehicleScore += 5;
			if (v.getSipp().charAt(3) == 'R')
				vehicleScore += 2;
			
			v.setVehicleScore(vehicleScore);
			sumOfScores = vehicleScore + v.getSupRating();
			v.setSumOfScores(sumOfScores);	
		}
		//sort the array list using the ratings comparator, loop through and print
		Collections.sort(vehicleList, compareSumOfScoreDesc);
		String result = "";
		for(Vehicle v: vehicleList)
		{	
			result = result + " " + (vehicleList.indexOf(v)+1) + " " + v.getName() + " - " + v.getVehicleScore() + " - " + v.getSupRating() + " - " + v.getSumOfScores();
			System.out.println(vehicleList.indexOf(v)+1 + " " + v.getName() + " - " + v.getVehicleScore() + " - " + v.getSupRating() + " - " + v.getSumOfScores());
		}
		return result;
	}
}
