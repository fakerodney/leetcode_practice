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
    public ListNode mergeTwoLists_021(ListNode list1, ListNode list2) {
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
    //----------------------------------------------------------------------------------

    /*
        https://leetcode.cn/problems/maximum-subarray/comments/, 最大子序列和
        dp
        2022/6/18
     */
    public int maxSubArray_051(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            System.out.println("result"+ result + "dp:" + dp[i]);
            //这一步很简单，算的是以n结尾的最长子序列和
            result = Math.max(result, dp[i]);
            //很关键，需要再做一次比较来找到所有子序列和中最大的
        }
        return result;

    }


    /*
        https://leetcode.cn/problems/climbing-stairs/solution 爬楼梯
        dp
        2022/6/18
     */
    public int climbStairs_070(int n) {

        int [] dp = new int [n];
        if (n==1) return 1;
        dp [0] = 1; //注意这里对应一层
        dp [1] = 2; //对应二层（楼梯）
        for (int i = 2 ; i < n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
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
        int[] test051 = new int[] {10,-1,-1,10};
        test.maxSubArray_051(test051);
       // System.out.println(test.isValid_020(test020));
    }




}