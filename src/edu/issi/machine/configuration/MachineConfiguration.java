package edu.issi.machine.configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import edu.issi.exceptions.MachineValidatorException;
import edu.issi.machine.Identity;
import edu.issi.machine.IteratorForMachineConfiguration;
import edu.issi.machine.product.Product;
import edu.issi.machine.properties.Properties;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid
 * 
 */
public class MachineConfiguration {
    private List<Subassembly> subassemblies;
    private List<Product> products;
    private Properties properties;

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

	MachineValidatorException.throwExceptionWhenEmpty(subassemblies,
		"Nie mozna utworzyc konfiguracji maszyny bez zadnych podzespolow!");

	MachineValidatorException.throwExceptionWhenEmpty(products,
		"Nie mozna utworzyc konfiguracji maszyny bez zadnych produktow!");

	this.subassemblies = subassemblies;
	this.products = products;
    }

    /**
     * @param subassemblies
     *            Podzespo�y maszyny.
     * @param products
     *            Produkty, kt�re mo�e stworzy� maszyna.
     * @param properties
     *            Dodatkowe parametry maszyny.
     * @throws IllegalStateException
     *             Wyst�pi w momencie pr�by stworzenia maszyny z pust� list�
     *             podzespo��w lub produkt�w.
     */
    public MachineConfiguration(List<Subassembly> subassemblies, List<Product> products, Properties properties)
	    throws IllegalStateException {
	this(subassemblies, products);
	this.properties = properties;
    }

    /**
     * @return Iterator po podzespo�ach maszyny.
     */
    public Iterator<Subassembly> subassemblies() {
	return new IteratorForMachineConfiguration<Subassembly>(subassemblies);
    }

    /**
     * @return Iterator po produktach, kt�re mo�e wytworzy� maszyna.
     */
    public Iterator<Product> products() {
	return new IteratorForMachineConfiguration<Product>(products);
    }

    /**
     * @return Iterator po dodatkowych parametrach maszyny.
     */
    public Iterator<Entry<Identity, Object>> properties() {
	return properties.iterator();
    }

}
