package solutions.pack10;

public class TreeNode_660988 {
    int data;
    TreeNode_660988 left, right, parent;

    public TreeNode_660988(int d) {
        data = d;
    }

    @Override
    public String toString() {
        String leftChild = (left != null) ? String.valueOf(left.data) : "null";
        String rightChild = (right != null) ? String.valueOf(right.data) : "null";
        return leftChild + "<-" + data + "->" + rightChild;
    }
}
