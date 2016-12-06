package game;

import java.util.ArrayList;

import cartes.*;
import divinites.Divinite;

public abstract class Joueur {
	
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
		
	}
	
	protected String lancerDe()
	{
		return j.getDe().lancer();
	}
	
	protected void piocherCarte()
	{
		Carte c = j.getPioche().piocher();
		this.main.ajouterCarte(c);
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
		feedback("Divinité piochée : " + nomDivinite + " - " + originieDivinite + " - " + dogmesDivinite + " : " + this.d.getPouvoir());
	}
	
	protected void feedback(String str)
	{
		j.getIO().afficher(str);
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
		for (Carte c : main.getCartes()) {
			str+= c.toString()+"\n";
		}
		return str;
	}
	
	public void afficher(String _str)
	{
		j.getIO().afficher(this.name + "> " + _str);
	}
	
	public Divinite getDivinite()
	{
		return this.d;
	}
	
	public void ajouterPAJour(int n)
	{
		j.getIO().afficher(this.name + " gagne " + n + "PA Jour.");
		this.paJour+=n;
	}
	
	public void ajouterPANuit(int n)
	{
		j.getIO().afficher(this.name + " gagne " + n + "PA Nuit.");
		this.paNuit+=n;
	}
	
	public void ajouterPANeant(int n)
	{
		j.getIO().afficher(this.name + " gagne " + n + "PA Néant.");
		this.paNeant+=n;
	}
	
	
	// A REDEFINIR DANS JOUEURAI/JOUEURHUMAIN
	
	public int askInt()
	{
		return 0;
	}
	
	public String askString()
	{
		return "";
	}
}
