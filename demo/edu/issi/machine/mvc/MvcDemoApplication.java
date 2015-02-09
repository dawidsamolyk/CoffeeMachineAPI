package edu.issi.machine.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.DemoApplication;
import edu.issi.machine.DemoGrinding;
import edu.issi.machine.configuration.MachineConfiguration;
import edu.issi.machine.id.Identity;
import edu.issi.machine.mvc.controller.Controller;
import edu.issi.machine.mvc.model.Model;
import edu.issi.machine.mvc.view.GraphicalView;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;
import edu.issi.machine.subassembly.TestingSubassembly;

/**
 * @author DawidSamolyk
 *
 */
public class MvcDemoApplication {

    /**
     * @param args
     *            Argumenty wywo³ania aplikacji.
     * @throws InvalidAttributeIdentifierException
     *             Wyst¹pi, jeœli konfiguracja wstêpna maszyny nie bêdzie
     *             poprawna.
     */
    public static void main(String[] args) throws InvalidAttributeIdentifierException {
	List<Ingredient> ingredients = DemoApplication.getDemoIngredients();
	List<Product> products = DemoApplication.getDemoProducts(ingredients);
	List<Subassembly> subassemblies = MvcDemoApplication.getDemoSubassemblies();

	MachineConfiguration config = new MachineConfiguration(subassemblies, ingredients, products);

	Model model = new Model(config);

	Controller controller = new Controller(model);
	controller.addAndInitializeView(new GraphicalView());

	controller.startMachine();
    }

    private static List<Subassembly> getDemoSubassemblies() {
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();

	List<Operation> grinderOperations = new ArrayList<Operation>();
	grinderOperations.add(new DemoGrinding(Identity.Factory.newIdentity("Operacja mielenia")));
	Subassembly grinder = new TestingSubassembly(Identity.Factory.newIdentity("Mielarka"), grinderOperations);
	subassemblies.add(grinder);

	return subassemblies;
    }
}