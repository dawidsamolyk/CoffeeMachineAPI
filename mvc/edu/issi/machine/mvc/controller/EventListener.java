package edu.issi.machine.mvc.controller;

/**
 * @author DawidSamolyk
 *         Interfejs dla klas obiektów nas³uchuj¹cych wydarzeñ.
 */
public interface EventListener extends java.util.EventListener {
    /**
     * Wykonanie wydarzenia.
     * 
     * @param arguments
     *            Argumenty wywo³ania akcji.
     */
    public void actionPerformed(EventArguments arguments);
}
