package edu.issi.machine.id;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("javadoc")
public class ObjectWithIdentityTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @SuppressWarnings("unused")
    @Test
    public void shouldNotCreatesWhenIdentityIsEmpty() throws Exception {
	exception.expect(IllegalArgumentException.class);
	new ObjectWithIdentity((Identity) null);
    }

    @Test
    public void shouldProvideName() throws Exception {
	String name = "Test";
	ObjectWithIdentity fixture = new ObjectWithIdentity(new Identity(0, name));
	
	assertEquals(name, fixture.getName());
    }
    
    @Test
    public void shouldIdNumber() throws Exception {
	int id = 101230;
	ObjectWithIdentity fixture = new ObjectWithIdentity(new Identity(id, "Test"));
	
	assertEquals(id, fixture.getIdNumber());
    }
    
    @Test
    public void shouldIdentifiesBySpecifiedIdNumber() throws Exception {
	int id = 101230;
	ObjectWithIdentity fixture = new ObjectWithIdentity(new Identity(id, "Test"));
	
	assertTrue(fixture.identifiesBy(id));
    }
    
    @Test
    public void shouldBeEqualOnlyToSelf() throws Exception {
	ObjectWithIdentity fixture = new ObjectWithIdentity(new Identity(999, "Test"));
	ObjectWithIdentity fixture2 = new ObjectWithIdentity(new Identity(999, "Test"));
	
	assertTrue(fixture.equals(fixture));
	assertFalse(fixture.equals(fixture2));
    }
}