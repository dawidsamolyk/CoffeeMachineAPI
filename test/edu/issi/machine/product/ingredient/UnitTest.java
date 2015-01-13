package edu.issi.machine.product.ingredient;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class UnitTest {
    @Test
    public void shouldProvideBarUnitAsText() {
	Unit fixture = Unit.BAR;

	String result = fixture.toString();

	assertEquals("bar", result);
    }

    @Test
    public void shouldProvideCelsjusUnitAsText() {
	Unit fixture = Unit.C;

	String result = fixture.toString();

	assertEquals("*C", result);
    }

    @Test
    public void shouldProvideGramUnitAsText() {
	Unit fixture = Unit.G;

	String result = fixture.toString();

	assertEquals("g", result);
    }

    @Test
    public void shouldProvideKilogramUnitAsText() {
	Unit fixture = Unit.KG;

	String result = fixture.toString();

	assertEquals("kg", result);
    }

    @Test
    public void shouldProvideLitreUnitAsText() {
	Unit fixture = Unit.L;

	String result = fixture.toString();

	assertEquals("l", result);
    }

    @Test
    public void shouldProvideMililitreUnitAsText() {
	Unit fixture = Unit.ML;

	String result = fixture.toString();

	assertEquals("ml", result);
    }
}