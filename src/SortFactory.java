package netcracker.lab1;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 22/11/11
 * Time: 16:50
 * <p/>
 * Abstract factory for all sorting methods
 *
 * @author Michael Pogoda
 * @version 0.5
 * @see Sort
 */
public class SortFactory {
    /**
     * Get sorting method by it's name
     *
     * @param sortName THE NAME
     * @return new instance of sorting method
     * @throws IllegalArgumentException JUST IN CASE
     * @see Sort
     */
    public static AbstractSort getSort(Sort sortName) throws IllegalArgumentException {
        switch (sortName) {
            case BUBBLE_SORT_DROWN:
                return new BubbleSortDrown();
            case BUBBLE_SORT_POP:
                return new BubbleSortPop();
            case MERGE_SORT:
                return new MergeSort();
            case OPTIMIZED_MERGE_SORT:
                return new OptimizedMergeSort();
            case QUICK_SORT:
                return new QuickSort();
            case SELECT_SORT:
                return new SelectSort();
            case JAVA_SORT:
                return new AbstractSort();
            default:
                throw new IllegalArgumentException("Y HAVE U DONE THAT");
        }
    }
}
