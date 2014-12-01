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
    public MachineConfiguration(List<Subassembly> subassemblies, List<Product> products)
	    throws IllegalStateException {
	ensureValidity();
	
	this.subassemblies = subassemblies;
	this.products = products;
    }

    /**
     * @throws IllegalStateException
     *             Wyst�pi w przypadku niepoprawnych parametr�w konfiguracji
     *             (pusta lista podzespo��w lub produkt�w).
     */
    public final void ensureValidity() throws IllegalStateException {
	final String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	Validator.throwExceptionWhenEmpty(subassemblies, message + "podzespo��w!");
	Validator.throwExceptionWhenEmpty(products, message + "produkt�w!");
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
}
