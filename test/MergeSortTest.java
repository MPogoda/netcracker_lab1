package netcracker.lab1.test;

import netcracker.lab1.MergeSort;
import org.junit.Before;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 16/11/11
 * Time: 00:17
 * <p/>
 * MergeSort test. Nothing to say here.
 *
 * @author Michael Pogoda
 * @version 0.0.3
 */
public final class MergeSortTest extends AbstractSortTest {
    @Before
    @Override
    public void initSort() {
        sortMethod = new MergeSort();
    }

}
