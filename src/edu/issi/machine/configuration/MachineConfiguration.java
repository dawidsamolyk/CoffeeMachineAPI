package edu.issi.machine.configuration;

import java.util.List;

import edu.issi.exceptions.MachineValidatorException;
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
     * @throws IllegalStateException
     */
    public MachineConfiguration(List<Subassembly> subassemblies) throws IllegalStateException {
	MachineValidatorException.generateExceptionWhenIsEmpty(subassemblies,
		"Nie mozna utworzyc konfiguracji maszyny bez zadnych podzespolow!");

	this.subassemblies = subassemblies;
    }

    /**
     * @param subassemblies
     * @param products
     * @param properties
     * @throws IllegalStateException
     */
    public MachineConfiguration(List<Subassembly> subassemblies, List<Product> products, Properties properties)
	    throws IllegalStateException {
	this(subassemblies);

	MachineValidatorException.generateExceptionWhenIsEmpty(products,
		"Nie mozna utworzyc konfiguracji maszyny bez zadnych produktow!");

	this.products = products;
	this.properties = properties;
    }

}
