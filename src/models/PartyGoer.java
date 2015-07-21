package models;

import specification.IMediator;
import specification.IPartyGoer;
/**
 * 
 * @author btdiem
 *
 */
public class PartyGoer extends AbstractPartyGoer implements IPartyGoer{

	public PartyGoer(String name, Languages[] spoken) {
		super(name, spoken);
	}
	/**
	 * This constructor is used to register itself to {@link IMediator}
	 * @param name
	 * @param spoken
	 * @param mediator
	 */
	public PartyGoer(String name, Languages[] spoken, IMediator mediator) {
		super(name, spoken);
		mediator.register(this);
	}

}
