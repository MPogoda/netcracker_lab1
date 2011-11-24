package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 22:55
 * <p/>
 * An abstract class for all sorting algorithms.
 *
 * @author Michael Pogoda
 * @version 0.0.2
 */
public class AbstractSort {
    /**
     * The only public method defined in this abstract class.
     * Simply clones input array, process it with <i>sortHelper</i> and return this copy.
     *
     * @param _array Input array
     * @param length The length of array to be sorted
     * @return array    Output array ^^
     */
    @NotNull
    final public int[] sort(@NotNull final int[] _array, final int length) {
        final int[] array = new int[length];
        System.arraycopy(_array, 0, array, 0, length);

        sortHelper(array, 0, length - 1);

        return array;
    }

    @NotNull
    final public int[] sort(@NotNull final int[] _array) {
        return sort(_array, _array.length);
    }

    /**
     * Abstract method to be reimplemented in ancestors
     *
     * @param array array to be sorted
     * @param left  left bound
     * @param right right bound
     */
    void sortHelper(final int[] array, final int left, final int right) {
        Arrays.sort(array, left, right + 1);
    }
}