package game;

import java.util.ArrayList;

public class Jeu {
	
	private ArrayList<Joueur> joueurs;
	private IO io;
	
	public Jeu()
	{
		io = new IO(this);
		io.afficher("Bienvenue.");
		initCartes();
		initJoueurs();
	}
	
	private void initJoueurs()
	{
		this.joueurs = new ArrayList<Joueur>();
		
		io.afficher("Combien de joueurs ?");
		int nbJoueurs = 0;
		while (nbJoueurs < 2)
		{
			nbJoueurs = io.askInt();
		}
		
		for (int i = 1; i <= nbJoueurs; i++)
		{
			io.afficher("Nom du joueur " + i);
			String nom = io.askString();
			joueurs.add(new JoueurHumain(this, nom));
		}
		
		System.out.println("Résumé des joueurs :");
		for (Joueur j : joueurs) {
			System.out.println(j);
		}
	}
	
	private void initDivinites()
	{
		
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
