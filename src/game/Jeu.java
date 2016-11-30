package game;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import divinites.Divinite;

public class Jeu {
	
	private ArrayList<Joueur> joueurs;
	private IO io;
	private LinkedList<Divinite> divinites;
	
	public Jeu()
	{
		io = new IO(this);
		afficher("Bienvenue.", this);
		initCartes();
		initDivinites();
		initJoueurs();
		lancerPartie();
	}
	
	public void lancerPartie()
	{
		for (Joueur j : joueurs) {
			afficher(j.getName()+", voici votre carte Divinité.", this);
			j.tour();
		}
		while(true)
		{
			
		}
	}
	
	private void initJoueurs()
	{
		this.joueurs = new ArrayList<Joueur>();
		
		afficher("Combien de joueurs ?", this);
		int nbJoueurs = 0;
		while (nbJoueurs < 2)
		{
			nbJoueurs = io.askInt();
		}
		
		for (int i = 1; i <= nbJoueurs; i++)
		{
			afficher("Nom du joueur " + i, this);
			String nom = io.askString();
			joueurs.add(new JoueurHumain(this, nom));
		}
	}
	
	private void initDivinites()
	{
		this.divinites = new LinkedList<Divinite>();
		String f = io.readFile("DIVINITES.txt");
		Parser p = new Parser();
		for (String line : p.parseFile(f)) { // split le fichier en lignes
			String name = p.getName(line);
			Origines origine = p.getOrigine(line);
			ArrayList<Dogmes> dogmes = p.getDogmes(line);
			
			divinites.add(new Divinite(name, origine, dogmes));
		}
		Collections.shuffle(divinites); //mélange !
	}
	
	private void initCartes()
	{
		
	}
	
	public Divinite piocheDivinite()
	{
		return divinites.poll();
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

	public void afficher(String str, Object origine)
	{
		String prefix = "";
		if(origine.getClass() == JoueurHumain.class || origine.getClass() == JoueurIA.class)
			prefix = ((Joueur)origine).getName() + "> ";
		else
			prefix = "#> ";
		System.out.println(prefix + str);	
	}
	
}
