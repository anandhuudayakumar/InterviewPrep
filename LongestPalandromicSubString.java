public class LongestPalandromicSubString {

    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        String longest = "";
        String tempString= "";
        String reverse = "";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                tempString = s.substring(i,j+1);
                reverse = new StringBuilder(tempString).reverse().toString();
                if(tempString.equals(reverse) && tempString.length()>longest.length()) longest = tempString;
            }
        }

        return longest;
    }
}
