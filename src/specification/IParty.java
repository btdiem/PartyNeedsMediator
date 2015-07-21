package specification;

import java.util.List;

/**
 * 
 * @author btdiem
 *
*/


public interface IParty {

	public String getName ();
	public void joinParty(IPartyGoer pg);
	public List<IPartyGoer> getPartyGoers();
}
