package edu.issi.machine.id;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("javadoc")
public class IdentityTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void identityShouldBeEnableToChangeName() {
	String originalName = "Test";
	String newName = "Real";
	Identity fixture = Identity.Factory.newIdentity(originalName);
	
	fixture.changeName(newName);
	
	assertEquals(newName, fixture.getName());
    }
    
    @Test
    public void identityNotShouldBeEnableToChangeToEmptyName() {
	Identity fixture = IdentityTest.getIdentityFixture();
	
	exception.expect(IllegalArgumentException.class);
	fixture.changeName(null);
    }
    
    @Test
    public void identityShouldBeKnownByIdNumber() {
	Identity fixture = IdentityTest.getIdentityFixture();
	int idNumber = fixture.getIdNumber();
	
	assertTrue(fixture.identifiesBy(idNumber));
    }
    
    @Test
    public void identityShouldNotBeKnownByUnknownIdNumber() {
	Identity fixture = IdentityTest.getIdentityFixture();
	int idNumber = fixture.getIdNumber();
	int unknownIdNumber = idNumber + 1;
	
	assertFalse(fixture.identifiesBy(unknownIdNumber));
    }
    
    @Test
    public void shouldBeEqualOnlyToSelf() throws Exception {
	Identity fixture = new Identity(999, "Test");
	Identity fixture2 = new Identity(999, "Test");
	
	assertTrue(fixture.equals(fixture));
	assertFalse(fixture.equals(fixture2));
    }
    
    public static Identity getIdentityFixture() {
        return Identity.Factory.newIdentity("Test");
    }

}
