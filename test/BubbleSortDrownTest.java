package netcracker.lab1.test;

import netcracker.lab1.BubbleSortDrown;
import org.junit.Before;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 16/11/11
 * Time: 08:55
 * <p/>
 * BubbleSortDrown test. Nothing to say here
 *
 * @author Michael Pogoda
 * @version 0.0.2
 */
public final class BubbleSortDrownTest extends AbstractSortTest {
    @Before
    @Override
    public void initSort() {
        sortMethod = new BubbleSortDrown();
    }
}
