package edu.issi.machine.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ProductTest;
import edu.issi.machine.product.ingredient.Ingredient;

@SuppressWarnings("javadoc")
public class OrderTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldNotCreatesWithoutProduct() {
	exception.expect(IllegalArgumentException.class);
	new Order((Product) null);
    }

    @Test
    public void shouldNotCreatesWithoutProductName() {
	exception.expect(IllegalArgumentException.class);
	new Order((String) null);
    }

    @Test
    public void shouldCreatesNewProductFromGivenName() {
	String productName = "Test product name";
	Order fixture = new Order(productName);

	assertEquals(productName, fixture.product.getName());
    }

    @Test
    public void whenCreatesWithSpecifiedProductShouldCreateCloneWithTheSameName() {
	Product product = ProductTest.Fixtures.getFixtureWithoutIngredients();
	Order fixture = new Order(product);

	assertEquals(product.getName(), fixture.product.getName());
    }

    @Test
    public void whenCreatesWithSpecifiedProductShouldCreateCloneWithNotTheSameIdentityNumber() {
	Product product = ProductTest.Fixtures.getFixtureWithoutIngredients();
	Order fixture = new Order(product);

	assertTrue(product.getIdNumber() != fixture.product.getIdNumber());
    }

    @Test
    public void whenCreatesWithSpecifiedProductShouldProvideTheSameOperationStatusAfterExecution() {
	List<Ingredient> ingredients = MachineConfigurationTest.Fixtures.getFixtureIngredients();
	Product product = ProductTest.Fixtures.getFixtureWith(ingredients , "Test product name");
	Order fixture = new Order(product);

	List<OperationStatus> allOperationsStatuses = new ArrayList<OperationStatus>();
	for (Ingredient eachIngredient : product) {
	    List<OperationStatus> operationsStatus = (List<OperationStatus>) eachIngredient.doOperations();
	    allOperationsStatuses.addAll(operationsStatus);
	}
	OperationStatus productOperationsStatus = OperationStatus.Factory.getFrom(allOperationsStatuses);
	OperationStatus fixtureOperationsStatus = fixture.execute();

	assertEquals(productOperationsStatus, fixtureOperationsStatus);
    }
}
