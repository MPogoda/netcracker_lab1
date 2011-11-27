package netcracker.lab1.test;

import netcracker.lab1.OptimizedMergeSort;
import org.junit.Before;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 25/11/11
 * Time: 14:47
 * </p>
 *
 * Test OptimizedMergeSort
 *
 * @author Michael Pogoda
 * @version 0.1.0
 * @see OptimizedMergeSort
 */
public class OptimizedMergeSortTest extends AbstractSortTest {
    @Before
    @Override
    public void initSort() {
        sortMethod = new OptimizedMergeSort();
    }
}
