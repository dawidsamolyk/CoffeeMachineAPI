package edu.issi.machine;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class IdentityTest {

    @Test(expected = SecurityException.class)
    public void shouldSecureFromTheSameIdForManyObjects() {
	new Identity(1);
	new Identity(1);
    }

}
