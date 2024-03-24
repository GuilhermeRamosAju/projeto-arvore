package BinarySearchTree;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
  private Node root;
  private List<Node> nodes;


  public BinarySearchTree() {
    this.root = null;
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

  public int getNodeLevel(int value) {
    Node node = findNode(root, value);
    if (node.getValue() == root.getValue()){
      return 0;
    }
  }

}
