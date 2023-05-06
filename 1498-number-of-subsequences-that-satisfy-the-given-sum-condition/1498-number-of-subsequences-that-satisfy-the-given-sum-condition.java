class Solution {
    public int numSubseq(int[] nums, int target) {
        // ArrayList<Integer> list = new ArrayList<>();
        // int count = 0;
        // for( int i = 0 ; i < nums.length; i++){
        //     for( int j = 0 ; j < nums.length; j++){
        //         int max = 0;
        //         int min = 0;
        //         max =  Collections.max(list);
        //         min = Collections.min(list);
        //         if( target <= max+min){
        //             count++;
        //         }
        //     }
        // }
        // return count;

        int n = nums.length;
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        
        // Precompute the value of 2 to the power of each value.
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        
        int answer = 0;
        int left = 0, right = n - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                answer += power[right - left];
                answer %= mod;
                left++;
            } else {
                right--;
            }
        }
        
        return answer;
    
    }
}