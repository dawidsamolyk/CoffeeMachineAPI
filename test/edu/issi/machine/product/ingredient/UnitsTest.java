package edu.issi.machine.product.ingredient;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class UnitsTest {
    @Test
    public void shouldProvideBarUnitAsText() {
	Unit fixture = Unit.BAR;

	assertEquals("bar", fixture.toString());
    }

    @Test
    public void shouldProvideCelsjusUnitAsText() {
	Unit fixture = Unit.C;

	assertEquals("*C", fixture.toString());
    }

    @Test
    public void shouldProvideGramUnitAsText() {
	Unit fixture = Unit.G;

	assertEquals("g", fixture.toString());
    }

    @Test
    public void shouldProvideKilogramUnitAsText() {
	Unit fixture = Unit.KG;

	assertEquals("kg", fixture.toString());
    }

    @Test
    public void shouldProvideLitreUnitAsText() {
	Unit fixture = Unit.L;

	assertEquals("l", fixture.toString());
    }

    @Test
    public void shouldProvideMililitreUnitAsText() {
	Unit fixture = Unit.ML;

	assertEquals("ml", fixture.toString());
    }
}