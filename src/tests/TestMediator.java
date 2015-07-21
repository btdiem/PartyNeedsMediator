package tests;

import static org.junit.Assert.*;

import java.util.List;

import models.Languages;
import models.Mediator;
import models.PartyGoer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import specification.IMediator;
import specification.IPartyGoer;

/**
 * Test for Class {@link Mediator} using {@link JUnit4} and {@link Mockito}
 * @author btdiem
 *
 */
public class TestMediator {
	
	IMediator mediator;
	
	@Before
	public void setUp() throws Exception {
		mediator = new Mediator();
	}

	@After
	public void tearDown() throws Exception {
		mediator = null;
	}

	@Test
	public void testConstructor() {
		assertEquals(0, mediator.getRegisters().size());
	}
	
	@Test
	public void testRegister(){
		IPartyGoer person = Mockito.mock(IPartyGoer.class);
		mediator.register(person);
		assertEquals(1, mediator.getRegisters().size());
	}
	/**
	 * The result is null because 2 {@link IPartyGoer} don't need a {@link IMediator}
	 */
	@Test
	public void testFindTranslator1(){
		
		Languages [] paulspeaks = {Languages.ENGLISH, Languages.FRENCH, Languages.SPANISH};
		PartyGoer pg1 = new PartyGoer ("Paul", paulspeaks, mediator);
		Languages [] geoffspeaks = {Languages.GREEK, Languages.ENGLISH, Languages.ITALIAN, Languages.SPANISH};
		PartyGoer pg2 = new PartyGoer ("Geoff", geoffspeaks, mediator);
		assertNull(mediator.findTranslator(pg1, pg2));

	}
	/**
	 * The result is a {@link IPartyGoer}
	 */
	@Test
	public void testFindTranslator2(){
		
		Languages [] paulspeaks = {Languages.ENGLISH, Languages.FRENCH, Languages.SPANISH};
		PartyGoer pg1 = new PartyGoer ("Paul", paulspeaks, mediator);
		Languages [] geoffspeaks = {Languages.GREEK, Languages.ENGLISH, Languages.ITALIAN, Languages.SPANISH};
		PartyGoer pg2 = new PartyGoer ("Geoff", geoffspeaks, mediator);	
		Languages [] billspeaks = {Languages.ITALIAN};
		PartyGoer bill = new PartyGoer ("Bill", billspeaks, mediator);
		
		List<IPartyGoer> translators = mediator.findTranslator(pg1, bill);
		assertNotNull(translators);
		assertTrue(translators.contains(pg2));
		
	}	

}
