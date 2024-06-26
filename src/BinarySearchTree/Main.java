package BinarySearchTree;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo à árvore binária de busca!");
        System.out.println("Digite um valor para a raiz da árvore: ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(value);
        while (true) {
            System.out.println("Digite um valor para continuar a inserir na árvore ou '-1' para sair: ");
            value = scanner.nextInt();
            if (value == -1) {
                break;
            }
            tree.insert(value);
        }
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("0. Nível de um nó (digite o valor dele)");
            System.out.println("1. Nível da árvore");
            System.out.println("2. Profundidade de cada nó");
            System.out.println("3. Profundidade da árvore");
            System.out.println("4. Altura de cada nó");
            System.out.println("5. Altura da árvore");
            System.out.println("6. Imprimir árvore com identação");
            System.out.println("7. Imprimir nós no percurso LRN");
            System.out.println("8. Imprimir nós no percurso NLR");
            System.out.println("9. Imprimir nós no percurso LNR");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();

            Node root = tree.getRoot();
            switch (choice) {
                case 0:
                    System.out.print("Valor do nó: ");
                    int nodeValue = scanner.nextInt();
                    System.out.println("Nível do nó: " + tree.getNodeLevel(root, nodeValue));
                    break;
                case 1:
                    System.out.println("Nível da árvore: " + tree.getTreeLevel(root));
                    break;
                case 2:
                    tree.printNodeDepth();
                    break;
                case 3:
                    System.out.println("Profundidade da árvore: " + tree.getTreeDepth());
                    break;
                 case 4:
                     tree.printNodeHeights(root, tree);
                     break;
                 case 5:
                     System.out.println("Altura da árvore: " + tree.treeHeight(root));
                     break;
                 case 6:
                     tree.printTree(root, 0);
                     break;
                 case 7:
                     tree.printLRN(root);
                     break;
                 case 8:
                     tree.printNLR(root);
                     break;
                 case 9:
                     tree.printLNR(root);
                     break;
                 case 10:
                    scanner.close();
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

    }
}
