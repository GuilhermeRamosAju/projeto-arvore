package GenericTree;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GenericTree<String> tree = null;

        try {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("0. Criar árvore genérica");
                System.out.println("1. Adicionar filho");
                System.out.println("2. Remover filho");
                System.out.println("4. Exibir árvore");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        System.out.print("Valor da raiz: ");
                        String rootValue = scanner.next();
                        tree = new GenericTree<String>(new Node<>(rootValue));
                        System.out.println("Árvore criada!");
                        break;
                
                    case 1:
                        if (tree == null) {
                            System.out.println("Crie a árvore antes de adicionar qualquer filho(opção 0).");
                            break;
                        }

                        System.out.print("Valor do nó pai: ");
                        String parent = scanner.next();
                        System.out.print("Valor do nó filho: ");
                        String child = scanner.next();

                        Node<String> parentNode = findNode(tree.getRoot(), parent);
                        if (parentNode != null) {
                            Node<String> childNode = new Node<>(child);
                            tree.addChild(parentNode, childNode);
                            System.out.println("Nó adicionado!");
                        } else {
                            System.out.println("Nó pai não encontrado!");
                        }
                        break;

                    case 2:
                        if (tree == null) {
                            System.out.println("Crie a árvore antes de adicionar qualquer filho(opção 0).");
                            break;
                        }

                        System.out.print("Valor do nó pai: ");
                        String parentToRemove = scanner.next();
                        System.out.print("Valor do nó filho que será removido: ");
                        String childToRemove = scanner.next();

                        Node<String> parentToRemoveNode = findNode(tree.getRoot(), parentToRemove);
                        if (parentToRemoveNode != null) {
                            Node<String> childToRemoveNode = findNode(parentToRemoveNode, childToRemove);
                            if (childToRemoveNode != null) {
                                tree.removeChild(parentToRemoveNode, childToRemoveNode);
                                System.out.println("Nó removido!");
                            } else {
                                System.out.println("Nó filho não encontrado!");
                            }
                        } else {
                            System.out.println("Nó pai não encontrado!");
                        }
                        break;

                    case 4:
                        if (tree == null) {
                            System.out.println("Crie a árvore antes de exibi-la(opção 0).");
                            break;
                        }
                        tree.printTree();
                        break;

                    case 3:
                        System.out.println("Encerrando...");
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static Node<String> findNode(Node<String> node, String value) {
        if (node == null || node.getValue().equals(value)) {
            return node;
        }

        for (Node<String> child : node.getChildren()) {
            Node<String> result = findNode(child, value);
            if (result != null) {
                return result;
            }
        }

        return null;
    }
}
