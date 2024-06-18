package DSA_Practice;

import java.util.Arrays;

public class LongestConsecutiveOnes {
    private static int longestConsecutiveOnes(String A) {
        long cnt_one = Arrays.stream(A.split("")).filter(s->s.equals("1")).count();
        int max_cnt = 0;
        for(int i=0;i<A.length();i++){
            int left_one = 0;
            for(int j= i-1;j>=0;j--){
                if(A.charAt(j)=='1'){
                    left_one++;
                }
                else
                    break;
            }
            int right_one = 0;
            for(int j= i+1;j<A.length();j++){
                if(A.charAt(j)=='1'){
                    right_one++;
                }
                else
                    break;
            }

            if(left_one+right_one < cnt_one)
                max_cnt = Math.max(max_cnt,left_one+right_one+1);
            else
                max_cnt = Math.max(max_cnt,left_one+right_one);
        }
        return max_cnt;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutiveOnes("11010110000000000"));
    }
}
