package netcracker.lab1.test;

import netcracker.lab1.QuickSort;
import org.junit.Before;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 16/11/11
 * Time: 09:03
 * <p/>
 * QuickSort Test. Nothing to say here
 *
 * @author Michael Pogoda
 * @version 0.0.1
 */
public class QuickSortTest extends AbstractSortTest {
    @Before
    @Override
    public void initSort() {
        sortMethod = new QuickSort();
    }
}
