package edu.issi.machine.product.ingredient;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTest {
    @Test
    public void testToString_1() {
	Unit fixture = Unit.BAR;

	String result = fixture.toString();

	assertEquals("bar", result);
    }

    @Test
    public void testToString_2() {
	Unit fixture = Unit.C;

	String result = fixture.toString();

	assertEquals("*C", result);
    }

    @Test
    public void testToString_3() {
	Unit fixture = Unit.G;

	String result = fixture.toString();

	assertEquals("g", result);
    }

    @Test
    public void testToString_4() {
	Unit fixture = Unit.KG;

	String result = fixture.toString();

	assertEquals("kg", result);
    }

    @Test
    public void testToString_5() {
	Unit fixture = Unit.L;

	String result = fixture.toString();

	assertEquals("l", result);
    }

    @Test
    public void testToString_6() {
	Unit fixture = Unit.ML;

	String result = fixture.toString();

	assertEquals("ml", result);
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(UnitTest.class);
    }
}