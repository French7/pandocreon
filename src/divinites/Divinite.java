package divinites;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import game.Dogmes;
import game.Origines;

public class Divinite {
	private String nom;
	private Origines origine;
	private ArrayList<Dogmes> dogmes;
	private Pouvoir pouvoir;
	
	public Divinite(String _nom, Origines _o, ArrayList<Dogmes> _dogmes) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		this.nom = _nom;
		this.origine = _o;
		this.dogmes = _dogmes;
		this.pouvoir = new Pouvoir(this.nom);
	}
	
	public void pouvoir() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		this.pouvoir.invoquerPouvoir();
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
	
	public Pouvoir getPouvoir()
	{
		return this.pouvoir;
	}
}
