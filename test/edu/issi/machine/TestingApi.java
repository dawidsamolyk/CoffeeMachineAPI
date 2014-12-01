package edu.issi.machine;

import java.lang.reflect.Method;

import edu.issi.machine.api.Api;
import edu.issi.machine.operation.ApiMethod;
import edu.issi.machine.product.ingredient.Ingredient;
import edu.issi.machine.subassembly.Subassembly;

@SuppressWarnings("javadoc")
public class TestingApi extends Api {

    @Override
    public void execute(Subassembly subassembly, Ingredient ingredient) {
    }

    public static ApiMethod mockApiMethod() {
	for (Method each : TestingApi.class.getMethods()) {
	    if (each.getName().equals("execute")) {
		return new ApiMethod(new TestingApi(), each);
	    }
	}

	return new ApiMethod(new TestingApi(), TestingApi.class.getMethods()[0]);
    }
}
