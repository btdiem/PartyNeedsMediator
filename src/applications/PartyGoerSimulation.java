package applications;

import models.Languages;
import models.PartyGoer;

/**
 * 
 * @author btdiem
 *
*/


public class PartyGoerSimulation {


	public static void main(String[] args) {
		//create a person with their own languages
		Languages [] paulspeaks = {Languages.ENGLISH, Languages.FRENCH, Languages.SPANISH};
		PartyGoer pg1 = new PartyGoer ("Paul", paulspeaks);
		System.out.println(pg1);
		//check which language he can not speak
		for (Languages l : Languages.values())			
			if (!pg1.speaksLanguage(l)) System.out.println("Paul does not speak "+l);
		
		System.out.println("\n\n");
		//create a person
		Languages [] geoffspeaks = {Languages.GREEK, Languages.ENGLISH, Languages.ITALIAN, Languages.SPANISH};
		PartyGoer pg2 = new PartyGoer ("Geoff", geoffspeaks);
		System.out.println(pg2);
		//check which language he can not speak
	    for (Languages l : Languages.values())			
			if (!pg2.speaksLanguage(l)) System.out.println("Geoff does not speak "+l);
		
	    System.out.println("\n\n");
	  //create a person with their own languages
		Languages [] dummyspeaks = null;
		PartyGoer pg3 = new PartyGoer ("Dummy", dummyspeaks);
		System.out.println(pg3);
		//check which language he can not speak
	    for (Languages l : Languages.values())			
			if (!pg3.speaksLanguage(l)) System.out.println("Dummy does not speak "+l);
	    
	    System.out.println("\n\n");
	    //return the number of languages that both can communicate
	    Languages [] common = pg1.languagesInCommon(pg2);
		System.out.print("Paul and Geoff can converse in ");
	    for (int i =0; i< common.length; i++) System.out.print( common[i]+" ");
	    System.out.println();
	    
	    System.out.println("\n\n");
	    //return the number of languages that both can communicate
	    common = pg2.languagesInCommon(pg1);
		System.out.print("Geoff and Paul can converse in ");
	    for (int i =0; i< common.length; i++) System.out.print( common[i]+" ");
	    System.out.println();
	    
	    System.out.println("\n\n");
	    //return the number of languages that both can communicate
	    //transitive
	    common = pg2.languagesInCommon(pg2);
		System.out.print("Geoff and Geoff can converse in ");
	    for (int i =0; i< common.length; i++) System.out.print(common[i]+" ");
	    System.out.println();
	    
	    
	    if (pg1.languagesInCommon(pg3)==null)
	     System.out.println("Paul and Dummy cannot converse");
	    
	    if (pg3.languagesInCommon(pg2)==null)
		     System.out.println("Dummy and Geoff cannot converse");
	    
	    
	}

}
