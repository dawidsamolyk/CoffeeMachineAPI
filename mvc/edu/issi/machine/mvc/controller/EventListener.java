package edu.issi.machine.mvc.controller;

/**
 * @author DawidSamolyk
 *
 */
public interface EventListener {
    /**
     * @param arguments
     *            Argumenty wywo³ania akcji.
     */
    public void actionPerformed(EventArguments arguments);
}
