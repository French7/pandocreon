package game;

import java.util.Scanner;

import cartes.Carte;

public class JoueurHumain extends Joueur {
	
	private IO vue = j.getIO();
	
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
			vue.valider();
			vue.getEtat(this);
			getMainJoueur();
			vue.afficher("Que voulez vous faire ?");
			vue.afficher("1. Défausser des cartes");
			vue.afficher("2. Compléter votre main à 7");
			vue.afficher("3. Jouer");

			boolean end = false;
			
			while(!end)
			{
				switch(vue.askInt())
				{
					case 1:
						vue.afficher("Quelle carte défausser ?");
						vue.afficher(vue.descCartes(main.getCartes()));
						int index = 0;
						while(index < 1 || index > main.nbCartes())
							index = vue.askInt();
						defausserCarte(main.getCartes().get(index));
						break;
					case 2:
						vue.afficher("Vous avez " + main.getCartes().size() + " cartes en main.");
						for(int i = main.getCartes().size() ; i < 7 ; i++){
							piocherCarte();
						}
						vue.afficher("Vous avez maintenant 7 cartes en main.");
						vue.afficher(vue.descCartes(main.getCartes()));
						break;
					case 3:
						vue.afficher("Que voulez faire ?");
						vue.afficher("1. Jouer carte action.");
						vue.afficher("2. Sacrifier");
						vue.askInt();
						
						if (vue.askInt() == 1)
						{
							vue.afficher("Quelle carte voulez-vous jouer ?");
							//choisirCarte(int numCarte);
							//effet
						}
						
						else if(vue.askInt() == 2)
						{
							vue.afficher("Quelle carte voulez-vous sacrifier ?");
							//choisirCarte(numCarte);
							//sacrifierCarte(choisirCarte(numCarte));
							
						}
				}
			}
		}
	}
	
	public int askInt()
	{
		return vue.askInt();
	}
	
	public String askString()
	{
		return vue.askString();
	}
}
