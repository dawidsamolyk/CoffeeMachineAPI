package edu.issi.machine;

import java.io.IOException;

import javax.naming.directory.InvalidAttributesException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;

@SuppressWarnings("javadoc")
public class ApplicationTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldNotExecuteWithInvalidConfigurationFile() throws InvalidAttributesException, IOException {
	String[] args = new String[] { "./bin/.gitignore" };

	exception.expect(InvalidAttributesException.class);
	Application.main(args);
    }
    
    @Test
    public void shouldNotExecuteWithNotExistendConfigurationFile() throws InvalidAttributesException, IOException {
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
    public void shouldExecuteProperlyWithValidConfigurationFile() throws InvalidAttributesException, IOException {
	String[] args = new String[] { "./bin/testData/validConf.json" };

	Application.main(args);
    }

}
