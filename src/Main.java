package netcracker.lab1;

// dima.halushko@ukr.net
// Tu16_14_Pogoda

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 16:50
 * <p/>
 * Main. ITS MAIN
 *
 * @author Michael Pogoda
 * @version 0.3.0
 */
final public class Main {

    /**
     * Maximum difference between two items in generated sorted array
     */
    private final static int MAX_DIFF = 50;
    /**
     * Maximum number in arrays
     */
    private final static int MAX_NUM = Integer.MAX_VALUE;
    /**
     * Maximum length of array
     */
    private final static int MAX_SIZE = 1000;

    /**
     * Generate sorted array (each element (except last) have larger successor
     *
     * @return sorted array of size MAX_SIZE
    */
    private static int[] generateSortedArray() {
        final int[] result = new int[MAX_SIZE];
        final Random generator = new Random(System.nanoTime());
        result[0] = 0;
        for (int i = 1; i < MAX_SIZE; ++i) {
            result[i] = generator.nextInt(MAX_DIFF) + result[i - 1];
        }

        return result;
    }

    /**
     * generate the array sorted in reverse way (each element (except last) have smaller successor)
     *
     * @return array of size MAX_SIZE
     */
    private static int[] generateReverseSortedArray() {
        final int[] result = new int[MAX_SIZE];
        final Random generator = new Random(System.nanoTime());
        result[Main.MAX_SIZE - 1] = 0;
        for (int i = Main.MAX_SIZE - 2; i >= 0; --i) {
            result[i] = result[i + 1] + generator.nextInt(MAX_DIFF);
        }

        return result;
    }

    /**
     * Initialize array with random elements
     *
     * @return array of size MAX_SIZE
     */
    private static int[] generateRandomArray() {
        final int[] result = new int[MAX_SIZE];
        final Random generator = new Random(System.nanoTime());
        for (int i = 0; i < Main.MAX_SIZE; ++i) {
            result[i] = generator.nextInt(MAX_NUM);
        }

        return result;
    }

    /**
     * Benchmark sortMethod on array
     *
     * @param array      Array to be sorted
     * @param sortMethod Sorting method
     * @param length     The length of array
     * @return the time sortMethod took to sort array in nanoseconds
     */
    private static long benchmark(@NotNull final int[] array, @NotNull final AbstractSort sortMethod, final int length) {
        final long currentTime = System.nanoTime();
        sortMethod.sort(array, length);
        return System.nanoTime() - currentTime;
    }

    /**
     * Benchmark sortMethod on array, without changing any element in this array
     *
     * @param array      array, which will be sorted
     * @param sortMethod sorting method
     */
    private static void benchmarkWithoutChangeOfArray(@NotNull final int[] array, @NotNull final AbstractSort sortMethod) {
        for (int i = 1; i < MAX_SIZE; ++i) {
            System.out.print(i);
            System.out.print('\t');
            System.out.println(benchmark(array, sortMethod, i));
            System.gc(); //I DO NOT WANT TO GC when BENCHMARKING
        }
    }

    /**
     * Benchmark all sorting methods with sorted array
     *
     * @throws FileNotFoundException just in case
     */
    private static void caseA() throws FileNotFoundException {
        final int[] array = generateSortedArray();
        AbstractSort sortMethod;

        System.setOut(new PrintStream("caseA_AS"));
        sortMethod = new AbstractSort();
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortDrown();
        System.setOut(new PrintStream("caseA_BSD"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortPop();
        System.setOut(new PrintStream("caseA_BSP"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new MergeSort();
        System.setOut(new PrintStream("caseA_MS"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new QuickSort();
        System.setOut(new PrintStream("caseA_QS"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new SelectSort();
        System.setOut(new PrintStream("caseA_SS"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();
    }

    /**
     * Benchmark sortMethod on array, with changing last element to random element.
     *
     * @param array      array, which will be sorted
     * @param sortMethod sorting method
     */
    private static void benchmarkCaseB(final int[] array, @NotNull final AbstractSort sortMethod) {
        final Random generator = new Random(System.nanoTime());
        final int [] arrayCopy = new int[MAX_SIZE];
        System.arraycopy(array, 0, arrayCopy, 0, MAX_SIZE);

        for (int i = MAX_SIZE - 1; i > 0; --i) {
            arrayCopy[i] = generator.nextInt(MAX_NUM);
            System.out.print(i);
            System.out.print('\t');
            System.out.println(benchmark(arrayCopy, sortMethod, i));
            System.gc();
        }
    }

    /**
     * Benchmark all sorting methods on arrays, which are sorted, except last element
     *
     * @throws FileNotFoundException just in case
     */
    private static void caseB() throws FileNotFoundException {
        final int[] array = generateReverseSortedArray();
        AbstractSort sortMethod;

        System.setOut(new PrintStream("caseB_AS"));
        sortMethod = new AbstractSort();
        benchmarkCaseB(array, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortDrown();
        System.setOut(new PrintStream("caseB_BSD"));
        benchmarkCaseB(array, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortPop();
        System.setOut(new PrintStream("caseB_BSP"));
        benchmarkCaseB(array, sortMethod);
        System.out.close();

        sortMethod = new MergeSort();
        System.setOut(new PrintStream("caseB_MS"));
        benchmarkCaseB(array, sortMethod);
        System.out.close();

        sortMethod = new QuickSort();
        System.setOut(new PrintStream("caseB_QS"));
        benchmarkCaseB(array, sortMethod);
        System.out.close();

        sortMethod = new SelectSort();
        System.setOut(new PrintStream("caseB_SS"));
        benchmarkCaseB(array, sortMethod);
        System.out.close();
    }

    /**
     * Benchmark all sorting methods on array, that sorted in reverse direction
     *
     * @throws FileNotFoundException just in case
     */
    private static void caseC() throws FileNotFoundException {
        final int[] array = generateReverseSortedArray();
        AbstractSort sortMethod;

        System.setOut(new PrintStream("caseC_AS"));
        sortMethod = new AbstractSort();
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortDrown();
        System.setOut(new PrintStream("caseC_BSD"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortPop();
        System.setOut(new PrintStream("caseC_BSP"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new MergeSort();
        System.setOut(new PrintStream("caseC_MS"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new QuickSort();
        System.setOut(new PrintStream("caseC_QS"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new SelectSort();
        System.setOut(new PrintStream("caseC_SS"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

    }

    /**
     * Benchmark all sorting methods on random array
     *
     * @throws FileNotFoundException just in case
     */
    private static void caseD() throws FileNotFoundException {
        final int[] array = generateRandomArray();
        AbstractSort sortMethod;

        System.setOut(new PrintStream("caseD_AS"));
        sortMethod = new AbstractSort();
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortDrown();
        System.setOut(new PrintStream("caseD_BSD"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortPop();
        System.setOut(new PrintStream("caseD_BSP"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new MergeSort();
        System.setOut(new PrintStream("caseD_MS"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new QuickSort();
        System.setOut(new PrintStream("caseD_QS"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

        sortMethod = new SelectSort();
        System.setOut(new PrintStream("caseD_SS"));
        benchmarkWithoutChangeOfArray(array, sortMethod);
        System.out.close();

    }

    /**
     * It's MAIN
     *
     * @param argv command line arguments
     */
    public static void main(String[] argv) {
        try {
            caseA();
            caseB();
            caseC();
            caseD();
        } catch (FileNotFoundException e) {
            System.out.println("oops");
        } catch (OutOfMemoryError e) {
            System.out.println("JAVA F.CKED UP");
        }
    }
}
