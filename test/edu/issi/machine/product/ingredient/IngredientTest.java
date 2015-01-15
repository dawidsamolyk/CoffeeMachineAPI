package edu.issi.machine.product.ingredient;

import static org.junit.Assert.*;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Test;

import edu.issi.machine.id.IdentityTest;
import edu.issi.machine.id.PropertyIdentity;
import edu.issi.machine.operation.Operation;
import edu.issi.machine.operation.OperationTest;
import edu.issi.machine.product.OrderedElementsList;

public class IngredientTest {
    
    @Test
    public void ingredientShouldHoldsProperties() throws InvalidAttributeIdentifierException {
	Ingredient ingredient = IngredientTest.getSimpleFixture();
	
	PropertyIdentity property = PropertyIdentity.Factory.newProperty("Pressure", Unit.BAR);
	ingredient.add(property, new Double(-1.0));
	
	assertFalse(ingredient.getProperties().isEmpty());
    }
    
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
