package edu.issi.machine.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationTest;

@SuppressWarnings("javadoc")
public class OrderedElementsContainerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldAgregateOrderedObjectsIndexedFromZero() {
	OrderedElementsList<Object> fixture = new OrderedElementsList<Object>();
	Object firstObject = new Object();
	Object secondObject = new Object();
	Object thirdObject = new Object();

	fixture.add(firstObject);
	fixture.add(secondObject);
	fixture.add(thirdObject);

	assertEquals(firstObject, fixture.getElement(0));
	assertEquals(secondObject, fixture.getElement(1));
	assertEquals(thirdObject, fixture.getElement(2));
    }

    @Test
    public void shouldProvideInformationAboutNumberOfAggegatedObjects() {
	int numberOfObjects = 10;
	OrderedElementsList<Object> fixture = new OrderedElementsList<Object>();

	for (int x = 0; x < numberOfObjects; x++) {
	    fixture.add(new Object());
	}

	assertEquals(numberOfObjects, fixture.getNumberOfElements());
    }

    @Test
    public void shouldBeAbleToAddObjectAtExistingIndexWithoutLossOfOtherObjects() throws Exception {
	OrderedElementsList<Operation> fixture = getFixture();

	Operation element = OperationTest.getFixture();
	fixture.addAt(1, element);

	assertEquals(element, fixture.getElement(1));
    }

    @Test
    public void shouldBeAbleToAddObjectAtBeginningOfList() throws Exception {
	OrderedElementsList<Operation> fixture = getFixture();
	Operation element = OperationTest.getFixture();
	
	fixture.addAt(0, element);

	assertEquals(element, fixture.getElement(0));
    }

    @Test
    public void shouldBeAbleToRemoveAnyExistingObject() {
	OrderedElementsList<Object> fixture = new OrderedElementsList<Object>();
	Object firstObject = new Object();
	Object secondObject = new Object();
	Object thirdObject = new Object();

	fixture.add(firstObject);
	fixture.add(secondObject);
	fixture.add(thirdObject);

	fixture.remove(1);

	assertEquals(firstObject, fixture.getElement(0));
	assertEquals(thirdObject, fixture.getElement(1));

	exception.expect(NoSuchElementException.class);
	fixture.getElement(2);
    }

    @Test
    public void shouldProvideSeparatedIterators() throws Exception {
	OrderedElementsList<Operation> fixture = getFixture();

	Iterator<Operation> firstIterator = fixture.iterator();
	Object firstIteratorObject = firstIterator.next();

	Iterator<Operation> secondIterator = fixture.iterator();
	secondIterator.next();
	Object secondIteratorObject = secondIterator.next();

	assertTrue(firstIteratorObject != secondIteratorObject);
    }

    @Test
    public void shouldProvideIteratorForOrderedObjects() {
	OrderedElementsList<Object> fixture = new OrderedElementsList<Object>();
	Object firstObject = new Object();
	Object secondObject = new Object();
	Object thirdObject = new Object();

	fixture.add(firstObject);
	fixture.add(secondObject);
	fixture.add(thirdObject);

	Iterator<Object> iterator = fixture.iterator();

	assertEquals(firstObject, iterator.next());
	assertEquals(secondObject, iterator.next());
	assertEquals(thirdObject, iterator.next());
    }

    public void shouldNotBeAbleToAddObjectAtNonexistentIndex() throws Exception {
	OrderedElementsList<Operation> fixture = getFixture();

	exception.expect(UnsupportedOperationException.class);
	fixture.addAt(100, OperationTest.getFixture());
    }

    @Test
    public void shouldNotBeAbleToRemoveObjectAtNonexistentIndex() throws Exception {
	OrderedElementsList<Operation> fixture = getFixture();

	exception.expect(NoSuchElementException.class);
	fixture.remove(100);
    }

    public static OrderedElementsList<Operation> getFixture() throws Exception {
	OrderedElementsList<Operation> result = new OrderedElementsList<Operation>();

	result.add(OperationTest.getFixture());
	result.add(OperationTest.getFixture());
	result.add(OperationTest.getFixture());

	return result;
    }

}
