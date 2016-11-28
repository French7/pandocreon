package game;

import java.util.Scanner;

public class IO {
	
	private Jeu j;
	
	public IO(Jeu _j)
	{
		this.j = _j;
	}
	
	public void afficher(String srt)
	{
		System.out.println(srt);
	}
	
	private void prompt(){
		System.out.print("> ");
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
}
