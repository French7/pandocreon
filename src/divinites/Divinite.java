package divinites;


import java.util.ArrayList;

import game.Dogmes;
import game.Origines;

public class Divinite {
	protected String nom;
	protected Origines origine;
	protected ArrayList<Dogmes> dogmes;
	
	public Divinite(String _nom, Origines _o, ArrayList<Dogmes> _dogmes)
	{
		this.nom = _nom;
		this.origine = _o;
		this.dogmes = _dogmes;
	}
	
	public void pouvoir()
	{
		
	}
}
