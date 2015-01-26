package edu.issi.machine.id;

import static org.junit.Assert.*;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("javadoc")
public class IdentityTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void identityShouldBeEnableToChangeName() throws InvalidAttributeIdentifierException {
	String originalName = "Test";
	String newName = "Real";
	Identity fixture = Identity.Factory.newIdentity(originalName);
	
	fixture.changeName(newName);
	
	assertEquals(newName, fixture.getName());
    }
    
    @Test
    public void identityNotShouldBeEnableToChangeToEmptyName() throws InvalidAttributeIdentifierException {
	Identity fixture = IdentityTest.getIdentityFixture();
	
	exception.expect(IllegalArgumentException.class);
	fixture.changeName(null);
    }
    
    @Test
    public void identityShouldBeKnownByIdNumber() throws InvalidAttributeIdentifierException {
	Identity fixture = IdentityTest.getIdentityFixture();
	int idNumber = fixture.getIdNumber();
	
	assertTrue(fixture.identifiesBy(idNumber));
    }
    
    @Test
    public void identityShouldNotBeKnownByUnknownIdNumber() throws InvalidAttributeIdentifierException {
	Identity fixture = IdentityTest.getIdentityFixture();
	int idNumber = fixture.getIdNumber();
	int unknownIdNumber = idNumber + 1;
	
	assertFalse(fixture.identifiesBy(unknownIdNumber));
    }
    
    public static Identity getIdentityFixture() throws InvalidAttributeIdentifierException {
        return Identity.Factory.newIdentity("Test");
    }

}
