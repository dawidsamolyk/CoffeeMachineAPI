package edu.issi.machine.configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    private final List<Subassembly> subassemblies;
    private final List<Ingredient> ingredients;
    private final List<Product> products;

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

	this.subassemblies = subassemblies;
	this.ingredients = ingredients;
	this.products = products;
    }

    private void ensureValidity(List<Subassembly> subassemblies, List<Ingredient> ingredients, List<Product> products)
	    throws IllegalStateException {
	final String message = "Nie mozna utworzyc konfiguracji maszyny bez zadnych ";

	Validator.throwExceptionWhenContainsNullOrEmpty(subassemblies, message + "podzespo��w!");
	Validator.throwExceptionWhenContainsNullOrEmpty(ingredients, message + "sk�adnik�w!");
	Validator.throwExceptionWhenContainsNullOrEmpty(products, message + "produkt�w!");
    }

    private void ensureIngredientsValidity(List<Ingredient> ingredients, List<Product> products) {
	List<String> invalidProductsNames = new ArrayList<String>();

	for (Product eachProduct : products) {
	    if (hasOnlyAvailableIngredients(eachProduct, ingredients) == false) {
		invalidProductsNames.add(eachProduct.getName());
	    }
	}

	if (!invalidProductsNames.isEmpty()) {
	    throw new IllegalStateException("Produkty " + invalidProductsNames + " zawieraj� nieznane sk�adniki!");
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
     * @return Iterator po produktach, kt�re mo�e wyda� maszyna.
     */
    public Iterator<Product> getProductsIterator() {
	return products.iterator();
    }

    /**
     * @return Iterator po sk�adnikach produkt�w, kt�re mo�e wyda� maszyny.
     */
    public Iterator<Ingredient> getIngredientsIterator() {
	return ingredients.iterator();
    }

    /**
     * @return Iterator po podzespo�ach maszyny.
     */
    public Iterator<Subassembly> getSubassembliesIterator() {
	return subassemblies.iterator();
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

	if (hasOnlyAvailableIngredients(product, this.ingredients) == false) {
	    throw new IllegalArgumentException("Produkt " + product.getName() + " zawiera nieznane sk�adniki!");
	}

	products.add(product);
    }
}
