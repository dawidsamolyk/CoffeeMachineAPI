package edu.issi.machine.product;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class OrderedElementsContainerTest {

    @Test
    public void shouldAgregateOrderedObjectsIndexedFromZero() {
	OrderedElementsList<Object> product = new OrderedElementsList<Object>();
	Object firstObject = new Object();
	Object secondObject = new Object();
	Object thirdObject = new Object();

	product.addAtTheEnd(firstObject);
	product.addAtTheEnd(secondObject);
	product.addAtTheEnd(thirdObject);

	assertEquals(firstObject, product.getElementAt(0));
	assertEquals(secondObject, product.getElementAt(1));
	assertEquals(thirdObject, product.getElementAt(2));
    }

    @Test
    public void shouldProvideInformationAboutNumberOfAggegatedObjects() {
	int numberOfObjects = new Random().nextInt(1000);
	OrderedElementsList<Object> product = new OrderedElementsList<Object>();

	for (int x = 0; x < numberOfObjects; x++) {
	    product.addAtTheEnd(new Object());
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
	assertEquals(ingredient, product.getElementAt(1));
    }

    @Test
    public void shouldBeAbleToAddObjectAtBeginningOfList() {
	OrderedElementsList<Object> product = productWithThreeExampleObjects();
	Object ingredient = new Object();
	product.addAt(0, ingredient);

	assertEquals(4, product.numberOfElements());
	assertEquals(ingredient, product.getElementAt(0));
    }

    @Test
    public void shouldBeAbleToRemoveAnyExistingObject() {
	OrderedElementsList<Object> product = new OrderedElementsList<Object>();
	Object firstObject = new Object();
	Object secondObject = new Object();
	Object thirdObject = new Object();

	product.addAtTheEnd(firstObject);
	product.addAtTheEnd(secondObject);
	product.addAtTheEnd(thirdObject);

	product.removeAt(1);

	assertEquals(firstObject, product.getElementAt(0));
	assertEquals(thirdObject, product.getElementAt(1));

	try {
	    product.getElementAt(2);
	    fail("Element powinien zostac usuniety, a nie zostalo to zrealizowane!");
	} catch (NoSuchElementException e) {
	}
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

	product.addAtTheEnd(firstObject);
	product.addAtTheEnd(secondObject);
	product.addAtTheEnd(thirdObject);

	Iterator<Object> iterator = product.iterator();
	assertEquals(firstObject, iterator.next());
	assertEquals(secondObject, iterator.next());
	assertEquals(thirdObject, iterator.next());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotBeAbleToAddObjectAtNonexistentIndex() {
	OrderedElementsList<Object> product = productWithThreeExampleObjects();
	product.addAt(100, new Object());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldNotBeAbleToRemoveObjectAtNonexistentIndex() {
	OrderedElementsList<Object> product = productWithThreeExampleObjects();
	product.removeAt(100);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldNotBeAbleToGetObjectAtNonexistentIndex() {
	OrderedElementsList<Object> product = productWithThreeExampleObjects();
	product.getElementAt(100);
    }

    private OrderedElementsList<Object> productWithThreeExampleObjects() {
	OrderedElementsList<Object> product = new OrderedElementsList<Object>();
	product.addAtTheEnd(new Object());
	product.addAtTheEnd(new Object());
	product.addAtTheEnd(new Object());
	return product;
    }

}
