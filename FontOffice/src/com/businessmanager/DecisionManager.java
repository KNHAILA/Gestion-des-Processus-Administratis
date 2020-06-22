package com.businessmanager;

import java.util.ArrayList;

import com.business.Decision;
import com.persistance.dao.DAODecision;

public class DecisionManager {
	
	public static boolean ajoutDecision(Decision d)
	{
		return DAODecision.setDecision(d);
	}
	public static boolean lastDecision(Decision d)
	{
		return DAODecision.setLastDecision(d);
	}
	public static ArrayList<Decision> getDecisions()
	{
		return DAODecision.getDecisions();
	}
	public static int ordreDecision(int n)
	{
		return DAODecision.ordreDecision(n);
	}
}
