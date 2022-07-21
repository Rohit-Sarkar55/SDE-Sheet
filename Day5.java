
// DAY 5

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution{
    //1 . Reverse a LinkedList
    public ListNode reverseList(ListNode head) {
        ListNode ptr = head, prev = null;
        
        while(ptr != null){
            ListNode Next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = Next;
        }
        
        return prev;
        
    }

    // 2. Get Middle of a LinkedList
    public ListNode middleNode(ListNode head) {
        ListNode fast = head , slow =head;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 3. Merge two Sorted List 
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(list1 != null && list2 != null ){
            if(list1.val <= list2.val ){
                ptr.next = list1;
                list1 = list1.next;
            }
            else{
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }
        
        if(list1 != null){
            ptr.next = list1;
        }
        
        if(list2!= null ){
            ptr.next = list2;
        }
        
        return dummy.next;
    }

    // 4. Remove N-th node from back of LinkedList

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode ptr = head;
        while(ptr != null ){
            len++;
            ptr=ptr.next;
        }
        
        ptr = head;
        ListNode prev = null , Next = ptr.next;
        int pos = 0;
        while(pos < len - n  ) {
            pos++;
            prev = ptr;
            ptr = Next;
            Next = Next.next;
        }
        if(prev == null) {
            head = head.next;
            return head;
        }
        prev.next = Next;
        return head;
    }

    //5 . Add Two Number
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode p1 = l1 , p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        int carry = 0; 
        while(p1 != null && p2 != null ){
            int d = carry + p1.val + p2.val;
            ptr.next = new ListNode(d%10);
            carry  = (d/10);
            ptr = ptr.next;
            p1=p1.next;
            p2=p2.next;
        }
        
        while(p1 != null ){
            int d = carry + p1.val ;
            ptr.next = new ListNode(d%10);
            carry  = (d/10);
            ptr = ptr.next;
            p1 =p1.next;
        }
        
        while(p2 != null){
            int d = carry + p2.val;
            ptr.next = new ListNode(d%10);
            carry  = (d/10);
            ptr = ptr.next;
            p2 = p2.next;
        }
        while(carry > 0){
            ptr.next = new ListNode(carry % 10);
            carry/=10;
            ptr = ptr.next;
        }
        
        return dummy.next;
        
    }

    // 6.Delete a given Node when a node is given.(0(1) solution)
    
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


}
