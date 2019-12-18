package net.thonguyen.immutablequeue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implement ImmutableQueue
 *
 * @param <T>
 */
public class ImmutableQueue<T> implements Queue<T> {

    /**
     * Initiate queue with help of LinkedList
     */
    private final LinkedList<T> queue;

    /**
     * Default public constructor
     */
    public ImmutableQueue() {
        this.queue = new LinkedList<>();
    }

    /**
     * Create new queue
     *
     * @param q LinkedList
     */
    private ImmutableQueue(LinkedList<T> q) {
        this.queue = q;
    }

    /**
     * Add element to the last of queue and return queue
     *
     * @param t element
     * @return queue
     */
    @Override
    public Queue<T> enQueue(T t) {
        if (t == null) {
            throw new NoSuchElementException();
        }
        this.queue.add(t);
        return new ImmutableQueue<>(this.queue);
    }

    /**
     * Remove the first element of queue and return queue
     *
     * @return queue
     */
    @Override
    public Queue<T> deQueue() {
        if (this.queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        this.queue.pollFirst();
        return new ImmutableQueue<>(this.queue);
    }

    /**
     * Get the first element of queue, if queue is null, return NoSuchElementException
     *
     * @return element | NoSuchElementException
     */
    @Override
    public T head() {
        if (this.queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.queue.getFirst();
    }

    /**
     * check if queue is empty (null) or not
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}