package DSA_HW6;

import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null)
            throw new java.lang.IllegalArgumentException("Error: some exception was thrown");
        if(size == backingArray.length - 1)
            resize(); 
        size++;
        backingArray[size] = data;
        upHeap(size);
    }

    private void upHeap(int index) {
        if(index == 1)
            return;
        if(backingArray[index].compareTo(backingArray[index/2]) < 0) {
            T temp = backingArray[index];
            backingArray[index] = backingArray[index/2];
            backingArray[index/2] = temp;
            upHeap(index/2);
        }
    }

    private void resize() {
        T[] newBackingArray = (T[]) new Comparable[backingArray.length * 2];
        for (int i = 0; i <= size; i++) {
            newBackingArray[i] = backingArray[i];
        }
        backingArray = newBackingArray;
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(size == 0)
            throw new java.util.NoSuchElementException("Error: some exception was thrown");
        T dataToReturn = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;
        downHeap(1);
        return dataToReturn;
    }

    private void downHeap(int index) {
        if(2*index > size) {
            return;
        }
        else if(2*index + 1 > size) {
            if(backingArray[index].compareTo(backingArray[2*index]) < 0)
                return;
            else {
                T temp = backingArray[index];
                backingArray[index] = backingArray[2*index];
                backingArray[2*index] = temp;
                return;
            }
        }
        else {
            int indexToReturn = backingArray[2*index].compareTo(backingArray[2*index + 1]) < 0 ? 2*index : 2*index + 1;
            if(backingArray[index].compareTo(backingArray[indexToReturn]) < 0)
                return;
            T temp = backingArray[index];
            backingArray[index] = backingArray[indexToReturn];
            backingArray[indexToReturn] = temp;
            downHeap(indexToReturn);
        }
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}