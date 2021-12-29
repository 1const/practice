package functions.UNDO_String_Builder.TaskTests.Exercise2Test;

import functions.Tasks.Exercise2.ArrayClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ArrayTest {
    @Test
    public void testCreateArrayWithDim() {
        ArrayClass  object = new  ArrayClass();
        double[] array = object.createArrayWithDim(5);
        double[] knownArray = {0.0, 0.0, 0.0, 0.0, 0.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArrayOfOnes() {
        ArrayClass  object = new  ArrayClass ();
        double[] array = object.getArrayOfOnes(6);
        double[] knownArray = {2.0, 1.0, 1.0, 1.0, 1.0, 2.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArrayOfOddIntegerNumbers() {
        ArrayClass  object = new ArrayClass();
        double[] array = object.getArrayOfOddIntegerNumbers(5);
        double[] knownArray = {1.0, 3.0, 5.0, 7.0, 9.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArrayOfEvenDecreasingNumbers() {
        ArrayClass object = new  ArrayClass();
        double[] array = object.getArrayOfEvenDecreasingNumbers(7);
        double[] knownArray = {14.0, 12.0, 10.0, 8.0, 6.0, 4.0, 2.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArrayOfFibonacciNumbers() {
        ArrayClass object = new ArrayClass();
        double[] array = object.getArrayOfFibonacciNumbers(10);
        double[] knownArray = {0.0, 1.0, 1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0, 34.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArrayOfSquareOfNumbers() {
        ArrayClass object = new  ArrayClass();
        double[] array = object.getArrayOfSquareOfNumbers(10);
        double[] knownArray = {0.0, 1.0, 4.0, 9.0, 16.0, 25.0, 36.0, 49.0, 64.0, 81.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetSolvingTheQuadraticEquation() {
        ArrayClass object = new ArrayClass();
        double[] firstSolution = object.getSolvingTheQuadraticEquation(0, -5, 2);
        double[] secondSolution = object.getSolvingTheQuadraticEquation(4, 0, 9);
        double[] thirdSolution = object.getSolvingTheQuadraticEquation(3, 12, 0);
        double[] fourthSolution = object.getSolvingTheQuadraticEquation(4, 4, 1);
        double[] fifthSolution = object.getSolvingTheQuadraticEquation(1, 5, 6);
        double[] sixthSolution = object.getSolvingTheQuadraticEquation(-1, -5, 14);
        double[] seventhSolution = object.getSolvingTheQuadraticEquation((double) 1 / 3, (double) -3 / 7, (double) 9 / 5);
        double[] eighthSolution = object.getSolvingTheQuadraticEquation((double) 1 / 30, (double) -1 / 6, (double) 1 / 5);
        double[] firstKnownArray = {0.4};
        double[] secondKnownArray = {}; //0 элементов
        double[] thirdKnownArray = {-4.0, 0.0};
        double[] fourthKnownArray = {-0.5};
        double[] fifthKnownArray = {-3.0, -2.0};
        double[] sixthKnownArray = {-7.0, 2.0};
        double[] seventhKnownArray = {}; //0 элементов
        double[] eighthKnownArray = {2, 3};
        assertTrue(Arrays.equals(firstSolution, firstKnownArray));
        assertTrue(Arrays.equals(secondSolution, secondKnownArray));
        assertTrue(Arrays.equals(thirdSolution, thirdKnownArray));
        assertTrue(Arrays.equals(fourthSolution, fourthKnownArray));
        assertTrue(Arrays.equals(fifthSolution, fifthKnownArray));
        assertTrue(Arrays.equals(sixthSolution, sixthKnownArray));
        assertTrue(Arrays.equals(seventhSolution, seventhKnownArray));
        for (int i = 0; i < eighthSolution.length; i++) {
            Assert.assertEquals(eighthSolution[i], eighthKnownArray[i], 0.00001);
        }
    }

    @Test
    public void testGetArrayOfNaturalNumbersNotDivisibleBy3() {
        ArrayClass object = new  ArrayClass();
        double[] array = object.getArrayOfNaturalNumbersNotDivisibleBy3(10);
        double[] knownArray = {1.0, 2.0, 4.0, 5.0, 7.0, 8.0, 10.0, 11.0, 13.0, 14.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArrayOfArithmeticProgression() {
        ArrayClass object = new  ArrayClass();
        double[] array = object.getArrayOfArithmeticProgression(10, -20, 3);
        double[] knownArray = {-20.0, -17.0, -14.0, -11.0, -8.0, -5.0, -2.0, 1.0, 4.0, 7.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArrayOfGeometricProgressionName() {
        ArrayClass object = new  ArrayClass();
        double[] array = object.getArrayOfGeometricProgression(7, 100, (double) 1 / 6);
        double[] knownArray = new double[]{100.0, 16.66666, 2.77777, 0.462963, 0.07716, 0.01286, 0.00214};
        for (int i = 0; i < 7; i++)
            Assert.assertEquals(array[i], knownArray[i], 0.00001);
    }

    @Test
    public void testGetArrayOIntegerDivisors() {
        ArrayClass object = new  ArrayClass();
        double[] array = object.getArrayOIntegerDivisors(100);
        double[] knownArray = {1.0, 2.0, 4.0, 5.0, 10.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArrayOfPositivePrimes() {
        ArrayClass object = new  ArrayClass();
        double[] array = object.getArrayOfPositivePrimes(50);
        double[] knownArray = {2.0, 3.0, 5.0, 7.0, 11.0, 13.0, 17.0, 19.0, 23.0, 29.0, 31.0, 37.0, 41.0, 43.0, 47.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetSymmetricalArray() {
        ArrayClass object = new ArrayClass();
        double[] array = object.getSymmetricalArray(11);
        double[] knownArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0};
        assertTrue(Arrays.equals(array, knownArray));
        array = object.getSymmetricalArray(8);
        knownArray = new double[]{1.0, 2.0, 3.0, 4.0, 4.0, 3.0, 2.0, 1.0};
        assertTrue(Arrays.equals(array, knownArray));
    }

    @Test
    public void testGetArrayOfElementsWithOppositeSigns() {
        ArrayClass object = new  ArrayClass();
        double[] array = {-10.0, 2.0, 3.0, -25.0, 7.0};
        object.getArrayOfElementsWithOppositeSigns(array);
        assertTrue(Arrays.equals(array, new double[]{10.0, -2.0, -3.0, 25.0, -7.0}));
    }

    @Test
    public void testisNumberInTheArray() {
        ArrayClass object = new  ArrayClass();
        double[] array = {1.0, 2.0, 30.5, 23.0, 48.9, -1.0, 9.2, -3};
        assertTrue(object.isNumberInTheArray(array, 30.5));
        Assert.assertFalse(object.isNumberInTheArray(array, 10));
    }

    @Test
    public void testisNullInTheArray() {
        ArrayClass object = new  ArrayClass();
        Integer[] array = {1, 3, 6, 34, 78, 30, null};
        assertTrue(object.isNullInTheArray(array));
        array = new Integer[]{3, 2, 5, 7, 89};
        Assert.assertFalse(object.isNullInTheArray(array));
    }

    @Test
    public void testGetNumberOfEvenNumbersInArray() {
        ArrayClass object = new  ArrayClass();
        double[] knownArray = {1, 4, 6, 8, 11, 12, 45, 32, 67, 88, 9, 24, 58};
        Assert.assertEquals(object.getNumberOfEvenNumbersInArray(knownArray), 8);
    }

    @Test
    public void testGetMaximalElementInArray() {
        ArrayClass object = new  ArrayClass();
        double[] knownArray = {23, 45, 61, 54, 78, 90, 432, 123, 456, 789, 20, 654};
        Assert.assertEquals(object.getMaximalElementInArray(knownArray), 789.0);
        knownArray = new double[]{};
        Assert.assertNull((String) object.getMaximalElementInArray(knownArray), null);
    }

    @Test
    public void testGetSumOfNumbersWithEvenIndexes() {
        ArrayClass object = new  ArrayClass();
        double[] knownArray = {12, 34, 52, 41, 67, 80, 97, 57, 24, 689, 12};
        Assert.assertEquals(object.getSumOfNumbersWithEvenIndexes(knownArray), 264.0);
    }

    @Test
    public void testWhoHasTheMostDivisible() {
        ArrayClass object = new  ArrayClass();
        double[] knownArray = {2, 5, 6, 8, 10, 12, 15, 21, 22, 56, 78, 99, 3};
        assertTrue(object.whoHasTheMostDivisible(knownArray));
        knownArray = new double[]{4, 8, 9, 12, 18, 45, 33, 12, 60, 24, 54, 3};
        Assert.assertFalse(object.whoHasTheMostDivisible(knownArray));
    }



}
