package BinarySearchTree;

public class Node {
  private int value;
  private Node left;
  private Node right;

  public Node(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public Node findNode(Node node, int value) {
    if (node.getValue() == value) {
      return node;
    }else if (value < node.getValue()) {
      return findNode(node.getLeft(), value);
    } else {
      return findNode(node.getRight(), value);
    }
  }
}
