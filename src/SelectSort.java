package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 17:19
 * <p/>
 * Select sort, always O(n^2)
 *
 * @author Michael Pogoda
 * @version 0.4.1
 */
public final class SelectSort extends AbstractSort {
    /**
     * An implementation of select sort: go through all positions in array,
     * find the element, that should be at this position and place it here.
     *
     * @param array  array to be sorted
     * @param left   left bound
     * @param right  right bound
     * @param <Type> any instance of Comparable<Type>
     */
    @Override
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final Type[] array, final int left, final int right) {
        for (int i = left; i < right; ++i) {
            Type min = array[i];
            int pos = i;
            // find minimum element after current
            for (int j = i + 1; j <= right; ++j) {
                if (array[j].compareTo(min) == -1) {
                    min = array[j];
                    pos = j;
                }
            }
            // if there was element smaller than element we was looking for
            if (pos != i) {
                array[pos] = array[i];
                array[i] = min;
            }
        }
    }
}
