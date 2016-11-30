package divinites;


import java.util.ArrayList;

import game.Dogmes;
import game.Origines;

public class Divinite {
	protected String nom;
	protected Origines origine;
	protected ArrayList<Dogmes> dogmes;
	
	public Divinite(String _nom, Origines _o, ArrayList<Dogmes> _dogmes)
	{
		this.nom = _nom;
		this.origine = _o;
		this.dogmes = _dogmes;
	}
	
	public void pouvoir()
	{
		
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public Origines getOrigine()
	{
		return this.origine;
	}
	
	public ArrayList<Dogmes> getDogmes()
	{
		return this.dogmes;
	}
	
	public String toString()
	{
		String out = "Nom : "+nom+" ; ";
		out += "Origine : "+origine+" ; ";
		out += "Dogmes : "+dogmes;
		return out;
	}
}
