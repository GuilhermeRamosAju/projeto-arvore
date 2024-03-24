package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
  private Node root;
  private int treeLevel;
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

    int leftDepth = getTreeDepth(node.getLeft());
    int rightDepth = getTreeDepth(node.getRight());

    return Math.max(leftDepth, rightDepth) + 1;
  }

}
