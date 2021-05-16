package edu.school.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FirstProblemAbs 
{

	public static void main(String[] args) 
	{
		List<Integer> numberN = new ArrayList<>();
		List<Integer> numberM = new ArrayList<>();
		List<Integer> reversedResult = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		Random rand = new Random();
		int n = rand.nextInt(10) + 1; // allows up to ten digits in the number
		int m = rand.nextInt(10) + 1; // allows up to ten digits in the number
		
		for(int i = 0; i < n; i++) //generate first number
		{
			numberN.add(Math.abs(rand.nextInt(9) + 1));
		}
		
		for(int i = 0; i < m; i++) //generate second number
		{
			numberM.add(Math.abs(rand.nextInt(9) + 1));
		}
		
		System.out.println("NumberN: " + numberN.toString()); //just for testing
		System.out.println("NumberM: " + numberM.toString()); //just for testing
		
		if(numberN.size() < numberM.size()) //subtract n from m
		{
			reversedResult = subtractLargerSizedNumber(numberN, numberM, reversedResult);
		}
		
		else if(numberN.size() > numberM.size()) //subtract m from n
		{
			reversedResult = subtractLargerSizedNumber(numberM, numberN, reversedResult);
		}
		
		else if(numberN.size() == numberM.size())
		{
			boolean subtractNFromM = false;
			for(int i = 0; i < numberN.size(); i++)
			{
				if(numberN.get(i) < numberM.get(i))
				{
					subtractNFromM = true;
					break;
				}
				if(numberN.get(i) > numberM.get(i))
					break;
			}
			if(subtractNFromM == true)
			{
				reversedResult = subtractEqualSizedNumbers(numberN, numberM, reversedResult);
			}
			else
			{
				reversedResult = subtractEqualSizedNumbers(numberM, numberN, reversedResult);
			}
		}
		
		//adding the numbers in the result in the correct order
		for(int i = reversedResult.size() - 1; i >= 0; i--)
		{
			result.add(reversedResult.get(i));
		}
		if(result.get(0) == 0)
		{
			result.remove(0);
		}
		
		//for ease of testing
		System.out.println("ReversedResult: " + reversedResult.toString());
		System.out.println("Result: " + result.toString());
	}
	
	private static List<Integer> subtractLargerSizedNumber(List<Integer> a, List<Integer> b, List<Integer> result)
	{
		for(int i = a.size() - 1, j = b.size() - 1; i >= 0; i--, j--)
		{
			int currentA = a.get(i);
			int currentB = b.get(j);
			if(currentB >= currentA)
			{
				result.add(currentB - currentA);
			}
			else
			{
				currentB += 10;
				if(j == 1)
				{
					int previousM = b.get(0) - 1;
					b.remove(0);
					b.add(0, previousM);
				}
				else if(j != 0)
				{
					int previousM = b.get(j - 1) - 1;
					b.remove(j - 1);
					b.add(j - 1, previousM);
				}
				result.add(currentB - currentA);
			}
		}
		
		for(int i = (b.size() - a.size()) - 1; i >= 0; i--)
		{
			result.add(b.get(i));
		}
		
		return result;
	}
	
	private static List<Integer> subtractEqualSizedNumbers(List<Integer> a, List<Integer> b, List<Integer> result)
	{
		for(int i = a.size() - 1; i >= 0; i--)
		{
			int currentA = a.get(i);
			int currentB = b.get(i);
			if(currentB >= currentA)
			{
				result.add(currentB - currentA);
			}
			else
			{
				currentB += 10;
				if(i == 1)
				{
					int previousM = b.get(0) - 1;
					b.remove(0);
					b.add(0, previousM);
				}
				else if(i != 0)
				{
					int previousM = b.get(i - 1) - 1;
					b.remove(i - 1);
					b.add(i - 1, previousM);
				}
				result.add(currentB - currentA);
			}
		}
		
		return result;
	}

}
