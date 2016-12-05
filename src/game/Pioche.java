package game;

import java.util.LinkedList;
import cartes.*;

public final class Pioche {
	
	private static Pioche instance = null;
	private LinkedList<cartes.Carte> cartes;
	
	private Pioche()
	{
		cartes = new LinkedList<cartes.Carte>();
	}
	
	public final static Pioche getInstance()
	{
		if (Pioche.instance == null)
		{
			Pioche.instance = new Pioche();
		}
		return Pioche.instance;
	}

	public void ajouterCarte(Carte _c)
	{
		cartes.add(_c);
	}
	
	public void melanger()
	{
		
	}
	
	public Carte piocher()
	{
		return cartes.remove();
	}
	
	public LinkedList<Carte> getListeCartes()
	{
		return this.cartes;
	}
}