package edu.issi.machine.mvc;

import java.util.Map;

import edu.issi.machine.mvc.Controller.ProductsListener;
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
    public final static int INVALID_ID = -1;
    
    /**
     * @param products
     *            Produkty. Kluczem mapy jest numer ID produktu, a drugim
     *            parametrem jest jego nazwa.
     */
    void showProducts(Map<Integer, String> products);

    /**
     * @param productID
     *            Numer ID produktu.
     * @param productName
     *            Nazwa produktu.
     * @param ingredients
     *            Sk³adniki produktu.
     */
    void showProductIngredients(int productID, String productName, Map<Integer, String> ingredients);

    /**
     * @param ingredients
     *            Sk³adniki. Kluczem mapy jest numer ID sk³adnika, a drugim
     *            parametrem jest jego nazwa.
     */
    void showIngredients(Map<Integer, String> ingredients);

    /**
     * @param ingredientIdNumber
     *            Numer ID sk³adnika.
     * @param ingredientName
     *            Nazwa sk³adnika.
     * @param properties
     *            W³aœciwoœci sk³adnika. Kluczem jest nazwa w³aœciowoœci, a
     *            wartoœci¹ jednostka miary tej w³aœciwoœci.
     * 
     */
    void showIngredientProperties(int ingredientIdNumber, String ingredientName, Map<String, Unit> properties);

    /**
     * @return Numer ID produktu, który ma zostaæ wydany.
     */
    int getSelectedForPreparationProductIdNumber();

    /**
     * @param ingredientIdNumber
     *            Numer ID sk³adnika produktu, który ma zostaæ wydany.
     * @param ingredientName
     *            Nazwa sk³adnika produktu, który ma zostaæ wydany.
     * @return W³aœciwoœci sk³adnika. Kluczem mapy jest nazwa w³aœciwoœci, a
     *         drugim parametrem jest wartoœæ dla wybranej w³aœciwoœci (wartoœæ
     *         ta jest wyra¿ana w jednostkach ustawionych we w³aœciwoœci).
     */
    Map<String, Float> getSelectedPropertiesForIngredientFromChoseProduct(int ingredientIdNumber, String ingredientName);

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
     * @return Sk³adniki nowego produktu. Kluczem mapy s¹ numery ID sk³adników,
     *         a wartoœciami nazwy.
     */
    Map<Integer, String> getNewProductIngredients();

    /**
     * @param ingredientIdNumber
     *            Numer ID sk³adnika nowego produktu.
     * @param ingredientName
     *            Nazwa sk³adnika nowego produktu.
     * @return W³aœciowœci wybranego sk³adnika nowego produktu. Kluczem jest
     *         nazwa w³aœciwoœci, a drugim parametrem jest wartoœæ danej
     *         w³aœciwoœci (wartoœæ ta jest wyra¿ana w jednostkach ustawionych
     *         we w³aœciwoœci).
     */
    Map<String, Float> getPropertiesForNewProductIngredient(int ingredientIdNumber, String ingredientName);

    /**
     * @param productsListListener
     *            Obiekt nas³uchuj¹cy zmian listy produktów.
     */
    void addProductsListListener(ProductsListener productsListListener);
}
