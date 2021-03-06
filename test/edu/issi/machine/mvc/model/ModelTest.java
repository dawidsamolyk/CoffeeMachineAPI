package edu.issi.machine.mvc.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.configuration.MachineConfigurationTest;
import edu.issi.machine.configuration.MachineConfigurationTest.Fixtures;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ProductTest;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.fakes.TestingSubassembly;

@SuppressWarnings("javadoc")
public class ModelTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldNotCreatesWithoutMachineConfiguration() {
	exception.expect(IllegalArgumentException.class);
	new Model(null);
    }

    @Test
    public void modelShouldBeAbleToStartMachine() throws Exception {
	MachineConfiguration configuration = Fixtures.getFixture();
	Model model = new Model(configuration);

	model.startMachine();

	Iterator<Subassembly> subassembliesIterator = configuration.getSubassembliesIterator();
	while (subassembliesIterator.hasNext()) {
	    TestingSubassembly subassembly = (TestingSubassembly) subassembliesIterator.next();
	    assertTrue(subassembly.isRunning());
	}
    }

    @Test
    public void modelShouldBeAbleToStopMachine() throws Exception {
	MachineConfiguration configuration = Fixtures.getFixture();
	Model model = new Model(configuration);

	model.startMachine();
	model.stopMachine();

	Iterator<Subassembly> subassembliesIterator = configuration.getSubassembliesIterator();
	while (subassembliesIterator.hasNext()) {
	    TestingSubassembly subassembly = (TestingSubassembly) subassembliesIterator.next();
	    assertFalse(subassembly.isRunning());
	}
    }

    @Test
    public void modelShouldProvidesProductsNames() throws Exception {
	List<Subassembly> subassemblies = Fixtures.getFixtureSubassemlies();
	List<Ingredient> ingredients = Fixtures.getFixtureIngredients();
	String[] fixtureProductsNames = { "Kawa", "Herbata", "Czekolada" };
	List<Product> products = ProductTest.Fixtures.getManyNamedFixturesWithIngredients(ingredients,
		fixtureProductsNames);
	MachineConfiguration configuration = new MachineConfiguration(subassemblies, ingredients, products);
	Model model = new Model(configuration);

	List<String> productsNames = model.getProductsNames();

	assertSame(productsNames.size(), fixtureProductsNames.length);

	for (String eachFixtureProductName : fixtureProductsNames) {
	    assertTrue(productsNames.contains(eachFixtureProductName));
	}
    }

    @Test
    public void modelShouldProvidesIngredientsNames() throws Exception {
	MachineConfiguration configuration = Fixtures.getFixture();
	Model model = new Model(configuration);

	List<String> ingredientsNames = model.getAllIngredientsNames();

	Iterator<Ingredient> ingredientsIterator = configuration.getIngredientsIterator();
	int ingredientsQuantity = 0;
	while (ingredientsIterator.hasNext()) {
	    Ingredient eachIngredient = ingredientsIterator.next();
	    assertTrue(ingredientsNames.contains(eachIngredient.getName()));

	    ingredientsQuantity++;
	}

	assertSame(ingredientsNames.size(), ingredientsQuantity);
    }

    @Test
    public void modelShouldNotProvidesIngredientsNamesForUnknownProduct() throws Exception {
	MachineConfiguration configuration = Fixtures.getFixture();
	Model model = new Model(configuration);

	exception.expect(NoSuchElementException.class);
	model.getIngredientsNamesForProductNamed("Unknown product");
    }

    @Test
    public void modelShouldProvidesPropertiesForKnownIngredient() throws Exception {
	List<Subassembly> subassemblies = MachineConfigurationTest.Fixtures.getFixtureSubassemlies();
	List<Ingredient> ingredients = MachineConfigurationTest.Fixtures.getFixtureIngredients();

	Map<String, Unit> properties = new HashMap<String, Unit>();
	properties.put("Test property 1", Unit.C);
	properties.put("Test property 2", Unit.G);
	properties.put("Test property 3", Unit.ML);

	String ingredientName = "Test ingredient";
	Ingredient testIngredient = new Ingredient(Identity.Factory.newIdentity(ingredientName));
	for (String eachPropertyName : properties.keySet()) {
	    Unit propertyUnit = properties.get(eachPropertyName);
	    PropertyIdentity property = PropertyIdentity.Factory.newProperty(eachPropertyName, propertyUnit);
	    testIngredient.add(property, 100.0);
	}
	ingredients.add(testIngredient);

	List<Product> products = MachineConfigurationTest.Fixtures.getFixtureProducts(ingredients);
	MachineConfiguration configuration = new MachineConfiguration(subassemblies, ingredients, products);
	Model model = new Model(configuration);

	Map<String, Unit> result = model.getPropertiesForIngredientNamed(ingredientName);

	assertEquals(properties, result);
    }

    @Test
    public void modelShouldNotProvidesPropertiesForUnknownIngredient() throws Exception {
	MachineConfiguration configuration = Fixtures.getFixture();
	Model model = new Model(configuration);

	exception.expect(NoSuchElementException.class);
	model.getPropertiesForIngredientNamed("Unknown ingredient");
    }

    public static Model getFixture() throws Exception {
	return new Model(MachineConfigurationTest.Fixtures.getFixture());
    }
}
