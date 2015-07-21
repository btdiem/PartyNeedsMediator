package applications;

import specification.IPartyGoer;
import models.Languages;
import models.Party;
import models.PartyGoer;

/**
 * 
 * @author btdiem
 *
*/


public class PartySimulation {
	
	public static void main(String[] args) {
		//create a party
		Party party = new Party("FunParty");
		System.out.println(party);
		
		//create Paul with his speaking languages
		Languages [] paulspeaks = 
		              {Languages.ENGLISH, Languages.FRENCH};
		PartyGoer paul = new PartyGoer ("Paul", paulspeaks);
		party.joinParty(paul);
		System.out.println(party);
		
		//create Geoff with his speaking languages
		Languages [] geoffspeaks = {Languages.GERMAN};
		PartyGoer geoff = new PartyGoer ("Geoff", geoffspeaks);
		party.joinParty(geoff);
		System.out.println(party);
		
		//create sam with his speaking languages
		Languages [] samspeaks = {Languages.ITALIAN, Languages.SPANISH, Languages.GERMAN};
		PartyGoer sam = new PartyGoer ("Sam", samspeaks);
		party.joinParty(sam);
		System.out.println(party);
		
		//create Bill with his speaking languages
		Languages [] billspeaks = {Languages.ENGLISH, Languages.ITALIAN, Languages.SPANISH, Languages.FRENCH};
		PartyGoer bill = new PartyGoer ("Bill", billspeaks);
		party.joinParty(bill);
		System.out.println(party);
		
		//create Tom with his speaking languages
		Languages [] tomspeaks = {Languages.ENGLISH, Languages.ITALIAN, Languages.GREEK};
		PartyGoer tom = new PartyGoer ("Tom", tomspeaks);
		party.joinParty(tom);
		System.out.println(party);
		
		//create a new party 2 and add members into party people list
		PartyGoer [] partyGoers = {tom, bill, sam, geoff, paul};
		party = new Party("FunParty2",partyGoers);
		System.out.println(party);
		
		IPartyGoer [] translators;
		
		//tom checkd whether bill can have any common speaking language with him
		if (tom.findTranslators(bill)==null)
			System.out.println("tom and bill can converse and dont need a translator\n");
		
		//paul checkd whether geoff can have any common speaking language with him
		if (paul.findTranslators(geoff)==null)
			System.out.println("paul and geoff cannot converse as no translator available\n");
		
		//find some people in the party who can help to translate between paul and sam
		translators = paul.findTranslators(sam);
		System.out.println("paul and sam can converse using one of these translators:");
		for (int i=0; i <translators.length; i++)
			System.out.println(translators[i]);
		
		System.out.println();
		//find some people in the party who can help to translate between tom and geoff
		translators = tom.findTranslators(geoff);
		System.out.println("tom and geoff can converse using one of these translators:");
		for (int i=0; i <translators.length; i++)
			System.out.println(translators[i]);
		
	}

}
