package netcracker.lab1.test;

import netcracker.lab1.BubbleSortPop;
import org.junit.Before;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 16/11/11
 * Time: 09:01
 * <p/>
 * BubbleSortPop test. Nathin' to say here.
 *
 * @author Michael Pogoda
 * @version 0.0.1
 */
public final class BubbleSortPopTest extends AbstractSortTest {
    @Before
    @Override
    public void initSort() {
        sortMethod = new BubbleSortPop();
    }
}
