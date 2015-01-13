package edu.issi.machine;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.controller.MachineController;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.product.OrderedElementsList;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.TestingSubassembly;
import edu.issi.machine.subassembly.handler.DefaultHandler;

@SuppressWarnings("javadoc")
public class DemoApplication {
    private static MachineController controller;

    protected static void setUp() throws InvalidAttributeIdentifierException {
	List<Product> products = getTestingProducts();
	List<Subassembly> subassemblies = getTestingSubassemblies(products);

	MachineConfiguration config = new MachineConfiguration(subassemblies, products);
	
	controller = new MachineController();
	controller.setUpUsing(config);
    }

    protected static List<Subassembly> getTestingSubassemblies(List<Product> products)
	    throws InvalidAttributeIdentifierException {
	
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	
	List<Operation> grinderOperations = new ArrayList<Operation>();
	grinderOperations.add(new DemoGrinding(Identity.Factory.newIdentity("Operacja mielenia")));
	Subassembly grinder = new TestingSubassembly(Identity.Factory.newIdentity("Mielarka"), grinderOperations);
	grinder.addHandler(new DefaultHandler());
	subassemblies.add(grinder);

	List<Operation> guiOperations = new ArrayList<Operation>();
	guiOperations.add(new DemoGuiProductsList(Identity.Factory.newIdentity("Lista produkt�w"), products));
	guiOperations.add(new DemoGuiProductChooser(Identity.Factory.newIdentity("Wyb�r produktu"), products));
	guiOperations.add(new DemoGuiProductAdder(Identity.Factory.newIdentity("Dodawanie produktu"), products));
	DemoUserInterfaceSubassembly gui = new DemoUserInterfaceSubassembly(Identity.Factory.newIdentity("Demo GUI"), guiOperations);

	subassemblies.add(gui);
	return subassemblies;
    }

    protected static List<Product> getTestingProducts() throws InvalidAttributeIdentifierException {
	List<Product> products = new ArrayList<Product>();

	Product blackCoffee = new Product(Identity.Factory.newIdentity("Kawa czarna"));
	
	Ingredient coffee = getCoffeeIngredient();
	blackCoffee.add(coffee);
	
	Ingredient water = getWaterIngredient();
	blackCoffee.add(water);
	
	products.add(blackCoffee);

	return products;
    }

    private static Ingredient getWaterIngredient() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = new Ingredient(Identity.Factory.newIdentity("Woda"));

	ingredient.add(PropertyIdentity.Factory.newProperty("Temperatura", Unit.C), 100.0);
	ingredient.add(PropertyIdentity.Factory.newProperty("Ci�nienie", Unit.BAR), 2.0);
	ingredient.add(PropertyIdentity.Factory.newProperty("Rozmiar porcji", Unit.ML), 200.0);

	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Podgrzewanie")).setIngredient(ingredient));
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Wlewanie")).setIngredient(ingredient));

	ingredient.addOperations(operations);

	return ingredient;
    }

    protected static Ingredient getCoffeeIngredient() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = new Ingredient(Identity.Factory.newIdentity("Ziarna kawy"));

	ingredient.add(PropertyIdentity.Factory.newProperty("Ilo��", Unit.G), 5000.0);
	ingredient.add(PropertyIdentity.Factory.newProperty("Temperatura", Unit.C), 50.0);
	ingredient.add(PropertyIdentity.Factory.newProperty("Rozmiar porcji", Unit.G), 10.0);

	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Wybranie porcji")).setIngredient(ingredient));
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Mielenie")).setIngredient(ingredient));
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Podgrzewanie")).setIngredient(ingredient));
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Wsypywanie")).setIngredient(ingredient));

	ingredient.addOperations(operations);

	return ingredient;
    }

    protected static void tearDown() throws Exception {
	controller.start();
	controller.stop();
	controller.tearDown();
    }

    public static void main(String[] args) throws Exception {
	setUp();
	controller.start();
	tearDown();
    }

}