package netcracker.lab1.test;

import netcracker.lab1.AbstractSort;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.ListIterator;
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
 * @version 0.2.5
 */
public class AbstractSortTest {
    private ArrayList<Integer> list;
    private final static int MAX = 100;
    private final static int SIZE = 50;
    AbstractSort sortMethod; // can be overridden in ancestors

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>(SIZE);
        @NotNull Random generator = new Random(System.nanoTime());
        for (int i = 0; i < SIZE; ++i) {
            list.add(generator.nextInt(MAX));
        }
    }

    @Before
    public void initSort() {
        sortMethod = new AbstractSort();
    }

    @Test
    public void itDoesNotChangeLength() {
        assertEquals(sortMethod.sort(list).size(), list.size());
    }

    @Test
    public void itSorts() {
        @NotNull final ArrayList<Integer> outputArray = sortMethod.sort(list);
        ListIterator<Integer> iterator = outputArray.listIterator();
        int current = iterator.next();
        int next;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (current > next) {
                fail("List isn't sorted. OOPS");
            }
            current = next;
        }
        assertTrue(true);
    }

    @Test
    public void itDoesNotChangeInputArray() {
        final ListIterator<Integer> iteratorCopy = (new ArrayList<>(list)).listIterator();
        sortMethod.sort(list);
        for (@NotNull Integer element : list) {
            if (!element.equals(iteratorCopy.next())) {
                fail("Input list have been changed!");
            }
        }
        assertTrue(true);
    }
}
