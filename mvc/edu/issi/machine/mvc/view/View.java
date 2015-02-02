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
     *            Sk³adniki produktu.
     */
    void showProductIngredients(String productName, Set<String> ingredients);

    /**
     * @param ingredients
     *            Sk³adniki.
     */
    void showIngredients(Set<String> ingredients);

    /**
     * @param ingredientName
     *            Nazwa sk³adnika.
     * @param properties
     *            W³aœciwoœci sk³adnika. Kluczem jest nazwa w³aœciowoœci, a
     *            wartoœci¹ jednostka miary tej w³aœciwoœci.
     * 
     */
    void showIngredientProperties(String ingredientName, Map<String, Unit> properties);

    /**
     * @return Nazwa produktu, który ma zostaæ wydany.
     */
    String getSelectedForPreparationProductName();

    /**
     * @param ingredientName
     *            Nazwa sk³adnika produktu, który ma zostaæ wydany.
     * @param availableProperties
     *            Dostêpne w³aœciwoœci dla podanego sk³adnika. Kluczem jest
     *            nazwa w³aœciwoœci, a wartoœci¹ jednostka miary.
     * @return W³aœciwoœci sk³adnika. Kluczem mapy jest nazwa w³aœciwoœci, a
     *         drugim parametrem jest wartoœæ dla wybranej w³aœciwoœci (wartoœæ
     *         ta jest wyra¿ana w jednostkach ustawionych we w³aœciwoœci).
     */
    Map<String, Float> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties);

    /**
     * @param status
     *            Status operacji.
     * @param description
     *            Opis statusu operacji (mo¿e byæ pusty).
     */
    void showOperationStatus(Status status, String description);

    /**
     * @return Nazwa produktu.
     */
    String getNewProductName();

    /**
     * @param availableIngredients
     *            Dostêpne sk³adniki.
     * @return Sk³adniki nowego produktu.
     */
    Set<String> getNewProductIngredients(Set<String> availableIngredients);

    /**
     * @param productsListListener
     *            Obiekt nas³uchuj¹cy zmian listy produktów.
     */
    void addProductsListener(ProductsListener productsListListener);

    /**
     * @param ingredientsListener
     *            Obiekt nas³uchuj¹cy zmian listy sk³adników.
     */
    void addIngredientsListener(IngredientsListener ingredientsListener);

    void addOrderListener(OrderListener orderListener);

    void addPropertiesListener(PropertiesListener propertiesListener);
}
