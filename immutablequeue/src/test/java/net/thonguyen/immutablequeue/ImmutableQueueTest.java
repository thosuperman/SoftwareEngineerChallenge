package net.thonguyen.immutablequeue;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * ImmutableQueue Unit Test
 */
public class ImmutableQueueTest {

    // For empty (null) testing
    private ImmutableQueue<String> emptyQueue = new ImmutableQueue<>();

    // For having data testing
    private ImmutableQueue<String> stringQueue = new ImmutableQueue<>();

    /**
     * Initiate for testing.
     */
    @Before
    public void setup() {
        stringQueue.enQueue("T");
        stringQueue.enQueue("H");
        stringQueue.enQueue("O");
    }

    /**
     * Test enQueue() with empty (null) Immutable Queue.
     */
    @Test(expected = NoSuchElementException.class)
    public void testEnQueueWithEmptyQueue() {
        emptyQueue.enQueue(null);
    }

    /**
     * Test deQueue() with empty (null) Immutable Queue.
     */
    @Test(expected = NoSuchElementException.class)
    public void testDeQueueWithEmptyQueue() {
        emptyQueue.deQueue();
    }

    /**
     * Test head() with empty (null) Immutable Queue.
     */
    @Test(expected = NoSuchElementException.class)
    public void testHeadWithEmptyQueue() {
        emptyQueue.head();
    }

    /**
     * Test isEmpty() with empty (null) Immutable Queue.
     * Expected: true
     */
    @Test
    public void testIsEmptyWithEmptyQueue() {
        assertTrue(emptyQueue.isEmpty());
    }

    /**
     * Test isEmpty() with String Immutable Queue.
     * Expected: false
     */
    @Test
    public void testIsEmptyWithStringQueue() {
        assertFalse(stringQueue.isEmpty());
    }

    /**
     * Test combine enQueue(), deQueue(), head(), isEmpty() with String Immutable Queue.
     */
    @Test
    public void testStringQueueWithTestCases() {
        // current queue: ["T", "H", "O"]
        // get first element, expected "T"
        assertEquals(stringQueue.head(), "T");
        // add new element to queue
        stringQueue.enQueue("N");
        // current queue: ["T", "H", "O", "N"]
        // test deQueue(): remove first element
        stringQueue.deQueue();
        // now "H" become first element, test if it correct
        assertEquals(stringQueue.head(), "H");
        // do one more deQueue()
        stringQueue.deQueue();
        // now "O" become first element, test if it correct
        assertEquals(stringQueue.head(), "O");
        // now queue has 2 elements: ["O", "N"], do deQueue() 2 times to make it empty
        stringQueue.deQueue();
        stringQueue.deQueue();
        // test head(), expected: NoSuchElementException
        try {
            stringQueue.head();
        } catch (NoSuchElementException expectedException) {
            assertEquals(expectedException.getClass().toString(), "class java.util.NoSuchElementException");
        }
        // test isEmpty(), expected: true
        assertTrue(stringQueue.isEmpty());
    }
}
