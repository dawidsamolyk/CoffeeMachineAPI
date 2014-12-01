package edu.issi.machine;

import java.io.IOException;

import javax.naming.directory.InvalidAttributesException;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.gson.JsonSyntaxException;

import edu.issi.machine.controller.MachineController;

@SuppressWarnings("javadoc")
public class ApplicationTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void beforeClass() {
	MachineController.API = TestingApi.INSTANCE;
    }

    @Test
    public void shouldNotExecuteWithValidArguments() throws InvalidAttributesException, IOException {
	exception.expect(IllegalStateException.class);
	Application.main(null);

	exception.expect(IllegalStateException.class);
	Application.main(new String[] {});

	exception.expect(IllegalStateException.class);
	Application.main(new String[] { "", "" });
    }

    @Test
    public void shouldNotExecuteWithInvalidConfigurationFile() throws InvalidAttributesException, IOException {
	String[] args = new String[] { "./bin/.gitignore" };

	exception.expect(InvalidAttributesException.class);
	Application.main(args);
    }

    @Test
    public void shouldNotExecuteWithNotExistendConfigurationFile() throws InvalidAttributesException,
	    IOException {
	String[] args = new String[] { "./bin/nonExistenFile" };

	exception.expect(IOException.class);
	Application.main(args);
    }

    @Test
    public void shouldNotExecuteWithBrokenConfigurationFile() throws InvalidAttributesException, IOException {
	String[] args = new String[] { "./bin/testData/brokenConf.json" };

	exception.expect(JsonSyntaxException.class);
	Application.main(args);
    }

    @Test
    public void shouldNotExecuteWithEmptyConfigurationFile() throws InvalidAttributesException, IOException {
	String[] args = new String[] { "./bin/testData/emptyConf.json" };

	exception.expect(IllegalStateException.class);
	Application.main(args);
    }

    @Test
    public void shouldExecuteProperlyWithValidConfigurationFile() throws InvalidAttributesException,
	    IOException {
	String[] args = new String[] { "./bin/testData/validConf.json" };

	Application.main(args);
    }

}
