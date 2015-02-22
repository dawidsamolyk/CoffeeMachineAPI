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
     * Wy�wietlenie wszystkich produkt�w.
     * 
     * @param list
     *            Produkty.
     */
    void showProducts(List<String> list);

    /**
     * Pobranie wybranego do przygotowania produktu.
     * 
     * @return Nazwa produktu, kt�ry ma zosta� wydany.
     */
    String getSelectedForPreparationProductName();

    /**
     * Wy�wietlenie sk�adnik�w podanego produktu.
     * 
     * @param productName
     *            Nazwa produktu.
     * @param ingredients
     *            Sk�adniki produktu.
     */
    void showProductIngredients(String productName, List<String> ingredients);

    /**
     * Wy�wietlenie wszystkich sk�adnik�w.
     * 
     * @param ingredients
     *            Sk�adniki.
     */
    void showIngredients(List<String> ingredients);

    /**
     * Wy�wietlenie wszystkich w�a�ciwo�ci podanego sk�adnika.
     * 
     * @param ingredientName
     *            Nazwa sk�adnika.
     * @param properties
     *            W�a�ciwo�ci sk�adnika. Kluczem jest nazwa w�a�ciowo�ci, a
     *            warto�ci� jednostka miary tej w�a�ciwo�ci.
     * 
     */
    void showIngredientProperties(String ingredientName, Map<String, Unit> properties);

    /**
     * Pobranie w�a�ciwo�ci dla podanego sk�adnika.
     * 
     * @param ingredientName
     *            Nazwa sk�adnika produktu, kt�ry ma zosta� wydany.
     * @param availableProperties
     *            Dost�pne w�a�ciwo�ci dla podanego sk�adnika. Kluczem jest
     *            nazwa w�a�ciwo�ci, a warto�ci� jednostka miary.
     * @return W�a�ciwo�ci sk�adnika. Kluczem mapy jest nazwa w�a�ciwo�ci, a
     *         drugim parametrem jest warto�� dla wybranej w�a�ciwo�ci (warto��
     *         ta jest wyra�ana w jednostkach ustawionych we w�a�ciwo�ci).
     */
    Map<String, Double> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties);

    /**
     * Wy�wietlenie statusu operacji.
     * 
     * @param status
     *            Status operacji.
     * @param description
     *            Opis statusu operacji (mo�e by� pusty).
     */
    void showOperationStatus(Status status, String description);

    /**
     * Pobranie nazwy produktu, kt�ry samodzielnie definiuje u�ytkownik.
     * 
     * @return Nazwa produktu.
     */
    String getCustomProductName();

    /**
     * Pobranie sk�adnik�w dla nowego produktu.
     * 
     * @param availableIngredients
     *            Dost�pne sk�adniki.
     * @return Sk�adniki nowego produktu.
     */
    List<String> getNewProductIngredients(List<String> availableIngredients);

    /**
     * Dodanie obiektu nas�uchuj�cego zdarzenia dotycz�cego produkt�w (np. ich
     * wy�wietlenie).
     * 
     * @param productsListListener
     *            Obiekt nas�uchuj�cy zmian listy produkt�w.
     */
    void addProductsListener(ProductsListener productsListListener);

    /**
     * Dodanie obiektu nas�uchuj�cego zdarzenia dotycz�cego sk�adnik�w (np. ich
     * wy�wietlenie).
     * 
     * @param ingredientsListener
     *            Obiekt nas�uchuj�cy zmian listy sk�adnik�w.
     */
    void addIngredientsListener(IngredientsListener ingredientsListener);

    /**
     * Dodanie obiektu nas�uchuj�cego zdarzenia dotycz�cego w�a�ciwo�ci
     * sk�adnik�w (np. ich wy�wietlenie).
     * 
     * @param propertiesListener
     *            Obiekt nas�uchuj�cy zmian listy w�a�ciwo�ci sk�adnik�w.
     */
    void addPropertiesListener(PropertiesListener propertiesListener);

    /**
     * Dodanie obiektu nas�uchuj�cego zdarzenia dotycz�cego z�o�enia zam�wienia.
     * 
     * @param orderListener
     *            Obiekt nas�uchuj�cy zdarzenia z�o�enia zam�wienia.
     */
    void addOrderListener(OrderListener orderListener);

    /**
     * Wy�wietlenie informacji o b��dzie.
     * 
     * @param description
     *            Opis b��du.
     */
    void showError(String description);

    /**
     * Dodanie obiektu nas�uchuj�cego zdarzenia dotycz�cego z�o�enia zam�wienia
     * produktu zdefiniowanego przez u�ytkownika.
     * 
     * @param customOrderListener
     *            Obiekt nas�uchuj�cy zdarzenia z�o�enia zam�wienia produktu
     *            zdefiniowanego przez u�ytkownika.
     */
    void addCustomOrderListener(CustomOrderListener customOrderListener);

}
