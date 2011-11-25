package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
 * @version 0.1.2
 */
public class AbstractSort {
    /**
     * The only public method defined in this abstract class.
     * Simply copy input List into ArrayList,
     * process it with <i>sortHelper</i> and return this ArrayList.
     *
     * @param <Type>    any comparable<Type> value
     * @param inputList input list
     * @param length    length of list to be sorted
     * @return sorted ArrayList
     */
    @NotNull
    final public <Type extends Comparable<Type>>
    ArrayList<Type> sort(@NotNull final List<Type> inputList, final int length) {

        @NotNull ArrayList<Type> outputList = new ArrayList<>(length);
        for (Type element : inputList.subList(0, length)) {
            outputList.add(element);
        }

        sortHelper(outputList, 0, length - 1);

        return outputList;
    }

    /**
     * Simply calls sort method with second parameter equals to length of inputList
     *
     * @param inputList input list to be sorted
     * @param <Type>    any Comparable<Type>
     * @return sorted ArrayList
     */
    @NotNull
    final public <Type extends Comparable<Type>>
    ArrayList<Type> sort(@NotNull final List<Type> inputList) {

        return sort(inputList, inputList.size());
    }

    /**
     * Abstract method to be reimplemented in ancestors.
     * Here it uses Collections.sort method
     *
     * @param list  list to be sorted
     * @param left  left bound
     * @param right right bound
     */
    <Type extends Comparable<Type>>
    void sortHelper(final ArrayList<Type> list, final int left, final int right) {
        Collections.sort(list);
    }
}