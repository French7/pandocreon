package game;

import java.util.Scanner;

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
			afficher("Lancement du Dé de Cosmogonie : appuyez sur [Entrée]");
			j.getIO().valider();
			String de = j.getDe().lancer();
			j.getIO().afficher(de);
			j.getIO().afficher("Que voulez vous jouer ?\n"
					+ "1- ...");
			int choix = askInt();
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
