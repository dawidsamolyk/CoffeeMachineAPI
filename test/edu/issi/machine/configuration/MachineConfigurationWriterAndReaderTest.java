package edu.issi.machine.configuration;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.directory.InvalidAttributesException;

import org.junit.Test;

import edu.issi.machine.id.Identity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.IngredientProperty;
import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class MachineConfigurationWriterAndReaderTest {

    @Test
    public void shouldWriteComplexConfiguration() throws Exception {
	List<Product> products = new ArrayList<Product>();
	products.add(blackCoffee());

	List<Subassembly> subassemblies = new ArrayList<Subassembly>();
	subassemblies.add(new Subassembly(new Identity(5, "Zbiornik na kawê"), operations()));
	subassemblies.add(new Subassembly(new Identity(7, "Grza³ka"), heatWaterOperation()));
	subassemblies.add(new Subassembly(new Identity(9, "Zbiornik na wodê"), giveWaterOperation()));

	MachineConfiguration conf = new MachineConfiguration(subassemblies, products);

	testSerialization(conf);
    }

    private void testSerialization(MachineConfiguration conf) throws IOException, InvalidAttributesException {
	File file = new File("./bin/configuration.json");
	file.createNewFile();
	ConfigurationFile testDirectory = new ConfigurationFile(file);

	MachineConfigurationWriter writer = new MachineConfigurationWriter(testDirectory);
	writer.write(conf);

	MachineConfigurationReader reader = new MachineConfigurationReader(testDirectory);
	file.delete();

	assertEquals(conf, reader.getMachineConfiguration());
    }

    private Product blackCoffee() {
	Product blackCoffee = new Product(new Identity(0, "Kawa czarna"));
	blackCoffee.add(coffee());
	blackCoffee.add(water());
	return blackCoffee;
    }

    private Operation giveWaterOperation() {
	Operation giveWater = new Operation(new Identity(8, "Wpompowanie wody"));
	return giveWater;
    }

    private Operation heatWaterOperation() {
	Operation heatWater = new Operation(new Identity(6, "Podgrzanie wody"));
	return heatWater;
    }

    private Operation[] operations() {
	return new Operation[] { new Operation(new Identity(4, "Zmielenie kawy")),
		new Operation(new Identity(3, "Wsypanie kawy")) };
    }

    private Ingredient water() {
	Map<IngredientProperty, Double> waterProperties = new HashMap<IngredientProperty, Double>();
	
	waterProperties.put(IngredientProperty.QUANTITY_IN_ML, 250.0);
	waterProperties.put(IngredientProperty.PRESSURE_IN_BAR, 0.5);
	
	return new Ingredient(new Identity(2, "Woda"), waterProperties);
    }

    private Ingredient coffee() {
	Map<IngredientProperty, Double> coffeeProperties = new HashMap<IngredientProperty, Double>();
	
	coffeeProperties.put(IngredientProperty.QUANTITY_IN_G, 10.0);
	
	return new Ingredient(new Identity(1, "Kawa"), coffeeProperties);
    }
}
