package edu.issi.machine.id;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import edu.issi.machine.product.ingredient.Unit;

public class PropertyIdentityTest {
    @Test
    public void testPropertyIdentity_1() throws Exception {
	int id = 0;
	String name = "";
	Unit unit = Unit.BAR;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 0, Nazwa: ", result.toString());
    }

    @Test
    public void testPropertyIdentity_2() throws Exception {
	int id = 1;
	String name = "0123456789";
	Unit unit = Unit.C;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 1, Nazwa: 0123456789", result.toString());
    }

    @Test
    public void testPropertyIdentity_3() throws Exception {
	int id = 0;
	String name = "";
	Unit unit = Unit.G;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 0, Nazwa: ", result.toString());
    }

    @Test
    public void testPropertyIdentity_4() throws Exception {
	int id = 1;
	String name = "0123456789";
	Unit unit = Unit.KG;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 1, Nazwa: 0123456789", result.toString());
    }

    @Test
    public void testPropertyIdentity_5() throws Exception {
	int id = 0;
	String name = "";
	Unit unit = Unit.L;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 0, Nazwa: ", result.toString());
    }

    @Test
    public void testPropertyIdentity_6() throws Exception {
	int id = 1;
	String name = "0123456789";
	Unit unit = Unit.ML;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 1, Nazwa: 0123456789", result.toString());
    }

    @Test
    public void testPropertyIdentity_7() throws Exception {
	int id = 0;
	String name = "0123456789";
	Unit unit = Unit.BAR;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 0, Nazwa: 0123456789", result.toString());
    }

    @Test
    public void testPropertyIdentity_8() throws Exception {
	int id = 7;
	String name = "";
	Unit unit = Unit.C;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 7, Nazwa: ", result.toString());
    }

    @Test
    public void testPropertyIdentity_9() throws Exception {
	int id = 0;
	String name = "0123456789";
	Unit unit = Unit.G;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 0, Nazwa: 0123456789", result.toString());
    }

    @Test
    public void testPropertyIdentity_10() throws Exception {
	int id = 7;
	String name = "";
	Unit unit = Unit.KG;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 7, Nazwa: ", result.toString());
    }

    @Test
    public void testPropertyIdentity_11() throws Exception {
	int id = 0;
	String name = "0123456789";
	Unit unit = Unit.L;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 0, Nazwa: 0123456789", result.toString());
    }

    @Test
    public void testPropertyIdentity_12() throws Exception {
	int id = 7;
	String name = "";
	Unit unit = Unit.ML;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 7, Nazwa: ", result.toString());
    }

    @Test
    public void testPropertyIdentity_13() throws Exception {
	int id = 1;
	String name = "";
	Unit unit = Unit.BAR;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 1, Nazwa: ", result.toString());
    }

    @Test
    public void testPropertyIdentity_14() throws Exception {
	int id = 7;
	String name = "0123456789";
	Unit unit = Unit.C;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 7, Nazwa: 0123456789", result.toString());
    }

    @Test
    public void testPropertyIdentity_15() throws Exception {
	int id = 1;
	String name = "";
	Unit unit = Unit.G;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 1, Nazwa: ", result.toString());
    }

    @Test
    public void testPropertyIdentity_16() throws Exception {
	int id = 7;
	String name = "0123456789";
	Unit unit = Unit.KG;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 7, Nazwa: 0123456789", result.toString());
    }

    @Test
    public void testPropertyIdentity_17() throws Exception {
	int id = 1;
	String name = "";
	Unit unit = Unit.L;

	PropertyIdentity result = new PropertyIdentity(id, name, unit);

	assertNotNull(result);
	assertEquals("ID: 1, Nazwa: ", result.toString());
    }

    @Test
    public void testGetUnit_3() throws Exception {
	PropertyIdentity fixture = new PropertyIdentity(7, "An??t-1.0.txt", Unit.G);

	Unit result = fixture.getUnit();

	assertNotNull(result);
	assertEquals("g", result.toString());
	assertEquals("G", result.name());
	assertEquals(0, result.ordinal());
    }

    public static void main(String[] args) {
	new org.junit.runner.JUnitCore().run(PropertyIdentityTest.class);
    }
}