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
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.EmptyOperation;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.product.Product;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.product.ingredient.Unit;
import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class MachineConfigurationWriterAndReaderTest {

	@Test
	public void shouldWriteComplexConfiguration() throws Exception {
		List<Product> products = new ArrayList<Product>();
		products.add(blackCoffee());

		List<Subassembly> subassemblies = new ArrayList<Subassembly>();
		subassemblies.add(new Subassembly(new Identity(5, "Zbiornik na kawê"),
				operations()));
		subassemblies.add(new Subassembly(new Identity(7, "Grza³ka"),
				heatWaterOperation()));
		subassemblies.add(new Subassembly(new Identity(9, "Zbiornik na wodê"),
				giveWaterOperation()));

		MachineConfiguration conf = new MachineConfiguration(subassemblies,
				products);

		testSerialization(conf);
	}

	private void testSerialization(MachineConfiguration conf)
			throws IOException, InvalidAttributesException {
		File file = new File("./bin/configuration.json");
		file.createNewFile();
		ConfigurationFile testDirectory = new ConfigurationFile(file);

		MachineConfigurationWriter writer = new MachineConfigurationWriter(
				testDirectory);
		writer.write(conf);

		MachineConfigurationReader reader = new MachineConfigurationReader(
				testDirectory);
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
		return new EmptyOperation(new Identity(8, "Wpompowanie wody"));
	}

	private Operation heatWaterOperation() {
		return new EmptyOperation(new Identity(6, "Podgrzanie wody"));
	}

	private EmptyOperation[] operations() {
		return new EmptyOperation[] {
				new EmptyOperation(new Identity(4, "Zmielenie kawy")),
				new EmptyOperation(new Identity(3, "Wsypanie kawy")) };
	}

	private Ingredient water() {
		Map<PropertyIdentity, Double> waterProperties = new HashMap<PropertyIdentity, Double>();

		waterProperties.put(new PropertyIdentity(100, "Ciœnienie", Unit.BAR),
				1.0);
		waterProperties.put(new PropertyIdentity(101, "Temperatura", Unit.C),
				2.5);
		waterProperties.put(new PropertyIdentity(101, "Iloœæ", Unit.L), 2.5);

		return new Ingredient(new Identity(2, "Woda"), waterProperties);
	}

	private Ingredient coffee() {
		Map<PropertyIdentity, Double> coffeeProperties = new HashMap<PropertyIdentity, Double>();

		coffeeProperties.put(new PropertyIdentity(101, "Iloœæ", Unit.G), 10.0);

		return new Ingredient(new Identity(1, "Kawa"), coffeeProperties);
	}
}
