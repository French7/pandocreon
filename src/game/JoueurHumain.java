package game;

import java.util.Scanner;

import cartes.Carte;

public class JoueurHumain extends Joueur {
	public JoueurHumain(Jeu _j, String _name)
	{
		super(_j, _name);
	}
	
	public void tour()
	{
		if (!jeuLance)
		{
			piocherDivinite();
			jeuLance = true;
		}
		else 
		{
			j.getIO().afficher(getEtat());
			j.getIO().valider();
		}
	}
	
	private String getEtat()
	{
		String str = this.name+" : ";
		str+="\nPA Jour : "+this.paJour;
		str+="\nPA Nuit : "+this.paNuit;
		str+="\nPA Néant : "+this.paNeant;
		str+="\nCartes en main :";
		for (Carte c : main.getCartes()) {
			str+="\n\t"+c.toString();
		}
		return str;
	}
	
	public int askInt()
	{
		return j.getIO().askInt();
	}
	
	public String askString()
	{
		return j.getIO().askString();
	}
}
