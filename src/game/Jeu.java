package game;

public class Jeu {
	public Jeu()
	{
		
	}
	
	public De getDe()
	{
		return De.getInstance();
	}
	
	public Centre getCentre()
	{
		return Centre.getInstance();
	}
	
	public Pioche getPioche()
	{
		return Pioche.getInstance();
	}
	
}
