class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int res = 0;
        for( int i = 0 ; i < gain.length ; i++){
            max = max + gain[i];
              res = Math.max(res , max);
            }
        return res;
    }
}