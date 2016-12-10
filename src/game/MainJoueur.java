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
	
	public int getPP()
	{
		int pp = 0;
		for (Carte carte : cartes) {
			if (carte.getClass() == GuideSpirituel.class)
			{
				pp+=((GuideSpirituel) carte).getPP();
			}
		}
		return pp;
	}
}
