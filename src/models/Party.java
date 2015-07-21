package models;

import java.util.List;
import java.util.Vector;

import specification.IParty;
import specification.IPartyGoer;

/**
 * 
 * @author btdiem
 *
 */

public class Party implements IParty{
	
	public Vector <IPartyGoer> partyGoers;
	
	public String name;
	
	public Party (String name){
		
		this.name = name;
		partyGoers = new Vector<IPartyGoer> ();
	}
	
	public String getName (){return name;}
	
	
	public Party (String name, IPartyGoer [] partyPeople){
		this.name = name;
		partyGoers = new Vector<IPartyGoer> ();
		if (partyPeople == null) return;
		
		for (int i =0; i< partyPeople.length; i++)
			{partyGoers.add(partyPeople[i]);
			 partyPeople[i].joinParty(this);
			}
	}
	
	public void joinParty(IPartyGoer pg){
		
		pg.joinParty(this);
		partyGoers.add(pg);
		
	}
	
	
	public String toString (){
		String str ="People at the "+ name+" party are -\n";
		for (IPartyGoer pg : partyGoers) str = str+pg+"\n";
		return str;
	}

	@Override
	public List<IPartyGoer> getPartyGoers() {
		// TODO Auto-generated method stub
		return partyGoers;
	}

}
