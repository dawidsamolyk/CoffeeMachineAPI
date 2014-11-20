package edu.issi.machine.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class OperationStateTest {

    @Test
    public void shouldProvideState() {
	OperationState state = new OperationState(Status.OK);

	assertNotNull(state.getStatus());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotCreatesWhenStatusIsNotProvided() {
	new OperationState(null);
    }

    @Test
    public void shouldProvideDescriptionWhenItIsSetted() {
	String description = "Pompa dziala prawidlowo.";
	OperationState state = new OperationState(Status.OK, description);

	assertEquals(description, state.getDescription());

	description = "Pompa dziala niepoprawnie z powodu przegrzania!";
	state = new OperationState(Status.ERROR, description);

	assertEquals(description, state.getDescription());

	description = "Pompa dziala, ale rozwaz jej wymiane, poniewaz lekko sie przegrzewa.";
	state = new OperationState(Status.WARNING, description);

	assertEquals(description, state.getDescription());
    }

    @Test
    public void shouldProvideDescriptionWhenStatusRequiresAttention() {
	try {
	    new OperationState(Status.ERROR, null);
	    fail("Powinien wystapic blad");
	} catch (IllegalStateException e) {
	}

	try {
	    new OperationState(Status.WARNING, "");
	    fail("Powinien wystapic blad");
	} catch (IllegalStateException e) {
	}

	try {
	    new OperationState(Status.ERROR);
	    fail("Powinien wystapic blad");
	} catch (IllegalStateException e) {
	}

	try {
	    new OperationState(Status.WARNING);
	    fail("Powinien wystapic blad");
	} catch (IllegalStateException e) {
	}
    }

    @Test
    public void shouldProvideCompensatedStatusAsText() {
	String compensatedStatus = "[ERROR] Przegrzana pompa!";
	OperationState state = new OperationState(Status.ERROR, "Przegrzana pompa!");

	assertEquals(compensatedStatus, state.getCompensatedStatus());
    }
}
