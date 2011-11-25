package netcracker.lab1.test;

import netcracker.lab1.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 22/11/11
 * Time: 17:13
 * <p/>
 * TEST MY SORTFACTORY PLZ
 *
 * @author Michael Pogoda
 * @version 0.5
 */
public class SortFactoryTest {
    @Test
    public void isItCorrectlyReturnsJavaSort() {
        assertTrue(SortFactory.getSort(Sort.JAVA_SORT) != null);
    }

    @Test
    public void isItCorrectlyReturnsBubbleSortDrown() {
        assertTrue(SortFactory.getSort(Sort.BUBBLE_SORT_DROWN) instanceof BubbleSortDrown);
    }

    @Test
    public void isItCorrectlyReturnsBubbleSortPop() {
        assertTrue(SortFactory.getSort(Sort.BUBBLE_SORT_POP) instanceof BubbleSortPop);
    }

    @Test
    public void isItCorrectlyReturnsMergeSort() {
        assertTrue(SortFactory.getSort(Sort.MERGE_SORT) instanceof MergeSort);
    }

    @Test
    public void isItCorrectlyReturnsQuickSort() {
        assertTrue(SortFactory.getSort(Sort.QUICK_SORT) instanceof QuickSort);
    }

    @Test
    public void isItCorrectlyReturnsSelectSort() {
        assertTrue(SortFactory.getSort(Sort.SELECT_SORT) instanceof SelectSort);
    }
}
