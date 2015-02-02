package edu.issi.machine.configuration;

import java.util.Iterator;
import java.util.List;

import edu.issi.machine.Validator;
import edu.issi.machine.product.Product;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid Samo�yk
 * 
 *         Konfiguracja maszyny.
 */
public class MachineConfiguration {
    private final List<Subassembly> subassemblies;
    private final List<Product> products;

    /**
     * @param subassemblies
     *            Podzespo�y maszyny.
     * @param products
     *            Produkty, kt�re mo�e stworzy� maszyna.
     * @throws IllegalStateException
     *             Wyst�pi w momencie pr�by stworzenia maszyny z pust� list�
     *             podzespo��w lub produkt�w.
     */
    public MachineConfiguration(List<Subassembly> subassemblies, List<Product> products) throws IllegalStateException {
	ensureValidity(subassemblies, products);

	this.subassemblies = subassemblies;
	this.products = products;
    }

    private void ensureValidity(List<Subassembly> subassemblies, List<Product> products) throws IllegalStateException {
	final String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	Validator.throwExceptionWhenContainsNullOrEmpty(subassemblies, message + "podzespo��w!");
	Validator.throwExceptionWhenContainsNullOrEmpty(products, message + "produkt�w!");
    }

    /**
     * @return Iterator po produktach, kt�re mo�e wyda� maszyna.
     */
    public Iterator<Product> getProductsIterator() {
	return products.iterator();
    }

    /**
     * @return Iterator po podzespo�ach maszyny.
     */
    public Iterator<Subassembly> getSubassembliesIterator() {
	return subassemblies.iterator();
    }

    /**
     * @param product
     *            Produkt.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li produkt, kt�ry jest argumentem wej�ciowym
     *             funkcji, nie zosta� stworzony.
     */
    public void addProduct(Product product) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(product,
		"Nie mo�na doda� pustego produktu do konfiguracji maszyny!");

	products.add(product);
    }
}
