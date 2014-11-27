package edu.issi.machine;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.issi.machine.configuration.MachineConfigurationCodeProTest;
import edu.issi.machine.configuration.MacineConfigurationWriterAndReaderTest;
import edu.issi.machine.operation.OperationCodeProTest;
import edu.issi.machine.operation.OperationStateCodeProTest;
import edu.issi.machine.product.OrderedElementsContainerTest;

@SuppressWarnings("javadoc")
@RunWith(Suite.class)
@SuiteClasses({ MachineConfigurationCodeProTest.class,
	MacineConfigurationWriterAndReaderTest.class, OperationCodeProTest.class, OperationStateCodeProTest.class,
	OrderedElementsContainerTest.class })
public class AllTests {

}
