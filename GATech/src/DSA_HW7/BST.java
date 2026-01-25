package DSA_HW7;

import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

     /**
     * Returns the data from the tree matching the given parameter.
     *
     * This should be done recursively.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to search for. You may assume data is never null.
     * @return The data in the tree equal to the parameter.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
     */
    public T get(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        return getRecur(root, data).getData();

    }

    private BSTNode<T> getRecur(BSTNode<T> curr, T data) {
        if(curr.getData().equals(data))
            return curr;
        if(curr.getData().compareTo(data) > 0)
            return getRecur(curr.getLeft(), data);
        else if(curr.getData().compareTo(data) > 0)
            return getRecur(curr.getRight(), data);
        else
            throw new java.util.NoSuchElementException("Error: some exception was thrown");
    }
    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the PREDECESSOR to
     * replace the data. You should use recursion to find and remove the
     * predecessor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove. You may assume that data is never null.
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        BSTNode<T> dummy = new BSTNode<T>(null);
        root = removeRecur(root, data, dummy);
        return dummy.getData();        
    }

    private BSTNode<T> removeRecur(BSTNode<T> curr, T data, BSTNode<T> dummy) {
        if(curr == null)
            throw new java.util.NoSuchElementException("Error: some exception was thrown");
        if(curr.getData().compareTo(data) > 0)
            curr.setLeft(removeRecur(curr.getLeft(), data, dummy));
        else if(curr.getData().compareTo(data) < 0)
            curr.setRight(removeRecur(curr.getRight(), data, dummy));
        else {
            dummy.setData(curr.getData());
            size--;
            if(curr.getLeft() == null && curr.getRight() == null)
                return null;
            else if(curr.getLeft() == null)
                return curr.getRight();
            else if(curr.getRight() == null)
                return curr.getLeft();
            else {
                BSTNode<T> dummy2 = new BSTNode<>(null);
                curr.setLeft(removePredecessor(curr.getLeft(), dummy2));
                curr.setData(dummy2.getData());            
            }            
        }
        return curr;
    }

    private BSTNode<T> removePredecessor(BSTNode<T> curr, BSTNode<T> dummy2) {
        if(curr.getRight() == null) {
            dummy2.setData(curr.getData());
            return curr.getLeft();
        }
        else {
            curr.setRight(removePredecessor(curr.getRight(), dummy2));
        }
        return curr;
    }


    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}