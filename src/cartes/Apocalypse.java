package cartes;

import game.Origines;

public class Apocalypse extends Carte {
	public Apocalypse(String _nom, Origines _o)
	{
		super(_nom, _o, null);
	}
	
	@Override
	public String toString()
	{
		String o = "";
		if(this.origine == null)
			o = "pas d'origine";
		else
			o = origine.toString();
		return "Apocalypse\t" + origine;
	}
}
