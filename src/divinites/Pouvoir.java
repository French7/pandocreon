package divinites;

import java.lang.reflect.Method;

public class Pouvoir {
	
	private String description;
	private Method pouvoir;
	
	public Pouvoir(String _nomDivinite) throws NoSuchMethodException, SecurityException
	{
		switch (_nomDivinite) {
		case "Brewalen":
			this.description = "Peut empêcher l'utilisation d'une carte Apocalypse.";
			this.pouvoir = Pouvoir.class.getDeclaredMethod("empechePoseApocalypse");
			break;
		case "Drinded":
			this.description = "Peut empêcher le sacrifice d'un des Guides Spirituels de n'importe quel joueur.";
			this.pouvoir = Pouvoir.class.getDeclaredMethod("empecheSacrifice");
			break;
		case "Yarstur":
			this.description = "Peut détruire toutes les cartes de croyants au centre de la table de type Néant.";
			this.pouvoir = Pouvoir.class.getDeclaredMethod("detruireCroyantsNeant");
			break;
		case "Killinstred":
			this.description = "Peut obliger un joueur à poser une carte Apocalypse s'il en possède une.";
			this.pouvoir = Pouvoir.class.getDeclaredMethod("obligePoseApocalypse");
			break;
		case "Llewella":
			this.description = "Peut empêcher l'utilisation d'une carte Apocalypse.";
			this.pouvoir = Pouvoir.class.getDeclaredMethod("empechePoseApocalypse");
			break;
		case "Pui-Tara":
			this.description = "Peut empêcher l'utilisation d'une carte Apocalypse.";
			this.pouvoir = Pouvoir.class.getDeclaredMethod("detruireCroyantsJour");
			break;
		case "Gwenghelen":
			this.description = "Peut empêcher l'utilisation d'une carte Apocalypse.";
			this.pouvoir = Pouvoir.class.getDeclaredMethod("recuperePANeant");
			break;
		case "Shingva":
			this.description = "Peut empêcher l'utilisation d'une carte Apocalypse.";
			this.pouvoir = Pouvoir.class.getDeclaredMethod("sacrificeGSDogmeNature");
			break;
		case "Gorpa":
			this.description = "Peut empêcher l'utilisation d'une carte Apocalypse.";
			this.pouvoir = Pouvoir.class.getDeclaredMethod("volePA");
			break;
		case "Romtec":
			this.description = "Peut empêcher l'utilisation d'une carte Apocalypse.";
			this.pouvoir = Pouvoir.class.getDeclaredMethod("empecheCreationGS");
			break;
		default:
			break;
		}
	}
	
	public void invoquerPouvoir()
	{
		try {
			this.pouvoir.invoke(this, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void obligePoseApocalypse()
	{
		
	}
	
	public void recuperePANeant()
	{
		
	}
	
	public void empecheSacrifice()
	{
		
	}
	
	public void detruireCroyantsNeant()
	{
		
	}
	
	public void empechePoseApocalypse()
	{
		
	}
	
	public void detruireCroyantsJour()
	{
		
	}
	
	public void sacrificeGSDogmeNature()
	{
		
	}
	
	public void volePA()
	{
		
	}
	
	public void empecheCreationGS()
	{
		
	}
	
	@Override
	public String toString()
	{
		return this.description;
	}
}
