package edu.issi.machine.id;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ IdentityTest.class, ObjectWithIdentityTest.class, PropertyIdentityTest.class })
public class AllTests {

}
