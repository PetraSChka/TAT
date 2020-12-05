package validator;

import exception.TriangleException;
import junit.framework.TestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleValidatorTest extends TestCase {
    TriangleValidator triangleValidator = new TriangleValidator();

    @DataProvider
    public Object[][] equilateralTriangle() {
        return new Object[][]{
                {5, 5, 5},
                {8, 8, 8}
        };
    }

    @Test(dataProvider = "equilateralTriangle")
    public void testCheckPossibleEquilateralTriangle(int sideA, int sideB, int sideC) throws Exception {
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] versatileTriangle() {
        return new Object[][]{
                {4, 7, 10},
                {5, 8, 11}
        };
    }

    @Test(dataProvider = "versatileTriangle")
    public void testCheckPossibleVersatileTriangle(int sideA, int sideB, int sideC) throws Exception {
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] isoscelesTriangle() {
        return new Object[][]{
                {7, 7, 6},
                {4, 4, 5}
        };
    }

    @Test(dataProvider = "isoscelesTriangle")
    public void testCheckPossibleIsoscelesTriangle(int sideA, int sideB, int sideC) throws Exception {
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] rightTriangle() {
        return new Object[][]{
                {8, 6, 10},
                {5, 12, 13}
        };
    }

    @Test(dataProvider = "rightTriangle")
    public void testCheckPossibleRightTriangle(int sideA, int sideB, int sideC) throws Exception {
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] egyptTriangle() {
        return new Object[][]{
                {3, 4, 5},
                {18, 19, 20}
        };
    }

    @Test(dataProvider = "egyptTriangle")
    public void testCheckPossibleEgyptTriangle(int sideA, int sideB, int sideC) throws Exception {
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] zeroSidesOfTriangle() {
        return new Object[][]{
                {0, 5, 5},
                {0, 0, 2},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "zeroSidesOfTriangle")
    public void testCheckPossibleZeroSidesOfTriangle(int sideA, int sideB, int sideC) throws Exception {
        assertFalse(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] negativeSidesOfTriangle() {
        return new Object[][]{
                {-2, 5, 5},
                {-6, -7, -44},
                {-1, -3, 2}
        };
    }

    @Test(dataProvider = "negativeSidesOfTriangle")
    public void testCheckPossibleNegativeSidesOfTriangle(int sideA, int sideB, int sideC) throws Exception {
        assertFalse(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] impossibleTriangle() {
        return new Object[][]{
                {1, 3, 6},
                {7, 2, 2}
        };
    }

    @Test(dataProvider = "impossibleTriangle")
    public void testCheckPossibleTriangle(int sideA, int sideB, int sideC) throws Exception {
        assertFalse(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @Test(expectedExceptions = TriangleException.class, expectedExceptionsMessageRegExp = "ОШИБКА!")
    public void testCheckTriangleForMaxSides(double sideA, double sideB, double sideC) throws Exception {
        assertFalse(triangleValidator.checkTrianglePossible(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test(expectedExceptions = TriangleException.class, expectedExceptionsMessageRegExp = "ОШИБКА!")
    public void testCheckTriangleForCrowedSides(double sideA, double sideB, double sideC) throws Exception {
        assertFalse(triangleValidator.checkTrianglePossible(Integer.MAX_VALUE + 100, Integer.MAX_VALUE + 100, Integer.MAX_VALUE + 100));
    }
}