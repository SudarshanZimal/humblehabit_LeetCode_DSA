// class Solution {
//     public int maxVowels(String s, int k) {
//       char[] ch = new char[s.length()];
//         int output = Integer.MIN_VALUE;
//         int count = 0;
//       for( int i = 0 ; i < ch.length - k - 1 ; i++ ){
//           for( int j = k ; j < ch.length ;  j++){
//               String str = s.substring(i , j);
//               if( str.contains('a' )){
//                   count++;
//                   output = Math.max(output ,count);
//               }
//               else if(  str.contains('e' )){
//                   count++;
//                   output = Math.max(output ,count);
//               }
//               else if(  str.contains('e' )){
//                   count++;
//                   output = Math.max(output ,count);
//               }
//                else if(  str.contains('i' )){
//                   count++;
//                   output = Math.max(output ,count);
//               }
//                else if(  str.contains('o' )){
//                   count++;
//                   output = Math.max(output ,count);
//               }
//                else if(  str.contains('u' )){
//                   count++;
//                   output = Math.max(output ,count);
//               }
                  
              
//           }
//       }  
//         return output;
//     }
// }

class Solution {
    public boolean isVowel(char c){
        if(c=='a' || c== 'e' || c== 'i' || c== 'o' || c== 'u')
            return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int n = s.length();
        int i=0;
        int count = 0;
        for(;i<k;i++){ // First window of size k
            if(isVowel(s.charAt(i)))
                count++;
        }
        int ans = count;
        for(;i<n;i++){ // Remaining n-k windows
            if(isVowel(s.charAt(i))) // If new character is vowel the increment count
                count++;
            if(isVowel(s.charAt(i-k))) // If previous character is vowel then decrement count
                count--;
            ans = Math.max(ans,count);
        }
        return ans;
    }
}