package Day07.回文链表;

import common.ListNode;

/**
 * 回文链表
 */
public class IsPalindromeSolution {

    public static void main(String[] args) {
        IsPalindromeSolution solution = new IsPalindromeSolution();
        ListNode node1 = ListNode.getOneToFiveList();
        boolean flag = solution.isPalindrome1(node1);
        System.out.println(flag);
    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head){
        int listSize = getListSize(head);
        if (listSize==0){
            return true;
        }
        int[] arr = new int[listSize];
        ListNode temp = head;
        for (int i = 0; i < listSize; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }
        int left = 0;
        int right = listSize-1;
        while (left!=right&&left<right){
            int ele1 = arr[left];
            int ele2 = arr[right];
            left++;
            right--;
            if (ele1==ele2){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public int getListSize(ListNode head){
        int count = 0;
        ListNode temp = head;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }


}
