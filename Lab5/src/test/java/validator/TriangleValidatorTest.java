package validator;

import validator.TriangleValidator;
import exception.TriangleException;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleValidatorTest {
    TriangleValidator triangleValidator = new TriangleValidator();

    @Test
    public void testCheckTrianglePossibleNegativeCase(int sideA, int sideB, int sideC) throws Exception {
        Assert.assertFalse(triangleValidator.checkTrianglePossible(-5, -5, -3));
    }
}