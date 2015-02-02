package edu.issi.machine.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import edu.issi.machine.product.ingredient.IngredientTest;
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
	List<Ingredient> fixtureIngredients = getFixtureIngredients();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(null, fixtureIngredients, getFixtureProducts(fixtureIngredients));
    }

    @SuppressWarnings("unused")
    @Test
    public void subassembliesListShouldNotBeEmpty() throws InvalidAttributeIdentifierException {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	List<Ingredient> fixtureIngredients = getFixtureIngredients();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(subassemblies, fixtureIngredients, getFixtureProducts(fixtureIngredients));
    }

    @SuppressWarnings("unused")
    @Test
    public void productsShouldBeSetted() throws Exception {
	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(getFixtureSubassemlies(), getFixtureIngredients(), null);
    }

    @SuppressWarnings("unused")
    @Test
    public void ingredientsShouldBeSetted() throws Exception {
	List<Ingredient> fixtureIngredients = getFixtureIngredients();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(getFixtureSubassemlies(), null, getFixtureProducts(fixtureIngredients));
    }

    @SuppressWarnings("unused")
    @Test
    public void productsListShouldNotBeEmpty() throws InvalidAttributeIdentifierException {
	List<Product> products = new ArrayList<Product>();

	exception.expect(IllegalArgumentException.class);
	new MachineConfiguration(getFixtureSubassemlies(), getFixtureIngredients(), products);
    }

    @Test
    public void shouldProvidesIteratorForProducts() throws InvalidAttributeIdentifierException {
	MachineConfiguration fixture = MachineConfigurationTest.getFixture();

	assertNotNull(fixture.getProductsIterator());
    }

    @Test
    public void shouldAddNewProduct() throws InvalidAttributeIdentifierException {
	// Tutaj dostarczone s¹ ju¿ przyk³adowe produkty
	MachineConfiguration fixture = MachineConfigurationTest.getFixture();

	Product product = ProductTest.getFixture();
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
	MachineConfiguration fixture = MachineConfigurationTest.getFixture();

	exception.expect(IllegalArgumentException.class);
	fixture.addProduct(null);
    }

    public static MachineConfiguration getFixture() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	List<Ingredient> fixtureIngredients = getFixtureIngredients();
	return new MachineConfiguration(getFixtureSubassemlies(), fixtureIngredients, getFixtureProducts(fixtureIngredients));
    }

    private static List<Subassembly> getFixtureSubassemlies() throws InvalidAttributeIdentifierException {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	TestingSubassembly subassembly = TestingSubassembly.getFixtureWith(OperationTest.getFixture());
	subassemblies.add(subassembly);
	
	return subassemblies;
    }

    private static List<Ingredient> getFixtureIngredients() throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	List<Ingredient> result = new ArrayList<Ingredient>();

	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(OperationTest.getFixture());

	Ingredient ingredient = IngredientTest.getSimpleFixture();
	ingredient.setOperations(operations);

	PropertyIdentity property = PropertyIdentity.Factory.newProperty("Pressure", Unit.BAR);
	ingredient.add(property, new Double(-1.0));
	
	result.add(ingredient);

	return result;
    }

    private static List<Product> getFixtureProducts(List<Ingredient> fixtureIngredients) throws IllegalArgumentException,
	    InvalidAttributeIdentifierException {
	List<Product> result = new ArrayList<Product>();

	for (Ingredient eachIngredient : fixtureIngredients) {
	    Product product = new Product(IdentityTest.getIdentityFixture());
	    product.add(eachIngredient);
	    result.add(product);
	}

	return result;
    }

}
