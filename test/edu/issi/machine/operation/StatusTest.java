package edu.issi.machine.operation;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class StatusTest {
    
    @Test
    public void erroneousStatusShouldRequiresAttention() {
	Status error = Status.ERROR;
	
	assertTrue(error.requiresAttention());
    }
    
    @Test
    public void warningStatusShouldRequiresAttention() {
	Status error = Status.WARNING;
	
	assertTrue(error.requiresAttention());
    }
    
    @Test
    public void validStatusShouldNotRequiresAttention() {
	Status error = Status.OK;
	
	assertFalse(error.requiresAttention());
    }
}
