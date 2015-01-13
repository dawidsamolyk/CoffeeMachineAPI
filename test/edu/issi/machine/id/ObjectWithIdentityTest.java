package edu.issi.machine.id;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("javadoc")
public class ObjectWithIdentityTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testNullInitialization() throws Exception {
	exception.expect(IllegalArgumentException.class);
	
	new ObjectWithIdentity((Identity) null);
    }

    @Test
    public void testIdentifiesBy() throws Exception {
	ObjectWithIdentity fixture = new ObjectWithIdentity(Identity.Factory.newIdentity("Test"));
	
	assertTrue(fixture.identifiesBy(fixture.hashCode()));
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(ObjectWithIdentityTest.class);
    }
}