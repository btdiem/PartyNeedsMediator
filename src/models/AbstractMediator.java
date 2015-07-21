package models;

import java.util.ArrayList;
import java.util.List;

import specification.IMediator;
import specification.IPartyGoer;

/**
 * 
 * @author btdiem
 *
 */

public abstract class AbstractMediator implements IMediator{

	protected List<IPartyGoer> listPartyGoer;
	
	public AbstractMediator(){
		listPartyGoer = new ArrayList<IPartyGoer>();
	}
	/*
	 * (non-Javadoc)
	 * @see specification.IMediator#register(specification.IPartyGoer)
	 * 
	 * Just adding the new IPartyGoer
	 */
	@Override
	public void register(IPartyGoer partyGoer) {
		// TODO Auto-generated method stub
		if (!listPartyGoer.contains(partyGoer)){
			listPartyGoer.add(partyGoer);
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see specification.IMediator#getRegisters()
	 */
	@Override
	public List<IPartyGoer> getRegisters() {
		// TODO Auto-generated method stub
		return this.listPartyGoer;
	}
	
	
}
