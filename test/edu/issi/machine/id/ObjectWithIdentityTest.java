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
    public void shouldNotCreatesWhenIdentityIsEmpty() throws Exception {
	exception.expect(IllegalArgumentException.class);
	new ObjectWithIdentity((Identity) null);
    }

    @Test
    public void shouldBeIdentifiedByObjectHashCode() throws Exception {
	ObjectWithIdentity fixture = new ObjectWithIdentity(IdentityTest.getIdentityFixture());
	
	assertTrue(fixture.identifiesBy(fixture.hashCode()));
    }
}