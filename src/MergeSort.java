package netcracker.lab1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 17:25
 * <p/>
 * Merge sort. Recursive algorithm.
 *
 * @author Michael Pogoda
 * @version 0.3.5
 */
public final class MergeSort extends AbstractSort {
    /**
     * Merge two sorted lists in one. These lists are located one by one.
     *
     * @param <Type> Instance of Comparable<Type>
     * @param list   Input&Output list
     * @param left   the left bound of first list
     * @param middle the right bound of first list & the left bound of second list
     * @param right  the right bound of second list
     */
    private <Type extends Comparable<Type>>
    void merge(@NotNull final ArrayList<Type> list, final int left, final int middle, final int right) {

        @NotNull final ArrayList<Type> leftList = new ArrayList<>(middle - left + 1);
        @NotNull final ArrayList<Type> rightList = new ArrayList<>(right - middle);
        for (Type elem : list.subList(left, middle + 1)) {
            leftList.add(elem);
        }
        for (Type elem : list.subList(middle + 1, right + 1)) {
            rightList.add(elem);
        }

        // iterates over output part of array
        final ListIterator<Type> subListIterator = list.subList(left, right + 1).listIterator();

        @Nullable ListIterator<Type> leftIterator = leftList.listIterator();
        @Nullable ListIterator<Type> rightIterator = rightList.listIterator();
        Type currentLeft = leftIterator.next();
        Type currentRight = rightIterator.next();

        while (leftIterator != null && rightIterator != null) {
            subListIterator.next();

            if (currentLeft.compareTo(currentRight) == -1) {
                subListIterator.set(currentLeft);
                try {
                    currentLeft = leftIterator.next();
                } catch (NoSuchElementException ex) {
                    leftIterator = null;
                }
            } else {
                subListIterator.set(currentRight);
                try {
                    currentRight = rightIterator.next();
                } catch (NoSuchElementException ex) {
                    rightIterator = null;
                }
            }
        }

        while (leftIterator != null) {
            assert rightIterator == null : "right list isn't empty";
            subListIterator.next();
            subListIterator.set(currentLeft);
            try {
                currentLeft = leftIterator.next();
            } catch (NoSuchElementException ex) {
                leftIterator = null;
            }
        }

        while (rightIterator != null) {
            assert leftIterator == null : "left list isn't empty";
            subListIterator.next();
            subListIterator.set(currentRight);
            try {
                currentRight = rightIterator.next();
            } catch (NoSuchElementException ex) {
                rightIterator = null;
            }
        }
    }

    /**
     * Sort array using Merge sort.
     * Divide array in two half, sort them and merge result
     *
     * @param list  list to be sorted
     * @param left  left bound
     * @param right right bound
     */
    @Override
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final ArrayList<Type> list, final int left, final int right) {
        if (left < right) {
            final int mid = (left + right) >> 1;
            sortHelper(list, left, mid);
            sortHelper(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }
}
