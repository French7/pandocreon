package game;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import cartes.Apocalypse;
import cartes.Croyant;
import cartes.DeusEx;
import divinites.Divinite;

public class Jeu {
	
	private ArrayList<Joueur> joueurs;
	private IO io;
	private LinkedList<Divinite> divinites;
	private Pioche pioche;
	
	public Jeu()
	{
		io = new IO(this);
		afficher("Bienvenue.", this, true);
		initCartes();
		initDivinites();
		this.joueurs = new ArrayList<Joueur>();
		initJoueurs();
		initJoueursIA();
		lancerPartie();
	}
	
	public void lancerPartie()
	{
		for (Joueur j : joueurs) {
			afficher(j.getName()+", appuyez sur [Entrée] pour piocher votre carte Divinité.", this, false);
			io.valider();
			j.tour();
		}
		while(joueurs.size() > 1)
		{
			for (Joueur joueur : joueurs) {
				joueur.tour();
			}
		}
	}
	
	private void initJoueurs()
	{		
		afficher("Combien de joueurs réels ?", this, true);
		int nbJoueursH = 0;
		while (nbJoueursH < 1)
		{
			nbJoueursH = io.askInt();
		}
		
		for (int i = 1; i <= nbJoueursH; i++)
		{
			afficher("Nom du joueur humain " + i, this, true);
			String nom = io.askString();
			joueurs.add(new JoueurHumain(this, nom));
		}
		
		afficher("Combien de joueurs virtuels ?", this, true);
		int nbJoueursV = io.askInt();
		
		while (nbJoueursH + nbJoueursV < 2)
		{
			nbJoueursV = io.askInt();
		}
		
		for (int i = 1; i <= nbJoueursV; i++)
		{
			afficher("Nom du joueur virtuel " + i, this, true);
			String nom = io.askString();
			joueurs.add(new JoueurIA(this, nom));
		}
		
		// remplissage des mains des joueurs
		for (Joueur joueur : joueurs) {
			for(int i=0;i<7;i++)
				joueur.piocherCarte();
		}
		
		io.afficher("Les 7 cartes d'action ont été distribuées");
	}
	
	private void initJoueursIA()
	{
		
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
			
			try {
				divinites.add(new Divinite(name, origine, dogmes));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Collections.shuffle(divinites); //mélange !
	}
	
	private void initCartes()
	{
		// croyants
		String f = io.readFile("CROYANTS.txt");
		Parser p = new Parser();
		for (String line : p.parseFile(f)) { // split le fichier en lignes
			String name = p.getName(line);
			Origines origine = p.getOrigine(line);
			ArrayList<Dogmes> dogmes = p.getDogmes(line);
			int nbCroyants = p.getNbCroyants(line);
			
			try {
				Pioche.getInstance().ajouterCarte(new Croyant(name, origine, dogmes, nbCroyants));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// deus ex
		f = io.readFile("DEUSEX.txt");
		p = new Parser();
		for (String line : p.parseFile(f)) { // split le fichier en lignes
			String name = p.getName(line);				
			Origines origine = p.getOrigine(line);
			
			try {
				Pioche.getInstance().ajouterCarte(new DeusEx(name, origine));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// apocalypses
		f = io.readFile("APOCALYPSE.txt");
		p = new Parser();
		for (String line : p.parseFile(f)) { // split le fichier en lignes
			String name = p.getName(line);				
			Origines origine = p.getOrigine(line);
			
			try {
				Pioche.getInstance().ajouterCarte(new Apocalypse(name, origine));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Collections.shuffle(Pioche.getInstance().getListeCartes()); //mélange !
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

	public void afficher(String str, Object origine, boolean retour)
	{
		String prefix = "";
		if(origine.getClass() == JoueurHumain.class || origine.getClass() == JoueurIA.class)
			prefix = ((Joueur)origine).getName() + "> ";
		else
			prefix = "#> ";
		if (retour)
			io.afficher(prefix + str);	
		else
			io.afficherSansRetour(prefix + str);
	}
	
	public IO getIO()
	{
		return this.io;
	}
	
}
