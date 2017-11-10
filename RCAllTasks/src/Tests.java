import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import com.RCAllTasks.classes.Response;
import com.RCAllTasks.classes.Vehicle;
import com.RCAllTasks.classes.SIPPMapping;

class Tests {
	
	//tests to check that empty arrayList returned when incorrect file is used.
	@Test
	public void testResponse() throws JSONException {
		Response response = new Response();
		ArrayList<Vehicle> returnedResponse = new ArrayList<Vehicle>();
		
		//return the response from getVehicleList
		returnedResponse = response.getVehicleList("cars.json");
		
		//the response should be an empty ArrayList<Vehicle>
		ArrayList<Vehicle> expectedResponse = new ArrayList<Vehicle>();
		
		//check that the response is empty ArrayList<Vehicle>
		assertEquals(returnedResponse, expectedResponse);
		
	}
	
	//test each sipp letters to retrieve correct mappings
	@Test
	public void testMappings()
	{
		SIPPMapping mappings = new SIPPMapping();
		//select a letter 
		char[] sipp = {'M', 'W', 'A', 'N'};
		
		String returnedResult = "";
		returnedResult = returnedResult + mappings.letterOneSpec(sipp[0])  + " ";
		returnedResult = returnedResult + mappings.letterTwoSpec(sipp[1])  + " ";
		returnedResult = returnedResult + mappings.letterThreeSpec(sipp[2])  + " ";
		returnedResult = returnedResult + mappings.letterFourSpec(sipp[3]);
		
		String expectedResult = "Mini Estate Automatic Petrol - No AC";
		
		//ensure that the letter returns the correct result
		assertEquals(returnedResult, expectedResult);
		
	}
	
	//tests creation of vehicle and returning vehicle attribute
	@Test
	public void testVehicle()
	{
		ArrayList<Vehicle> newVehicle = new ArrayList<Vehicle>();
		
		newVehicle.add(new Vehicle("Ford Focus", 2000.00, "XDMR", 7.8, "bhavsCars"));
		assertEquals(newVehicle.get(0).getName(), "Ford Focus");
	}

}
