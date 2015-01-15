package edu.issi.machine.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("javadoc")
public class OperationStatusTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldProvideStatus() {
	OperationStatus state = OperationStatus.Factory.createValid();

	assertNotNull(state.getStatus());
    }

    @Test
    public void shouldNotCreatesWhenStatusIsNotProvided() {
	exception.expect(IllegalArgumentException.class);
	OperationStatus.Factory.createErrorWithDescription(null);
    }

    @Test
    public void shouldProvideDescriptionWhenItIsSetted() {
	String description = "Pompa dziala poprawnie!";
	OperationStatus state = OperationStatus.Factory.createValidWithDescription(description);

	assertEquals(description, state.getDescription());
    }

    @Test
    public void shouldProvidesStatusWithDescriptionAsText() {
	String compensatedStatus = "[WARNING] Przegrzana pompa!";
	OperationStatus state = OperationStatus.Factory.createWarningWithDescription("Przegrzana pompa!");

	assertEquals(compensatedStatus, state.getCompensatedStatus());
    }
    
    @Test
    public void compesatedStatusShouldBeProvidedEvenWhenDescriptionIsNotSetted() {
	OperationStatus state = OperationStatus.Factory.createValid();

	assertEquals("[OK]", state.getCompensatedStatus());
    }
}
