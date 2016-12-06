package cartes;

import java.util.ArrayList;

import game.Dogmes;
import game.Origines;

public class GuideSpirituel extends Carte {

	private ArrayList<Croyant> croyants;
	
	public GuideSpirituel(String _nom, Origines _o, ArrayList<Dogmes> _dogmes)
	{
		super(_nom, _o, _dogmes);
	}
	
	@Override
	public String toString()
	{
		String o = "";
		if(this.origine.equals("null"))
			o = "pas d'origine";
		else
			o = origine.toString();
		return "Guide Spirituel - " + nom + ", " + origine;
	}
}
