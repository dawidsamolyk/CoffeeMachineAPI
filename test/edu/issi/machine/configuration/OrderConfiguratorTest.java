package edu.issi.machine.configuration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.configuration.Order.Configurator;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ProductTest;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.IngredientTest;

@SuppressWarnings("javadoc")
public class OrderConfiguratorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void configuratorShouldBeAbleToAddNewIngredientsToProduct() {
	List<Ingredient> ingredients = MachineConfigurationTest.Fixtures.getFixtureIngredients();
	Product product = ProductTest.Fixtures.getFixtureWith(ingredients, "Test product");
	Order order = new Order(product);
	Configurator fixture = order.new Configurator();

	fixture.addAt(0, IngredientTest.Fixtures.getComplexFixture());
	fixture.addAt(1, IngredientTest.Fixtures.getComplexFixture());

	assertEquals(product.numberOfElements() + 2, order.product.numberOfElements());
    }

    @Test
    public void configuratorShouldBeAbleToRemoveIngredientsFromProduct() {
	List<Ingredient> ingredients = MachineConfigurationTest.Fixtures.getFixtureIngredients();
	Product product = ProductTest.Fixtures.getFixtureWith(ingredients, "Test product");
	Order order = new Order(product);
	Configurator fixture = order.new Configurator();

	fixture.remove(0);

	assertEquals(product.numberOfElements() - 1, order.product.numberOfElements());
    }
}
