import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node { 
    public int data;
    public Node left, right;
    
    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTree {
      Node root;
    
    public BinaryTree() {
        root = null;
    }
    
    public void preOrder(Node node) {
        if (node == null) return;
        
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void inOrder(Node node) {
        if (node == null) return;
        
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
    public void postOrder(Node node) {
        if (node == null) return;
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    
    public void levelOrder(Node root) {
        if (root == null) return;
        
        List<Node> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        
        while (!currentLevel.isEmpty()) {
            List<Node> nextLevel = new ArrayList<>();
            
            for (Node node : currentLevel) {
                System.out.print(node.data + " ");
                
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            
            currentLevel = nextLevel;
        }
    }
    
    public int height(Node node) {
        if (node == null) return 0;
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    
    public boolean isFull(Node node) {
        if (node == null) return true;
        
        if (node.left == null && node.right == null) return true;
        
        if (node.left != null && node.right != null) {
            return isFull(node.left) && isFull(node.right);
        }
        
        return false;
    }
    
    public void createFullBinaryTree() {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
    }
    
    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        
        return node;
    }
    
    public void build(int[] numbers) {
        for (int num : numbers) {
            root = insert(root, num);
        }
    }
    
    public Node search(Node node, int key) {
        if (node == null || node.data == key) {
            return node;
        }
        
        if (key < node.data) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
    
    public Node sortedArrayTo(int[] arr, int start, int end) {
        if (start > end) return null;
        
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        
        node.left = sortedArrayTo(arr, start, mid - 1);
        node.right = sortedArrayTo(arr, mid + 1, end);
        
        return node;
    }
    
    public void insertLevelOrder(int data) {
        Node newNode = new Node(data);
        
        if (root == null) {
            root = newNode;
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.left == null) {
                current.left = newNode;
                break;
            } else {
                queue.add(current.left);
            }
            
            if (current.right == null) {
                current.right = newNode;
                break;
            } else {
                queue.add(current.right);
            }
        }
    }
    
    public void delete(int key) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            if (root.data == key) {
                root = null;
            }
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        Node keyNode = null;
        Node deepestNode = null;
        Node parentOfDeepest = null;
        
        while (!queue.isEmpty()) {
            deepestNode = queue.poll();
            
            if (deepestNode.data == key) {
                keyNode = deepestNode;
            }
            
            if (deepestNode.left != null) {
                parentOfDeepest = deepestNode;
                queue.add(deepestNode.left);
            }
            
            if (deepestNode.right != null) {
                parentOfDeepest = deepestNode;
                queue.add(deepestNode.right);
            }
        }
        
        if (keyNode != null && deepestNode != null) {
            keyNode.data = deepestNode.data;
            
            if (parentOfDeepest.right == deepestNode) {
                parentOfDeepest.right = null;
            } else {
                parentOfDeepest.left = null;
            }
        }
    }
   
    public void printTreeInfo() {
        System.out.println("\nИнформация о дереве:");
        System.out.println("Высота дерева: " + height(root));
        System.out.println("Полное бинарное дерево? " + isFull(root));
        
        System.out.print("Pre-order: ");
        preOrder(root);
        
        System.out.print("\nIn-order: ");
        inOrder(root);
        
        System.out.print("\nPost-order: ");
        postOrder(root);
        
        System.out.print("\nLevel-order: ");
        levelOrder(root);
        System.out.println();
    }
}


