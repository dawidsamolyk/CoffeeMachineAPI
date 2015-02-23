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
 * @author Dawid Samo³yk
 * 
 *         Konfiguracja maszyny.
 */
public class MachineConfiguration {
    private final Validator validator = new Validator();
    private final Map<String, Subassembly> subassemblies;
    private final Map<String, Ingredient> ingredients;
    private final Map<String, Product> products;

    /**
     * Konstruktor. Wymagane jest, aby wszystkie parametry by³y utworzone oraz
     * nie by³y puste. Konieczne jest równie¿, aby kolekcja obiektów Product
     * bazowa³a na obiektach kolekcji Ingredient (ka¿dy obiekt Product jest
     * kolekcj¹ obiektów Ingredient).
     * 
     * @param subassemblies
     *            Podzespo³y maszyny.
     * @param ingredients
     *            Dostêpne sk³adniki, które maszyna mo¿e wykorzystaæ podczas
     *            wytwarzania produktów.
     * @param products
     *            Produkty, które mo¿e stworzyæ maszyna.
     * @throws IllegalArgumentException
     *             Wyst¹pi w momencie próby stworzenia maszyny z pust¹ list¹
     *             podzespo³ów lub produktów lub sk³adników lub gdy którykolwiek
     *             z produktów posiada sk³adniki, które nie s¹ znane dla
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
     * Zwraca iterator, umo¿liwiaj¹cy przejrzenie produktów.
     * 
     * @return Iterator po produktach, które mo¿e wydaæ maszyna.
     */
    public Iterator<Product> getProductsIterator() {
	return products.values().iterator();
    }

    /**
     * Zwraca iterator, umo¿liwiaj¹cy przejrzenie sk³adników.
     * 
     * @return Iterator po sk³adnikach produktów, które mo¿e wydaæ maszyny.
     */
    public Iterator<Ingredient> getIngredientsIterator() {
	return ingredients.values().iterator();
    }

    /**
     * Zwraca iterator, umo¿liwiaj¹cy przejrzenie podzespo³ów.
     * 
     * @return Iterator po podzespo³ach maszyny.
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
		    "Nie mo¿na dodaæ pustego produktu do konfiguracji maszyny!");

	    if (!containsOnlyKnownIngredients(product)) {
		throw new IllegalArgumentException("Produkt " + product.getName() + " zawiera nieznane sk³adniki!");
	    }
	}

	private void throwExceptionIfAnyIsInvalid(Collection<Subassembly> subassemblies, Collection<Ingredient> ingredients,
		Collection<Product> products) throws IllegalArgumentException {
	    edu.issi.machine.Validator.throwExceptionWhenEmptyOrContainsEmptyObject(subassemblies,
		    "Nie mo¿na utworzyæ konfiguracji maszyny bez ¿adnych podzespo³ów!");
	    edu.issi.machine.Validator.throwExceptionWhenEmptyOrContainsEmptyObject(ingredients,
		    "Nie mo¿na utworzyæ konfiguracji maszyny bez ¿adnych sk³adników!");
	    edu.issi.machine.Validator.throwExceptionWhenEmptyOrContainsEmptyObject(products,
		    "Nie mo¿na utworzyæ konfiguracji maszyny bez ¿adnych produktów!");

	    for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
		Product eachProduct = iterator.next();

		if (eachProduct.numberOfElements() == 0) {
		    throw new IllegalArgumentException("Produkt " + eachProduct.getName() + " nie posiada ¿adnych sk³adników!");
		}
	    }
	}

    }
}
