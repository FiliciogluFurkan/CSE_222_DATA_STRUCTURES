
public class AVLTree {
    private class Node {
        Stock stock;
        Node left, right;
        int height;

        Node(Stock stock) {
            this.stock = stock;
            this.height = 1;
        }
    }

    private Node root;

    public void insert(Stock stock) {//insert method
        root = insert(root, stock);
    }

    private Node insert(Node node, Stock stock) {
     
            if (node == null) { //if node is null
                return new Node(stock);
            } 
            
                int k = node.stock.getSymbol().compareTo(stock.getSymbol());//it returns a value as -1,0,1
                if (k > 0) { //if k is 1
                    node.left = insert(node.left, stock);//if stock is bigger than node's stock,call insert function with left node
                } 
                else if (k < 0) { //if k is -1
                    node.right = insert(node.right, stock); //call insert function with right node
                }
                else {
                    return node;
                }
                
                node.height = Math.max(height(node.left), height(node.right)) + 1; //we determine the height of the node
                int heightDiff = heightDiff(node);
                if (heightDiff < -1) { //if the difference between the height of the left and right subtree is negative
                    if (heightDiff(node.right) > 0) { //if height of the right subtree is positive
                        node.right = rotateRight(node.right); //we rotate the right subtree to the left
                        return rotateLeft(node); //we rotate the node to the left
                    } else {
                        return rotateLeft(node); //if the difference between the height of the left and right subtree is negative and the height of the right subtree is negative
                    }     //it rotates the node to the left
                } else if (heightDiff > 1) {//if the difference between the height of the left and right subtree is positive
                    if (heightDiff(node.left) < 0) { //if height of the left subtree is negative
                        node.left = rotateLeft(node.left);
                        return rotateRight(node);//we rotate the node to the right
                    } else {
                        return rotateRight(node); //we rotate the node to the right
                    }
                }
return node;
    
    }
	private int heightDiff(Node n) { //it finds the difference between the height of the left and right subtree
        if (n == null) { //if the node is null
            return 0; //return 0
        }
        return height(n.left) - height(n.right); //return statement
    }

    private int height(Node node) {//finds the height of the node
        if (node == null) { 
            return 0;
        }
        
        int leftHeight = (node.left != null) ? node.left.height : 0;  //it gets the height of the left subtree
        int rightHeight = (node.right != null) ? node.right.height : 0;//it gets the height of the right subtree

        return 1 + Math.max(leftHeight, rightHeight); //it returns the height of the node
    }


    private int getBalance(Node node) { //it controls that the difference between the height of the left and right subtree is 0,1,or -1
        if (node == null) {
            return 0;
        }

        int leftHeight = (node.left != null) ? node.left.height : 0;
        int rightHeight = (node.right != null) ? node.right.height : 0;

        return leftHeight - rightHeight;  //it returns the difference between the height of the left and right subtree
    }

	private Node rotateRight(Node node) { //it rotates the right
	    Node node1 = node.left;
        node.left = node1.right;
        node1.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        node1.height = Math.max(height(node1.left), height(node1.right)) + 1;
        return node1;
	}

	private Node rotateLeft(Node node) { //it rotates the left
		
		    Node temp = node.right;
	        node.right = temp.left;
	        temp.left = node;
	        node.height = Math.max(height(node.left), height(node.right)) + 1;
	        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
	        return temp;
	}

	private Node findMin(Node node) {   //it finds the minimum node in the tree
    //this method will be used in the delete method
        while (node.left != null) {
            node = node.left;
        }
        return node; //returns that node
    }
    public Stock search(String symbol) { //search method
        Node result = search(root, symbol); //it searches the tree for the symbol.We will do this as recursion
        return (result != null) ? result.stock : null;
    }

    private Node search(Node node, String symbol) { //recursion method for search
        if (node == null || node.stock.getSymbol().equals(symbol)) { //if the node is null or the symbol is equal to the symbol of the node
            return node; //return that node
        }

        if (symbol.compareTo(node.stock.getSymbol()) < 0) { //if the symbol is smaller than the symbol of the node
            return search(node.left, symbol); //continue the search in the left subtree
        }
        else {
            return search(node.right, symbol); //continue the search in the right subtree
        }
    }
    
    
    public void delete(String symbol) {
        // Search for the node and delete if found
        root = delete(root, symbol);
    }

    private Node delete(Node node, String symbol) {
        if (node == null) {
            return null; // Node not found
        }

        // Recursively traverse based on symbol
        if (symbol.compareTo(node.stock.getSymbol()) < 0) {
            node.left = delete(node.left, symbol);
        } else if (symbol.compareTo(node.stock.getSymbol()) > 0) {
            node.right = delete(node.right, symbol);
        } else { // Node to be deleted found

            // Handle different node cases
            if (node.left == null && node.right == null) {
                return null; // Leaf node - simply remove
            } else if (node.left == null) {
                return node.right; // One child - promote the child
            } else if (node.right == null) {
                return node.left;
            } else { // Two children - find in-order successor
                Node smallestRight = findMin(node.right);
                node.stock = smallestRight.stock;
                node.right = delete(node.right, smallestRight.stock.getSymbol());
            }
        }

        // Update height after subtree modifications
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Check balance factor for potential imbalances
        int balance = getBalance(node);

        // Perform rotations to maintain balance (AVL property)
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        } else if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        } else if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        } else if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }
    //Print methods

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.stock);
            inOrderTraversal(node.right);
        }
    }
    public void preOrderTraveresal() {
    	preOrderTraversal(root);
    }
    private void preOrderTraversal(Node node) {
    	if (node != null) {
            System.out.println(node.stock + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    
    public void postOrderTraveresal() {
    	postOrderTraversal(root);
    }
    private void postOrderTraversal(Node node) {
    	if(node!=null) {
               preOrderTraversal(node.left);
               preOrderTraversal(node.right);
      		   System.out.println(node.stock + " ");
    	}
    }
    
    
    
    
}
