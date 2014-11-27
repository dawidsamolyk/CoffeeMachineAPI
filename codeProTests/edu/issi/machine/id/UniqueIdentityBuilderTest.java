package edu.issi.machine.id;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>UniqueIdentityBuilderTest</code> contains tests for the class
 * <code>{@link UniqueIdentityBuilder}</code>.
 *
 * @generatedBy CodePro at 27.11.14 17:52
 * @author Dawid
 * @version $Revision: 1.0 $
 */
public class UniqueIdentityBuilderTest {
    /**
     * An instance of the class being tested.
     *
     * @see UniqueIdentityBuilder
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    private UniqueIdentityBuilder fixture;

    /**
     * Return an instance of the class being tested.
     *
     * @return an instance of the class being tested
     *
     * @see UniqueIdentityBuilder
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    public UniqueIdentityBuilder getFixture() throws Exception {
	if (fixture == null) {
	    fixture = new UniqueIdentityBuilder();
	}
	return fixture;
    }

    /**
     * Run the UniqueIdentityBuilder() constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testUniqueIdentityBuilder_1() throws Exception {

	UniqueIdentityBuilder result = new UniqueIdentityBuilder();

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Identity build(int,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testBuild_fixture_1() throws Exception {
	UniqueIdentityBuilder fixture2 = getFixture();
	int id = 0;
	String name = "";

	Identity result = fixture2.build(id, name);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Identity build(int,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testBuild_fixture_2() throws Exception {
	UniqueIdentityBuilder fixture2 = getFixture();
	int id = 1;
	String name = "0123456789";

	Identity result = fixture2.build(id, name);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Identity build(int,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testBuild_fixture_3() throws Exception {
	UniqueIdentityBuilder fixture2 = getFixture();
	int id = 7;
	String name = "0123456789";

	Identity result = fixture2.build(id, name);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Identity build(int,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testBuild_fixture_4() throws Exception {
	UniqueIdentityBuilder fixture2 = getFixture();
	int id = 1;
	String name = "";

	Identity result = fixture2.build(id, name);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Identity build(int,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testBuild_fixture_5() throws Exception {
	UniqueIdentityBuilder fixture2 = getFixture();
	int id = 7;
	String name = "";

	Identity result = fixture2.build(id, name);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Run the Identity build(int,String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Test
    public void testBuild_fixture_6() throws Exception {
	UniqueIdentityBuilder fixture2 = getFixture();
	int id = 0;
	String name = "0123456789";

	Identity result = fixture2.build(id, name);

	// add additional test code here
	assertNotNull(result);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @Before
    public void setUp() throws Exception {
	// add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    @After
    public void tearDown() throws Exception {
	// Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     *
     * @generatedBy CodePro at 27.11.14 17:52
     */
    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(UniqueIdentityBuilderTest.class);
    }
}