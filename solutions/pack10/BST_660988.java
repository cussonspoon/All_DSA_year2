package solutions.pack10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BST_660988 {
    TreeNode_660988 root;

    public BST_660988() {
        root = null;
    }

    public TreeNode_660988 getRoot() {
        return root;
    }

    public TreeNode_660988 searchRecurse(int d, TreeNode_660988 node) {
        if (node == null)
            return null;
        if (d == node.data)
            return node;
        if (d < node.data)
            return searchRecurse(d, node.left);
        return searchRecurse(d, node.right);
    }

    public TreeNode_660988 search(int d) {
        return searchRecurse(d, root);
    }

    public void insert(int d) {
        if (root == null) {
            root = new TreeNode_660988(d);
            return;
        }
        TreeNode_660988 current = root;
        while (current != null) {
            if (d < current.data) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode_660988(d);
                    current.left.parent = current;
                    return;
                }
            } else { // ! (d < current.data)
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode_660988(d);
                    current.right.parent = current;
                    return;
                }
            }
        } // while
    }

    public void delete(int d) {
        deleteRecurse(d, root);
    }

    public void deleteRecurse(int d, TreeNode_660988 node) {
        if (node == null)
            return;

        if (d < node.data) {
            deleteRecurse(d, node.left);
        } else if (d > node.data) {
            deleteRecurse(d, node.right);
        } else {
            // Case 1: Node with one child or no child
            if (node.left == null || node.right == null) {
                TreeNode_660988 temp = (node.left != null) ? node.left : node.right;

                if (temp == null) { // No child case
                    if (node == root) {
                        root = null; // If the root is to be deleted
                    } else {
                        if (node.parent.left == node) {
                            node.parent.left = null;
                        } else {
                            node.parent.right = null;
                        }
                    }
                } else { // One child case
                    temp.parent = node.parent; // Link the parent to the new child
                    if (node == root) {
                        root = temp; // If the root is to be replaced
                    } else {
                        if (node.parent.left == node) {
                            node.parent.left = temp;
                        } else {
                            node.parent.right = temp;
                        }
                    }
                }
            } else { // Case 2: Node with two children
                // Find max in the left subtree
                TreeNode_660988 maxNode = findMaxFrom(node.left);
                node.data = maxNode.data; // Replace node data with maxNode data
                deleteRecurse(maxNode.data, maxNode); // Delete the maxNode
            }
        }
    }

    private TreeNode_660988 findMaxFrom(TreeNode_660988 node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /* Printing */
    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }

    private void printInOrderRecurse(TreeNode_660988 node) {
        if (node == null)
            return;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }

    public int count() {
        return countRecurse(root);
    }

    public int countRecurse(TreeNode_660988 node) {
        if (node == null) {
            return 0; // Base case
        }
        //Count this node plus the count of left and right subtrees
        return 1 + countRecurse(node.left) + countRecurse(node.right);
    }

    public void printPreOrderRecurse(TreeNode_660988 node) {
        if (node == null)
            return;
        System.out.println(node.data + " ");
        printPreOrderRecurse(node.left);
        printPreOrderRecurse(node.right);
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
    }

    public void printPostOrderRecurse(TreeNode_660988 node) {
        if (node == null)
            return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.println(node.data + " ");
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
    }

    public TreeNode_660988 findMaxRecurse(TreeNode_660988 node) {
        if (node.right == null) {
            return node;
        }
        return findMaxRecurse(node.right);
    }

    public TreeNode_660988 findMax() {
        return findMaxRecurse(root);
    }

    public TreeNode_660988 findMinRecurse(TreeNode_660988 node) {
        if (node.left == null) {
            return node;
        }
        return findMinRecurse(node.left);
    }

    public TreeNode_660988 findMin() {
        return findMinRecurse(root);
    }

    public int height() {
        return heightRecurse(root);
    }

    private int heightRecurse(TreeNode_660988 node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(heightRecurse(node.left), heightRecurse(node.right));
    }

    public double findMedian() {
        int n = count();
        if (n == 0)
            return 0;

        List<Integer> inorderList = new ArrayList<>();
        findMedianRecurse(root, inorderList);

        if (n % 2 == 1) {
            return inorderList.get(n / 2);
        } else {
            return (inorderList.get(n / 2 - 1) + inorderList.get(n / 2)) / 2.0;
        }
    }

    private void findMedianRecurse(TreeNode_660988 node, List<Integer> list) {
        if (node == null)
            return;
        findMedianRecurse(node.left, list);
        list.add(node.data);
        findMedianRecurse(node.right, list);
    }

    public int findRank(int value) {
        AtomicInteger rank = new AtomicInteger(0);
        AtomicInteger result = new AtomicInteger(-1);
        findRankRecurse(root, value, rank, result);
        if (result.get() != -1) {
            return result.get() + 1;
        }
        return -1;
    }
    
    private void findRankRecurse(TreeNode_660988 node, int value, AtomicInteger rank, AtomicInteger result) {
        if (node == null) return;
    
        findRankRecurse(node.left, value, rank, result);
    
        if (result.get() == -1) {
            if (node.data == value) {
                result.set(rank.get());
            } else {
                rank.incrementAndGet();
            }
        }
    
        findRankRecurse(node.right, value, rank, result);
    }
}
