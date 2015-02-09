package edu.issi.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationStatus;
import edu.issi.machine.product.Product;

@SuppressWarnings("javadoc")
public class DemoGuiProductChooser extends Operation {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<Product> products;
    private Product selectedProduct;

    public DemoGuiProductChooser(Identity identity, List<Product> products) {
	super(identity);
	this.products = products;
    }

    @Override
    public OperationStatus execute() {
	System.out.print("Wpisz ID produktu, który chcesz otrzymaæ (wpisz END, aby zakoñczyæ): ");

	int productID = 0;

	try {
	    String readedLine = br.readLine();
	    checkAppEnd(readedLine);
	    
	    productID = Integer.parseInt(readedLine);
	    selectProductByID(productID);
	} 
	catch (NumberFormatException e) {
	    return OperationStatus.Factory.createError("Podano nieprawid³owy ID!");
	} 
	catch (NoSuchElementException e) {
	    return OperationStatus.Factory.createError(e.getMessage());
	} 
	catch (IOException e) {
	    return OperationStatus.Factory.createError("Podano nieprawid³owy ID!");
	}

	System.out.println(">>> Wybrano " + selectedProduct);

	return OperationStatus.Factory.createValid();
    }

    private void checkAppEnd(String readedLine) {
	if(readedLine.equals("END")) {
	    System.exit(0);
	}
    }

    private void selectProductByID(int productID) throws NoSuchElementException {
	selectedProduct = null;

	for (Product each : products) {
	    if (each.identifiesBy(productID)) {
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
