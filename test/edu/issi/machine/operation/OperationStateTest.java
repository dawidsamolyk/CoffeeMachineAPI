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
		OperationState state = new OperationState(Status.OK);

		assertNotNull(state.getStatus());
	}

	@Test
	public void shouldNotCreatesWhenStatusIsNotProvided() {
		exception.expect(IllegalStateException.class);
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
	public void IllegalStateException() {
		exception.expect(IllegalStateException.class);
		new OperationState(Status.ERROR, null);

		exception.expect(IllegalStateException.class);
		new OperationState(Status.WARNING, "");

		exception.expect(IllegalStateException.class);
		new OperationState(Status.ERROR);

		exception.expect(IllegalStateException.class);
		new OperationState(Status.WARNING);
	}

	@Test
	public void shouldProvideCompensatedStatusAsText() {
		String compensatedStatus = "[ERROR] Przegrzana pompa!";
		OperationState state = new OperationState(Status.ERROR,
				"Przegrzana pompa!");

		assertEquals(compensatedStatus, state.getCompensatedStatus());
	}
}
