package edu.school.problems;

public class Product 
{
	private String name;
	private double price;
	private int itemsSold;
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public int getItemsSold() 
	{
		return itemsSold;
	}
	
	public void setItemsSold(int itemsSold) 
	{
		this.itemsSold = itemsSold;
	}
	
	public Product(String name, double price, int itemsSold)
	{
		this.setName(name);
		this.setPrice(price);
		this.setItemsSold(itemsSold);
	}
	
	public Product() //not sure if I need it, but just in case
	{
		this(null, 0, 0);
	}
	
	public String toString()
	{
		String result = this.getName() + ", " + this.getPrice() + ", " + this.getItemsSold();
		return result;
	}
	
	public String getNameAndPrice()
	{
		return this.getName() + ", " + this.getPrice();
	}
	
}
