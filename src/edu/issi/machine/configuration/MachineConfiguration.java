package edu.issi.machine.configuration;

import java.util.Iterator;
import java.util.List;

import edu.issi.machine.Validator;
import edu.issi.machine.product.Product;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid Samo³yk
 * 
 *         Konfiguracja maszyny.
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
	ensureValidity(subassemblies, products);

	this.subassemblies = subassemblies;
	this.products = products;
    }

    private void ensureValidity(List<Subassembly> subassemblies, List<Product> products) throws IllegalStateException {
	final String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	Validator.throwExceptionWhenContainsNullOrEmpty(subassemblies, message + "podzespo³ów!");
	Validator.throwExceptionWhenContainsNullOrEmpty(products, message + "produktów!");
    }

    /**
     * @return Iterator po produktach, które mo¿e wydaæ maszyna.
     */
    public Iterator<Product> getProductsIterator() {
	return products.iterator();
    }

    /**
     * @return Iterator po podzespo³ach maszyny.
     */
    public Iterator<Subassembly> getSubassembliesIterator() {
	return subassemblies.iterator();
    }

    /**
     * @param product
     *            Produkt.
     * @throws IllegalArgumentException
     *             Wyst¹pi, jeœli produkt, który jest argumentem wejœciowym
     *             funkcji, nie zosta³ stworzony.
     */
    public void addProduct(Product product) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(product,
		"Nie mo¿na dodaæ pustego produktu do konfiguracji maszyny!");

	products.add(product);
    }
}
