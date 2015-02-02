package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.issi.machine.Validator;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

/**
 * @author Dawid Samo³yk
 * 
 *         Konfiguracja maszyny.
 */
public class MachineConfiguration {
    private final List<Subassembly> subassemblies;
    private final List<Ingredient> ingredients;
    private final List<Product> products;

    /**
     * @param subassemblies
     *            Podzespo³y maszyny.
     * @param ingredients
     *            Dostêpne sk³adniki, które maszyna mo¿e wykorzystaæ podczas
     *            wytwarzania produktów.
     * @param products
     *            Produkty, które mo¿e stworzyæ maszyna.
     * @throws IllegalStateException
     *             Wyst¹pi w momencie próby stworzenia maszyny z pust¹ list¹
     *             podzespo³ów lub produktów.
     */
    public MachineConfiguration(List<Subassembly> subassemblies, List<Ingredient> ingredients, List<Product> products)
	    throws IllegalStateException {
	ensureValidity(subassemblies, ingredients, products);
	ensureIngredientsValidity(ingredients, products);

	this.subassemblies = subassemblies;
	this.ingredients = ingredients;
	this.products = products;
    }

    private void ensureValidity(List<Subassembly> subassemblies, List<Ingredient> ingredients, List<Product> products)
	    throws IllegalStateException {
	final String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	Validator.throwExceptionWhenContainsNullOrEmpty(subassemblies, message + "podzespo³ów!");
	Validator.throwExceptionWhenContainsNullOrEmpty(ingredients, message + "sk³adników!");
	Validator.throwExceptionWhenContainsNullOrEmpty(products, message + "produktów!");
    }

    private void ensureIngredientsValidity(List<Ingredient> ingredients, List<Product> products) {
	List<String> invalidProductsNames = new ArrayList<String>();

	for (Product eachProduct : products) {
	    if (hasOnlyAvailableIngredients(eachProduct, ingredients) == false) {
		invalidProductsNames.add(eachProduct.getName());
	    }
	}

	if (!invalidProductsNames.isEmpty()) {
	    throw new IllegalStateException("Produkty " + invalidProductsNames + " zawieraj¹ nieznane sk³adniki!");
	}
    }

    private boolean hasOnlyAvailableIngredients(Product product, List<Ingredient> ingredients) {
	Iterator<Ingredient> productIngredientsIterator = product.iterator();

	while (productIngredientsIterator.hasNext()) {
	    Ingredient eachIngredient = productIngredientsIterator.next();

	    if (ingredients.contains(eachIngredient) == false) {
		return false;
	    }
	}
	return true;
    }

    /**
     * @return Iterator po produktach, które mo¿e wydaæ maszyna.
     */
    public Iterator<Product> getProductsIterator() {
	return products.iterator();
    }

    /**
     * @return Iterator po sk³adnikach produktów, które mo¿e wydaæ maszyny.
     */
    public Iterator<Ingredient> getIngredientsIterator() {
	return ingredients.iterator();
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
     *             funkcji, nie zosta³ stworzony lub jeœli produkt zawiera
     *             nieznane sk³adniki (takie, których nie obs³uguje maszyna).
     */
    public void addProduct(Product product) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(product,
		"Nie mo¿na dodaæ pustego produktu do konfiguracji maszyny!");

	if (hasOnlyAvailableIngredients(product, this.ingredients) == false) {
	    throw new IllegalArgumentException("Produkt " + product.getName() + " zawiera nieznane sk³adniki!");
	}

	products.add(product);
    }
}
