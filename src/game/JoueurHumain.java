package game;


public class JoueurHumain extends Joueur {
	
	public JoueurHumain(Jeu _j, String _name)
	{
		super(_j, _name);
		
	}
	
	/*public void tour()
	{
		
	}*/
	
	public int askInt()
	{
		return vue.askInt();
	}
	
	public String askString()
	{
		return vue.askString();
	}
}
