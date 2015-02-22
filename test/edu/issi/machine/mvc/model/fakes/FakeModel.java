package edu.issi.machine.mvc.model.fakes;

import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.configuration.MachineConfigurationTest;
import edu.issi.machine.mvc.model.Model;

@SuppressWarnings("javadoc")
public class FakeModel extends Model {
    public String orderedProductName;
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

    public static FakeModel getFixture() {
	return new FakeModel(MachineConfigurationTest.Fixtures.getFixture());
    }

}
