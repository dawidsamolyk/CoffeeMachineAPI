package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.issi.machine.Utils;
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
    private final Map<String, Subassembly> subassemblies;
    private final Map<String, Ingredient> ingredients;
    private final Map<String, Product> products;

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

	// TODO zablokuj mo¿liwoœæ dodania takiego samego produktu lub produktu
	// o tej samej nazwie

	this.subassemblies = Utils.asMap(subassemblies);
	this.ingredients = Utils.asMap(ingredients);
	this.products = Utils.asMap(products);
    }

    private void ensureValidity(List<Subassembly> subassemblies, List<Ingredient> ingredients, List<Product> products)
	    throws IllegalStateException {
	final String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	Validator.throwExceptionWhenContainsNullOrEmpty(subassemblies, message + "podzespo³ów!");
	Validator.throwExceptionWhenContainsNullOrEmpty(ingredients, message + "sk³adników!");
	Validator.throwExceptionWhenContainsNullOrEmpty(products, message + "produktów!");
    }

    private void ensureIngredientsValidity(List<Ingredient> ingredients, List<Product> products) {
	final List<String> invalidProductsNames = new ArrayList<String>();

	for (Product eachProduct : products) {
	    if (hasInvalidIngredients(eachProduct, Utils.asMap(ingredients))) {
		invalidProductsNames.add(eachProduct.getName());
	    }
	}

	if (!invalidProductsNames.isEmpty()) {
	    throw new IllegalStateException("Produkty " + invalidProductsNames + " zawieraj¹ nieznane sk³adniki!");
	}
    }

    private boolean hasInvalidIngredients(Product product, Map<String, Ingredient> ingredients) {
	return !hasAnyIngredients(product) || !hasOnlyAvailableIngredients(product, ingredients);
    }

    private boolean hasAnyIngredients(Product eachProduct) {
	return eachProduct.numberOfElements() > 0;
    }

    private boolean hasOnlyAvailableIngredients(Product product, Map<String, Ingredient> ingredients) {
	for (Iterator<Ingredient> productIngredientsIterator = product.iterator(); productIngredientsIterator.hasNext();) {
	    Ingredient eachIngredient = productIngredientsIterator.next();

	    if (!ingredients.values().contains(eachIngredient)) {
		return false;
	    }
	}
	return true;
    }

    /**
     * @return Iterator po produktach, które mo¿e wydaæ maszyna.
     */
    public Iterator<Product> getProductsIterator() {
	return products.values().iterator();
    }

    /**
     * @return Iterator po sk³adnikach produktów, które mo¿e wydaæ maszyny.
     */
    public Iterator<Ingredient> getIngredientsIterator() {
	return ingredients.values().iterator();
    }

    /**
     * @return Iterator po podzespo³ach maszyny.
     */
    public Iterator<Subassembly> getSubassembliesIterator() {
	return subassemblies.values().iterator();
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

	// TODO zablokuj mo¿liwoœæ dodania takiego samego produktu lub produktu
	// o tej samej nazwie

	if (hasInvalidIngredients(product, ingredients)) {
	    throw new IllegalArgumentException("Produkt " + product.getName() + " zawiera nieznane sk³adniki!");
	}

	products.put(product.getName(), product);
    }
}
