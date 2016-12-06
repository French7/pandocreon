package cartes;

import java.util.ArrayList;

import game.Dogmes;
import game.Origines;

public class Croyant extends Carte {
	
	private int nbCroyants;
	
	public Croyant(String _nom, Origines _o, ArrayList<Dogmes> _dogmes, int _nbCroyants)
	{
		super(_nom, _o, _dogmes);
		this.nbCroyants = _nbCroyants;
	}
	
	@Override
	public String toString()
	{
		return "Croyant\t" + nom + "\t" + origine + "\t" + dogmes + "\treprésente " + nbCroyants + " croyants";
	}
}
