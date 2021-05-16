package edu.school.problems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondProblemDifference 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		//absolute path - has to be changed
		//couldn't get relative paths to work for some reason
		//I apologise for the inconvenience
		File file = new File("D:\\kids\\move\\Yova\\School\\Computer Science\\11th Grade Java\\Problems_Yova_Mitova_11i_14\\src\\resources\\Numbers.txt");
		Path filePath = file.toPath();
		System.out.println("Enter m: ");
		String m = input.next();
		input.close();
		
		List<String> numbers = parseFile(filePath, m);
		
		System.out.println(numbers); // just for testing
		
		File differenceFile = new File("D:\\kids\\move\\Yova\\School\\Computer Science\\11th Grade Java\\Problems_Yova_Mitova_11i_14\\src\\resources\\Difference.txt");
		writeInFile(differenceFile, numbers, m);

	}
	
	private static List<String> parseFile(Path filePath, String m)
	{
		//you need to select your things with stream
		List<String> file = new ArrayList<>();
		List<String> result = new ArrayList<>();
		
		try 
		{
			file = Files.readAllLines(filePath, StandardCharsets.UTF_8);
			for(String line : file)
			{
				String[] numbers = line.split(" ");
				for(String number : numbers)
				{
					if(number.contains(m))
					{
						result.add(number);
					}
				}
			}
		} 
		catch (IOException e) 
		{
			System.out.println("File parsing problems.");
			e.printStackTrace();
		}
		
		return result;
	}
	
	private static void writeInFile(File file, List<String> numbers, String m)
	{
		try 
		{
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for(String number : numbers)
			{
				List<Integer> currentNumber = numberToIntegers(number);
				List<Integer> difference = difference(currentNumber, m);
				String result = number + " - " + m + " = " + difference;
				bw.write(result);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fw.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Writing in file problems.");
			e.printStackTrace();
		}
	}
	
	private static List<Integer> numberToIntegers(String n)
	{
		List<Integer> number = new ArrayList<>();
		for(int i = 0; i < n.length(); i++)
		{
			int digit = Integer.parseInt("" + n.charAt(i));
			number.add(digit);
		}
		
		return number;
	}
	
	/*private static List<Integer> difference(List<Integer> number, String m)
	{
		List<Integer> result = new ArrayList<>();
		int mAsNumber = Integer.parseInt(m);
		int diff;
		if(number.get(number.size() - 1) >= mAsNumber)
		{
			diff = number.
			diff = number.get(number.size() - 1) - mAsNumber;
			//number.remove(number.get(number.size() - 1));
			//number.add(number.size() - 1, diff);
			for(int i = 0; i < number.size() - 1; i++)
			{
				result.add(number.get(i));
			}
			result.add(diff);
		}
		else
		{
			diff = number.get(number.size() - 1) + 10;
			int naum = number.get(number.size() - 2) - 1;
			diff = diff - mAsNumber;
			
			for(int i = 0; i < number.size() - 2; i++)
			{
				result.add(number.get(i));
			}
			result.add(naum);
			result.add(diff);
			//number.add(number.size() - 1, diff);
			//number.add(number.size() - 2, naum);
			//number.remove(number.size() - 1);
			//number.remove(number.size() - 2);

		}
		
		return result;
	}
	*/
	
	private static List<Integer> difference(List<Integer> number, String m)
	{
		int mAsNumber = Integer.parseInt(m);
		int diff;
		if(number.get(number.size() - 1) >= mAsNumber)
		{
			diff = number.get(number.size() - 1) - mAsNumber;
			number.set(number.size() - 1, diff);
		}
		else
		{
			diff = number.get(number.size() - 1) + 10;
			diff = diff - mAsNumber;
			int naum = number.get(number.size() - 2) - 1;
			number.set(number.size() - 1, diff);
			number.set(number.size() - 2, naum);
		}
		
		return number;
	}
	
	
	

}
