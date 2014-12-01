package edu.issi.machine;

import edu.issi.machine.api.Api;
import edu.issi.machine.operation.ApiMethod;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class TestingApi extends Api {

    public void giveTheCup(Subassembly subassembly, Ingredient ingredient) {
    }

    public void log(String message) {
    }

    public void logError(Exception e) {
    }

    public static ApiMethod mockApiMethod() {
	try {
	    return new ApiMethod(new TestingApi(), TestingApi.class.getMethod("giveTheCup",
		    Subassembly.class, Ingredient.class));
	} catch (NoSuchMethodException | SecurityException e) {
	    e.printStackTrace();
	}
	return null;
    }
}
