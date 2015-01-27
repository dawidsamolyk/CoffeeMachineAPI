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

    /**
     * @param products
     *            Produkty, które mo¿e stworzyæ maszyna.
     * @param subassemblies
     *            Podzespo³y maszyny.
     * @throws IllegalStateException
     *             Wyst¹pi w przypadku niepoprawnych parametrów konfiguracji
     *             (pusta lista podzespo³ów lub produktów).
     */
    private void ensureValidity(List<Subassembly> subassemblies, List<Product> products) throws IllegalStateException {
	final String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	Validator.throwExceptionWhenContainsNullOrEmpty(subassemblies, message + "podzespo³ów!");
	Validator.throwExceptionWhenContainsNullOrEmpty(products, message + "produktów!");
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
     *            Produkt.
     */
    public void addProduct(Product product) {
	Validator.throwExceptionWhenObjectIsNotCreated(product,
		"Nie mo¿na dodaæ pustego produktu do konfiguracji maszyny!");

	products.add(product);
    }

    /**
     * @param subassembly
     *            Podzespó³.
     */
    public void addSubassembly(Subassembly subassembly) {
	Validator.throwExceptionWhenObjectIsNotCreated(subassembly,
		"Nie mo¿na dodaæ pustego podzespo³u do konfiguracji maszyny!");

	subassemblies.add(subassembly);
    }
}
