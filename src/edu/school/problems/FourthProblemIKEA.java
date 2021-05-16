package edu.school.problems;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FourthProblemIKEA 
{

	public static void main(String[] args) 
	{
		//absolute paths - have to be changed
		//couldn't get relative paths to work for some reason
		//I apologise for the inconvenience
		List<ProductIKEA> file1 = parseFile("D:\\kids\\move\\Yova\\School\\Computer Science\\11th Grade Java\\Problems_Yova_Mitova_11i_14\\src\\resources\\òáß¬«ó«.txt");
		System.out.println(file1); //just for testing
		List<ProductIKEA> file2 = parseFile("D:\\kids\\move\\Yova\\School\\Computer Science\\11th Grade Java\\Problems_Yova_Mitova_11i_14\\src\\resources\\éáα¡á.txt");
		System.out.println(file2); //just for testing
		List<ProductIKEA> file3 = parseFile("D:\\kids\\move\\Yova\\School\\Computer Science\\11th Grade Java\\Problems_Yova_Mitova_11i_14\\src\\resources\\æ«áΣ¿∩.txt");
		System.out.println(file3); //just for testing
		List<ProductIKEA> file4 = parseFile("D:\\kids\\move\\Yova\\School\\Computer Science\\11th Grade Java\\Problems_Yova_Mitova_11i_14\\src\\resources\\üπαúáß.txt");
		System.out.println(file4); //just for testing

		List<ProductIKEA> allProducts = new ArrayList<>(); //a separate list for all the entries
		//for ease of some queries
		for(ProductIKEA item : file1)
		{
			allProducts.add(item);
		}
		for(ProductIKEA item : file2)
		{
			allProducts.add(item);
		}
		for(ProductIKEA item : file3)
		{
			allProducts.add(item);
		}
		for(ProductIKEA item : file4)
		{
			allProducts.add(item);
		}
		
		System.out.println("Price of all products: " + allProducts.stream()
				.mapToDouble(x -> x.getPrice() * x.getItemsSold())
				.sum());
		
		if(file1.stream()
				.mapToDouble(x -> x.getPrice() * x.getItemsSold())
				.sum() >= 1500)
		{
			System.out.println("òáß¬«ó«.txt");
		}
		
		if(file2.stream()
				.mapToDouble(x -> x.getPrice() * x.getItemsSold())
				.sum() >= 1500)
		{
			System.out.println("éáα¡á.txt");
		}
		
		if(file3.stream()
				.mapToDouble(x -> x.getPrice() * x.getItemsSold())
				.sum() >= 1500)
		{
			System.out.println("æ«áΣ¿∩.txt");
		}
		
		if(file4.stream()
				.mapToDouble(x -> x.getPrice() * x.getItemsSold())
				.sum() >= 1500)
		{
			System.out.println("üπαúáß.txt");
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a product type: ");
		String type = input.nextLine();
		input.close();
		
		System.out.println("Sum of all sold items of type " + type + ": " + allProducts.stream()
		.filter(x -> x.getType().contains(type))
		.mapToDouble(x -> x.getPrice() * x.getItemsSold())
		.sum());
		
		
		
	}
	
	private static List<ProductIKEA> parseFile(String filePath)
	{
		List<ProductIKEA> toReturn = new ArrayList<>();
		try 
		{
			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			for(String line : lines)
			{
				String[] items = line.split(",");
				String name = items[0];
				String type = items[1];
				double price = ParseDouble(items[2]);
				int itemsSold = ParseInt(items[3]);
				ProductIKEA newProduct = new ProductIKEA(name, type, price, itemsSold);
				toReturn.add(newProduct);
			}
		} 
		catch (IOException e) 
		{
			System.out.println("File parsing problems in Problem 4 on file: " + filePath);
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
