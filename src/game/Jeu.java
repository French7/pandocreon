package game;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import cartes.Apocalypse;
import cartes.Croyant;
import cartes.DeusEx;
import cartes.GuideSpirituel;
import divinites.Divinite;

public class Jeu {
	
	private ArrayList<Joueur> joueurs;
	private IO io;
	private LinkedList<Divinite> divinites;
	private Pioche pioche;
	
	public Jeu()
	{
		io = new IO(this);
		io.afficher("Bienvenue.");
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
			io.afficher(j.getName()+", appuyez sur [Entrée] pour piocher votre carte Divinité.");
			io.valider();
			j.tour();
		}
		while(joueurs.size() > 1)
		{
			for (Joueur joueur : joueurs) {
				lancementDe();
				io.afficher("C'est au tour de "+joueur.getName()+" de jouer.");
				joueur.tour();
			}
		}
	}
	
	private void initJoueurs()
	{		
		io.afficher("Combien de joueurs réels ?");
		int nbJoueursH = 0;
		while (nbJoueursH < 1)
		{
			nbJoueursH = io.askInt();
		}
		
		for (int i = 1; i <= nbJoueursH; i++)
		{
			io.afficher("Nom du joueur humain " + i);
			String nom = io.askString();
			joueurs.add(new JoueurHumain(this, nom));
		}
		
		io.afficher("Combien de joueurs virtuels ?");
		int nbJoueursV = io.askInt();
		
		while (nbJoueursH + nbJoueursV < 2)
		{
			nbJoueursV = io.askInt();
		}
		
		for (int i = 1; i <= nbJoueursV; i++)
		{
			io.afficher("Nom du joueur virtuel " + i);
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
		Parser p = new Parser();
		// croyants
		String f = io.readFile("CROYANTS.txt");
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
		
		// guides spirituels
				f = io.readFile("GS.txt");
				for (String line : p.parseFile(f)) { // split le fichier en lignes
					String name = p.getName(line);
					Origines origine = p.getOrigine(line);
					ArrayList<Dogmes> dogmes = p.getDogmes(line);
					int nbCroyantsMax = p.getNbCroyants(line);
					
					try {
						Pioche.getInstance().ajouterCarte(new GuideSpirituel(name, origine, dogmes, nbCroyantsMax));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		
		// deus ex
		f = io.readFile("DEUSEX.txt");
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
	
	public void lancementDe()
	{
		String de = getDe().lancer().toUpperCase();		
		io.afficher("Lancement du Dé de Cosmogonie : " + de);
		switch (de) {
		case "JOUR":
			for (Joueur j : joueurs) {
				if(j.getDivinite().getOrigine() == Origines.JOUR)
					j.ajouterPAJour(2);
				else if (j.getDivinite().getOrigine() == Origines.AUBE)
					j.ajouterPAJour(1);
			}
			break;
			
		case "NUIT":
			for (Joueur j : joueurs) {
				if(j.getDivinite().getOrigine() == Origines.NUIT)
					j.ajouterPANuit(2);
				else if (j.getDivinite().getOrigine() == Origines.CREPUSCULE)
					j.ajouterPANuit(1);
			}
			break;
			
		case "NEANT":
			for (Joueur j : joueurs) {
				if(j.getDivinite().getOrigine() == Origines.NEANT)
					j.ajouterPAJour(2);
				else if (j.getDivinite().getOrigine() == Origines.AUBE || j.getDivinite().getOrigine() == Origines.CREPUSCULE)
					j.ajouterPAJour(1);
			}
			break;
			
		default:
			break;
		}
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

	public IO getIO()
	{
		return this.io;
	}
	
}
