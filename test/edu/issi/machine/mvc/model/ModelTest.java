package edu.issi.machine.mvc.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.configuration.MachineConfigurationTest;
import edu.issi.machine.configuration.MachineConfigurationTest.Fixtures;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ProductTest;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.TestingSubassembly;

@SuppressWarnings("javadoc")
public class ModelTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @SuppressWarnings("unused")
    @Test
    public void shouldNotCreatesWithoutMachineConfiguration() {
	exception.expect(IllegalArgumentException.class);
	new Model(null);
    }

    @Test
    public void modelShouldNotBeAbleToAddNotCreatedProcutToMachineConfiguration() throws Exception {
	Model fixture = ModelTest.getFixture();

	exception.expect(IllegalArgumentException.class);
	fixture.addProduct(null);
    }

    @Test
    public void modelShouldBeAbleToAddNewProductToMachineConfiguration() throws Exception {
	List<Ingredient> ingredients = Fixtures.getFixtureIngredients();
	List<Subassembly> subassemlies = Fixtures.getFixtureSubassemlies();
	List<Product> products = ProductTest.Fixtures.getManyNamedFixturesWithIngredients(ingredients, "Kawa");
	MachineConfiguration configuration = new MachineConfiguration(subassemlies, ingredients, products);
	Model model = new Model(configuration);

	Product newProduct = ProductTest.Fixtures.getFixtureWith(ingredients, "Czekolada");
	model.addProduct(newProduct);

	boolean hasNewProduct = false;

	Iterator<Product> productsIterator = configuration.getProductsIterator();
	while (productsIterator.hasNext()) {
	    Product eachProduct = productsIterator.next();

	    if (eachProduct.equals(newProduct)) {
		hasNewProduct = true;
	    }
	}

	assertTrue(hasNewProduct);
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
	List<Product> products = ProductTest.Fixtures.getManyNamedFixturesWithIngredients(ingredients, fixtureProductsNames);
	MachineConfiguration configuration = new MachineConfiguration(subassemblies, ingredients, products);
	Model model = new Model(configuration);
	
	Set<String> productsNames = model.getProductsNames();
	
	assertSame(productsNames.size(), fixtureProductsNames.length);
	
	for(String eachFixtureProductName : fixtureProductsNames) {
	    assertTrue(productsNames.contains(eachFixtureProductName));
	}
    }
    
    @Test
    public void modelShouldProvidesIngredientsNames() throws Exception {
	MachineConfiguration configuration = Fixtures.getFixture();
	Model model = new Model(configuration);
	
	Set<String> ingredientsNames = model.getAllIngredientsNames();
	
	Iterator<Ingredient> ingredientsIterator = configuration.getIngredientsIterator();
	int ingredientsQuantity = 0;
	while(ingredientsIterator.hasNext()) {
	    Ingredient eachIngredient = ingredientsIterator.next();
	    assertTrue(ingredientsNames.contains(eachIngredient.getName()));
	    
	    ingredientsQuantity++;
	}
	
	assertSame(ingredientsNames.size(), ingredientsQuantity);
    }

    public static Model getFixture() throws Exception {
	return new Model(MachineConfigurationTest.Fixtures.getFixture());
    }
}
