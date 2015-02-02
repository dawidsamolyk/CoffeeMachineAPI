package edu.issi.machine.mvc.view;

import java.util.Map;
import java.util.Set;

import edu.issi.machine.mvc.controller.Controller.IngredientsListener;
import edu.issi.machine.mvc.controller.Controller.OrderListener;
import edu.issi.machine.mvc.controller.Controller.ProductsListener;
import edu.issi.machine.mvc.controller.Controller.PropertiesListener;
import edu.issi.machine.operation.Status;
import edu.issi.machine.product.ingredient.Unit;

/**
 * @author DawidSamolyk
 *
 */
public interface View {
    
    /**
     * 
     */
    void start();

    /**
     * @param products
     *            Produkty.
     */
    void showProducts(Set<String> products);

    /**
     * @param productName
     *            Nazwa produktu.
     * @param ingredients
     *            Sk�adniki produktu.
     */
    void showProductIngredients(String productName, Set<String> ingredients);

    /**
     * @param ingredients
     *            Sk�adniki.
     */
    void showIngredients(Set<String> ingredients);

    /**
     * @param ingredientName
     *            Nazwa sk�adnika.
     * @param properties
     *            W�a�ciwo�ci sk�adnika. Kluczem jest nazwa w�a�ciowo�ci, a
     *            warto�ci� jednostka miary tej w�a�ciwo�ci.
     * 
     */
    void showIngredientProperties(String ingredientName, Map<String, Unit> properties);

    /**
     * @return Nazwa produktu, kt�ry ma zosta� wydany.
     */
    String getSelectedForPreparationProductName();

    /**
     * @param ingredientName
     *            Nazwa sk�adnika produktu, kt�ry ma zosta� wydany.
     * @param availableProperties
     *            Dost�pne w�a�ciwo�ci dla podanego sk�adnika. Kluczem jest
     *            nazwa w�a�ciwo�ci, a warto�ci� jednostka miary.
     * @return W�a�ciwo�ci sk�adnika. Kluczem mapy jest nazwa w�a�ciwo�ci, a
     *         drugim parametrem jest warto�� dla wybranej w�a�ciwo�ci (warto��
     *         ta jest wyra�ana w jednostkach ustawionych we w�a�ciwo�ci).
     */
    Map<String, Float> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties);

    /**
     * @param status
     *            Status operacji.
     * @param description
     *            Opis statusu operacji (mo�e by� pusty).
     */
    void showOperationStatus(Status status, String description);

    /**
     * @return Nazwa produktu.
     */
    String getNewProductName();

    /**
     * @param availableIngredients
     *            Dost�pne sk�adniki.
     * @return Sk�adniki nowego produktu.
     */
    Set<String> getNewProductIngredients(Set<String> availableIngredients);

    /**
     * @param productsListListener
     *            Obiekt nas�uchuj�cy zmian listy produkt�w.
     */
    void addProductsListener(ProductsListener productsListListener);

    /**
     * @param ingredientsListener
     *            Obiekt nas�uchuj�cy zmian listy sk�adnik�w.
     */
    void addIngredientsListener(IngredientsListener ingredientsListener);

    void addOrderListener(OrderListener orderListener);

    void addPropertiesListener(PropertiesListener propertiesListener);
}
