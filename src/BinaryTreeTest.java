public class BinaryTreeTest {
    public static void main(String[] args) {
        
    
      BinaryTree tree = new BinaryTree();
        
        System.out.println("=== Часть 1: Базовые методы обхода ===");
        tree.insertLevelOrder(1);
        tree.insertLevelOrder(2);
        tree.insertLevelOrder(3);
        tree.insertLevelOrder(4);
        tree.insertLevelOrder(5);
        tree.printTreeInfo();
        
        System.out.println("\n=== Часть 2: Полное бинарное дерево ===");
        BinaryTree fullTree = new BinaryTree();
        fullTree.createFullBinaryTree();
        fullTree.printTreeInfo();
        
        System.out.println("\n=== Часть 3: Бинарное дерево поиска ===");
        BinaryTree bst = new BinaryTree();
        int[] numbers = {50, 30, 70, 20, 40, 60, 80};
        bst.build(numbers);
        System.out.print("In-order обход BST (должен быть отсортирован): ");
        bst.inOrder(bst.root);
        
        System.out.println("\n\n=== Часть 4: Сбалансированное дерево ===");
        BinaryTree balancedTree = new BinaryTree();
        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        balancedTree.root = balancedTree.sortedArrayTo(sortedArray, 0, sortedArray.length - 1);
        System.out.println("Высота сбалансированного дерева: " + balancedTree.height(balancedTree.root));
        System.out.print("In-order обход: ");
        balancedTree.inOrder(balancedTree.root);
        
        System.out.println("\n\n=== Часть 5: Операции с деревом ===");
        BinaryTree operationsTree = new BinaryTree();
        for (int i = 1; i <= 10; i++) {
            operationsTree.insertLevelOrder(i);
        }
        
        System.out.println("Дерево перед удалением:");
        operationsTree.levelOrder(operationsTree.root);
        
        operationsTree.delete(3); 
        
        System.out.println("\nДерево после удаления узла 3:");
        operationsTree.levelOrder(operationsTree.root);
    }
}
