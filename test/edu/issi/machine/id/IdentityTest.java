package edu.issi.machine.id;

import javax.naming.directory.InvalidAttributeIdentifierException;

@SuppressWarnings("javadoc")
public class IdentityTest {

    public static Identity getIdentityFixture() throws InvalidAttributeIdentifierException {
        return Identity.Factory.newIdentity("Test");
    }

}
