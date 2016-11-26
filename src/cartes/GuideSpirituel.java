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
}
