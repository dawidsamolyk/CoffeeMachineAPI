package edu.issi.machine.operation;

import static org.junit.Assert.*;

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
	OperationStatus state = OperationStatus.Factory.createValid(description);

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

    @Test
    public void equalErroneousOperationStatusShouldBeKnown() {
	String description = "Test";
	OperationStatus status1 = OperationStatus.Factory.createErrorWithDescription(description);
	OperationStatus status2 = OperationStatus.Factory.createErrorWithDescription(description);

	assertTrue(status1.equals(status2));
    }

    @Test
    public void equalValidOperationStatusWithoutDescriptionShouldBeKnown() {
	OperationStatus status1 = OperationStatus.Factory.createValid();
	OperationStatus status2 = OperationStatus.Factory.createValid();

	assertTrue(status1.equals(status2));
    }

    @Test
    public void NotEqualOperationStatusShouldNotBeKnown() {
	OperationStatus status1 = OperationStatus.Factory.createValid();
	OperationStatus status2 = OperationStatus.Factory.createErrorWithDescription("Test");

	assertFalse(status1.equals(status2));
    }

    @Test
    public void AnotherTypeOfObjectShouldNotBeEqual() {
	OperationStatus status1 = OperationStatus.Factory.createValid();

	assertFalse(status1.equals(new Object()));
    }

    @Test
    public void EmptyObjectShouldNotBeKnown() {
	OperationStatus status1 = OperationStatus.Factory.createValid();

	assertFalse(status1.equals(null));
    }

    @Test
    public void operationStatusesWithAnotherDescriptionsShouldNotBeKnownAsEqual() {
	OperationStatus status1 = OperationStatus.Factory.createErrorWithDescription("Test");
	OperationStatus status2 = OperationStatus.Factory.createErrorWithDescription("Real");

	assertFalse(status1.equals(status2));
    }

    @Test
    public void operationStatusesWithTheSameDescriptionsAndAnotherStatusShouldNotBeKnownAsEqual() {
	String description = "Test";
	OperationStatus status1 = OperationStatus.Factory.createErrorWithDescription(description);
	OperationStatus status2 = OperationStatus.Factory.createWarningWithDescription(description);

	assertFalse(status1.equals(status2));
    }
}
