package edu.school.problems;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ThirdProblemEarningsOver15 
{

	public static void main(String[] args) 
	{
		//absolute path - has to be changed
		//couldn't get relative paths to work for some reason
		//I apologise for the inconvenience
		List<Product> products = fileParser("D:/kids/move/Yova/School/Computer Science\\11th Grade Java resources\\Stream Problems Hristov\\Stream Problems 1\\products.txt");
		System.out.println(products); // for testing
		
		products.stream()
		.filter(x -> x.getPrice() * x.getItemsSold() >= 15)
		.map(x -> x.getNameAndPrice())
		.forEach(System.out::println);

	}
	
	private static List<Product> fileParser(String filePath)
	{
		List<Product> toReturn = new ArrayList<>();
		try 
		{
			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			for(String line : lines)
			{
				String[] items = line.split(",");
				String name = items[0];
				double price = ParseDouble(items[1]);
				int itemsSold = ParseInt(items[2]);
				Product newProduct = new Product(name, price, itemsSold);
				toReturn.add(newProduct);
			}
		} 
		catch (IOException e) 
		{
			System.out.println("Problem with file parsing in Problem 3.");
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	private static int ParseInt(String value)
	{
		String value1 = value.substring(1);
		return Integer.parseInt(value1);
	}
	
	private static double ParseDouble(String value)
	{
		value.replaceAll(" ", "");
		return Double.parseDouble(value);
	}

}
