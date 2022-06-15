import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class practice {
    //2022.6.14
    public int[] twoSum_01(int []sums, int target){
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
}