package game;

import cartes.*;
import java.util.ArrayList;;

public class MainJoueur {
	
	private ArrayList<Carte> cartes;
	
	public MainJoueur()
	{
		cartes = new ArrayList<Carte>();
	}
	
	public ArrayList<Carte> getCartes()
	{
		return this.cartes;
	}
	
	public void ajouterCarte(Carte _c)
	{
		this.cartes.add(_c);
	}
	
	public void retirerCarte(Carte _c)
	{
		this.cartes.remove(_c);
	}
	
	public int nbCartes()
	{
		return cartes.size();
	}
}
