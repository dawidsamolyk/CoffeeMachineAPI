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

@SuppressWarnings("javadoc")
public class DemoApplication {
    private static MachineController controller;
    
    public static void main(String[] args) throws Exception {
	setUp();
	controller.start();
	controller.stop();
    }

    private static void setUp() throws InvalidAttributeIdentifierException {
	List<Ingredient> ingredients = new ArrayList<Ingredient>();
	ingredients.add(getDemoCoffee());
	ingredients.add(getDemoWater());
	
	List<Product> products = getDemoProducts(ingredients);
	List<Subassembly> subassemblies = getDemoSubassemblies(products);

	MachineConfiguration config = new MachineConfiguration(subassemblies,ingredients, products);
	
	controller = new MachineController(config);
    }

    public static List<Subassembly> getDemoSubassemblies(List<Product> products)
	    throws InvalidAttributeIdentifierException {
	
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	
	List<Operation> grinderOperations = new ArrayList<Operation>();
	grinderOperations.add(new DemoGrinding(Identity.Factory.newIdentity("Operacja mielenia")));
	Subassembly grinder = new TestingSubassembly(Identity.Factory.newIdentity("Mielarka"), grinderOperations);
	subassemblies.add(grinder);

	List<Operation> guiOperations = new ArrayList<Operation>();
	guiOperations.add(new DemoGuiProductsList(Identity.Factory.newIdentity("Lista produktów"), products));
	guiOperations.add(new DemoGuiProductChooser(Identity.Factory.newIdentity("Wybór produktu"), products));
	guiOperations.add(new DemoGuiProductAdder(Identity.Factory.newIdentity("Dodawanie produktu"), products));
	DemoUserInterfaceSubassembly gui = new DemoUserInterfaceSubassembly(Identity.Factory.newIdentity("Demo GUI"), guiOperations);

	subassemblies.add(gui);
	return subassemblies;
    }

    public static List<Product> getDemoProducts(List<Ingredient> ingredients) throws InvalidAttributeIdentifierException {
	List<Product> products = new ArrayList<Product>();

	Product blackCoffee = new Product(Identity.Factory.newIdentity("Kawa czarna"));
	
	Ingredient coffee = ingredients.get(0);
	blackCoffee.add(coffee);
	
	Ingredient water = ingredients.get(1);
	blackCoffee.add(water);
	
	products.add(blackCoffee);

	return products;
    }

    public static Ingredient getDemoWater() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = new Ingredient(Identity.Factory.newIdentity("Woda"));

	ingredient.add(PropertyIdentity.Factory.newProperty("Temperatura", Unit.C), 100.0);
	ingredient.add(PropertyIdentity.Factory.newProperty("Ciœnienie", Unit.BAR), 2.0);
	ingredient.add(PropertyIdentity.Factory.newProperty("Rozmiar porcji", Unit.ML), 200.0);

	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Podgrzewanie")).setIngredient(ingredient));
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Wlewanie")).setIngredient(ingredient));

	ingredient.setOperations(operations);

	return ingredient;
    }

    public static Ingredient getDemoCoffee() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = new Ingredient(Identity.Factory.newIdentity("Ziarna kawy"));

	ingredient.add(PropertyIdentity.Factory.newProperty("Iloœæ", Unit.G), 5000.0);
	ingredient.add(PropertyIdentity.Factory.newProperty("Temperatura", Unit.C), 50.0);
	ingredient.add(PropertyIdentity.Factory.newProperty("Rozmiar porcji", Unit.G), 10.0);

	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Wybranie porcji")).setIngredient(ingredient));
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Mielenie")).setIngredient(ingredient));
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Podgrzewanie")).setIngredient(ingredient));
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Wsypywanie")).setIngredient(ingredient));

	ingredient.setOperations(operations);

	return ingredient;
    }

}
