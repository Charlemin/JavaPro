package com.plus;

/**
 * Created by Eric on 2016/4/28.
 */
public class ListNode {

    int val;
    ListNode next;
    public ListNode(int val){

        this.val=val;
        this.next=null;
    }

    //合并两个排序链表
    public ListNode mergeTwoLists(ListNode pHead1, ListNode pHead2) {
        // write your code here
        if(pHead1 == null)
            return pHead2;
        else if(pHead2 == null)
            return pHead1;
        ListNode pMergedHead = null;
        if(pHead1.val < pHead2.val)
        {
            pMergedHead = pHead1;
            pMergedHead.next = mergeTwoLists(pHead1.next, pHead2);
        }
        else
        {
            pMergedHead = pHead2;
            pMergedHead.next = mergeTwoLists(pHead1, pHead2.next);
        }

        return pMergedHead;
    }

    ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p,q;
        p=head.next;
        q=head;
        for(int i=1;i<=n+1;i++)
            q=q.next;
        while (q.next!=null){
            q=q.next;
            p=p.next;
        }
        p.next=p.next.next;
        return head;
    }
}
