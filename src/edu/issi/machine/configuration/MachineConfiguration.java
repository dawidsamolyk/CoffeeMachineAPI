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
 * @author Dawid Samo�yk
 * 
 *         Konfiguracja maszyny.
 */
public class MachineConfiguration {
    private final Map<String, Subassembly> subassemblies;
    private final Map<String, Ingredient> ingredients;
    private final Map<String, Product> products;

    /**
     * @param subassemblies
     *            Podzespo�y maszyny.
     * @param ingredients
     *            Dost�pne sk�adniki, kt�re maszyna mo�e wykorzysta� podczas
     *            wytwarzania produkt�w.
     * @param products
     *            Produkty, kt�re mo�e stworzy� maszyna.
     * @throws IllegalStateException
     *             Wyst�pi w momencie pr�by stworzenia maszyny z pust� list�
     *             podzespo��w lub produkt�w.
     */
    public MachineConfiguration(List<Subassembly> subassemblies, List<Ingredient> ingredients, List<Product> products)
	    throws IllegalStateException {
	ensureValidity(subassemblies, ingredients, products);
	ensureIngredientsValidity(ingredients, products);

	// TODO zablokuj mo�liwo�� dodania takiego samego produktu lub produktu
	// o tej samej nazwie

	this.subassemblies = Utils.asMap(subassemblies);
	this.ingredients = Utils.asMap(ingredients);
	this.products = Utils.asMap(products);
    }

    private void ensureValidity(List<Subassembly> subassemblies, List<Ingredient> ingredients, List<Product> products)
	    throws IllegalStateException {
	final String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	Validator.throwExceptionWhenContainsNullOrEmpty(subassemblies, message + "podzespo��w!");
	Validator.throwExceptionWhenContainsNullOrEmpty(ingredients, message + "sk�adnik�w!");
	Validator.throwExceptionWhenContainsNullOrEmpty(products, message + "produkt�w!");
    }

    private void ensureIngredientsValidity(List<Ingredient> ingredients, List<Product> products) {
	final List<String> invalidProductsNames = new ArrayList<String>();

	for (Product eachProduct : products) {
	    if (hasInvalidIngredients(eachProduct, Utils.asMap(ingredients))) {
		invalidProductsNames.add(eachProduct.getName());
	    }
	}

	if (!invalidProductsNames.isEmpty()) {
	    throw new IllegalStateException("Produkty " + invalidProductsNames + " zawieraj� nieznane sk�adniki!");
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
     * @return Iterator po produktach, kt�re mo�e wyda� maszyna.
     */
    public Iterator<Product> getProductsIterator() {
	return products.values().iterator();
    }

    /**
     * @return Iterator po sk�adnikach produkt�w, kt�re mo�e wyda� maszyny.
     */
    public Iterator<Ingredient> getIngredientsIterator() {
	return ingredients.values().iterator();
    }

    /**
     * @return Iterator po podzespo�ach maszyny.
     */
    public Iterator<Subassembly> getSubassembliesIterator() {
	return subassemblies.values().iterator();
    }

    /**
     * @param product
     *            Produkt.
     * @throws IllegalArgumentException
     *             Wyst�pi, je�li produkt, kt�ry jest argumentem wej�ciowym
     *             funkcji, nie zosta� stworzony lub je�li produkt zawiera
     *             nieznane sk�adniki (takie, kt�rych nie obs�uguje maszyna).
     */
    public void addProduct(Product product) throws IllegalArgumentException {
	Validator.throwExceptionWhenObjectIsNotCreated(product,
		"Nie mo�na doda� pustego produktu do konfiguracji maszyny!");

	// TODO zablokuj mo�liwo�� dodania takiego samego produktu lub produktu
	// o tej samej nazwie

	if (hasInvalidIngredients(product, ingredients)) {
	    throw new IllegalArgumentException("Produkt " + product.getName() + " zawiera nieznane sk�adniki!");
	}

	products.put(product.getName(), product);
    }
}
