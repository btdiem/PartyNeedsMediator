package applications;

import java.util.List;

import models.Languages;
import models.Mediator;
import models.PartyGoer;
import specification.IMediator;
import specification.IPartyGoer;

/**
 * 
 * @author btdiem
 *
*/

public class MediatorSimulation {

	public static void main(String[] args) {
		//create a person with their own languages
		IMediator mediator = new Mediator();
		
		Languages [] paulspeaks = {Languages.ENGLISH, Languages.FRENCH, Languages.SPANISH};
		PartyGoer pg1 = new PartyGoer ("Paul", paulspeaks, mediator);
		System.out.println(pg1);
		//check which language he can not speak
		for (Languages l : Languages.values())			
			if (!pg1.speaksLanguage(l)) System.out.println("Paul does not speak "+l);
		
		System.out.println("\n\n");
		//create a person
		Languages [] geoffspeaks = {Languages.GREEK, Languages.ENGLISH, Languages.ITALIAN, Languages.SPANISH};
		PartyGoer pg2 = new PartyGoer ("Geoff", geoffspeaks, mediator);
		System.out.println(pg2);
		//check which language he can not speak
	    for (Languages l : Languages.values())			
			if (!pg2.speaksLanguage(l)) System.out.println("Geoff does not speak "+l);
		
		Languages [] billspeaks = {Languages.ITALIAN};
		PartyGoer bill = new PartyGoer ("Bill", billspeaks, mediator);
		/**
		 * This is a translator for pg1 and bill
		 */
		Languages [] diemspeaks = {Languages.ITALIAN, Languages.ENGLISH};
		PartyGoer diem = new PartyGoer ("Diem", diemspeaks, mediator);
		
	    System.out.println("\n\n");
	  //create a person with their own languages
		Languages [] dummyspeaks = null;
		PartyGoer pg3 = new PartyGoer ("Dummy", dummyspeaks, mediator);
		System.out.println(pg3);
		//check which language he can not speak
	    for (Languages l : Languages.values())			
			if (!pg3.speaksLanguage(l)) System.out.println("Dummy does not speak "+l);
	    
	    System.out.println("\n\n");
	    //return the number of languages that both can communicate
	    List<IPartyGoer> translators = mediator.findTranslator(pg1, pg2);
	    displayMessage(pg1, pg2, translators);
	    System.out.println();
	    
	    //return the number of languages that both can communicate
	    translators = mediator.findTranslator(pg2, pg1);
	    displayMessage(pg2, pg1, translators);

	    System.out.println("\n\n");
	    translators = mediator.findTranslator(pg2, pg2);
	    displayMessage(pg2, pg2, translators);

	    System.out.println();
	    
	    translators = mediator.findTranslator(pg1, pg3);
	    displayMessage(pg1, pg3, translators);

	    
	    translators = mediator.findTranslator(pg2, pg3);
	    displayMessage(pg2, pg3, translators);

	    translators = mediator.findTranslator(pg1, bill);
	    displayMessage(pg1, bill, translators);

	    System.out.println();
	    
	}
	
	static void displayMessage(PartyGoer person1, PartyGoer person2, List<IPartyGoer> translators){
		
		if (translators == null || translators.isEmpty()){
			System.out.println(person1.getName() + "and  " + person2.getName() + " do not need a translator");
		}else{
			
			System.out.print(person1.getName() + " can communicate with: " + person2.getName() + " via :");
			for (IPartyGoer translator : translators){
				System.out.print(translator.getName() + "   ");
			}
		}

	}
}
