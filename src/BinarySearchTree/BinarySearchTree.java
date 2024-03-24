// Criação da árvore genérica, com os métodos addChild, removeChild e printTree.
// Obs: a função printTree exibe os nós com seus respectivos níveis e os filhos vêm logo abaixo do pai.
package BinarySearchTree;
import java.util.List;

public class BinarySearchTree<T> {
    public class Node{
        private int value;
        private Node left = null;
        private Node right = null;

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Node(int data) {
            value = data;
        }
    }
    Node root;

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree() {
        root = null;
    }

    public void delete(int value){
        root = deleteNode(root, value);
    }

    public Node deleteNode(Node root, int value){
        if (root == null)
            return root;
        if (value < root.value) {
            return deleteNode(root.left, value);
        } else if (value > root.value) {
            return deleteNode(root.right, value);
        }
        return root;
    }

    public void insert(int value){
        root = insertNode(root, value);
    }

    public Node insertNode(Node root, int value){
        if (root == null){
            root = new Node(value);
            return root;
        }
        if (value < root.value)
            root.left = insertNode(root.left, value);
        else if (value > root.value)
            root.right = insertNode(root.right, value);
        return root;
    }

    public boolean search(int value){
        root = searchNode(root, value);
        return root != null;
    }
    public Node searchNode(Node root, int value){
        if (root == null || root.value == value)
            return root;
        if (root.value > value){
            return searchNode(root.left, value);
        }
        return searchNode(root.right, value);
    }
}


