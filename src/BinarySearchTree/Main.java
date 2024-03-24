package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(45);
        tree.insert(10);
        tree.insert(50);
            System.out.println("LEFT::: " + tree.getRoot().getLeft().getValue()+ "\n"
                    + "NODE::: " + tree.getRoot().getValue() + "\n"
                    + "RIGHT::: " + tree.getRoot().getRight().getValue());
    }
}
