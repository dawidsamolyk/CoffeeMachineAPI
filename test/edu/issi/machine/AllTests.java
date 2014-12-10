package edu.issi.machine;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.issi.machine.configuration.MachineConfigurationTest;
import edu.issi.machine.configuration.MachineConfigurationWriterAndReaderTest;
import edu.issi.machine.operation.OperationStateTest;
import edu.issi.machine.operation.OperationTest;
import edu.issi.machine.product.OrderedElementsContainerTest;
import edu.issi.machine.subassembly.SubassemblyTest;

@RunWith(Suite.class)
@SuiteClasses({ MachineConfigurationTest.class,
		MachineConfigurationWriterAndReaderTest.class, OperationTest.class,
		OperationStateTest.class, OrderedElementsContainerTest.class,
		SubassemblyTest.class })
@SuppressWarnings("javadoc")
public class AllTests {

}
