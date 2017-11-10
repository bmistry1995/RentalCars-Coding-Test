package com.RCAllTasks.classes;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Response {
	
	public ArrayList<Vehicle> getVehicleList() throws JSONException
	{
		Client client = ClientBuilder.newClient();
		//target for the client
		WebTarget target = client.target("http://www.rentalcars.com/js/vehicles.json");
		//get the response and place in string to use for each part
		String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
		
		//set the object to be the response string we returned
		JSONObject object = new JSONObject(response);
		//get the first object
		JSONObject getObject = object.getJSONObject("Search");
		//get the array of vehicles
		JSONArray array = getObject.getJSONArray("VehicleList");

		//create arrayList of type vehicle
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		
		String name, sipp, supplier;
		Double price, supRating;
		//loop through the JSON array and place each desired attribute into the vehicle arrayList
		for(int i = 0; i < array.length(); i++)
		{
			JSONObject objects = array.getJSONObject(i);
			name = objects.getString("name");
			price = objects.getDouble("price");
			sipp = objects.getString("sipp");
			supRating = objects.getDouble("rating");
			supplier = objects.getString("supplier");
			vehicleList.add(new Vehicle(name, price, sipp, supRating, supplier));
		}
		
		return vehicleList;
	}

}
