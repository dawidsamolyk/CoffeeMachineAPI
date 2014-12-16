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
     *            Podzespo�y maszyny.
     * @param products
     *            Produkty, kt�re mo�e stworzy� maszyna.
     * @throws IllegalStateException
     *             Wyst�pi w momencie pr�by stworzenia maszyny z pust� list�
     *             podzespo��w lub produkt�w.
     */
    public MachineConfiguration(List<Subassembly> subassemblies, List<Product> products) throws IllegalStateException {
	this.subassemblies = subassemblies;
	this.products = products;

	ensureValidity();
    }

    /**
     * @throws IllegalStateException
     *             Wyst�pi w przypadku niepoprawnych parametr�w konfiguracji
     *             (pusta lista podzespo��w lub produkt�w).
     */
    public final void ensureValidity() throws IllegalStateException {
	final String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	Validator.throwExceptionWhenEmptyOrContainsNullObjects(subassemblies, message + "podzespo��w!");
	Validator.throwExceptionWhenEmptyOrContainsNullObjects(products, message + "produkt�w!");
    }

    /**
     * @return Iterator po produktach, kt�re mo�e wytworzy� maszyna.
     */
    public Iterator<Product> products() {
	return products.iterator();
    }

    /**
     * @return Iterator po podzespo�ach maszyny.
     */
    public Iterator<Subassembly> subassemblies() {
	return subassemblies.iterator();
    }

    /**
     * @param product
     */
    public void addProduct(Product product) {
	Validator.throwExceptionWhenObjectIsNotCreated(product, "Nie mo�na doda� pustego produktu do konfiguracji maszyny!");
	
	products.add(product);
    }

    /**
     * @param subassembly
     */
    public void addSubassembly(Subassembly subassembly) {
	Validator.throwExceptionWhenObjectIsNotCreated(subassembly, "Nie mo�na doda� pustego podzespo�u do konfiguracji maszyny!");

	subassemblies.add(subassembly);
    }
}
