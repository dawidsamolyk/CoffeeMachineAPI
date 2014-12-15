package edu.issi.machine.id;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class IdentityTest {
    @Test
    public void testIdentity_1() throws Exception {
	Identity result = new Identity(0);

	assertNotNull(result);
	assertEquals("ID: 0, Nazwa: 0", result.toString());
    }

    @Test
    public void testIdentity_3() throws Exception {
	int id = 0;
	String name = "";

	Identity result = new Identity(id, name);

	assertNotNull(result);
	assertEquals("ID: 0, Nazwa: ", result.toString());
    }

    @Test
    public void testIdentity_4() throws Exception {
	int id = 0;
	String name = "0123456789";

	Identity result = new Identity(id, name);

	assertNotNull(result);
	assertEquals("ID: 0, Nazwa: 0123456789", result.toString());
    }

    @Test
    public void testChangeName_1() throws Exception {
	Identity fixture = new Identity(0);
	String newName = null;

	String result = fixture.changeName(newName);

	assertEquals("0", result);
    }

    @Test
    public void testChangeName_2() throws Exception {
	Identity fixture = new Identity(0);
	fixture.changeName("1");
	String newName = null;

	String result = fixture.changeName(newName);

	assertEquals("1", result);
    }

    @Test
    public void testChangeName_3() throws Exception {
	Identity fixture = new Identity(0, "");
	String newName = null;

	String result = fixture.changeName(newName);

	assertEquals("", result);
    }

    @Test
    public void testChangeName_4() throws Exception {
	Identity fixture = new Identity(1, "0123456789");
	String newName = null;

	String result = fixture.changeName(newName);

	assertEquals("0123456789", result);
    }

    @Test
    public void testEquals_3() throws Exception {
	Identity fixture = new Identity(0, "");
	Object obj = null;

	boolean result = fixture.equals(obj);

	assertEquals(false, result);
    }

    @Test
    public void testToString_1() throws Exception {
	Identity fixture = new Identity(0);

	String result = fixture.toString();

	assertEquals("ID: 0, Nazwa: 0", result);
    }

    @Test
    public void testToString_3() throws Exception {
	Identity fixture = new Identity(0, "");

	String result = fixture.toString();

	assertEquals("ID: 0, Nazwa: ", result);
    }

    @Test
    public void testToString_4() throws Exception {
	Identity fixture = new Identity(1, "0123456789");

	String result = fixture.toString();

	assertEquals("ID: 1, Nazwa: 0123456789", result);
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(IdentityTest.class);
    }
}