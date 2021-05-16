package edu.school.problems;

public class ProductIKEA 
{
	private String name;
	private String type;
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
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
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
	
	public ProductIKEA(String name, String type, double price, int itemsSold)
	{
		this.setName(name);
		this.setType(type);
		this.setPrice(price);
		this.setItemsSold(itemsSold);
	}
	
	public ProductIKEA() //not sure if I need it, so just in case
	{
		this(null, null, 0, 0);
	}
	
	public String toString()
	{
		String result = this.getName() + ", " + this.getType() + ", " + this.getPrice() + ", " + this.getItemsSold();
		return result;
	}
}
