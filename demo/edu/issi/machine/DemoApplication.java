package edu.issi.machine;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.controller.MachineController;
import edu.issi.machine.id.UniqueIdentityBuilder;
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
	UniqueIdentityBuilder idBuilder = new UniqueIdentityBuilder();

	List<Product> products = getTestingProducts(idBuilder);
	List<Subassembly> subassemblies = getTestingSubassemblies(idBuilder, products);

	MachineConfiguration config = new MachineConfiguration(subassemblies, products);
	
	controller = new MachineController();
	controller.setUpUsing(config);
    }

    protected static List<Subassembly> getTestingSubassemblies(UniqueIdentityBuilder idBuilder, List<Product> products)
	    throws InvalidAttributeIdentifierException {
	
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	
	List<Operation> grinderOperations = new ArrayList<Operation>();
	grinderOperations.add(new DemoGrinding(idBuilder.newIdentity()));
	Subassembly grinder = new TestingSubassembly(idBuilder.newIdentityWithName("Mielarka"), grinderOperations);
	grinder.addHandler(new DefaultHandler());
	subassemblies.add(grinder);

	List<Operation> guiOperations = new ArrayList<Operation>();
	guiOperations.add(new DemoGuiProductsList(idBuilder.newIdentity(), products));
	guiOperations.add(new DemoGuiProductChooser(idBuilder.newIdentity(), products));
	guiOperations.add(new DemoGuiProductAdder(idBuilder.newIdentity(), products, idBuilder));
	DemoUserInterfaceSubassembly gui = new DemoUserInterfaceSubassembly(idBuilder.newIdentity(), guiOperations);

	subassemblies.add(gui);
	return subassemblies;
    }

    protected static List<Product> getTestingProducts(UniqueIdentityBuilder idBuilder) throws InvalidAttributeIdentifierException {
	List<Product> products = new ArrayList<Product>();

	Product blackCoffee = new Product(idBuilder.newIdentityWithName("Kawa czarna"));
	
	Ingredient coffee = getCoffeeIngredient(idBuilder);
	blackCoffee.add(coffee);
	
	Ingredient water = getWaterIngredient(idBuilder);
	blackCoffee.add(water);
	
	products.add(blackCoffee);

	return products;
    }

    private static Ingredient getWaterIngredient(UniqueIdentityBuilder idBuilder) throws InvalidAttributeIdentifierException {
	Ingredient ingredient = new Ingredient(idBuilder.newIdentityWithName("Woda"));

	ingredient.add(idBuilder.newProperty("Temperatura", Unit.C), 100.0);
	ingredient.add(idBuilder.newProperty("Ciœnienie", Unit.BAR), 2.0);
	ingredient.add(idBuilder.newProperty("Rozmiar porcji", Unit.ML), 200.0);

	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new DemoOperation(idBuilder.newIdentityWithName("Podgrzewanie")).setIngredient(ingredient));
	operations.add(new DemoOperation(idBuilder.newIdentityWithName("Wlewanie")).setIngredient(ingredient));

	ingredient.addOperations(operations);

	return ingredient;
    }

    protected static Ingredient getCoffeeIngredient(UniqueIdentityBuilder idBuilder) throws InvalidAttributeIdentifierException {
	Ingredient ingredient = new Ingredient(idBuilder.newIdentityWithName("Ziarna kawy"));

	ingredient.add(idBuilder.newProperty("Iloœæ", Unit.G), 5000.0);
	ingredient.add(idBuilder.newProperty("Temperatura", Unit.C), 50.0);
	ingredient.add(idBuilder.newProperty("Rozmiar porcji", Unit.G), 10.0);

	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new DemoOperation(idBuilder.newIdentityWithName("Wybranie porcji")).setIngredient(ingredient));
	operations.add(new DemoOperation(idBuilder.newIdentityWithName("Mielenie")).setIngredient(ingredient));
	operations.add(new DemoOperation(idBuilder.newIdentityWithName("Podgrzewanie")).setIngredient(ingredient));
	operations.add(new DemoOperation(idBuilder.newIdentityWithName("Wsypywanie")).setIngredient(ingredient));

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
