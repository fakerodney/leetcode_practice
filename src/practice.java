import java.util.*;

public class practice {
    /*
        https://leetcode.cn/problems/two-sum/ 两数之和
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
        https://leetcode.cn/problems/longest-palindromic-substring/ 最长回文字符串

     */


    public String longestPalindrome_005(String s) {
        return null;
    }


    /*
        https://leetcode.cn/problems/valid-parentheses/ 有效括号
        使用stack ， 对于每种情况分别处理

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

    public static void main(String[] args) {
        practice test = new practice();
        String test020 = "]";
        System.out.println(test.isValid_020(test020));
    }




}