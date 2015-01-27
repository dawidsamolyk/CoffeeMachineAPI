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
     *            Sk�adniki produktu.
     */
    void showProductIngredients(int productID, String productName, Map<Integer, String> ingredients);

    /**
     * @param ingredients
     *            Sk�adniki. Kluczem mapy jest numer ID sk�adnika, a drugim
     *            parametrem jest jego nazwa.
     */
    void showIngredients(Map<Integer, String> ingredients);

    /**
     * @param ingredientIdNumber
     *            Numer ID sk�adnika.
     * @param ingredientName
     *            Nazwa sk�adnika.
     * @param properties
     *            W�a�ciwo�ci sk�adnika. Kluczem jest nazwa w�a�ciowo�ci, a
     *            warto�ci� jednostka miary tej w�a�ciwo�ci.
     * 
     */
    void showIngredientProperties(int ingredientIdNumber, String ingredientName, Map<String, Unit> properties);

    /**
     * @return Numer ID produktu, kt�ry ma zosta� wydany.
     */
    int getSelectedForPreparationProductIdNumber();

    /**
     * @param ingredientIdNumber
     *            Numer ID sk�adnika produktu, kt�ry ma zosta� wydany.
     * @param ingredientName
     *            Nazwa sk�adnika produktu, kt�ry ma zosta� wydany.
     * @return W�a�ciwo�ci sk�adnika. Kluczem mapy jest nazwa w�a�ciwo�ci, a
     *         drugim parametrem jest warto�� dla wybranej w�a�ciwo�ci (warto��
     *         ta jest wyra�ana w jednostkach ustawionych we w�a�ciwo�ci).
     */
    Map<String, Float> getSelectedPropertiesForIngredientFromChoseProduct(int ingredientIdNumber, String ingredientName);

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
     * @return Sk�adniki nowego produktu. Kluczem mapy s� numery ID sk�adnik�w,
     *         a warto�ciami nazwy.
     */
    Map<Integer, String> getNewProductIngredients();

    /**
     * @param ingredientIdNumber
     *            Numer ID sk�adnika nowego produktu.
     * @param ingredientName
     *            Nazwa sk�adnika nowego produktu.
     * @return W�a�ciow�ci wybranego sk�adnika nowego produktu. Kluczem jest
     *         nazwa w�a�ciwo�ci, a drugim parametrem jest warto�� danej
     *         w�a�ciwo�ci (warto�� ta jest wyra�ana w jednostkach ustawionych
     *         we w�a�ciwo�ci).
     */
    Map<String, Float> getPropertiesForNewProductIngredient(int ingredientIdNumber, String ingredientName);

    /**
     * @param productsListListener
     *            Obiekt nas�uchuj�cy zmian listy produkt�w.
     */
    void addProductsListListener(ProductsListener productsListListener);
}
