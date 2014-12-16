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
    public void shouldProvideState() {
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
	String description = "Pompa dziala prawidlowo.";
	OperationStatus state = OperationStatus.Factory.createValidWithDescription(description);

	assertEquals(description, state.getDescription());

	description = "Pompa dziala niepoprawnie z powodu przegrzania!";
	state = OperationStatus.Factory.createErrorWithDescription(description);

	assertEquals(description, state.getDescription());

	description = "Pompa dziala, ale rozwaz jej wymiane, poniewaz lekko sie przegrzewa.";
	state = OperationStatus.Factory.createWarningWithDescription(description);

	assertEquals(description, state.getDescription());
    }

    @Test
    public void shouldProvideCompensatedStatusAsText() {
	String compensatedStatus = "[ERROR] Przegrzana pompa!";
	OperationStatus state = OperationStatus.Factory.createErrorWithDescription("Przegrzana pompa!");

	assertEquals(compensatedStatus, state.getCompensatedStatus());
    }
}
