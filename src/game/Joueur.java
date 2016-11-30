package game;

import java.util.ArrayList;

import cartes.*;
import divinites.Divinite;

public class Joueur {
	
	protected Jeu j;
	protected Divinite d;
	protected MainJoueur main;
	protected Camp camp;
	protected int paJour, paNuit, paNeant;
	protected String name;
	
	protected boolean jeuLance;
	
	public Joueur(Jeu _j, String _name)
	{
		this.j = _j;
		this.name = _name;
		main = new MainJoueur();
		camp = new Camp();
		paJour = 0;
		paNuit = 0;
		paNeant = 0;
		jeuLance = false;
	}
	
	public void tour()
	{
		if (!jeuLance)
		{
			piocherDivinite();
		}
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
		this.d = j.piocheDivinite();
		String nomDivinite = d.getNom();
		Origines originieDivinite = d.getOrigine();
		ArrayList<Dogmes> dogmesDivinite = d.getDogmes();
		feedback("Divinité piochée : " + nomDivinite + " - " + originieDivinite + " - " + dogmesDivinite);
	}
	
	protected void feedback(String str)
	{
		j.afficher(str, this);
	}
	
	protected void passerTour()
	{
		
	}
	
	protected void recupererCroyants()
	{
		
	}
	
	public String getName()
	{
		return this.name; 
	}
	
	public String toString()
	{
		String str = this.name;
		if(this instanceof JoueurHumain) str+="\thumain\t";
		else str+="\tIA\t";
		str+= paJour + " PA Jour, " + paNuit + " PA Nuit, " + paNeant + " PA Néant";
		return str;
	}
}
