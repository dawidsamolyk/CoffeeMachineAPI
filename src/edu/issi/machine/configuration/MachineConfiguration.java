package edu.issi.machine.configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import edu.issi.exceptions.MachineValidatorException;
import edu.issi.machine.IteratorForMachineConfiguration;
import edu.issi.machine.id.Identity;
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

	this.subassemblies = subassemblies;
	this.products = products;

	this.ensureValidity();
    }

    /**
     * @throws IllegalStateException
     *             Wyst�pi w przypadku niepoprawnych parametr�w konfiguracji
     *             (pusta lista podzespo��w lub produkt�w).
     */
    public void ensureValidity() throws IllegalStateException {
	String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	MachineValidatorException.throwExceptionWhenEmpty(this.subassemblies, message + "podzespolow!");
	MachineValidatorException.throwExceptionWhenEmpty(this.products, message + "produktow!");
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

    @Override
    public String toString() {
	return "MachineConfiguration [subassemblies=" + subassemblies + ", products=" + products
		+ ", properties=" + properties + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((products == null) ? 0 : products.hashCode());
	result = prime * result + ((properties == null) ? 0 : properties.hashCode());
	result = prime * result + ((subassemblies == null) ? 0 : subassemblies.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	MachineConfiguration other = (MachineConfiguration) obj;
	if (products == null) {
	    if (other.products != null)
		return false;
	} else if (!products.equals(other.products))
	    return false;
	if (properties == null) {
	    if (other.properties != null)
		return false;
	} else if (!properties.equals(other.properties))
	    return false;
	if (subassemblies == null) {
	    if (other.subassemblies != null)
		return false;
	} else if (!subassemblies.equals(other.subassemblies))
	    return false;
	return true;
    }

}
