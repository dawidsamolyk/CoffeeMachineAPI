package edu.issi.machine;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ edu.issi.machine.configuration.AllTests.class, edu.issi.machine.controller.AllTests.class,
	edu.issi.machine.id.AllTests.class, edu.issi.machine.operation.AllTests.class,
	edu.issi.machine.product.AllTests.class, edu.issi.machine.product.ingredient.AllTests.class,
	edu.issi.machine.subassembly.AllTests.class })
@SuppressWarnings("javadoc")
public class AllTests {
    public static void main(String[] args) {
	JUnitCore.runClasses(new Class[] { AllTests.class });
    }
}
