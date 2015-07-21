/**
 * 
 */
package specification;

import models.Languages;
import models.PartyGoer;

/**
 * This is an interface that refactor the old {@link PartyGoer}
 * @author btdiem
 *
 */
public interface IPartyGoer {

	public void joinParty(IParty partyToJoin);
	public int numberOfLanguagesSpoken();
	public boolean speaksLanguage(Languages language);
	public Languages [] languagesInCommon(IPartyGoer pg);
	public IPartyGoer [] findTranslators (IPartyGoer pg);
	public boolean isSameParty(IPartyGoer other);
	public IParty getParty();
	/**
	 * return name of IPartyGoer
	 * @return
	 */
	public String getName();
}
