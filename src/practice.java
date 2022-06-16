import java.util.*;

public class practice {
    /*
        https://leetcode.cn/problems/two-sum/ 两数之和
        ---------------------------------------------------------------------------------------
        2022.6.14
     */
    public int[] twoSum_001(int []sums, int target){
        int [] answer = new int [2];
        //hashmap 存入这个int， 如果找不到 （target - 其value）
        HashMap<Integer,Integer> searchmap = new HashMap();
        for(int i = 0; i < sums.length; i++){
            if (searchmap.containsKey(target-sums[i])){
                answer[0] = i;
                answer[1] = searchmap.get(target-sums[i]);
                break;
            }else{
                searchmap.put(sums[i],i);
            }
        }
        return answer;
    }

    /*
        https://leetcode.cn/problems/merge-two-sorted-lists/ 合并两个有序链表
        2022.6.16
        TODO: TRY RECURSION
---------------------------------------------------------------------------------------

     */

     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answernode = new ListNode(-1);
        //dummy node that points to the front, give it a value so that it won't be null
        ListNode head = answernode;
        while (list1!=null || list2!=null){
            //finish if one of the lists are zero
            if (list1==null){
                answernode.next = list2;
                break;
            }
            if (list2==null){
                answernode.next = list1;
                break;
            }
            //prolong the answernode: Notice, use the new Listnode instead of setting each value
            if (list1.val<= list2.val){
                answernode.next = new ListNode(list1.val);
                answernode = answernode.next;
                list1 = list1.next;
            } else {
                answernode.next = new ListNode(list2.val);
                answernode = answernode.next;
                list2 = list2.next;
            }

        }
        return head.next;

    }





    /*
        https://leetcode.cn/problems/valid-parentheses/ 有效括号
        使用stack ， 对于每种情况分别处理
---------------------------------------------------------------------------------------
     */
    public boolean isValid_020(String s) {
        Stack <Character> parentheses = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case ('('):
                    parentheses.push('(');
                    break;
                case ('['): parentheses.push('[');
                    break;
                case ('{'): parentheses.push('{');
                    break;
                case (')'):
                    if (parentheses.empty()){return  false;}//check null, otherwise cannot pass ')'
                    if (parentheses.peek() == '(') {
                        parentheses.pop();
                        break;
                    }else{
                        return false;
                    }
                //-----------
                case (']'):
                    if (parentheses.empty()){return  false;}
                    if (parentheses.peek() == '[') {
                        parentheses.pop();
                        break;
                    }else{
                        return false;
                    }
                //-----------
                case ('}'):
                    if (parentheses.empty()){return  false;}
                    if (parentheses.peek() == '{') {
                        parentheses.pop();
                        break;
                    }else{
                        return false;
                    }
                }
            }
        if (!parentheses.empty())return false;
        return true;
    }
//---------------------------------------------------------------------------------------
    public static void main(String[] args) {
        practice test = new practice();
        String test020 = "]";
        System.out.println(test.isValid_020(test020));
    }




}