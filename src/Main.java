package netcracker.lab1;

// dima.halushko@ukr.net
// Tu16_14_Pogoda

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.ListIterator;
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
 * @version 0.4.0
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
     * Generate sorted ArrayList (each element (except last) have larger successor
     *
     * @return sorted ArrayList of size MAX_SIZE
     */
    @NotNull
    private static ArrayList<Integer> generateSortedArray() {
        @NotNull final ArrayList<Integer> result = new ArrayList<>(MAX_SIZE);
        @NotNull final Random generator = new Random(System.nanoTime());
        result.add(0);
        int current = 0;
        for (int i = 1; i < MAX_SIZE; ++i) {
            current += generator.nextInt(MAX_DIFF);
            result.add(current);
        }

        return result;
    }

    /**
     * generate the ArrayList sorted in reverse way (each element (except last) have smaller successor)
     *
     * @return ArrayList of size MAX_SIZE
     */
    @NotNull
    private static ArrayList<Integer> generateReverseSortedArray() {
        @NotNull final ArrayList<Integer> result = new ArrayList<>(MAX_SIZE);
        @NotNull final Random generator = new Random(System.nanoTime());
        int current = MAX_NUM;
        result.add(current);
        for (int i = 1; i < MAX_NUM; ++i) {
            current -= generator.nextInt(MAX_DIFF);
            result.add(current);
        }

        return result;
    }

    /**
     * Initialize ArrayList with random elements
     *
     * @return ArrayList of size MAX_SIZE
     */
    @NotNull
    private static ArrayList<Integer> generateRandomArray() {
        @NotNull final ArrayList<Integer> result = new ArrayList<>(MAX_SIZE);
        @NotNull final Random generator = new Random(System.nanoTime());
        for (int i = 0; i < MAX_SIZE; ++i) {
            result.add(generator.nextInt(MAX_NUM));
        }

        return result;
    }

    /**
     * Benchmark sortMethod on list
     *
     * @param list       list to be sorted
     * @param sortMethod Sorting method
     * @param length     The length of list
     * @return time sortMethod took to sort list in nanoseconds
     */
    private static long benchmark(@NotNull final ArrayList<Integer> list, @NotNull final AbstractSort sortMethod, final int length) {
        final long currentTime = System.nanoTime();
        sortMethod.sort(list, length);
        return System.nanoTime() - currentTime;
    }

    /**
     * Benchmark sortMethod on list, without changing any element in this list
     *
     * @param list       list to be tested on
     * @param sortMethod sorting method
     */
    private static void benchmarkWithoutChangeOfArray(@NotNull final ArrayList<Integer> list, @NotNull final AbstractSort sortMethod) {
        for (int i = 1; i < MAX_SIZE; ++i) {
            System.out.print(i);
            System.out.print('\t');
            System.out.println(benchmark(list, sortMethod, i));
            System.gc(); //I DO NOT WANT TO GC when BENCHMARKING
        }
    }

    /**
     * Benchmark all sorting methods with sorted list
     *
     * @throws FileNotFoundException just in case
     */
    private static void caseA() throws FileNotFoundException {
        @NotNull final ArrayList<Integer> list = generateSortedArray();
        AbstractSort sortMethod;

        System.setOut(new PrintStream("caseA_AS"));
        sortMethod = new AbstractSort();
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortDrown();
        System.setOut(new PrintStream("caseA_BSD"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortPop();
        System.setOut(new PrintStream("caseA_BSP"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new MergeSort();
        System.setOut(new PrintStream("caseA_MS"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new QuickSort();
        System.setOut(new PrintStream("caseA_QS"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new SelectSort();
        System.setOut(new PrintStream("caseA_SS"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();
    }

    /**
     * Benchmark sortMethod on list, with changing last element to random element.
     *
     * @param list       list, which will be sorted
     * @param sortMethod sorting method
     */
    private static void benchmarkCaseB(@NotNull final ArrayList<Integer> list, @NotNull final AbstractSort sortMethod) {
        @NotNull final Random generator = new Random(System.nanoTime());
        @NotNull final ArrayList<Integer> listCopy = new ArrayList<>(list);
        final ListIterator<Integer> iterator = listCopy.listIterator(MAX_SIZE);

        for (int i = MAX_SIZE - 1; i > 0; --i) {
            iterator.previous();
            iterator.set(generator.nextInt(MAX_NUM));
            System.out.print(i);
            System.out.print('\t');
            System.out.println(benchmark(listCopy, sortMethod, i));
            System.gc();
        }
    }

    /**
     * Benchmark all sorting methods on list, which are sorted, except last element
     *
     * @throws FileNotFoundException just in case
     */
    private static void caseB() throws FileNotFoundException {
        @NotNull final ArrayList<Integer> list = generateReverseSortedArray();
        AbstractSort sortMethod;

        System.setOut(new PrintStream("caseB_AS"));
        sortMethod = new AbstractSort();
        benchmarkCaseB(list, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortDrown();
        System.setOut(new PrintStream("caseB_BSD"));
        benchmarkCaseB(list, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortPop();
        System.setOut(new PrintStream("caseB_BSP"));
        benchmarkCaseB(list, sortMethod);
        System.out.close();

        sortMethod = new MergeSort();
        System.setOut(new PrintStream("caseB_MS"));
        benchmarkCaseB(list, sortMethod);
        System.out.close();

        sortMethod = new QuickSort();
        System.setOut(new PrintStream("caseB_QS"));
        benchmarkCaseB(list, sortMethod);
        System.out.close();

        sortMethod = new SelectSort();
        System.setOut(new PrintStream("caseB_SS"));
        benchmarkCaseB(list, sortMethod);
        System.out.close();
    }

    /**
     * Benchmark all sorting methods on list, that sorted in reverse direction
     *
     * @throws FileNotFoundException just in case
     */
    private static void caseC() throws FileNotFoundException {
        @NotNull final ArrayList<Integer> list = generateReverseSortedArray();
        AbstractSort sortMethod;

        System.setOut(new PrintStream("caseC_AS"));
        sortMethod = new AbstractSort();
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortDrown();
        System.setOut(new PrintStream("caseC_BSD"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortPop();
        System.setOut(new PrintStream("caseC_BSP"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new MergeSort();
        System.setOut(new PrintStream("caseC_MS"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new QuickSort();
        System.setOut(new PrintStream("caseC_QS"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new SelectSort();
        System.setOut(new PrintStream("caseC_SS"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

    }

    /**
     * Benchmark all sorting methods on random list
     *
     * @throws FileNotFoundException just in case
     */
    private static void caseD() throws FileNotFoundException {
        @NotNull final ArrayList<Integer> list = generateRandomArray();
        AbstractSort sortMethod;

        System.setOut(new PrintStream("caseD_AS"));
        sortMethod = new AbstractSort();
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortDrown();
        System.setOut(new PrintStream("caseD_BSD"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new BubbleSortPop();
        System.setOut(new PrintStream("caseD_BSP"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new MergeSort();
        System.setOut(new PrintStream("caseD_MS"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new QuickSort();
        System.setOut(new PrintStream("caseD_QS"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
        System.out.close();

        sortMethod = new SelectSort();
        System.setOut(new PrintStream("caseD_SS"));
        benchmarkWithoutChangeOfArray(list, sortMethod);
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
