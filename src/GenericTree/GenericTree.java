// Criação da árvore genérica, com os métodos addChild, removeChild e printTree.
// Obs: a função printTree exibe os nós com seus respectivos níveis e os filhos vêm logo abaixo do pai.
package GenericTree;
import java.util.List;

public class GenericTree<T> {

    private Node<T> root;

    public GenericTree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void addChild(Node<T> parent, Node<T> child) {
        parent.getChildren().add(child);
        child.getAncestral().add(parent);
        child.setLevel(parent.getLevel() + 1);
    }

    public void removeChild(Node<T> parent, Node<T> child) {
        List<Node<T>> children = parent.getChildren();
        children.removeIf(node -> node.equals(child));
    }

    public void printTree() {
      printTree(root, 0);
  }

  private void printTree(Node<T> node, int level) {
      if (node == null) {
          return;
      }
      System.out.println("Level " + level + ": " + node.getValue());
      for (Node<T> child : node.getChildren()) {
          printTree(child, level + 1);
      }
  }
}


