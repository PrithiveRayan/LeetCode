package Interview75.stack;


public class RemovingStarsFromString {
    public String removeStars(String s) {
//        StackUsingArray stack = new StackUsingArray(s.length());
//        for(int i=0; i<s.length(); i++){
//            if(s.charAt(i) == '*'){
//                stack.pop();
//            }
//            else {
//                stack.push(s.charAt(i));
//            }
//        }
//        stack.returnString();
//        return stack.returnString();

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '*') {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        RemovingStarsFromString rs = new RemovingStarsFromString();
        System.out.println(rs.removeStars("leet**cod*e"));
        System.out.println(rs.removeStars("erase*****"));

    }
}
