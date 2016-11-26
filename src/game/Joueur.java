package game;

import cartes.*;

public class Joueur {
	
	Jeu j;
	Divinite d;
	MainJoueur main;
	Camp camp;
	
	public Joueur(Jeu _j)
	{
		this.j = _j;
		main = new MainJoueur();
		camp = new Camp();
	}
	
	protected String lancerDe()
	{
		return j.getDe().lancer();
	}
	
	protected Carte piocherCarte()
	{
		return j.getPioche().piocher();
	}
	
	protected void defausserCarte()
	{
		
	}
	
	protected void piocherDivinite()
	{
		
	}
	
	protected void passerTour()
	{
		
	}
	
	protected void recupererCroyants()
	{
		
	}
}
