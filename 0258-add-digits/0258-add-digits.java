class Solution {
    public int addDigits(int num) {
        if( num == 0 )return 0;
       // // int ans= 0;
       //  int sum = 0;
       //  while( num != 0){
       //      sum += num%10;
       //      num/= 10;
       //  }
       //  if(sum % 10 != 0)
       //  while( sum != 0){
       //      sum += sum%10;
       //      sum/= 10;
       //      //ans++;
       //  }
       //  return sum;
       
    int sum = -99;
    int x = num;
    //if (num == 0) return 0;

    while (sum / 10 != 0) {
        sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        x = sum;
    }

    return sum;
   

    }
}