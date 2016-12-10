package game;

import java.util.LinkedList;

import cartes.*;

public final class Centre {
	
	private static Centre instance = null;
	private LinkedList<Croyant> croyants;
	
	private Centre()
	{
		croyants = new LinkedList<Croyant>();
	}
	
	public final static Centre getInstance()
	{
		if (Centre.instance == null)
		{
			Centre.instance = new Centre();
		}
		return Centre.instance;
	}
	
	public LinkedList<Croyant> getCroyants()
	{
		return this.croyants;
	}
	
	public void ajouterCarte(Croyant _c)
	{
		this.croyants.add(_c);
	}
	
	public int getNbCroyants()
	{
		return this.croyants.size();
	}
	
	public Croyant getCroyant(int i)
	{
		return this.croyants.get(i);
	}
	
	public void retirerCroyant(Croyant _c)
	{
		this.croyants.remove(_c);
	}
}