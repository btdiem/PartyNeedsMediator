package tests;
import static org.junit.Assert.*;
import models.Languages;
import models.Party;
import models.PartyGoer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import specification.IMediator;
import specification.IParty;
import specification.IPartyGoer;

/**
 * Test for Class {@link PartyGoer} using {@link JUnit4} and {@link Mockito}
 * @author btdiem
 *
 */
public class TestPartyGoer {

	PartyGoer defaultConstructor;
	Languages [] LANGUAGES_SPOKEN = {Languages.ENGLISH, Languages.FRENCH, Languages.SPANISH};
	String name = "DIEM";
	@Before
	public void setUp(){
		defaultConstructor = new PartyGoer(name, LANGUAGES_SPOKEN);
	}
	
	@After
	public void tearDown() throws Exception {
		defaultConstructor = null;
	}
	
	@Test
	public void testConstructor1(){
//		defaultConstructor = new PartyGoer(name, LANGUAGES_SPOKEN);
		assertEquals("DIEM", defaultConstructor.getName());
		assertEquals(3, defaultConstructor.numberOfLanguagesSpoken());
	}
	@Test
	public void testConstructor2(){
		IMediator mediator = Mockito.mock(IMediator.class);
		defaultConstructor = new PartyGoer(name, LANGUAGES_SPOKEN, mediator);
		assertEquals("DIEM", defaultConstructor.getName()) ;
		assertEquals(3, defaultConstructor.numberOfLanguagesSpoken());
	}
	@Test
	public void testJoinParty(){
		IParty party = Mockito.mock(IParty.class);
		defaultConstructor.joinParty(party);
		assertEquals(party, defaultConstructor.getParty());
	}
	@Test
	public void testIsSameParty(){
		IParty party = Mockito.mock(IParty.class);
		IPartyGoer other = Mockito.mock(IPartyGoer.class);
		Mockito.when(other.getParty()).thenReturn(party);
		defaultConstructor.joinParty(party);
		assertTrue(defaultConstructor.isSameParty(other));
		Mockito.verify(other).getParty();
	}
	@Test
	public void testSpeaksLanguage(){
		assertTrue(defaultConstructor.speaksLanguage(Languages.ENGLISH));
		assertFalse(defaultConstructor.speaksLanguage(Languages.GREEK));
	}
	@Test
	public void testLanguagesInCommon1(){
		IPartyGoer other = Mockito.mock(IPartyGoer.class);
		Mockito.when(other.numberOfLanguagesSpoken()).thenReturn(0);
		assertNull(defaultConstructor.languagesInCommon(other));
		Mockito.verify(other).numberOfLanguagesSpoken();
	}
	
	@Test
	public void testLanguagesInCommon2(){
		
		IPartyGoer other = new PartyGoer("OTHER", new Languages[] {Languages.ENGLISH, Languages.FRENCH});
		assertNotNull(defaultConstructor.languagesInCommon(other));
	}
	
	@Test
	public void testfindTranslators(){
		
		Party party = new Party("FunParty");
		defaultConstructor.joinParty(party);
		Languages [] geoffspeaks = {Languages.GREEK};
		PartyGoer pg2 = new PartyGoer ("Geoff", geoffspeaks);
		party.joinParty(pg2);
		
		Languages [] tomspeaks = {Languages.ENGLISH, Languages.ITALIAN, Languages.GREEK};
		PartyGoer tom = new PartyGoer ("Tom", tomspeaks);
		party.joinParty(tom);
		IPartyGoer[] translator = defaultConstructor.findTranslators(pg2);
		assertNotNull(translator);
		
	}

	@Test
	public void testToString(){
		String s = "DIEM is a member of no party and speaks 3 languages: English French Spanish";
		assertEquals(s, defaultConstructor.toString());
	}

}
