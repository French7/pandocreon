package game;

import java.util.ArrayList;

public class Parser {
	public Parser()
	{
		
	}
	
	public String[] parseFile(String _in)
	{
		return _in.split("\n");
	}
	
	public String[] parseLine(String _in)
	{
		return _in.split(";");
	}
	
	public String getName(String _in)
	{
		return _in.split(";")[0];
	}
	
	public Origines getOrigine(String _in)
	{
		if(_in.split(";")[1].equals("null"))
			return null;
		else
			return Origines.valueOf(_in.split(";")[1]);
	}
	
	public ArrayList<Dogmes> getDogmes(String _in)
	{
		String dogmes = _in.split(";")[2];
		String[] dogmesArray = dogmes.split(",");
		ArrayList<Dogmes> dogmesArrayList = new ArrayList<Dogmes>();
		for (String str : dogmesArray) {
			dogmesArrayList.add(Dogmes.valueOf(str));
		}
		return dogmesArrayList;
	}
	
	public int getNbCroyants(String _in)
	{
		return Integer.parseInt(_in.split(";")[3]);
	}
}
