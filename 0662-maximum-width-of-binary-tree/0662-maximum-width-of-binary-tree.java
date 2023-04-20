/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
// //first height calcualte 
//         void printLevelOrder(){
//             int h = height(root);
//             for( int i = 0 ; i < h ; i++){
//                 printCurrentLevelOrder(root , i);
//             }
//         }
// //height function
//            if( root == null ){
//             return;
//         }else{
//                int lheight = height( root.left );//recursion
//                int rheight =  height(root.right);//recursion
//            }
//         if( lheight > rheight){
//             return (lheight+1);
//         }else{
//             return(height+1);
//         }
//         //print max count element in the level
//         void  printCurrentLevelOrder( TreeNode root , int level){
//             if (root == null || level == 1)
//             return;
//             else if (level > 1) {
//             printCurrentLevelOrder(root.left, level - 1);
//             printCurrentLevelOrder(root.right, level - 1);
//         }
//             if( height > 2){
                
//             }
//         }
        
       if (root == null) {
            return 0;
        }
        //treenode store the node element 
        //int store the index of the element
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        //add pair of root and index of the element
        queue.add(new Pair<>(root, 0));
        
        int maxWidth = 0;
        
        while (!queue.isEmpty()) {
            //store size of the queue
            int length = queue.size();
            int start = queue.peek().getValue();
            int index = 0;
            //calcualte the width of the tree inculding null node
            //between not  null node
            for (int i = 0; i < length; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                index = pair.getValue();
                //if find last element null in level then stop
                if (node.left != null) {
                    queue.add(new Pair<>(node.left, 2*index +1));
                }
                //if find last element null in level then stop
                
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, 2*index+2));
                }
            }
            
            maxWidth = Math.max(maxWidth, index - start + 1);
        }
        //return ans
        return maxWidth;
    
    }
}