//java.lang.NumberFormatException;
class Solution {
  
//     int modValue = 1_000_000_007;
//     //we make function to solve the problem ( pass into the string , k ,start , and array )
//      int dfs( int k , String s , int start , int[] dp){
//          int m = s.length();
//          int count = 0;
//          //corner case 1 => use memorization
//          if( dp[start] != 0)return dp[start];
         
//          //corner case 2 => Empty string
//          if( start == m)return 1;
         
//          //corner case 3 => no leading zeroes in teh array then simply return zero
//          if( s.charAt(start) =='0')return 0;
         
//          for( int i = 0 ; i < m ; i++){
//              String currNumber = s.substring(start , i+1);
//              try {
    
//              if(Long.parseLong(currNumber) > k) break;
// } catch (NumberFormatException e) {
//     // The format was incorrect
// }
//              count = (count+dfs(k ,s, i+1, dp)) % modValue;
//          }
         
//          //update dp[start]
//          dp[start]=count;
//          return count;
         
//      }
    
    // public int numberOfArrays(String s, int k) {
    //     int[] dp= new int[s.length()+1];
    //     return dfs(k , s , 0 , dp);
 public int numberOfArrays(String s, int k) {
        int m = s.length();
    int n = String.valueOf(k).length();
        int mod = 1_000_000_007;
        
        
        int[] dp = new int[n + 1];
        
       
        dp[0] = 1;
        
       
        for (int start = 0; start < m; ++start) {
            if (s.charAt(start) == '0') {
                dp[start % (n + 1)] = 0;
                continue;
            }
            
            
            for (int end = start; end < m; ++end) {
                String currNumber = s.substring(start, end + 1);
                
                if (Long.parseLong(currNumber) > k)
                    break;
                
               
                dp[(end + 1) % (n + 1)] = (dp[(end + 1) % (n + 1)] + dp[start % (n + 1)]) % mod;
            }

            
            dp[start % (n + 1)] = 0;
        }
        return dp[m % (n + 1)];
    }
}