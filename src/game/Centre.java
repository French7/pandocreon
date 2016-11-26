package game;

import java.util.ArrayList;

import cartes.*;

public final class Centre {
	
	private static Centre instance = null;
	private ArrayList<Croyant> croyants = null;
	
	private Centre()
	{
		
	}
	
	public final static Centre getInstance()
	{
		if (Centre.instance == null)
		{
			Centre.instance = new Centre();
		}
		return Centre.instance;
	}

}