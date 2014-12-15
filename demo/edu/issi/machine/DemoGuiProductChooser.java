package edu.issi.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationState;
import edu.issi.machine.product.Product;

public class DemoGuiProductChooser extends Operation {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<Product> products;
    private Product selectedProduct;

    public DemoGuiProductChooser(Identity identity, List<Product> products) {
	super(identity);
	this.products = products;
    }

    @Override
    public OperationState execute() {
	System.out.print("Wpisz ID produktu, który chcesz otrzymaæ: ");

	int productID = 0;

	try {
	    productID = Integer.parseInt(br.readLine());
	    selectProductByID(productID);
	}
	catch (NumberFormatException e) {
	    return new OperationState.Factory().createErrorWithDescription("Podano nieprawid³owy ID!");
	}
	catch (NoSuchElementException e) {
	    return new OperationState.Factory().createErrorWithDescription(e.getMessage());
	}
	catch (IOException e) {
	    return new OperationState.Factory().createErrorWithDescription("Podano nieprawid³owy ID!");
	}
	
	System.out.println(">>> Wybrano " + selectedProduct);

	return new OperationState.Factory().createValidState();
    }

    private void selectProductByID(int productID) throws NoSuchElementException {
	selectedProduct = null;

	for (Product each : products) {
	    if (each.identifiesBy(new Identity(productID))) {
		selectedProduct = each;
	    }
	}
	if (selectedProduct == null) {
	    throw new NoSuchElementException("Nie ma produktu o podanym ID!");
	}
    }

    public Product getSelected() {
	return selectedProduct;
    }

}
