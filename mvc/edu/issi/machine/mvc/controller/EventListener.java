package edu.issi.machine.mvc.controller;

/**
 * @author DawidSamolyk
 *
 */
public interface EventListener {
    /**
     * @param arguments
     *            Argumenty wywo�ania akcji.
     */
    public void actionPerformed(EventArguments arguments);
}
