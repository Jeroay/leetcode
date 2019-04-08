package cn.leetcode;

/**
 * Given a string , find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "au";
        int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s){
        if(s == null || s.isEmpty()){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int result = 0;
        for(int i = 0; i<s.length(); i++){
            sb.append(s.charAt(i));
            for(int j = i+1; j<s.length(); j++){
                if(sb.indexOf("" + s.charAt(j)) < 0){
                    sb.append(s.charAt(j));
                }else{
                    result = result >sb.length() ? result : sb.length();
                    sb.delete(0,sb.length());
                    break;
                }
            }
            //若直到字符串结尾都没有重复字符，也计算临时字符串的长度并清空
            result = result >sb.length() ? result : sb.length();
            sb.delete(0,sb.length());
        }
        return result;
    }
}
