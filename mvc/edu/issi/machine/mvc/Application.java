package edu.issi.machine.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.DemoGrinding;
import edu.issi.machine.DemoOperation;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.id.Identity;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.product.OrderedElementsList;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.TestingSubassembly;

/**
 * @author DawidSamolyk
 *
 */
public class Application {

    /**
     * @param args
     *            Argumenty wywo³ania aplikacji.
     * @throws InvalidAttributeIdentifierException
     *             Wyst¹pi, jeœli konfiguracja wstêpna maszyny nie bêdzie
     *             poprawna.
     */
    public static void main(String[] args) throws InvalidAttributeIdentifierException {
	List<Product> products = getDemoProducts();
	List<Subassembly> subassemblies = getDemoSubassemblies();

	MachineConfiguration config = new MachineConfiguration(subassemblies, products);

	Model model = new Model(config);

	Controller controller = new Controller(model);
	controller.addAndInitializeView(new ConsoleView());
	
	model.startMachine();
    }

    private static List<Subassembly> getDemoSubassemblies() throws InvalidAttributeIdentifierException {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();

	List<Operation> grinderOperations = new ArrayList<Operation>();
	grinderOperations.add(new DemoGrinding(Identity.Factory.newIdentity("Operacja mielenia")));
	Subassembly grinder = new TestingSubassembly(Identity.Factory.newIdentity("Mielarka"), grinderOperations);
	subassemblies.add(grinder);

	return subassemblies;
    }

    private static List<Product> getDemoProducts() throws InvalidAttributeIdentifierException {
	List<Product> products = new ArrayList<Product>();

	Product blackCoffee = new Product(Identity.Factory.newIdentity("Kawa czarna"));

	Ingredient coffee = getDemoCoffee();
	blackCoffee.add(coffee);

	Ingredient water = getDemoWater();
	blackCoffee.add(water);

	products.add(blackCoffee);

	return products;
    }

    private static Ingredient getDemoWater() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = new Ingredient(Identity.Factory.newIdentity("Woda"));

	ingredient.add(PropertyIdentity.Factory.newProperty("Temperatura", Unit.C), 90.0);
	ingredient.add(PropertyIdentity.Factory.newProperty("Ciœnienie", Unit.BAR), 2.0);
	ingredient.add(PropertyIdentity.Factory.newProperty("Rozmiar porcji", Unit.ML), 200.0);

	OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Podgrzewanie")).setIngredient(ingredient));
	operations.add(new DemoOperation(Identity.Factory.newIdentity("Wlewanie")).setIngredient(ingredient));

	ingredient.setOperations(operations);

	return ingredient;
    }

    private static Ingredient getDemoCoffee() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = new Ingredient(Identity.Factory.newIdentity("Ziarna kawy"));

	ingredient.add(PropertyIdentity.Factory.newProperty("Iloœæ", Unit.G), 50.0);
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