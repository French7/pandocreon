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
			j.getIO().afficher(j.getIO().getEtat(this));
			j.getIO().valider();
		}
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
