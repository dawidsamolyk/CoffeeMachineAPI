package edu.issi.machine;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("javadoc")
public class ValidatorTest {
    private static final String TEST_EXCEPTION_MESSAGE = "Test";
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowsExceptionWhenObjectIsNotCreated() {
	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenObjectIsNotCreated(null, TEST_EXCEPTION_MESSAGE);
    }

    @Test
    public void shouldThrowsExceptionWhenTextIsEmpty() {
	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenTextIsEmpty("", TEST_EXCEPTION_MESSAGE);
    }

    @Test
    public void shouldThrowsExceptionWhenTextIsNotCreated() {
	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenTextIsEmpty(null, TEST_EXCEPTION_MESSAGE);
    }
    
    @Test
    public void shouldThrowsExceptionWhenThereIsNotSuchElementAtSpecifiedIndex() {
	List<Object> list = new ArrayList<Object>();
	list.add(new Object());
	
	exception.expect(NoSuchElementException.class);
	Validator.throwExceptionWhenNoSuchElementAtIndex(list, 10, TEST_EXCEPTION_MESSAGE);
    }
    
    @Test
    public void shouldThrowsExceptionWhenSearchForElementFromIndexLessThanZero() {
	List<Object> list = new ArrayList<Object>();
	list.add(new Object());
	
	exception.expect(NoSuchElementException.class);
	Validator.throwExceptionWhenNoSuchElementAtIndex(list, -1, TEST_EXCEPTION_MESSAGE);
    }
    
    @Test
    public void shouldThrowsExceptionWhenIterableIsNotCreated() {
	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenContainsNullOrEmpty(null, TEST_EXCEPTION_MESSAGE);
    }
    
    @Test
    public void shouldThrowsExceptionWhenIterableHasNoElements() {
	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenContainsNullOrEmpty(new ArrayList<Object>(), TEST_EXCEPTION_MESSAGE);
    }
    
    @Test
    public void shouldThrowsExceptionWhenIterableContainsNotCreatedObjects() {
	ArrayList<Object> itearable = new ArrayList<Object>();
	itearable.add(new Object());
	itearable.add(null);
	itearable.add(new Object());
	
	exception.expect(IllegalArgumentException.class);
	Validator.throwExceptionWhenContainsNullOrEmpty(itearable, TEST_EXCEPTION_MESSAGE);
    }
    
    @Test
    public void shouldRecognizeIterableWithAnyNotCreatedElement() {
	List<Object> itearable = new ArrayList<Object>();
	itearable.add(new Object());
	itearable.add(null);
	itearable.add(new Object());
	
	assertTrue(Validator.containsNullObjects(itearable));
    }
    
    @Test
    public void shouldRecognizeIterableWithAllCreatedElements() {
	List<Object> itearable = new ArrayList<Object>();
	itearable.add(new Object());
	itearable.add(new Object());
	itearable.add(new Object());
	
	assertFalse(Validator.containsNullObjects(itearable));
    }
}
