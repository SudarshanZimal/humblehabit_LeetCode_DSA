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
//     int count =0;
//      public void postOrder( TreeNode root){
//         postOrder( root.left);
//         postOrder( root.right);
//         System.out.print(root.val);
       
//          count++;
//         }
//     public int longestZigZag(TreeNode root) {
//         if( root == null)return 0;
//        // if( root == 1)return 1;
//        return count;
//     }
    int count = 0;
    public void dfs( TreeNode node , Boolean left, int steps  ){
        if( node ==  null)return;
        count = Math.max(count , steps);
        if( left ){
            dfs(node.left , false , steps+1);
            dfs( node.right , true , 1);
            
        }
        else{
            dfs(node.left , false , 1);
            dfs( node.right,true, steps+1);
        }
    }
     public int longestZigZag(TreeNode root) {
         dfs(root , true ,0);
         dfs( root , false , 0);
         return count;
        
         
}
}