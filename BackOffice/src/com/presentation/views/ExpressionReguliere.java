package com.presentation.views;

public class ExpressionReguliere {
	public boolean Nom_PrenomIsValide(String a)
	{
		String Rex="^[a-zA-Z]+$";
		return a.matches(Rex);
	}
	
	public static boolean MatriculeIsValide(String a)
	{
		String Rex="^[a-zA-Z0-9]+$";
		return a.matches(Rex);
	}
	
	public boolean DateIsValide(String a)
	{
		String Rex="^[0-9]{4,4}-[0-9]{2,2}-[0-9]{2,2}$";
		return a.matches(Rex);
	}
	public boolean NumeroIsValide(String a)
	{
		String Rex="^[0-9]+$";
		return a.matches(Rex);
	}
}
