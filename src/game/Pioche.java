package game;

import java.util.Queue;
import cartes.*;

public final class Pioche {
	
	private static Pioche instance = null;
	private Queue<cartes.Carte> cartes;
	
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