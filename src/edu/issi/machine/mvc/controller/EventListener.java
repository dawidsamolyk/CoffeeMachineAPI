package edu.issi.machine.mvc.controller;

/**
 * @author DawidSamolyk
 *         Interfejs dla klas obiektów nasłuchujących wydarzeń.
 */
public interface EventListener extends java.util.EventListener {
    /**
     * Wykonanie wydarzenia.
     * 
     * @param arguments
     *            Argumenty wywołania akcji.
     */
    public void actionPerformed(EventArguments arguments);
}
