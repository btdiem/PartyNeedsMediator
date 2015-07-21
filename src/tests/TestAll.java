package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * 
 * @author btdiem
 *
*/

@RunWith(Suite.class)
@SuiteClasses({TestMediator.class,
			 TestParty.class,
			 TestPartyGoer.class})

public class TestAll {


}
