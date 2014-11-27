package edu.issi.machine;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ApplicationCodeProTest.class,
	edu.issi.machine.api.TestAll.class,
	edu.issi.machine.configuration.TestAll.class,
	edu.issi.machine.controller.TestAll.class,
	edu.issi.machine.id.TestAll.class,
	edu.issi.machine.operation.TestAll.class,
	edu.issi.machine.product.TestAll.class,
	edu.issi.machine.properties.TestAll.class,
	edu.issi.machine.subassembly.TestAll.class,
})
public class TestAll {

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    public static void main(String[] args) {
    	JUnitCore.runClasses(new Class[] { TestAll.class });
    }
}
