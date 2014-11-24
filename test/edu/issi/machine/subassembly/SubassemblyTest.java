package edu.issi.machine.subassembly;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

import edu.issi.machine.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.properties.Properties;

@SuppressWarnings("javadoc")
public class SubassemblyTest {

    @Test
    public void shouldCreatesWithNotEmptyOperations() throws InvalidAttributeValueException {
	Subassembly subassembly = new Subassembly(Identity.SAMPLE, null, new Operation(null));

	assertNotNull(subassembly);
    }

    @Test
    public void shouldNotCreatesWhenOperationsAreNotSetted() throws InvalidAttributeValueException {
	try {
	    Operation[] operations = null;
	    new Subassembly(Identity.SAMPLE, null, operations);
	    fail("Powinien wystapic blad, poniewaz lista operacji nie zostala podana!");
	} catch (InvalidAttributeValueException e) {
	}
    }

    @Test
    public void shouldNotCreatesWhenOperationsListIsEmpty() throws InvalidAttributeValueException {
	try {
	    new Subassembly(Identity.SAMPLE, null, new Operation[] {});
	    fail("Powinien wystapic blad, poniewaz lista operacji jest pusta!");
	} catch (InvalidAttributeValueException e) {
	}
    }

    @Test
    public void shouldCorrectRecognizeSupportedOperations() throws InvalidAttributeValueException {
	Operation testOperation = new Operation(null);
	Subassembly subassembly = new Subassembly(Identity.SAMPLE, null, testOperation, new Operation(null));

	assertTrue(subassembly.supports(testOperation));
    }

    @Test
    public void shouldCorrectRecognizeNotSupportedOperations() throws InvalidAttributeValueException {
	Operation testOperation = new Operation(null);
	Subassembly subassembly = mockSubassembly();

	assertFalse(subassembly.supports(testOperation));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldInformWhenPropertiesNotSetted() throws InvalidAttributeValueException {
	Subassembly subassembly = mockSubassembly();

	subassembly.getProperty(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldInformWhenSubassemblyHasNotPropertyWithSpecifiedIdentifier()
	    throws InvalidAttributeValueException {
	Properties properties = new Properties();
	properties.add(new Identity(5), 5);
	properties.add(new Identity(10), 10);

	Subassembly subassembly = mockSubassembly();

	subassembly.getProperty(new Identity(4));
    }

    @Test
    public void shouldProvideProperties() throws InvalidAttributeValueException {
	Properties properties = new Properties();
	Identity firstId = new Identity(2);
	properties.add(firstId, 5);
	Identity secondId = new Identity(3);
	properties.add(secondId, 10);

	Subassembly subassembly = new Subassembly(Identity.SAMPLE, properties, new Operation(null));

	assertNotNull(subassembly.getProperty(firstId));
	assertNotNull(subassembly.getProperty(secondId));
    }

    public static Subassembly mockSubassembly() throws InvalidAttributeValueException {
	return new Subassembly(Identity.SAMPLE, null, new Operation(null));
    }

}
