package DSA_HW4;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> traversal = new ArrayList<>();
        preorderRecur(traversal, root);
        return traversal;
    }

    private void preorderRecur(List<T> traversal, TreeNode<T> node) {
        if(node == null)
            return;
        else {
            traversal.add(node.getData());
            preorderRecur(traversal, node.getLeft());
            preorderRecur(traversal, node.getRight());
        }
    }
    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> traversal = new ArrayList<>();
        inorderRecur(traversal, root);
        return traversal;
    }

    private void inorderRecur(List<T> traversal, TreeNode<T> node) {
        if(node == null)
            return;
        else {
            inorderRecur(traversal, node.getLeft());
            traversal.add(node.getData());
            inorderRecur(traversal, node.getRight());
        }
    }
    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> traversal = new ArrayList<>();
        postorderRecur(traversal, root);
        return traversal;
    }
    private void postorderRecur(List<T> traversal, TreeNode<T> node) {
        if(node == null)
            return;
        else {
            postorderRecur(traversal, node.getLeft());
            postorderRecur(traversal, node.getRight());
            traversal.add(node.getData());
        }
    }
}