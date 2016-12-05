package game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class IO {
	
	private Jeu j;
	
	public IO(Jeu _j)
	{
		this.j = _j;
	}
	
	public void afficher(String str)
	{
		System.out.println(str);
	}
	
	public void afficherSansRetour(String str)
	{
		System.out.print(str);
	}
	
	private void prompt(){
		System.out.print("~> ");
	}
	
	public String askString()
	{
		prompt();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}
	
	public int askInt()
	{
		Scanner sc = new Scanner(System.in);
		prompt();
		while (!sc.hasNextInt())
		{
			prompt();
			sc.next();
		}
		int i = sc.nextInt();
		return i;
	}
	
	public String readFile(String _f)
	{
		String str = "";
		try {
			Scanner sc = new Scanner(new FileReader(_f));
			while(sc.hasNext())
			{
				str+=sc.next();
				str+="\n";
			}
		} catch (FileNotFoundException e) {
			afficher("Fichier non trouvé !");
		}
		return str;
	}
	
	public void valider()
	{
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}
}
