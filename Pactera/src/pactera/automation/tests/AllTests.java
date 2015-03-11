package pactera.automation.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestHomePageNavigationSuccessful.class,
		TestSearchScenario.class })
public class AllTests {

}
