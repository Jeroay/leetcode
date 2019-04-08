package cn.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(3);

        ListNode ret = new AddTwoNumbers().addTwoNumbers(l1 , l2);

        while(ret.next != null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode listTmp = result;

        int curInt = 0 , nextInt = 0;
        while(l1 != null || l2 != null || nextInt != 0){
            if(l1 == null){
                l1 = new ListNode(0);
            }
            if(l2 == null){
                l2 = new ListNode(0);
            }
            listTmp.next = new ListNode(0);
            listTmp = listTmp.next;
            curInt = l1.val + l2.val + nextInt;
            nextInt = 0;
            if(curInt >= 10){
                nextInt = curInt / 10;
                curInt = curInt % 10;
            }

            listTmp.val = curInt;

            l1 = l1.next;
            l2 = l2.next;
        }
        return result.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}