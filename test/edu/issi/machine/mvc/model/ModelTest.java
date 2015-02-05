package edu.issi.machine.mvc.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.configuration.MachineConfigurationTest;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.TestingSubassembly;

@SuppressWarnings("javadoc")
public class ModelTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @SuppressWarnings("unused")
    @Test
    public void shouldNotCreatesWithoutMachineConfiguration() {
	exception.expect(IllegalArgumentException.class);
	new Model(null);
    }

    @Test
    public void modelShouldNotBeAbleToAddNotCreatedProcutToMachineConfiguration() throws Exception {
	Model fixture = ModelTest.getFixture();

	exception.expect(IllegalArgumentException.class);	
	fixture.addProduct(null);
    }
    
    @Test
    public void modelShouldBeAbleToStartMachine() throws Exception {
	MachineConfiguration configuration = MachineConfigurationTest.getFixture();
	Iterator<Subassembly> subassembliesIterator = configuration.getSubassembliesIterator();
	Model model = new Model(configuration);
	
	model.startMachine();
	
	while(subassembliesIterator.hasNext()) {
	    TestingSubassembly subassembly = (TestingSubassembly) subassembliesIterator.next();
	    assertTrue(subassembly.isRunning());
	}
    }
    
    @Test
    public void modelShouldBeAbleToStopMachine() throws Exception {
	MachineConfiguration configuration = MachineConfigurationTest.getFixture();
	Iterator<Subassembly> subassembliesIterator = configuration.getSubassembliesIterator();
	Model model = new Model(configuration);
	
	model.startMachine();
	model.stopMachine();
	
	while(subassembliesIterator.hasNext()) {
	    TestingSubassembly subassembly = (TestingSubassembly) subassembliesIterator.next();
	    assertFalse(subassembly.isRunning());
	}
    }

    public static Model getFixture() throws Exception {
	return new Model(MachineConfigurationTest.getFixture());
    }
}
