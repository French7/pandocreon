package game;

import cartes.*;

public class Joueur {
	
	protected Jeu j;
	protected Divinite d;
	protected MainJoueur main;
	protected Camp camp;
	protected int paJour, paNuit, paNeant;
	
	public Joueur(Jeu _j)
	{
		this.j = _j;
		main = new MainJoueur();
		camp = new Camp();
		paJour = 0;
		paNuit = 0;
		paNeant = 0;
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
