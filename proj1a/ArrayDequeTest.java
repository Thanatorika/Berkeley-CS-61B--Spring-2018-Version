import org.junit.Test;

import static org.junit.Assert.*;

/** Performs some basic array tests. */
public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkItem(Object expected, Object actual) {
        if (expected != actual) {
            System.out.println("get() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    @Test
    public void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> ad1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, ad1.size()) && passed;
        passed = checkEmpty(false, ad1.isEmpty()) && passed;

        ad1.addLast("middle");
        passed = checkSize(2, ad1.size()) && passed;

        ad1.addLast("back");
        passed = checkSize(3, ad1.size()) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();
        System.out.println();

        printTestStatus(passed);

    }

    @Test
    public void AddGetTest() {
        System.out.println("Running add/get test.");

        ArrayDeque<String> ad1 = new ArrayDeque<>();

        ad1.addFirst("front");
        ad1.addLast("middle");
        ad1.addLast("back");
        ad1.addFirst(("new-front"));

        System.out.println("Printing out deque: ");
        ad1.printDeque();
        System.out.println();

        String got = ad1.get(3);

        boolean passed = checkItem("back", got);

        printTestStatus(passed);
    }

    @Test
    public void runAllTests() {
        addIsEmptySizeTest();
    }
}
