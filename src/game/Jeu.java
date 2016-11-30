package game;


import java.util.ArrayList;
import divinites.Divinite;

public class Jeu {
	
	private ArrayList<Joueur> joueurs;
	private IO io;
	private ArrayList<Divinite> divinites;
	
	public Jeu()
	{
		io = new IO(this);
		io.afficher("Bienvenue.");
		initCartes();
		initDivinites();
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
		this.divinites = new ArrayList<Divinite>();
		String f = io.readFile("DIVINITES.txt");
		Parser p = new Parser();
		for (String line : p.parseFile(f)) { // split le fichier en lignes
			String name = p.getName(line);
			Origines origine = p.getOrigine(line);
			ArrayList<Dogmes> dogmes = p.getDogmes(line);
			
			divinites.add(new Divinite(name, origine, dogmes));
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
