package cartes;

import game.*;
import java.util.ArrayList;

public abstract class Carte {
	
	protected String nom;
	protected Origines origine;
	protected ArrayList<Dogmes> dogmes;
	
	public Carte(String _nom, Origines _o, ArrayList<Dogmes> _dogmes)
	{
		this.nom = _nom;
		this.origine = _o;
		this.dogmes = _dogmes;
	}
	
	public void effet()
	{
		
	}
}
