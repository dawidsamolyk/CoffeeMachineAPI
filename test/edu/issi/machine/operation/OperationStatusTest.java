package edu.issi.machine.operation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	OperationStatus.Factory.createError(null);
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
	OperationStatus state = OperationStatus.Factory.createWarning("Przegrzana pompa!");

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
	OperationStatus status1 = OperationStatus.Factory.createError(description);
	OperationStatus status2 = OperationStatus.Factory.createError(description);

	assertTrue(status1.equals(status2));
    }

    @Test
    public void equalValidOperationStatusWithoutDescriptionShouldBeKnown() {
	OperationStatus status1 = OperationStatus.Factory.createValid();
	OperationStatus status2 = OperationStatus.Factory.createValid();

	assertTrue(status1.equals(status2));
    }

    @Test
    public void notEqualOperationStatusShouldNotBeKnown() {
	OperationStatus status1 = OperationStatus.Factory.createValid();
	OperationStatus status2 = OperationStatus.Factory.createError("Test");

	assertFalse(status1.equals(status2));
    }

    @Test
    public void anotherTypeOfObjectShouldNotBeEqual() {
	OperationStatus status1 = OperationStatus.Factory.createValid();

	assertFalse(status1.equals(new Object()));
    }

    @Test
    public void emptyObjectShouldNotBeKnown() {
	OperationStatus status1 = OperationStatus.Factory.createValid();

	assertFalse(status1.equals(null));
    }

    @Test
    public void operationStatusesWithAnotherDescriptionsShouldNotBeKnownAsEqual() {
	OperationStatus status1 = OperationStatus.Factory.createError("Test");
	OperationStatus status2 = OperationStatus.Factory.createError("Real");

	assertFalse(status1.equals(status2));
    }

    @Test
    public void operationStatusesWithTheSameDescriptionsAndAnotherStatusShouldNotBeKnownAsEqual() {
	String description = "Test";
	OperationStatus status1 = OperationStatus.Factory.createError(description);
	OperationStatus status2 = OperationStatus.Factory.createWarning(description);

	assertFalse(status1.equals(status2));
    }

    @Test
    public void operationStatusShouldBeEqualToSelf() {
	OperationStatus status = OperationStatus.Factory.createError("Test");
	assertTrue(status.equals(status));
    }

    @Test
    public void shouldProvideOneValidOperationStatusFromManyObjectsOfThisKind() {
	List<OperationStatus> operationsStatuses = new ArrayList<OperationStatus>();
	operationsStatuses.add(OperationStatus.Factory.createValid());
	operationsStatuses.add(OperationStatus.Factory.createValid("Description..."));

	OperationStatus result = OperationStatus.Factory.getFrom(operationsStatuses);

	assertEquals(Status.OK, result.getStatus());
    }

    @Test
    public void shouldProvideCompensatedDescriptionFromManyValidOperationStatuses() {
	String description1 = "Description...";
	String description2 = "Description 2...";
	List<OperationStatus> operationsStatuses = new ArrayList<OperationStatus>();
	operationsStatuses.add(OperationStatus.Factory.createValid());
	operationsStatuses.add(OperationStatus.Factory.createValid(description1));
	operationsStatuses.add(OperationStatus.Factory.createValid(description2));

	OperationStatus result = OperationStatus.Factory.getFrom(operationsStatuses);

	assertEquals(OperationStatus.Factory.ALL_VALID.getDescription(), result.getDescription());
    }

    @Test
    public void shouldProvideWarningOperationStatusFromManyObjectsWithAnyWarning() {
	List<OperationStatus> operationsStatuses = new ArrayList<OperationStatus>();
	operationsStatuses.add(OperationStatus.Factory.createValid("Description..."));
	operationsStatuses.add(OperationStatus.Factory.createWarning("Test description"));

	OperationStatus result = OperationStatus.Factory.getFrom(operationsStatuses);

	assertEquals(Status.WARNING, result.getStatus());
    }

    @Test
    public void shouldProvideCompensatedDescriptionFromManyOperationStatusesWithAnyWarning() {
	List<OperationStatus> operationsStatuses = new ArrayList<OperationStatus>();
	operationsStatuses.add(OperationStatus.Factory.createValid());
	OperationStatus warning = OperationStatus.Factory.createWarning("Warning description...");
	operationsStatuses.add(warning);
	OperationStatus warning2 = OperationStatus.Factory.createWarning("Warning description 2...");
	operationsStatuses.add(warning2);

	OperationStatus result = OperationStatus.Factory.getFrom(operationsStatuses);

	String expectedOutput = OperationStatus.Factory.WARNING_OCCURS_INFO + "[" + warning.getCompensatedStatus() + ", "
		+ warning2.getCompensatedStatus() + "]";
	assertEquals(expectedOutput, result.getDescription());
    }

    @Test
    public void shouldProvideErrorneousOperationStatusFromManyObjectsWithAnyError() {
	List<OperationStatus> operationsStatuses = new ArrayList<OperationStatus>();
	operationsStatuses.add(OperationStatus.Factory.createValid("Description..."));
	operationsStatuses.add(OperationStatus.Factory.createWarning("Test description"));
	operationsStatuses.add(OperationStatus.Factory.createError("Error description!"));
	operationsStatuses.add(OperationStatus.Factory.createWarning("Warning description"));
	operationsStatuses.add(OperationStatus.Factory.createValid());

	OperationStatus result = OperationStatus.Factory.getFrom(operationsStatuses);

	assertEquals(Status.ERROR, result.getStatus());
    }

    @Test
    public void shouldProvideCompensatedDescriptionFromManyOperationStatusesWithAnyError() {
	List<OperationStatus> operationsStatuses = new ArrayList<OperationStatus>();
	operationsStatuses.add(OperationStatus.Factory.createValid());
	OperationStatus error = OperationStatus.Factory.createError("Error description...");
	operationsStatuses.add(error);
	OperationStatus error2 = OperationStatus.Factory.createError("Error description 2!!!");
	operationsStatuses.add(error2);

	OperationStatus result = OperationStatus.Factory.getFrom(operationsStatuses);

	String expectedOutput = OperationStatus.Factory.ERROR_OCCURS_INFO + "[" + error.getCompensatedStatus() + ", "
		+ error2.getCompensatedStatus() + "]";
	assertEquals(expectedOutput, result.getDescription());
    }

    @Test
    public void shouldProvideCompensatedDescriptionFromManyOperationStatusesWhenAnyErrorsAndWarningsOccurs() {
	List<OperationStatus> operationsStatuses = new ArrayList<OperationStatus>();
	operationsStatuses.add(OperationStatus.Factory.createValid());
	operationsStatuses.add(OperationStatus.Factory.createValid("Description..."));
	OperationStatus error = OperationStatus.Factory.createError("Error description!!!");
	operationsStatuses.add(error);
	OperationStatus warning = OperationStatus.Factory.createWarning("Warning description...");
	operationsStatuses.add(warning);

	OperationStatus result = OperationStatus.Factory.getFrom(operationsStatuses);

	String expectedOutput = OperationStatus.Factory.ERROR_OCCURS_INFO + "[" + error.getCompensatedStatus() + ", "
		+ warning.getCompensatedStatus() + "]";
	assertEquals(expectedOutput, result.getDescription());
    }
    
    @Test
    public void shouldCreateAggregatedErrorneusStatusesForManyDescriptions() {
	String[] descriptions = {"Test 1", "Test 2", "Test 3"};
	
	List<OperationStatus> result = OperationStatus.Factory.createErrors(descriptions);
	
	for(int p = 0 ; p < descriptions.length ; p++) {
	    OperationStatus eachOperationStatus = result.get(p);
	    assertEquals(descriptions[p], eachOperationStatus.getDescription());
	}
    }

    @Test
    public void operationStatusShouldProvideHashCode() {
	assertNotNull(OperationStatus.Factory.createValid().hashCode());
    }
}
