package netcracker.lab1.test;

import netcracker.lab1.AbstractSort;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 16/11/11
 * Time: 00:31
 * <p/>
 * Template for all sorting test.
 *
 * @author Michael Pogoda
 * @version 0.0.5
 */
public class AbstractSortTest {
    private Integer[] array;
    private final static int MAX = 100;
    private final static int SIZE = 50;
    AbstractSort sortMethod; // can be overridden in ancestors

    @Before
    public void setUp() throws Exception {
        array = new Integer[SIZE];
        Random generator = new Random(System.nanoTime());
        for (int i = 0; i < SIZE; ++i) {
            array[i] = generator.nextInt(MAX);
        }
    }

    @Before
    public void initSort() {
        sortMethod = new AbstractSort();
    }

    @Test
    public void itDoesNotChangeLength() {
        assertEquals(sortMethod.sort(array).length, array.length);
    }

    @Test
    public void itSorts() {
        final Integer[] outputArray = sortMethod.sort(array);
        for (int i = 0; i < SIZE - 1; ++i) {
            if (outputArray[i] > outputArray[i + 1]) {
                fail("Array isn't sorted. Oops");
            }
        }
        assertTrue(true);
    }

    @Test
    public void itDoesNotChangeInputArray() {
        final Integer[] _arr = new Integer[SIZE];
        System.arraycopy(array, 0, _arr, 0, array.length);
        sortMethod.sort(array);
        for (int i = 0; i < SIZE; ++i) {
            if (!array[i].equals(_arr[i])) {
                fail("Input array have been changed!");
            }
        }
        assertTrue(true);
    }
}
