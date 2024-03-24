package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
  private Node root;
  private int treeLevel;
  private List<Node> nodes;

  public BinarySearchTree() {
    this.root = null;
    this.treeLevel = 0;
  }

  public Node getRoot() {
    return root;
  }

  public void insert(int value) {
    Node newNode = new Node(value);
    if (root == null) {
      root = newNode;
      nodes = new ArrayList<>();
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

  public Node findNode(Node node, int value) {
    if (node.getValue() == value) {
      return node;
    } else if (value < node.getValue()) {
      return findNode(node.getLeft(), value);
    } else {
      return findNode(node.getRight(), value);
    }
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
    if (node == null) {
      return 0;
    }

    int leftDepth = getTreeDepth(node.getLeft());
    int rightDepth = getTreeDepth(node.getRight());

    return Math.max(leftDepth, rightDepth) + 1;
  }

}
