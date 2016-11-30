package game;

public final class De {
	
	private static De instance = null;
	private String[] faces;
	
	private De()
	{
		faces = new String[3];
		faces[0] = "jour";
		faces[1] = "nuit";
		faces[2] = "neant";
	}
	
	public final static De getInstance()
	{
		if (De.instance == null)
		{
			De.instance = new De();
		}
		return De.instance;
	}
	
	public String lancer()
	{
		int n = (int) (Math.random() * (3));
		return this.faces[n];
	}
}