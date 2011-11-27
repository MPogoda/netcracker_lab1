package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 22:55
 * <p/>
 * An abstract class for all sorting algorithms.
 *
 * @author Michael Pogoda
 * @version 0.4.2
 */
public class AbstractSort {
    /**
     * Simply copy inputList into array, process it with <i>sortHelper</i>
     * and return sorted ArrayList.
     *
     * @param <Type>    instance of Comparable<Type>
     * @param inputList Input list
     * @param length    The length of list to be sorted
     * @return sorted ArrayList<Type>
     */
    @NotNull
    @SuppressWarnings({"unchecked"}) //don't warning about Comparable -> Type cast
    final <Type extends Comparable<Type>>
    ArrayList<Type> sort(@NotNull final List<Type> inputList, final int length) {

        @NotNull final Type[] array = (Type[]) new Comparable[length];
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(inputList.toArray(), 0, array, 0, length);

        sortHelper(array, 0, length - 1);

        @NotNull ArrayList<Type> outputList = new ArrayList<>(length);
        Collections.addAll(outputList, array);

        return outputList;
    }

    /**
     * Sort array of Integers using <i>sortMethod</i>
     *
     * @param inputArray array to be sorted
     * @param length     length of inputArray
     * @return sorted array of Integers
     */
    @NotNull
    final public Integer[] sort(@NotNull final Integer[] inputArray, final int length) {
        @NotNull final Integer[] array = new Integer[length];
        System.arraycopy(inputArray, 0, array, 0, length);

        sortHelper(array, 0, length - 1);

        return array;
    }

    /**
     * Proxy to Integer[] sort(Integer[], int).
     *
     * @param inputArray array to be sorted
     * @return sorted array of Integer
     */
    @NotNull
    final public Integer[] sort(@NotNull final Integer[] inputArray) {
        return sort(inputArray, inputArray.length);
    }

    /**
     * Proxy to ArrayList<Type> sort(List<Type>, int)
     *
     * @param inputList list to be sorted
     * @param <Type>    any Comparable<Type>
     * @return sorted ArrayList<Type>
     */
    @SuppressWarnings({"UnusedDeclaration"}) //stop warning me, it can be used
    @NotNull
    final public <Type extends Comparable<Type>>
    ArrayList<Type> sort(@NotNull final List<Type> inputList) {
        return sort(inputList, inputList.size());
    }


    /**
     * Abstract method to be reimplemented in ancestors.
     * Here it uses standard sort method from java.util.Arrays
     *
     * @param array  array to be sorted
     * @param left   left bound
     * @param right  right bound
     * @param <Type> any Comparable<Type> instance
     * @see java.util.Arrays
     */
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final Type[] array, final int left, final int right) {
        Arrays.sort(array, left, right + 1);
    }
}