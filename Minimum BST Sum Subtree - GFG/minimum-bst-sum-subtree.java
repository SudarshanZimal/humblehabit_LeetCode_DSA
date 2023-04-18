//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int target;
            target = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.minSubtreeSumBST(target, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    //  int count= 0;
    //  int ans = 0;
    //  public void traverse ( Node root){
    //      if( root == null){
    //          return;
    //      }
    //      if( root.data != null){
    //      traverse(root.right);
    //      count++;
    //      ans+=right.data;
    //      }
    //  }
    // public static int minSubtreeSumBST(int target, Node root) {
    
    //   traverse(Node root);
      
    //  if( target == ans ){
    //      return count;
    //     }
     
     //return count;
     // Initialize the minimum subtree sum to the maximum possible integer value
int minSubtreeSum = Integer.MAX_VALUE;

// Function to find the minimum number of nodes in a subtree with a given sum
public int minSubtreeSumBST(int target, Node root) {
    // Reset the minimum subtree sum to the maximum possible integer value
    minSubtreeSum = Integer.MAX_VALUE;
    
    // Recursively solve the problem by traversing the tree
    solve(root, target);
    
    // If the minimum subtree sum was not updated during traversal, return -1
    if (minSubtreeSum == Integer.MAX_VALUE) {
        return -1;
    }
    
    // Otherwise, return the minimum subtree sum
    return minSubtreeSum;
}

// Helper function to solve the problem recursively by traversing the tree
private void solve(Node root, int target) {
    // If the root is null, return
    if (root == null) {
        return;
    }
    
    // If the root is a leaf node and its value matches the target, update the minimum subtree sum
    if (root.left == null && root.right == null) {
        if (root.data == target) {
            minSubtreeSum = 1;
            return;
        }
    }
    
    // If the current subtree is a binary search tree, get the sum of its nodes and check if it matches the target
    if (checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
        int[] count = {0};
        int sum = getSum(root, count);
        if (sum == target) {
            minSubtreeSum = Math.min(minSubtreeSum, count[0]);
        }
    }
    
    // Recursively solve the left and right subtrees
    solve(root.left, target);
    solve(root.right, target);
}


// Helper function to check if a given tree is a binary search tree
private boolean checkBST(Node root, int minVal, int maxVal) {
    // If the root is null, it is a valid BST
    if (root == null) {
        return true;
    }
    
    // If the root's data is outside the valid range, it is not a BST
    if (root.data < minVal || root.data > maxVal) {
        return false;
    }
    
    // Recursively check if the left and right subtrees are also BSTs
    return checkBST(root.left, minVal, root.data - 1) && checkBST(root.right, root.data + 1, maxVal);
}

// Helper function to get the sum of all nodes in a tree and count the number of nodes
private int getSum(Node root, int[] count) {
    // If the root is null, return 0
    if (root == null) {
        return 0;
    }
    
    // If the root is a leaf node, increment the node count and return its value
    if (root.left == null && root.right == null) {
        count[0]++;
        return root.data;
    }
    
    // Otherwise, increment the node count and recursively get the sum of the left and right subtrees
    count[0]++;
    return root.data + getSum(root.left, count) + getSum(root.right, count);
}
}

