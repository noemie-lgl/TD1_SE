package heap;

import java.util.NoSuchElementException;

public interface Heap<Integer> extends Iterable<Integer> {


    /** Add specified element into this heap.Heap, increase capacity of the heap if not enough space
     *
     * @return true if the element was successfully added
     */
    boolean insertElement(Integer e);

    /**
     * Retrieves (without removing) the highest element of this heap
     *
     * @return the highest element of this heap
     * @throws NoSuchElementException if this heap is empty
     */
    Integer element();

    /**
     * Retrieves (and remove) the highest element of this heap
     *
     * @return the highest element of this heap
     * @throws NoSuchElementException if this heap is empty
     */
    Integer popElement();

    /** Returns true if this heap contains no elements. */
    boolean isEmpty();

    /** Returns the number of elements contained in this heap */
    int size();

}

