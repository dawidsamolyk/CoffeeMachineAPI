package edu.issi.machine.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("javadoc")
public class OperationStateTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldProvideStatus() {
	OperationStatus state = OperationStatus.Factory.createValidState();

	assertNotNull(state.getStatus());
    }

    @Test
    public void shouldNotCreatesWhenStatusIsNotProvided() {
	exception.expect(IllegalStateException.class);
	OperationStatus.Factory.createErrorWithDescription(null);
    }

    @Test
    public void shouldProvideDescriptionWhenItIsSetted() {
	String description = "Pompa dziala niepoprawnie z powodu przegrzania!";
	OperationStatus state = OperationStatus.Factory.createErrorWithDescription(description);

	assertEquals(description, state.getDescription());
    }

    @Test
    public void shouldProvidesStatusAsText() {
	String compensatedStatus = "[ERROR] Przegrzana pompa!";
	OperationStatus state = OperationStatus.Factory.createErrorWithDescription("Przegrzana pompa!");

	assertEquals(compensatedStatus, state.getCompensatedStatus());
    }
}
