import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        String output = "";
        if(s.length() == 1) {
            System.out.println(s);
            return 1;
        }
        Set<String> chars = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            for(int j=i+1; j<s.length(); j++) {
                chars.add(s.charAt(i) + "");
                char c = s.charAt(j);
                if(chars.contains(c + "")) {
                    chars.clear();
                    String tmp = s.substring(i, j);
                    if(tmp.length() > output.length())
                        output = tmp;
                    break;
                } else {
                    chars.add(c + "");
                    String tmp = s.substring(i, j+1);
                    if(tmp.length() > output.length())
                        output = tmp;
                }
            }
        }
        System.out.println(output);
        return output.length();
    }
    public static void main(String[] args) {
        LongestSubString sol = new LongestSubString();
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
    }
}