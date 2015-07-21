package tests;

import static org.junit.Assert.*;
import models.Party;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import specification.IParty;
import specification.IPartyGoer;

/**
 * Test for {@link Party} class using {@link JUnit4} and {@link Mockito}
 * @author btdiem
 *
 */
public class TestParty {
	
	IParty defaultConstructor;
	String defaultName = "PARTY";
			
	@Before
	public void setUp() throws Exception {
		defaultConstructor = new Party(defaultName);
	}

	@After
	public void tearDown() throws Exception {
		defaultConstructor = null;
	}

	@Test
	public void testConstructor1() {
		assertEquals(defaultName, defaultConstructor.getName());
		assertEquals(0, defaultConstructor.getPartyGoers().size());
	}
	@Test
	public void testConstructor2(){
		IPartyGoer person1 = Mockito.mock(IPartyGoer.class);
		IPartyGoer person2 = Mockito.mock(IPartyGoer.class);
		defaultConstructor = new Party(defaultName, new IPartyGoer [] {person1, person2});
		assertEquals(2, defaultConstructor.getPartyGoers().size());
	}
	@Test
	public void testJoinParty(){
		IPartyGoer person1 = Mockito.mock(IPartyGoer.class);
		defaultConstructor.joinParty(person1);
		assertEquals(1, defaultConstructor.getPartyGoers().size());
	}
	@Test
	public void testToString(){
		IPartyGoer person1 = Mockito.mock(IPartyGoer.class);
		defaultConstructor.joinParty(person1);
		defaultConstructor.toString();
	}

}
