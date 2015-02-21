package edu.issi.machine.configuration;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationTest;
import edu.issi.machine.operation.fakes.FakeOperation;
import edu.issi.machine.product.OrderedElementsList;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ProductTest;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.fakes.TestingSubassembly;

@SuppressWarnings("javadoc")
public class MachineConfigurationTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void subassembliesShouldBeSetted() {
	List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(null, fixtureIngredients, Fixtures.getFixtureProducts(fixtureIngredients));
    }

    @Test
    public void subassembliesListShouldNotBeEmpty() {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, fixtureIngredients, Fixtures.getFixtureProducts(fixtureIngredients));
    }

    @Test
    public void productsShouldBeSetted() throws Exception {
	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(Fixtures.getFixtureSubassemlies(), Fixtures.getFixtureIngredients(), null);
    }

    @Test
    public void ingredientsShouldBeSetted() throws Exception {
	List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(Fixtures.getFixtureSubassemlies(), null, Fixtures.getFixtureProducts(fixtureIngredients));
    }

    @Test
    public void productsListShouldNotBeEmpty() {
	List<Product> products = new ArrayList<Product>();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(Fixtures.getFixtureSubassemlies(), Fixtures.getFixtureIngredients(), products);
    }

    @Test
    public void shouldProvidesIteratorForProducts() {
	MachineConfiguration fixture = Fixtures.getFixture();

	assertNotNull(fixture.getProductsIterator());
    }

    @Test
    public void shouldAddNewProduct() {
	List<Ingredient> ingredients = Fixtures.getFixtureIngredients();
	List<Subassembly> subassemlies = Fixtures.getFixtureSubassemlies();
	List<Product> products = ProductTest.Fixtures.getManyNamedFixturesWithIngredients(ingredients, "Kawa");
	MachineConfiguration fixture = new MachineConfiguration(subassemlies, ingredients, products);

	Product newProduct = ProductTest.Fixtures.getFixtureWith(ingredients, "Czekolada");
	fixture.addProduct(newProduct);

	boolean containsNewProduct = false;
	for (Iterator<Product> iterator = fixture.getProductsIterator(); iterator.hasNext();) {
	    Product eachProduct = iterator.next();
	    
	    if(eachProduct.equals(newProduct)) {
		containsNewProduct = true;
		break;
	    }
	}

	assertTrue(containsNewProduct);
    }

    @Test
    public void shouldNotAddEmptyProduct() {
	MachineConfiguration fixture = Fixtures.getFixture();

	exception.expect(IllegalArgumentException.class);
	fixture.addProduct(null);
    }

    @Test
    public void shouldNotAddProductWhichHasUnavailableIngredients() throws IllegalArgumentException {

	List<Ingredient> ingredients = Fixtures.getFixtureIngredients();
	List<Subassembly> subassemlies = Fixtures.getFixtureSubassemlies();
	List<Product> products = ProductTest.Fixtures.getManyNamedFixturesWithIngredients(ingredients, "Kawa");
	MachineConfiguration fixture = new MachineConfiguration(subassemlies, ingredients, products);

	Product newProduct = ProductTest.Fixtures.getFixtureWith(Fixtures.getFixtureIngredients(), "Czekolada");

	exception.expect(IllegalArgumentException.class);
	fixture.addProduct(newProduct);
    }

    @Test
    public void machineConfigurationShouldConsistsOfProductsWhichContainsOnlyAvailableIngredients() throws Exception {
	List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();
	List<Subassembly> fixtureSubassemlies = Fixtures.getFixtureSubassemlies();
	List<Product> fixtureProducts = ProductTest.Fixtures.getManyNamedFixturesWithIngredients(
		Fixtures.getFixtureIngredients(), "Kawa", "Herbata");

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(fixtureSubassemlies, fixtureIngredients, fixtureProducts);
    }

    @Test
    public void machineConfigurationShouldConsistsOfProductsWhichContainsAnyIngredients() throws Exception {
	List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();
	List<Subassembly> fixtureSubassemlies = Fixtures.getFixtureSubassemlies();
	List<Product> fixtureProducts = ProductTest.Fixtures.getManyFixtures();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(fixtureSubassemlies, fixtureIngredients, fixtureProducts);
    }

    public static class Fixtures {

	public static MachineConfiguration getFixture() throws IllegalArgumentException {
	    List<Subassembly> fixtureSubassemlies = Fixtures.getFixtureSubassemlies();
	    List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();
	    List<Product> fixtureProducts = Fixtures.getFixtureProducts(fixtureIngredients);

	    return new MachineConfiguration(fixtureSubassemlies, fixtureIngredients, fixtureProducts);
	}

	public static List<Subassembly> getFixtureSubassemlies() {
	    List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	    TestingSubassembly subassembly = TestingSubassembly.getFixtureWith(OperationTest.getFixture());
	    subassemblies.add(subassembly);

	    return subassemblies;
	}

	public static List<Ingredient> getFixtureIngredients() throws IllegalArgumentException {
	    List<Ingredient> result = new ArrayList<Ingredient>();

	    result.add(getFixtureIngredient("Woda", PropertyIdentity.Factory.newProperty("Temperatura", Unit.C), 100.0));
	    result.add(getFixtureIngredient("Cukier", PropertyIdentity.Factory.newProperty("Iloœæ", Unit.G), 20.0));
	    result.add(getFixtureIngredient("Kawa", PropertyIdentity.Factory.newProperty("Iloœæ", Unit.G), 70.0));
	    result.add(getFixtureIngredient("Mleko", PropertyIdentity.Factory.newProperty("Iloœæ", Unit.ML), 10.0));

	    return result;
	}

	private static Ingredient getFixtureIngredient(String name, PropertyIdentity property, Double value) {
	    OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	    operations.add(new FakeOperation());
	    Ingredient ingredient = new Ingredient(Identity.Factory.newIdentity(name));
	    ingredient.setOperations(operations);
	    ingredient.add(property, value);
	    return ingredient;
	}

	public static List<Product> getFixtureProducts(List<Ingredient> fixtureIngredients) throws IllegalArgumentException {
	    List<Product> result = new ArrayList<Product>();

	    for (Ingredient eachIngredient : fixtureIngredients) {
		Product product = new Product(IdentityTest.getIdentityFixture());
		product.add(eachIngredient);
		result.add(product);
	    }

	    return result;
	}

    }

}
