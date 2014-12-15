package edu.issi.machine.product;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@SuppressWarnings("javadoc")
public class OrderedElementsContainerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldAgregateOrderedObjectsIndexedFromZero() {
	OrderedElementsList<Object> product = new OrderedElementsList<Object>();
	Object firstObject = new Object();
	Object secondObject = new Object();
	Object thirdObject = new Object();

	product.add(firstObject);
	product.add(secondObject);
	product.add(thirdObject);

	assertEquals(firstObject, product.getElement(0));
	assertEquals(secondObject, product.getElement(1));
	assertEquals(thirdObject, product.getElement(2));
    }

    @Test
    public void shouldProvideInformationAboutNumberOfAggegatedObjects() {
	int numberOfObjects = new Random().nextInt(1000);
	OrderedElementsList<Object> product = new OrderedElementsList<Object>();

	for (int x = 0; x < numberOfObjects; x++) {
	    product.add(new Object());
	}

	assertEquals(numberOfObjects, product.numberOfElements());
    }

    @Test
    public void shouldBeAbleToAddObjectAtExistingIndexWithoutLossOfOtherObjects() {
	OrderedElementsList<Object> product = productWithThreeExampleObjects();
	int originalNumberOfObjects = product.numberOfElements();

	Object ingredient = new Object();
	product.addAt(1, ingredient);

	assertEquals(originalNumberOfObjects + 1, product.numberOfElements());
	assertEquals(ingredient, product.getElement(1));
    }

    @Test
    public void shouldBeAbleToAddObjectAtBeginningOfList() {
	OrderedElementsList<Object> product = productWithThreeExampleObjects();
	Object ingredient = new Object();
	product.addAt(0, ingredient);

	assertEquals(4, product.numberOfElements());
	assertEquals(ingredient, product.getElement(0));
    }

    @Test
    public void shouldBeAbleToRemoveAnyExistingObject() {
	OrderedElementsList<Object> product = new OrderedElementsList<Object>();
	Object firstObject = new Object();
	Object secondObject = new Object();
	Object thirdObject = new Object();

	product.add(firstObject);
	product.add(secondObject);
	product.add(thirdObject);

	product.remove(1);

	assertEquals(firstObject, product.getElement(0));
	assertEquals(thirdObject, product.getElement(1));

	exception.expect(NoSuchElementException.class);
	product.getElement(2);
    }

    @Test
    public void shouldProvideSeparatedIterators() {
	OrderedElementsList<Object> product = productWithThreeExampleObjects();

	Iterator<Object> firstIterator = product.iterator();
	Object firstIteratorObject = firstIterator.next();

	Iterator<Object> secondIterator = product.iterator();
	secondIterator.next();
	Object secondIteratorObject = secondIterator.next();

	assertFalse(firstIteratorObject == secondIteratorObject);
    }

    @Test
    public void shouldProvideIteratorForOrderedObjects() {
	OrderedElementsList<Object> product = new OrderedElementsList<Object>();
	Object firstObject = new Object();
	Object secondObject = new Object();
	Object thirdObject = new Object();

	product.add(firstObject);
	product.add(secondObject);
	product.add(thirdObject);

	Iterator<Object> iterator = product.iterator();
	assertEquals(firstObject, iterator.next());
	assertEquals(secondObject, iterator.next());
	assertEquals(thirdObject, iterator.next());
    }

    public void shouldNotBeAbleToAddObjectAtNonexistentIndex() {
	OrderedElementsList<Object> product = productWithThreeExampleObjects();

	exception.expect(UnsupportedOperationException.class);
	product.addAt(100, new Object());
    }

    @Test
    public void shouldNotBeAbleToRemoveObjectAtNonexistentIndex() {
	OrderedElementsList<Object> product = productWithThreeExampleObjects();

	exception.expect(NoSuchElementException.class);
	product.remove(100);
    }

    @Test
    public void shouldNotBeAbleToGetObjectAtNonexistentIndex() {
	OrderedElementsList<Object> product = productWithThreeExampleObjects();

	exception.expect(NoSuchElementException.class);
	product.getElement(100);
    }

    private OrderedElementsList<Object> productWithThreeExampleObjects() {
	OrderedElementsList<Object> product = new OrderedElementsList<Object>();
	product.add(new Object());
	product.add(new Object());
	product.add(new Object());
	return product;
    }

}
