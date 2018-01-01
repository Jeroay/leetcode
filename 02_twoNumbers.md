###问题描述：
- 两个数字求和，数字用链表表示，每一个结点代表一位。链表顺序与数字顺序相反，即表头存放数字的最低位。  
例：<pre>Input: (2 -> 4 -> 1) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 6
Explanation: 142 + 465 = 607.</pre>
- 解法要点：  
1.根据加法的进位原理，写一个逆序加法逻辑  
2.注意两个链表长度不一致的问题，还有最后一位的进位问题   
- 答案：<pre>
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null&&l2==null) {
			return null;
		}
		ListNode first=l1;
		ListNode second=l2;
		int carry=0;
		ListNode head=new ListNode(0);
		ListNode prev=head;	
		while(first!=null&&second!=null) {
			int q=(first.val+second.val+carry)/10;
			int r=(first.val+second.val+carry)%10;
			carry=q;
			ListNode node=new ListNode(r);
			prev.next=node;
			prev=node;
			first=first.next;
			second=second.next;	
		}
		while(first!=null) {
			int q=(first.val+carry)/10;
			int r=(first.val+carry)%10;
			ListNode node=new ListNode(r);
			carry=q;
			prev.next=node;
			prev=node;
			first=first.next;
		}
		while(second!=null) {
			int q=(second.val+carry)/10;
			int r=(second.val+carry)%10;
			ListNode node=new ListNode(r);
			carry=q;
			prev.next=node;
			prev=node;
			second=second.next;	
		}
		if(carry!=0) {
			prev.next =new ListNode(carry);
		}
		return head.next;
	}
</pre> 

----------
Java基础技术点：  
1.理解变量是内存中用来存储数据的  
2.理解引用型变量的赋值和其对对象的操作  
3.学会利用基本数据类型强转导致的数据精度丢失特性
