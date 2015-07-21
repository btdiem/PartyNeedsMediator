package models;


/**
 * 
 * @author btdiem
 *
 */

public enum Languages {
	
	ENGLISH("English"), 
	FRENCH("French"),
	GERMAN("German"), 
	GREEK("Greek"),
	ITALIAN("Italian"), 
	SPANISH("Spanish");
	
	private String stringName;
	
	private Languages(String name){stringName = name;}
	
	public String toString(){return stringName;}

}
