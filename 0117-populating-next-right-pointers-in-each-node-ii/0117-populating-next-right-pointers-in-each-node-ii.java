/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    public Node(int _val) { val = _val; }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node current = root; // current node of current level
        Node nextHead = null; // head of the next level
        Node prev = null; // previous node in the next level

        while (current != null) {
            while (current != null) {
                if (current.left != null) {
                    if (prev != null) {
                        prev.next = current.left;
                    } else {
                        nextHead = current.left;
                    }
                    prev = current.left;
                }
                if (current.right != null) {
                    if (prev != null) {
                        prev.next = current.right;
                    } else {
                        nextHead = current.right;
                    }
                    prev = current.right;
                }
                current = current.next; // move along the current level
            }
            // Move to the next level
            current = nextHead;
            nextHead = null;
            prev = null;
        }

        return root;
    }
}
