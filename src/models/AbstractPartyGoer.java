package models;

import specification.IParty;
import specification.IPartyGoer;
import specification.IMediator;

/**
 * 
 * @author btdiem
 *
 */

public abstract class AbstractPartyGoer implements IPartyGoer{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.NAME;
	}

	private final Languages [] LANGUAGES_SPOKEN;
	
	private IParty party;
	
	public final String NAME;
	
	protected IMediator mediator;
	
	public AbstractPartyGoer (String name, Languages [] spoken){
		
		party = null;
		NAME = name;
		if (spoken==null) LANGUAGES_SPOKEN = null;
		else{ LANGUAGES_SPOKEN = new Languages [spoken.length];
		      System.arraycopy(spoken,0,LANGUAGES_SPOKEN, 0, LANGUAGES_SPOKEN.length);}
	}
	
	@Override
	public boolean isSameParty(IPartyGoer other) {
		// TODO Auto-generated method stub
		return this.party.equals(other.getParty());
	}

	@Override
	public IParty getParty() {
		// TODO Auto-generated method stub
		return this.party;
	}

	public void joinParty(IParty partyToJoin){
		party = partyToJoin;
	}
	
	public int numberOfLanguagesSpoken(){
		if (LANGUAGES_SPOKEN ==null) return 0;
		return LANGUAGES_SPOKEN.length;
	}
	
	public boolean speaksLanguage(Languages language){
		
		if (LANGUAGES_SPOKEN ==null) return false;
		for (int i = 0; i< LANGUAGES_SPOKEN.length;i++)
			if (language == LANGUAGES_SPOKEN[i]) return true;
		
		return false;
	}
	/**
	 * pg should speak some languages
	 * find the common ones
	 * and return
	 * 
	 * @param pg
	 * @return
	 */
	public Languages [] languagesInCommon(IPartyGoer pg){
		
		if (LANGUAGES_SPOKEN ==null) return null;
		if (pg.numberOfLanguagesSpoken()==0) return null;
		
		Languages [] result = null;
		int numberOfLanguagesInCommon =0;
		
		for (int i = 0; i<LANGUAGES_SPOKEN.length ;i++)
			if (pg.speaksLanguage(LANGUAGES_SPOKEN[i]))
					numberOfLanguagesInCommon++;	
		
		int languageIndex=0;
		if (numberOfLanguagesInCommon>0) {
			result = new Languages[numberOfLanguagesInCommon];
			for (int i = 0; i<LANGUAGES_SPOKEN.length ;i++)
				if (pg.speaksLanguage(LANGUAGES_SPOKEN[i]))
						result[languageIndex++] = LANGUAGES_SPOKEN[i];		
		}
		
		return result;
	}
	
	public IPartyGoer [] findTranslators (IPartyGoer pg){
		
		// if you have a language in common then there is no need for a translator
		if (languagesInCommon(pg)!=null) return null;
		
        int numberOfTranslators =0;
		
		for (IPartyGoer pgindex : party.getPartyGoers())
			if ( pgindex.languagesInCommon(this)!=null && pgindex.languagesInCommon(pg)!=null)
			numberOfTranslators++;	
		
	    // no translators found
		if (numberOfTranslators==0) return null;
		
		int transindex=0;
		IPartyGoer [] translators = new PartyGoer [numberOfTranslators];
		for (IPartyGoer pgindex : party.getPartyGoers())
			if ( pgindex.languagesInCommon(this)!=null && pgindex.languagesInCommon(pg)!=null)
				translators[transindex++] = pgindex;		
		
		return translators;
		
	}
	
	public String toString (){
		
		String str;
		if (party == null)
			str = NAME+" is a member of no party";
		else 
			str =NAME+" is a member of party - "+ party.getName()+" -";
		
		str = str +" and speaks "+ numberOfLanguagesSpoken()+" languages:";
		if (LANGUAGES_SPOKEN ==null) return str;
		
		for (int i = 0; i<LANGUAGES_SPOKEN.length ;i++)
			str = str +" "+ LANGUAGES_SPOKEN[i];
		
		return str;
		
	}
}
