package edu.issi.machine.mvc.controller;

/**
 * @author DawidSamolyk
 *         Interfejs dla klas obiekt�w nas�uchuj�cych wydarze�.
 */
public interface EventListener extends java.util.EventListener {
    /**
     * Wykonanie wydarzenia.
     * 
     * @param arguments
     *            Argumenty wywo�ania akcji.
     */
    public void actionPerformed(EventArguments arguments);
}
