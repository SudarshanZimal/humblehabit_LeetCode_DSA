//INPUT :   l1 = [2,4,3], l2 = [5,6,4] 


class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     // we create a dummy linked list to store the result
        
        ListNode dummy = new ListNode(0);
        ListNode currentPointer = dummy;
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1){
            int sum = 0;
            if(l1 != null){
                
                sum+=l1.val; 
                //1st iteration => 2
                //2nd iteration => 4
                //3rd iteration => 3
                l1=l1.next;
            }
              if(l2 != null){
                sum+=l2.val;
                 //1st iteration => 2+5=7  
                //2nd iteration => 4+6 = 0
                //3rd iteration => 3+4 =7
                l2=l2.next;
            }
            sum +=carry; 
             //1st iteration => 7+0 = 7 
            //2nd iteration => 0+0=0
              //3rd iteration => 7+1=8
            carry = sum / 10; // 2nd itration 10/10=1
            ListNode node = new ListNode( sum % 10);
            currentPointer.next = node;
            currentPointer = currentPointer.next;
            
                
                
        }
        //dummy.next beacause we initilize the dummy as zero 
        return dummy.next;
       // Output: [7,0,8]
        
        
    }
    
}