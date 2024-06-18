package DSA_Practice;

public class Palindrome {
    private static boolean isPalindrome(String str){
        int len = str.length();
        for(int i=0,j=len-1; i<len/2; i++,j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
    }
}
