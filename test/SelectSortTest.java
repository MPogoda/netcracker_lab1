package netcracker.lab1.test;

import netcracker.lab1.SelectSort;
import org.junit.Before;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 16/11/11
 * Time: 09:02
 * <p/>
 * SelectSort Test. Nothing to say here
 */
public final class SelectSortTest extends AbstractSortTest {
    @Before
    @Override
    public void initSort() {
        sortMethod = new SelectSort();
    }
}
