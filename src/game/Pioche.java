package game;

import java.util.LinkedList;
import java.util.Queue;
import cartes.*;

public final class Pioche {
	
	private static Pioche instance = null;
	private LinkedList<cartes.Carte> cartes;
	
	private Pioche()
	{
		
	}
	
	public final static Pioche getInstance()
	{
		if (Pioche.instance == null)
		{
			Pioche.instance = new Pioche();
		}
		return Pioche.instance;
	}

	
	public void melanger()
	{
		
	}
	
	public Carte piocher()
	{
		return cartes.remove();
	}
}