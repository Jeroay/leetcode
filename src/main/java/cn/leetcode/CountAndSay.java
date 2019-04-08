package cn.leetcode;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * Input: 1    Output: "1"
 * Input: 4    Output: "1211"
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }

    public String countAndSay(int n) {
        String init = "1";
        if(n == 1){
            return init;
        }
        for(int i = 1; i< n; i++){
            init = next(new StringBuilder(),init);
        }
        return init;
    }

    public String next(StringBuilder sb,String str){
        if(str.length() == 0){
            return sb.toString();
        }
        char tmp = str.charAt(0);
        int num = 1;
        for (int i = 1; i < str.length(); i++) {
            if(tmp == str.charAt(i)){
                num++;
            }else {
                break;
            }
        }
        str = str.substring(num);
        sb.append(num).append(tmp);
        next(sb,str);
        return sb.toString();
    }
}
