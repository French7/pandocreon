package game;

import cartes.*;
import java.util.ArrayList;

public class Camp {
	
	private ArrayList<GuideSpirituel> guides;
	
	public Camp()
	{
		guides = new ArrayList<GuideSpirituel>();
	}
	
	public void ajouterGuides(GuideSpirituel _g){
		guides.add(_g);
	}

}
