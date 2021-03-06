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
 *         Widok (MVC).
 */
public interface View {

    /**
     * Wyświetlenie wszystkich produktów.
     * 
     * @param list
     *            Produkty.
     */
    void showProducts(List<String> list);

    /**
     * Pobranie wybranego do przygotowania produktu.
     * 
     * @return Nazwa produktu, który ma zostać wydany.
     */
    String getSelectedForPreparationProductName();

    /**
     * Wyświetlenie składników podanego produktu.
     * 
     * @param productName
     *            Nazwa produktu.
     * @param ingredients
     *            Składniki produktu.
     */
    void showProductIngredients(String productName, List<String> ingredients);

    /**
     * Wyświetlenie wszystkich składników.
     * 
     * @param ingredients
     *            Składniki.
     */
    void showIngredients(List<String> ingredients);

    /**
     * Wyświetlenie wszystkich właściwości podanego składnika.
     * 
     * @param ingredientName
     *            Nazwa składnika.
     * @param properties
     *            Właściwości składnika. Kluczem jest nazwa właściowości, a
     *            wartością jednostka miary tej właściwości.
     * 
     */
    void showIngredientProperties(String ingredientName, Map<String, Unit> properties);

    /**
     * Pobranie właściwości dla podanego składnika.
     * 
     * @param ingredientName
     *            Nazwa składnika produktu, który ma zostać wydany.
     * @param availableProperties
     *            Dostępne właściwości dla podanego składnika. Kluczem jest
     *            nazwa właściwości, a wartością jednostka miary.
     * @return Właściwości składnika. Kluczem mapy jest nazwa właściwości, a
     *         drugim parametrem jest wartość dla wybranej właściwości (wartość
     *         ta jest wyrażana w jednostkach ustawionych we właściwości).
     */
    Map<String, Double> getPropertiesForIngredient(String ingredientName, Map<String, Unit> availableProperties);

    /**
     * Wyświetlenie statusu operacji.
     * 
     * @param status
     *            Status operacji.
     * @param description
     *            Opis statusu operacji (może być pusty).
     */
    void showOperationStatus(Status status, String description);

    /**
     * Pobranie nazwy produktu, który samodzielnie definiuje użytkownik.
     * 
     * @return Nazwa produktu.
     */
    String getCustomProductName();

    /**
     * Pobranie składników dla nowego produktu.
     * 
     * @param availableIngredients
     *            Dostępne składniki.
     * @return Składniki nowego produktu.
     */
    List<String> getNewProductIngredients(List<String> availableIngredients);

    /**
     * Dodanie obiektu nasłuchującego zdarzenia dotyczącego produktów (np. ich
     * wyświetlenie).
     * 
     * @param productsListListener
     *            Obiekt nasłuchujący zmian listy produktów.
     */
    void addProductsListener(ProductsListener productsListListener);

    /**
     * Dodanie obiektu nasłuchującego zdarzenia dotyczącego składników (np. ich
     * wyświetlenie).
     * 
     * @param ingredientsListener
     *            Obiekt nasłuchujący zmian listy składników.
     */
    void addIngredientsListener(IngredientsListener ingredientsListener);

    /**
     * Dodanie obiektu nasłuchującego zdarzenia dotyczącego właściwości
     * składników (np. ich wyświetlenie).
     * 
     * @param propertiesListener
     *            Obiekt nasłuchujący zmian listy właściwości składników.
     */
    void addPropertiesListener(PropertiesListener propertiesListener);

    /**
     * Dodanie obiektu nasłuchującego zdarzenia dotyczącego złożenia zamówienia.
     * 
     * @param orderListener
     *            Obiekt nasłuchujący zdarzenia złożenia zamówienia.
     */
    void addOrderListener(OrderListener orderListener);

    /**
     * Wyświetlenie informacji o błędzie.
     * 
     * @param description
     *            Opis błędu.
     */
    void showError(String description);

    /**
     * Dodanie obiektu nasłuchującego zdarzenia dotyczącego złożenia zamówienia
     * produktu zdefiniowanego przez użytkownika.
     * 
     * @param customOrderListener
     *            Obiekt nasłuchujący zdarzenia złożenia zamówienia produktu
     *            zdefiniowanego przez użytkownika.
     */
    void addCustomOrderListener(CustomOrderListener customOrderListener);

}
