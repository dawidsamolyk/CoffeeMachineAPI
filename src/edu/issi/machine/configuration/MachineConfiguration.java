package edu.issi.machine.configuration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import edu.issi.machine.Utils;
import edu.issi.machine.id.ObjectWithIdentity;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid Samo�yk
 * 
 *         Konfiguracja maszyny.
 */
public class MachineConfiguration {
    private final Validator validator = new Validator();
    private final Map<String, Subassembly> subassemblies;
    private final Map<String, Ingredient> ingredients;
    private final Map<String, Product> products;

    /**
     * Konstruktor. Wymagane jest, aby wszystkie parametry by�y utworzone oraz
     * nie by�y puste. Konieczne jest r�wnie�, aby kolekcja obiekt�w Product
     * bazowa�a na obiektach kolekcji Ingredient (ka�dy obiekt Product jest
     * kolekcj� obiekt�w Ingredient).
     * 
     * @param subassemblies
     *            Podzespo�y maszyny.
     * @param ingredients
     *            Dost�pne sk�adniki, kt�re maszyna mo�e wykorzysta� podczas
     *            wytwarzania produkt�w.
     * @param products
     *            Produkty, kt�re mo�e stworzy� maszyna.
     * @throws IllegalArgumentException
     *             Wyst�pi w momencie pr�by stworzenia maszyny z pust� list�
     *             podzespo��w lub produkt�w lub sk�adnik�w lub gdy kt�rykolwiek
     *             z produkt�w posiada sk�adniki, kt�re nie s� znane dla
     *             konfiguracji maszyny.
     */
    public MachineConfiguration(Collection<Subassembly> subassemblies, Collection<Ingredient> ingredients,
	    Collection<Product> products) throws IllegalArgumentException {
	validator.throwExceptionIfAnyIsInvalid(subassemblies, ingredients, products);

	this.subassemblies = transformToMap(subassemblies);
	this.ingredients = transformToMap(ingredients);
	this.products = new HashMap<String, Product>();
	this.addAll(products);
    }

    private void addAll(Collection<Product> products) throws IllegalStateException {
	for (Product eachProduct : products) {
	    this.addProduct(eachProduct);
	}
    }

    private <T extends ObjectWithIdentity> Map<String, T> transformToMap(Collection<T> objects) {
	return Utils.asMap(objects);
    }

    /**
     * Zwraca iterator, umo�liwiaj�cy przejrzenie produkt�w.
     * 
     * @return Iterator po produktach, kt�re mo�e wyda� maszyna.
     */
    public Iterator<Product> getProductsIterator() {
	return products.values().iterator();
    }

    /**
     * Zwraca iterator, umo�liwiaj�cy przejrzenie sk�adnik�w.
     * 
     * @return Iterator po sk�adnikach produkt�w, kt�re mo�e wyda� maszyny.
     */
    public Iterator<Ingredient> getIngredientsIterator() {
	return ingredients.values().iterator();
    }

    /**
     * Zwraca iterator, umo�liwiaj�cy przejrzenie podzespo��w.
     * 
     * @return Iterator po podzespo�ach maszyny.
     */
    public Iterator<Subassembly> getSubassembliesIterator() {
	return subassemblies.values().iterator();
    }

    private void addProduct(Product product) throws IllegalArgumentException {
	validator.throwExceptionWhenInvalid(product);
	products.put(product.getName(), product);
    }

    private class Validator {

	private boolean containsOnlyKnownIngredients(Product product) {
	    return product.containsIn(ingredients.values());
	}

	private void throwExceptionWhenInvalid(Product product) throws IllegalArgumentException {
	    edu.issi.machine.Validator.throwExceptionWhenObjectIsNotCreated(product,
		    "Nie mo�na doda� pustego produktu do konfiguracji maszyny!");

	    if (!containsOnlyKnownIngredients(product)) {
		throw new IllegalArgumentException("Produkt " + product.getName() + " zawiera nieznane sk�adniki!");
	    }
	}

	private void throwExceptionIfAnyIsInvalid(Collection<Subassembly> subassemblies, Collection<Ingredient> ingredients,
		Collection<Product> products) throws IllegalArgumentException {
	    edu.issi.machine.Validator.throwExceptionWhenEmptyOrContainsEmptyObject(subassemblies,
		    "Nie mo�na utworzy� konfiguracji maszyny bez �adnych podzespo��w!");
	    edu.issi.machine.Validator.throwExceptionWhenEmptyOrContainsEmptyObject(ingredients,
		    "Nie mo�na utworzy� konfiguracji maszyny bez �adnych sk�adnik�w!");
	    edu.issi.machine.Validator.throwExceptionWhenEmptyOrContainsEmptyObject(products,
		    "Nie mo�na utworzy� konfiguracji maszyny bez �adnych produkt�w!");

	    for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
		Product eachProduct = iterator.next();

		if (eachProduct.numberOfElements() == 0) {
		    throw new IllegalArgumentException("Produkt " + eachProduct.getName() + " nie posiada �adnych sk�adnik�w!");
		}
	    }
	}

    }
}
