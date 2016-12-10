package game;

import java.util.ArrayList;

import cartes.*;
import divinites.Divinite;

public abstract class Joueur {
	
	protected Jeu j;
	protected Divinite d;
	protected MainJoueur main;
	protected Camp camp;
	protected int paJour, paNuit, paNeant;
	protected String name;
	protected IO vue;
	protected boolean jeuLance;
	
	public Joueur(Jeu _j, String _name)
	{
		this.j = _j;
		this.name = _name;
		main = new MainJoueur();
		camp = new Camp();
		paJour = 0;
		paNuit = 0;
		paNeant = 0;
		jeuLance = false;
		vue = j.getIO();
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
			boolean joue = false; 
			vue.valider();
			while(!joue)
			{
				vue.afficher(vue.getEtat(this));
				vue.afficher("Que voulez vous faire ?");
				vue.afficher("1. Défausser des cartes");
				vue.afficher("2. Compléter votre main à 7");
				vue.afficher("3. Jouer");
				
				switch(vue.askInt())
				{
					case 1:
						vue.afficher("Quelle carte défausser ?");
						int index = -1;
						while(index < 0 || index > main.nbCartes())
							index = vue.askInt()-1;
						defausserCarte(main.getCartes().get(index));
						break;
					case 2:
						vue.afficher("Vous avez " + main.getCartes().size() + " cartes en main.");
						for(int i = main.getCartes().size() ; i < 7 ; i++){
							piocherCarte();
						}
						vue.afficher("Vous avez maintenant 7 cartes en main.");
						break;
					case 3:
						joue = true;
						vue.afficher("Que voulez faire ?");
						vue.afficher("1. Jouer carte action.");
						vue.afficher("2. Sacrifier");
						
						if (vue.askInt() == 1)
						{
							vue.afficher("Quelle carte voulez-vous jouer ?");
							vue.afficher(vue.descCartes(main.getCartes()));
							jouerCarte(choixCarte());
							//effet
						}
						
						else if(vue.askInt() == 2)
						{
							vue.afficher("Quelle carte voulez-vous sacrifier ?");
							sacrifierCarte(choixCarte());
							
						}
				}
			}
		}
	}
	
	protected String lancerDe()
	{
		return j.getDe().lancer();
	}
	
	protected void piocherCarte()
	{
		Carte c = j.getPioche().piocher();
		this.main.ajouterCarte(c);
	}
	
	protected Carte choixCarte()
	{
		int numCarte = -1;
		while (numCarte < 0 || numCarte > main.getCartes().size())
			numCarte = vue.askInt() - 1;
		
		return main.getCartes().get(numCarte);
	}
	
	protected void defausserCarte(Carte _c)
	{
		j.getPioche().ajouterCarte(_c);
		main.retirerCarte(_c);
	}
	
	protected void piocherDivinite()
	{
		this.d = j.piocheDivinite();
		String nomDivinite = d.getNom();
		Origines originieDivinite = d.getOrigine();
		ArrayList<Dogmes> dogmesDivinite = d.getDogmes();
		feedback("Divinité piochée : " + nomDivinite + " - " + originieDivinite + " - " + dogmesDivinite + " : " + this.d.getPouvoir());
	}
	
	protected void feedback(String str)
	{
		j.getIO().afficher(str);
	}

	protected void jouerCarte(Carte _c)
	{
		main.retirerCarte(_c);
		switch (_c.getClass().getSimpleName()){
		case "Croyant":
			 j.ajouterCroyantAuCentre((Croyant) _c);
			 vue.afficher(vue.descCartes(j.getCentre().getCroyants()));
			 break;
		case "GuideSpirituel":
			camp.ajouterGuides((GuideSpirituel) _c);
			if (j.getCentre().getNbCroyants() > 0){
				vue.afficher("Quel croyant voulez-vous ramenez dans votre camp ?");
				vue.afficher("0\tAucun");
				for (int i = 1 ; i < j.getCentre().getNbCroyants() ; i++) {
					vue.afficher(i + "\t" + j.getCentre().getCroyant(i));
				}
				int i = -1;
				while(i<0 && i<j.getCentre().getNbCroyants()) i = vue.askInt();
				// on essaie d'ajouter le croyant au GS
				j.croyantVersGuide(j.getCentre().getCroyant(i), (GuideSpirituel) _c);
			}
			else{
				vue.afficher("Pas de croyants au centre.");
			}
			break;
		case "DeusEx":
			_c.effet();
			break;
		case "Apocalypse":
			j.apocalypse();
			break;
		}
	}
	
	protected void sacrifierCarte(Carte _c)
	{
		
	}
	
	public String getName()
	{
		return this.name; 
	}
	
	public int getPP()
	{
		return main.getPP();
	}
	
	public String toString()
	{
		String str = this.name;
		if(this instanceof JoueurHumain) str+="\thumain\t";
		else str+="\tIA\t";
		str+= paJour + " PA Jour, " + paNuit + " PA Nuit, " + paNeant + " PA Néant";
		for (Carte c : main.getCartes()) {
			str+= c.toString()+"\n";
		}
		return str;
	}
	
	public void afficher(String _str)
	{
		j.getIO().afficher(this.name + "> " + _str);
	}
	
	public Divinite getDivinite()
	{
		return this.d;
	}
	
	public void recupererCroyant()
	{
		
	}
	
	public void ajouterPAJour(int n)
	{
		j.getIO().afficher(this.name + " gagne " + n + "PA Jour.");
		this.paJour+=n;
	}
	
	public void ajouterPANuit(int n)
	{
		j.getIO().afficher(this.name + " gagne " + n + "PA Nuit.");
		this.paNuit+=n;
	}
	
	public void ajouterPANeant(int n)
	{
		j.getIO().afficher(this.name + " gagne " + n + "PA Néant.");
		this.paNeant+=n;
	}
	
	public int getPAJour()
	{
		return this.paJour;
	}
	
	public int getPANuit()
	{
		return this.paNuit;
	}
	
	public int getPANeant()
	{
		return this.paNeant;
	}
	
	public MainJoueur getMainJoueur()
	{
		return this.main;
	}
	
	
	// A REDEFINIR DANS JOUEURAI/JOUEURHUMAIN
	
	public int askInt()
	{
		return 0;
	}
	
	public String askString()
	{
		return "";
	}
}
