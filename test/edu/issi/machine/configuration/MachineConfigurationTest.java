package edu.issi.machine.configuration;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class MachineConfigurationTest {

    @Test
    public void shouldNotCreatesWhenSubassembliesAreNotSetted() {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();

	try {
	    new MachineConfiguration(subassemblies);
	    fail("Powinien wystapic blad!");
	} catch (IllegalStateException e) {
	}

	try {
	    new MachineConfiguration(null);
	    fail("Powinien wystapic blad!");
	} catch (IllegalStateException e) {
	}
    }

}
