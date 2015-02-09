package edu.issi.machine.mvc.model.fakes;

import java.util.List;

import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.configuration.MachineConfigurationTest;
import edu.issi.machine.mvc.model.Model;
import edu.issi.machine.operation.OperationStatus;

@SuppressWarnings("javadoc")
public class FakeModel extends Model {
    public boolean working = false;

    public FakeModel(MachineConfiguration configuration) throws IllegalArgumentException {
	super(configuration);
    }

    @Override
    public void startMachine() {
	working = true;
    }

    @Override
    public void stopMachine() {
	working = false;
    }

    @Override
    public List<OperationStatus> makeOrder(String orderedProductName) throws IllegalArgumentException {
	return super.makeOrder(orderedProductName);
    }

    public static FakeModel getFixture() {
	return new FakeModel(MachineConfigurationTest.Fixtures.getFixture());
    }

}
