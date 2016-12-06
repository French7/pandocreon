package cartes;

import game.Origines;

public class DeusEx extends Carte {
	public DeusEx(String _nom, Origines _o)
	{
		super(_nom, _o, null);
	}
	
	@Override
	public String toString()
	{
		String o = "";
		if(this.origine.equals("null"))
			o = "pas d'origine";
		else
			o = origine.toString();
		return "Deus Ex - " + nom + ", " + origine;
	}
}
