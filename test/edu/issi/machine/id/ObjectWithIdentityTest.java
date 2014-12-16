package edu.issi.machine.id;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ObjectWithIdentityTest {
    @Test
    public void testObjectWithIdentity_1() throws Exception {
	assertNotNull(new ObjectWithIdentity(null));
    }

    @Test
    public void testEquals_1() throws Exception {
	ObjectWithIdentity fixture = new ObjectWithIdentity((Identity) null);

	assertFalse(fixture.equals("1"));
    }

    @Test
    public void testEquals_2() throws Exception {
	ObjectWithIdentity fixture = new ObjectWithIdentity((Identity) null);
	Object obj = null;

	boolean result = fixture.equals(obj);

	assertEquals(false, result);
    }

    @Test
    public void testIdentifiesBy() throws Exception {
	ObjectWithIdentity fixture = new ObjectWithIdentity(new Identity(1));

	assertTrue(fixture.identifiesBy(new Identity(1)));
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(ObjectWithIdentityTest.class);
    }
}