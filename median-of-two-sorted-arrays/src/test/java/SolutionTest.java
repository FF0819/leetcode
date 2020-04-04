import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @ParameterizedTest
    @CsvSource({
            "'1,3,4,9','2,4,6','2,4,6'",
            "'1','2,4,6','1'",
            "'2,3','2,4','2,3'"
    })
    public void findShorterArrayTest(String arrayInput1, String arrayInput2, String arrayExpected) {
        int[] arrayInput1Covert = Arrays.stream(arrayInput1.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] arrayInput2Covert = Arrays.stream(arrayInput2.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] arrayExpectedCovert = Arrays.stream(arrayExpected.split(",")).mapToInt(Integer::parseInt).toArray();
        assertArrayEquals(arrayExpectedCovert, Solution.findShorterArray(arrayInput1Covert, arrayInput2Covert));
    }

    @ParameterizedTest
    @CsvSource({
            "'1,3,4,9','2,4,6','1,3,4,9'",
            "'1','2,4,6','2,4,6'",
            "'2,3','2,4','2,4'"
    })
    public void findLongerArrayTest(String arrayInput1, String arrayInput2, String arrayExpected) {
        int[] arrayInput1Covert = Arrays.stream(arrayInput1.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] arrayInput2Covert = Arrays.stream(arrayInput2.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] arrayExpectedCovert = Arrays.stream(arrayExpected.split(",")).mapToInt(Integer::parseInt).toArray();
        assertArrayEquals(arrayExpectedCovert, Solution.findLongerArray(arrayInput1Covert, arrayInput2Covert));
    }

    @ParameterizedTest
    @CsvSource({
            "'1,3,4,9',0,-2147483648",
            "'2,4,6',2,4",
            "'2,3',2,3"
    })
    public void findBoundaryLeftValueTest(String arrayInput, int flagInput, int valueExpected) {
        int[] arrayInputCovert = Arrays.stream(arrayInput.split(",")).mapToInt(Integer::parseInt).toArray();
        assertEquals(valueExpected, Solution.findBoundaryLeftValue(arrayInputCovert, flagInput));
    }

    @ParameterizedTest
    @CsvSource({
            "'1,3,4,9',0,1",
            "'2,4,6',2,6",
            "'2,3',2,2147483647"
    })
    public void findBoundaryRightValueTest(String arrayInput, int flagInput, int valueExpected) {
        int[] arrayInputCovert = Arrays.stream(arrayInput.split(",")).mapToInt(Integer::parseInt).toArray();
        assertEquals(valueExpected, Solution.findBoundaryRightValue(arrayInputCovert, flagInput));
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4','5,6,7,8',4.5",
            "'1,3,4,9','2,4,6',4",
            "'1','2,4,6',3",
            "'2,3','4',3",
            "'1','1',1"
    })
    public void findMedianSortedArraysTest(String arrayInput1, String arrayInput2, double valueExpected) {
        int[] arrayInput1Covert = Arrays.stream(arrayInput1.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] arrayInput2Covert = Arrays.stream(arrayInput2.split(",")).mapToInt(Integer::parseInt).toArray();
        assertEquals(valueExpected, Solution.findMedianSortedArrays(arrayInput1Covert, arrayInput2Covert), 0);
    }
}
