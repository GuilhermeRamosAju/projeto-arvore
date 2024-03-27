package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;
    private List<Node> nodes;

    public BinarySearchTree() {
        this.root = null;
        this.nodes = new ArrayList<>();
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            nodes.add(root);
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (value < current.getValue()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        nodes.add(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        nodes.add(newNode);
                        return;
                    }
                }
            }
        }
    }

    public int getNodeLevel(Node node, int value) {

        if (node.getValue() == value) {
            return 0;
        } else if (value < node.getValue()) {
            return 1 + getNodeLevel(node.getLeft(), value);
        } else {
            return 1 + getNodeLevel(node.getRight(), value);
        }

    }

    public int getTreeLevel(Node node) {
        if (node == null) {
            return -1;
        }
        int leftLevel = getTreeLevel(node.getLeft());
        int rightLevel = getTreeLevel(node.getRight());

        return Math.max(leftLevel, rightLevel) + 1;
    }


    public void printNodeDepth() {
        printNodeDepth(root, 0);
    }

    private void printNodeDepth(Node node, int depth) {
        if (node == null) {
            return;
        }

        System.out.println("Valor: " + node.getValue() + ", Profundidade: " + depth);

        printNodeDepth(node.getLeft(), depth + 1);
        printNodeDepth(node.getRight(), depth + 1);
    }

    public int getTreeDepth() {
        return getTreeDepth(root);
    }

    private int getTreeDepth(Node node) {
        if (node == null || (node.getLeft() == null && node.getRight() == null)) {
            return 0;
        }

        int leftDepth = getTreeDepth(node.getLeft());
        int rightDepth = getTreeDepth(node.getRight());

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int nodeHeight(Node node) {
        if (node == null || (node.getLeft() == null && node.getRight() == null))
            return 0;

        int leftHeight = nodeHeight(node.getLeft());
        int rightHeight = nodeHeight(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int treeHeight(Node root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null))
            return 0;

        int leftHeight = treeHeight(root.getLeft());
        int rightHeight = treeHeight(root.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static void printNodeHeights(Node node, BinarySearchTree calculator) {
        if (node == null)
            return;

        System.out.println("Node value: " + node.getValue() + ", Height: " + (calculator.nodeHeight(node)));

        printNodeHeights(node.getLeft(), calculator);
        printNodeHeights(node.getRight(), calculator);
    }

    public void printTree(Node root) {
        if (root == null) {
            System.out.println("Árvore Inexistente!");
        }

        StringBuilder tree = new StringBuilder();

        for (Node node : nodes) {
            if (node == this.root) {
                tree.append(node.getValue()).append("\n");
                continue;
            }
            StringBuilder toAdd = new StringBuilder();
            for (int i = 1; i <= this.getTreeLevel(root); i++) {
                toAdd.append("  ");
                assert root != null;
                if (this.getNodeLevel(root, node.getValue()) == i) {
                    tree.append(toAdd.append(node.getValue()).append("\n"));
                }
            }
        }
        System.out.println(tree);
    }
}