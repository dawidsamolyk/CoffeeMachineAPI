package edu.issi.machine.configuration;

import java.util.Iterator;
import java.util.List;

import edu.issi.machine.Validator;
import edu.issi.machine.product.Product;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid
 * 
 */
public class MachineConfiguration {
    private final List<Subassembly> subassemblies;
    private final List<Product> products;

    /**
     * @param subassemblies
     *            Podzespo³y maszyny.
     * @param products
     *            Produkty, które mo¿e stworzyæ maszyna.
     * @throws IllegalStateException
     *             Wyst¹pi w momencie próby stworzenia maszyny z pust¹ list¹
     *             podzespo³ów lub produktów.
     */
    public MachineConfiguration(List<Subassembly> subassemblies, List<Product> products) throws IllegalStateException {
	this.subassemblies = subassemblies;
	this.products = products;

	ensureValidity();
    }

    /**
     * @throws IllegalStateException
     *             Wyst¹pi w przypadku niepoprawnych parametrów konfiguracji
     *             (pusta lista podzespo³ów lub produktów).
     */
    public final void ensureValidity() throws IllegalStateException {
	final String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	Validator.throwExceptionWhenEmptyOrContainsNullObjects(subassemblies, message + "podzespo³ów!");
	Validator.throwExceptionWhenEmptyOrContainsNullObjects(products, message + "produktów!");
    }

    /**
     * @return Iterator po produktach, które mo¿e wytworzyæ maszyna.
     */
    public Iterator<Product> products() {
	return products.iterator();
    }

    /**
     * @return Iterator po podzespo³ach maszyny.
     */
    public Iterator<Subassembly> subassemblies() {
	return subassemblies.iterator();
    }

    /**
     * @param product
     */
    public void addProduct(Product product) {
	Validator.throwExceptionWhenObjectIsNotCreated(product, "Nie mo¿na dodaæ pustego produktu do konfiguracji maszyny!");
	
	products.add(product);
    }

    /**
     * @param subassembly
     */
    public void addSubassembly(Subassembly subassembly) {
	Validator.throwExceptionWhenObjectIsNotCreated(subassembly, "Nie mo¿na dodaæ pustego podzespo³u do konfiguracji maszyny!");

	subassemblies.add(subassembly);
    }
}
