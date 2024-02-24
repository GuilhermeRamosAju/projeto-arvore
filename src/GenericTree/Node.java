// Criação do nó genérico, com os atributos e métodos necessários.

package GenericTree;
import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private T value;
    private Node<T> parent;
    private List<Node<T>> uncles;
    private List<Node<T>> children;
    private List<Node<T>> sibling;
    private List<Node<T>> cousin;
    private List<Node<T>> ancestral;
    private int level;

    public Node(T value) {
        this.value = value;
        this.parent = null;
        this.children = new ArrayList<>();
        this.sibling = new ArrayList<>();
        this.cousin = new ArrayList<>();
        this.ancestral = new ArrayList<>();
        this.level = 0;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getUncles() {
        return uncles;
    }

    public void setUncles(List<Node<T>> uncles) {
        this.uncles = uncles;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    public List<Node<T>> getSibling() {
        return sibling;
    }

    public void setSibling(List<Node<T>> sibling) {
        this.sibling = sibling;
    }

    public List<Node<T>> getCousin() {
        return cousin;
    }

    public void setCousin(List<Node<T>> cousin) {
        this.cousin = cousin;
    }

    public List<Node<T>> getAncestral() {
        return ancestral;
    }

    public void setAncestral(List<Node<T>> ancestral) {
        this.ancestral = ancestral;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
