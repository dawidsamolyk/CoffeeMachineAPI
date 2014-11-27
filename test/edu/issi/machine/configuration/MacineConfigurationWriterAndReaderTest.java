package edu.issi.machine.configuration;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.issi.machine.api.ExampleApi;
import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.IngredientUnit;
import edu.issi.machine.properties.Properties;
import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class MacineConfigurationWriterAndReaderTest {

    @Test
    public void shouldWriteExampleConfiguration() throws Exception {
	File file = new File("./bin/configuration.json");
	file.createNewFile();
	ConfigurationFile testDirectory = new ConfigurationFile(file);

	MachineConfiguration conf = MachineConfigurationTest.mockMachineConfiguration();

	MachineConfigurationWriter writer = new MachineConfigurationWriter(testDirectory);
	writer.write(conf);

	MachineConfigurationReader reader = new MachineConfigurationReader(testDirectory);

	assertEquals(conf, reader.getMachineConfiguration());
    }

    @Test
    public void shouldWriteComplexConfiguration() throws Exception {
	File file = new File("./bin/configuration.json");
	file.createNewFile();
	ConfigurationFile testDirectory = new ConfigurationFile(file);

	// -- API
	Method giveIngredient = ExampleApi.class.getDeclaredMethod("giveIngredient", Integer.class,
		IngredientUnit.class);
	Method heat = ExampleApi.class.getDeclaredMethod("heat", Integer.class,
		IngredientUnit.class);

	// -- SK£ADNIKI
	Ingredient coffee = new Ingredient(new Identity(1, "Kawa"));
	Ingredient water = new Ingredient(new Identity(2, "Woda"));

	// -- PRODUKTY
	List<Product> products = new ArrayList<Product>();
	// CZARNA KAWA
	Product blackCoffee = new Product(new Identity(10, "Kawa mocno zmielona"));
	blackCoffee.add(coffee);
	blackCoffee.add(water);
	products.add(blackCoffee);
	// KAWA ZWYCZAJNA
	Product standardCoffee = new Product(new Identity(11, "Kawa s³abo zmielona"));
	standardCoffee.add(coffee);
	standardCoffee.add(water);
	products.add(standardCoffee);
	// WODA
	Product cupOfWater = new Product(new Identity(12, "Kubek wody"));
	cupOfWater.add(water);
	products.add(cupOfWater);

	// -- PODZESPO£Y
	List<Subassembly> subassemblies = new ArrayList<Subassembly>();

	// ZBIORNIK NA KAWÊ
	Properties p1 = new Properties();
	p1.add(new Identity(1000, "Pojemnoœæ [g]"), 2000);

	Operation giveCoffee = new Operation(null);
	subassemblies.add(new Subassembly(new Identity(100, "Zbiornik na kawê"), p1, giveCoffee));
	// ZBIORNIK NA WODÊ
	Properties p2 = new Properties();
	p2.add(new Identity(1001, "Pojemnoœæ [ml]"), 3000);

	Operation giveWater = new Operation(null);
	subassemblies.add(new Subassembly(new Identity(101, "Zbiornik na wodê"), p2, giveWater));
	// GRZA£KA
	Properties p3 = new Properties();
	p3.add(new Identity(1002, "Max temp [*C]"), 100);

	Operation heater = new Operation(null);
	subassemblies.add(new Subassembly(new Identity(102, "Grza³ka"), p3, heater));
	// POMOPA DO WODY

	// POJEMNIK NA KUBKI

	// W£ACZNIK

	Properties properties = new Properties();

	MachineConfiguration conf = new MachineConfiguration(subassemblies, products, properties);

	MachineConfigurationWriter writer = new MachineConfigurationWriter(testDirectory);
	writer.write(conf);

	MachineConfigurationReader reader = new MachineConfigurationReader(testDirectory);

	assertEquals(conf, reader.getMachineConfiguration());
    }
}
