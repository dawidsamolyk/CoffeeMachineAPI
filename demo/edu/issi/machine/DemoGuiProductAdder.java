package edu.issi.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.product.OrderedElementsList;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;

@SuppressWarnings("javadoc")
public class DemoGuiProductAdder extends Operation {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<Product> products;

    public DemoGuiProductAdder(Identity identity, List<Product> products) {
	super(identity);
	this.products = products;
    }

    @Override
    public OperationStatus execute() {
	String readedLine;
	
	try {
	    readedLine = readLineAfterComunicate("Chcesz dodaæ nowy produkt? [T/N]:");
	} catch (IOException e) {
	    return OperationStatus.Factory.createErrorWithDescription("Niedostêpny interfejs u¿ytkownika!");
	}

	if (!readedLine.equals("T")) {
	    return OperationStatus.Factory.createValid();
	}

	try {
	    products.add(newProduct());
	} 
	catch (InvalidAttributeIdentifierException e) {
	    return OperationStatus.Factory.createErrorWithDescription("Problem z generowaniem nowego ID!");
	} 
	catch (IOException e) {
	    return OperationStatus.Factory.createErrorWithDescription("Niedostêpny interfejs u¿ytkownika!");
	}

	return OperationStatus.Factory.createValid();
    }

    private Product newProduct() throws InvalidAttributeIdentifierException, IOException {
	String readedLine = readLineAfterComunicate("Wpisz nazwê produktu: ");
	
	Product newProduct = new Product(Identity.Factory.newIdentity(readedLine));

	Ingredient ingredient;

	while (true) {
	    readedLine = readLineAfterComunicate("Wpisz nazwê sk³adnika produktu (koniec dodawania sk³adników - wpisz END): ");

	    if (readedLine.equals("END")) {
		break;
	    }

	    ingredient = new Ingredient(Identity.Factory.newIdentity(readedLine));

	    ingredient.add(PropertyIdentity.Factory.newProperty("Temperatura", Unit.C), 100.0);
	    ingredient.add(PropertyIdentity.Factory.newProperty("Ciœnienie", Unit.BAR), 2.0);
	    ingredient.add(PropertyIdentity.Factory.newProperty("Rozmiar porcji", Unit.ML), 200.0);

	    OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	    operations.add(new DemoOperation(Identity.Factory.newIdentity("Podgrzewanie")).setIngredient(ingredient));
	    operations.add(new DemoOperation(Identity.Factory.newIdentity("Wlewanie")).setIngredient(ingredient));
	    ingredient.setOperations(operations);

	    newProduct.add(ingredient);
	}
	
	return newProduct;
    }

    private String readLineAfterComunicate(String comunicate) throws IOException {
	System.out.print(comunicate);
	return br.readLine();
    }

}
