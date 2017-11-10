package com.RCAllTasks.classes;

public class Vehicle {
	
	private String name;
	private double price;
	private String sipp;
	private double supRating;
	private int vehicleScore;
	private double sumOfScores;
	private String supplier;
	
	public Vehicle(String passedName, double passedPrice, String passedSipp, double passedSupRating, String passedSupplier)
	{
		name = passedName;
		price = passedPrice;
		sipp = passedSipp;
		supRating = passedSupRating;
		supplier = passedSupplier;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public String getSipp()
	{
		return sipp;
	}
	public double getSupRating()
	{
		return supRating;
	}
	public int getVehicleScore()
	{
		return vehicleScore;
	}
	public void setVehicleScore(int passedVehicleScore)
	{
		vehicleScore = passedVehicleScore;
	}
	public double getSumOfScores()
	{
		return sumOfScores;
	}
	
	public void setSumOfScores(double passedSumOfScores)
	{
		sumOfScores = passedSumOfScores;
	}
	public String getSupplier()
	{
		return supplier;
	}

}
