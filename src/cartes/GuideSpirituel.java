package cartes;

import java.util.ArrayList;

import game.Dogmes;
import game.Origines;

public class GuideSpirituel extends Carte {

	private ArrayList<Croyant> croyants;
	private int nbCroyantsMax;
	
	public GuideSpirituel(String _nom, Origines _o, ArrayList<Dogmes> _dogmes, int _nbMax)
	{
		super(_nom, _o, _dogmes);
		this.nbCroyantsMax = _nbMax;
	}
	
	public boolean recupererCroyant(Croyant croyant) {
		boolean dogmeEnCommun = false;
		for (Dogmes d : dogmes) {
			if (croyant.hasDogme(d))
				dogmeEnCommun = true;
		}
		if (croyants.size() < nbCroyantsMax && dogmeEnCommun)
		{
				croyants.add(croyant);
				return true;
		} else
		{
			return false;
		}
	}
	
	public int getPP()
	{
		int pp = 0;
		for(Croyant c : croyants)
		{
			pp+=c.getPP();
		}
		return pp;
	}
	
	@Override
	public String toString()
	{
		String o = "";
		if(this.origine.equals("null"))
			o = "pas d'origine";
		else
			o = origine.toString();
		return "Guide Spirituel\t" + nom + "\t" + origine + "\treprésente " + nbCroyantsMax + " maximum";
	}
}
