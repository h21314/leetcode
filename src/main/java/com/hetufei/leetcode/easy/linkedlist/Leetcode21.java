package com.hetufei.leetcode.easy.linkedlist;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 1727 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Leetcode21 {
    //采用新链表，尾插法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode();//哑头
        ListNode tail = dummy;
        while (l1 != null || l2 != null) {
            //l2为空或者l1中的值小于等于l2中的值，则取l1结点加入到新链表中
            if (l2 == null || (l1 != null && l1.val <= l2.val)) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }else{//否则取l2结点添加到链表尾部
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }

        }
        //需要将tail.next设置为空
        tail.next = null;
        return dummy.next;
    }
}
