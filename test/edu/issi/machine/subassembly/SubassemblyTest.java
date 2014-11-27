package edu.issi.machine.subassembly;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.api.MachineApi;
import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationTest;
import edu.issi.machine.properties.Properties;

@SuppressWarnings("javadoc")
public class SubassemblyTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldCreatesWithNotEmptyOperations() throws InvalidAttributeValueException {
	Subassembly subassembly = new Subassembly(Identity.SAMPLE, null, new Operation(null));

	assertNotNull(subassembly);
    }

    @Test
    public void shouldNotCreatesWhenOperationsAreNotSetted() throws InvalidAttributeValueException {
	Operation[] operations = null;

	exception.expect(InvalidAttributeValueException.class);
	new Subassembly(Identity.SAMPLE, null, operations);
    }

    @Test
    public void shouldNotCreatesWhenOperationsListIsEmpty() throws InvalidAttributeValueException {
	exception.expect(InvalidAttributeValueException.class);
	new Subassembly(Identity.SAMPLE, null, new Operation[] {});
    }

    @Test
    public void shouldCorrectRecognizeSupportedOperations() throws InvalidAttributeValueException {
	Operation testOperation = new Operation(null);
	Subassembly subassembly = new Subassembly(Identity.SAMPLE, null, testOperation, new Operation(null));

	assertTrue(subassembly.supports(testOperation));
    }

    @Test
    public void shouldCorrectRecognizeNotSupportedOperations() throws Exception {
	Operation testOperation = new Operation(OperationTest.mockApiMethod());
	Subassembly subassembly = mockSubassembly();

	assertFalse(subassembly.supports(testOperation));
    }

    @Test
    public void shouldInformWhenPropertiesNotSetted() throws Exception {
	Subassembly subassembly = mockSubassembly();

	exception.expect(NoSuchElementException.class);
	subassembly.getProperty(null);
    }

    @Test
    public void shouldInformWhenSubassemblyHasNotPropertyWithSpecifiedIdentifier() throws Exception {
	Properties properties = new Properties();
	properties.add(new Identity(5), 5);
	properties.add(new Identity(10), 10);

	Subassembly subassembly = mockSubassembly();

	exception.expect(NoSuchElementException.class);
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

    public static Subassembly mockSubassembly() throws Exception {
	return new Subassembly(Identity.SAMPLE, null, new Operation(null));
    }

}
