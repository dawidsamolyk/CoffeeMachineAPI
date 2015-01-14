package edu.issi.machine.product.ingredient;

import javax.naming.directory.InvalidAttributeIdentifierException;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationTest;
import edu.issi.machine.product.OrderedElementsList;

public class IngredientTest {
    
    public static Ingredient getSimpleFixture() throws InvalidAttributeIdentifierException {
	return new Ingredient(IdentityTest.getIdentityFixture());
    }

    public static Ingredient getComplexFixture() throws InvalidAttributeIdentifierException {
        OrderedElementsList<Operation> operations = new OrderedElementsList<Operation>();
	operations.add(OperationTest.getFixture());
    
        Ingredient result = IngredientTest.getSimpleFixture();
        result.setOperations(operations);
        
        PropertyIdentity property = PropertyIdentity.Factory.newProperty("Pressure", Unit.BAR);
        result.add(property, new Double(-1.0));
    
        return result;
    }
    
    
}
