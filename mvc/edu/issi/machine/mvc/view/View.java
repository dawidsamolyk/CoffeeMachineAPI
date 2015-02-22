package edu.issi.machine.mvc.view;

import java.util.List;
import java.util.Map;

import edu.issi.machine.mvc.controller.Controller.CustomOrderListener;
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
     * @param list
     *            Produkty.
     */
    void showProducts(List<String> list);

    /**
     * @return Nazwa produktu, który ma zostaæ wydany.
     */
    String getSelectedForPreparationProductName();

    /**
     * @param productName
     *            Nazwa produktu.
     * @param ingredients
     *            Sk³adniki produktu.
     */
    void showProductIngredients(String productName, List<String> ingredients);

    /**
     * @param ingredients
     *            Sk³adniki.
     */
    void showIngredients(List<String> ingredients);

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
     * @param ingredientName
     *            Nazwa sk³adnika produktu, który ma zostaæ wydany.
     * @param availableProperties
     *            Dostêpne w³aœciwoœci dla podanego sk³adnika. Kluczem jest
     *            nazwa w³aœciwoœci, a wartoœci¹ jednostka miary.
     * @return W³aœciwoœci sk³adnika. Kluczem mapy jest nazwa w³aœciwoœci, a
     *         drugim parametrem jest wartoœæ dla wybranej w³aœciwoœci (wartoœæ
     *         ta jest wyra¿ana w jednostkach ustawionych we w³aœciwoœci).
     */
    Map<String, Double> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties);

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
    String getCustomProductName();

    /**
     * @param availableIngredients
     *            Dostêpne sk³adniki.
     * @return Sk³adniki nowego produktu.
     */
    List<String> getNewProductIngredients(List<String> availableIngredients);

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

    /**
     * @param propertiesListener
     *            Obiekt nas³uchuj¹cy zmian listy w³aœciwoœci sk³adników.
     */
    void addPropertiesListener(PropertiesListener propertiesListener);

    /**
     * @param orderListener
     *            Obiekt nas³uchuj¹cy zdarzenia z³o¿enia zamówienia.
     */
    void addOrderListener(OrderListener orderListener);

    /**
     * @param description
     *            Opis b³êdu.
     */
    void showError(String description);

    void addCustomOrderListener(CustomOrderListener customOrderListener);

}
