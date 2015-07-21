package specification;

import java.util.List;

import models.Languages;

/**
 * 
 * @author btdiem
 *
*/


public interface IMediator {
	/**
	 * The {@link IPartyGoer} will register itself with {@link IMediator}
	 * @param partyGoer
	 */
	public void register(IPartyGoer partyGoer);
	/**
	 * When {@link IPartyGoer} calls this function, it will returns a List of {@link IPartyGoer}
	 * who have the same speaking {@link Languages}
	 * Return null if both can communicate each other
	 * @return 
	 */
	public List<IPartyGoer> findTranslator(IPartyGoer person1, IPartyGoer person2);
	/**
	 * Return a list of {@link IPartyGoer} who registers to {@link IMediator} system
	 * @return List<IPartyGoer>
	 */
	public List<IPartyGoer> getRegisters();
}
