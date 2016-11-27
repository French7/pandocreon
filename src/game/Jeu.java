package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {
	
	private ArrayList<Joueur> joueurs;
	private int nbJoueurs;
	
	public Jeu()
	{
		System.out.println("Bienvenue.");
		initCartes();
		initJoueurs();
	}
	
	private void initJoueurs()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Combien de joueurs ?");
		nbJoueurs = 0;
		while (nbJoueurs < 2)
		{
			System.out.print("> ");
			while (!sc.hasNextInt())
			{
				System.out.print("> ");
				sc.nextLine();
			}
			nbJoueurs = sc.nextInt();
		}
		
		for (int i = 1; i < nbJoueurs; i++)
		{
			System.out.println("Nom du joueur " + i);
			System.out.println("> ");
			String nom = sc.nextLine(); // probleme
			joueurs.add(new JoueurHumain(this, nom));
		}
	}
	
	private void initCartes()
	{
		
	}
	
	public De getDe()
	{
		return De.getInstance();
	}
	
	public Centre getCentre()
	{
		return Centre.getInstance();
	}
	
	public Pioche getPioche()
	{
		return Pioche.getInstance();
	}
	
}
