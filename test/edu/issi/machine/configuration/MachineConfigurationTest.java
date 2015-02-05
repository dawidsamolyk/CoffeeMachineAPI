package edu.issi.machine.configuration;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationTest;
import edu.issi.machine.product.OrderedElementsList;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ProductTest;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.TestingSubassembly;

@SuppressWarnings("javadoc")
public class MachineConfigurationTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @SuppressWarnings("unused")
    @Test
    public void subassembliesShouldBeSetted() throws InvalidAttributeIdentifierException {
	List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(null, fixtureIngredients, Fixtures.getFixtureProducts(fixtureIngredients));
    }

    @SuppressWarnings("unused")
    @Test
    public void subassembliesListShouldNotBeEmpty() throws InvalidAttributeIdentifierException {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, fixtureIngredients, Fixtures.getFixtureProducts(fixtureIngredients));
    }

    @SuppressWarnings("unused")
    @Test
    public void productsShouldBeSetted() throws Exception {
	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(Fixtures.getFixtureSubassemlies(), Fixtures.getFixtureIngredients(), null);
    }

    @SuppressWarnings("unused")
    @Test
    public void ingredientsShouldBeSetted() throws Exception {
	List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(Fixtures.getFixtureSubassemlies(), null,
		Fixtures.getFixtureProducts(fixtureIngredients));
    }

    @SuppressWarnings("unused")
    @Test
    public void productsListShouldNotBeEmpty() throws InvalidAttributeIdentifierException {
	List<Product> products = new ArrayList<Product>();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(Fixtures.getFixtureSubassemlies(), Fixtures.getFixtureIngredients(), products);
    }

    @Test
    public void shouldProvidesIteratorForProducts() throws InvalidAttributeIdentifierException {
	MachineConfiguration fixture = Fixtures.getFixture();

	assertNotNull(fixture.getProductsIterator());
    }

    @Test
    public void shouldAddNewProduct() throws InvalidAttributeIdentifierException {
	List<Ingredient> ingredients = Fixtures.getFixtureIngredients();
	List<Subassembly> subassemlies = Fixtures.getFixtureSubassemlies();
	List<Product> products = ProductTest.Fixtures.getManyNamedFixturesWithIngredients(ingredients, "Kawa");
	MachineConfiguration fixture = new MachineConfiguration(subassemlies, ingredients, products);

	Product product = ProductTest.Fixtures.getFixtureWith(ingredients, "Czekolada");
	fixture.addProduct(product);

	// Pobieram ostatni produkt, poniewa¿ nowo dodany produkt bêdzie na
	// koñcu listy
	Iterator<Product> iterator = fixture.getProductsIterator();
	Product productToCheck = null;
	while (iterator.hasNext()) {
	    productToCheck = iterator.next();
	}

	assertEquals(product, productToCheck);
    }

    @Test
    public void shouldNotAddEmptyProduct() throws InvalidAttributeIdentifierException {
	MachineConfiguration fixture = Fixtures.getFixture();

	exception.expect(IllegalArgumentException.class);
	fixture.addProduct(null);
    }

    @Test
    public void shouldNotAddProductWhichHasUnavailableIngredients() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	
	List<Ingredient> ingredients = Fixtures.getFixtureIngredients();
	List<Subassembly> subassemlies = Fixtures.getFixtureSubassemlies();
	List<Product> products = ProductTest.Fixtures.getManyNamedFixturesWithIngredients(ingredients, "Kawa");
	MachineConfiguration fixture = new MachineConfiguration(subassemlies, ingredients, products);

	Product newProduct = ProductTest.Fixtures.getFixtureWith(Fixtures.getFixtureIngredients(), "Czekolada");

	exception.expect(IllegalArgumentException.class);
	fixture.addProduct(newProduct);
    }
    
    @Test
    public void shouldNotAddProductWhichHasNotAnyIngredients() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	MachineConfiguration fixture = Fixtures.getFixture();
	
	exception.expect(IllegalArgumentException.class);
	fixture.addProduct(ProductTest.Fixtures.getFixtureWithoutIngredients());
    }

    @SuppressWarnings("unused")
    @Test
    public void machineConfigurationShouldConsistsOfProductsWhichContainsOnlyAvailableIngredients() throws Exception {
	List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();
	List<Subassembly> fixtureSubassemlies = Fixtures.getFixtureSubassemlies();
	List<Product> fixtureProducts = ProductTest.Fixtures.getManyNamedFixturesWithIngredients(
		Fixtures.getFixtureIngredients(), "Kawa", "Herbata");

	exception.expect(IllegalStateException.class);
	new MachineConfiguration(fixtureSubassemlies, fixtureIngredients, fixtureProducts);
    }

    @SuppressWarnings("unused")
    @Test
    public void machineConfigurationShouldConsistsOfProductsWhichContainsAnyIngredients() throws Exception {
	List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();
	List<Subassembly> fixtureSubassemlies = Fixtures.getFixtureSubassemlies();
	List<Product> fixtureProducts = ProductTest.Fixtures.getManyFixtures();

	exception.expect(IllegalStateException.class);
	new MachineConfiguration(fixtureSubassemlies, fixtureIngredients, fixtureProducts);
    }

    public static class Fixtures {

	public static MachineConfiguration getFixture() throws IllegalArgumentException,
		InvalidAttributeIdentifierException {

	    List<Ingredient> fixtureIngredients = Fixtures.getFixtureIngredients();
	    List<Subassembly> fixtureSubassemlies = Fixtures.getFixtureSubassemlies();
	    List<Product> fixtureProducts = Fixtures.getFixtureProducts(fixtureIngredients);

	    return new MachineConfiguration(fixtureSubassemlies, fixtureIngredients, fixtureProducts);
	}

	public static List<Subassembly> getFixtureSubassemlies() throws InvalidAttributeIdentifierException {
	    List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	    TestingSubassembly subassembly = TestingSubassembly.getFixtureWith(OperationTest.getFixture());
	    subassemblies.add(subassembly);

	    return subassemblies;
	}

	public static List<Ingredient> getFixtureIngredients() throws IllegalArgumentException,
		InvalidAttributeIdentifierException {
	    List<Ingredient> result = new ArrayList<Ingredient>();

	    OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	    operations.add(OperationTest.getFixture());

	    Ingredient ingredient = edu.issi.machine.product.ingredient.IngredientTest.Fixtures.getSimpleFixture();
	    ingredient.setOperations(operations);

	    PropertyIdentity property = PropertyIdentity.Factory.newProperty("Pressure", Unit.BAR);
	    ingredient.add(property, new Double(-1.0));

	    result.add(ingredient);

	    return result;
	}

	public static List<Product> getFixtureProducts(List<Ingredient> fixtureIngredients)
		throws IllegalArgumentException, InvalidAttributeIdentifierException {
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
