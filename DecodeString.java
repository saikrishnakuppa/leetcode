import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> results = new Stack<>();
        String res = "";
        int index = 0;

        while (index < s.length()) {
            if(Character.isDigit(s.charAt(index))) {
                int count = 0;
                while(Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index += 1;
                }
                counts.push(count);
            } else if(s.charAt(index) == '[') {
                results.push(res);
                res = "";
                index += 1;
            } else if(s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(results.pop());
                int count = counts.pop();
                for(int i=0; i<count; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index += 1;
            } else {
                res += res + s.charAt(index);
                index += 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
        //System.out.println(sol.decodeString("3[a2[c]]"));
        System.out.println(sol.decodeString("3[a]2[bc]"));
        //System.out.println(sol.decodeString("2[abc]3[cd]ef"));
    }
}
