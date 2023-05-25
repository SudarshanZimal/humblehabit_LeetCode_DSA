class Solution {
    public double new21Game(int n, int k, int maxPts) {
    //problem statement
        //alice plays game 
        //alice start with 0 points 
        //draw numbers while she has less than k points
        //alice stop drawing when she gets k or more than points
        //return probability that alice has n or fewer points
    //Approach
        //declare the array dp and initialize it with zeroes
        double dp[] = new double[n+1];
        //base condition 
        dp[0] = 1;
        //declare and initialize the variable s 
        double s = k > 0 ? 1:0;
        //iterate i from 1 to n
        for( int i =1 ; i <= n ; i++){
            dp[i]=s/maxPts;
            if( i < k){
                s+=dp[i];
            }
            if( i -maxPts >=  0 && i - maxPts < k){
                s -= dp[i -maxPts];
            }
        }
        //return dp[i]
        double ans = 0;
        for( int i = k ; i <= n ; i++){
            ans +=dp[i];
        }
        return ans;
    }
}