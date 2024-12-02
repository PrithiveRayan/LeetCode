package String;

import java.util.Stack;

public class SimplifyPath {

//    public String simplifyPath(String path) {
//        Stack<String> stack = new Stack<>();
//
////        for(int i=0; i<path.length(); i++){
////
////
////        }
//        int counter = 0;
//        String temp = "";
//        while(counter < path.length()){
//            if(path.charAt(counter) == '/'){
//                counter++;
//                if(temp.length() > 1){
//                    stack.push(temp);
//                    temp = "";
//                }else {
//                    continue;
//                }
//            }
//            else if(path.charAt(counter) == '.'){
//                if(counter+1 < path.length() && counter+2 < path.length() && path.charAt(counter+1) == '.' && path.charAt(counter+2) == '.'){
//                    stack.push("...");
//                    temp = "";
//                    counter = counter+3;
//                }
//                else if(counter+1 < path.length() && counter+2 < path.length() && path.charAt(counter+1) == '.' && path.charAt(counter+2) != '.'){
//                    stack.pop();
//                    counter = counter+2;
//                }
//                else{
//                    counter++;
//                    continue;
//                }
//            }
//            else{
//                temp = temp+path.charAt(counter);
//                counter++;
//            }
//        }
//
//        StringBuilder result = new StringBuilder();
//        while(!stack.isEmpty()){
//            result.append("/"+stack.pop());
//        }
//
//        return result.reverse().toString();
//    }

//    public String simplifyPath(String path) {
//        Stack<String> stack = new Stack<>();
//       String temp = "";
//       for(int i=0; i<path.length(); i++){
//           if(path.charAt(i) != '/'){
//               temp += path.charAt(i);
//           }
//           else{
//               if(temp.length() < 1 || temp.equals(".")){
//                   continue;
//               }
//               if(temp.equals("..")){
//                   if(stack.isEmpty()){
//                       temp = "";
//                       continue;
//                   }
//                   String popped = stack.pop();
//                   String toPush = popped.substring(0,popped.lastIndexOf('/'));
//                   if(toPush.length() > 1){
//                       stack.push(toPush);
//                   }
//                   temp = "";
//               }else{
//                   if(stack.isEmpty()){
//                       stack.push("/"+temp);
//                       temp = "";
//                       continue;
//                   }
//                   String popped = stack.pop() + "/" + temp;
//                   stack.push(popped);
//                   temp = "";
//               }
//           }
//       }
//       String result = stack.isEmpty() ? "" : stack.pop();
//       if(result.length() < 1 && temp.equals("..")){
//           return "/";
//       }
//       if(temp.length() > 1){
//           result += "/"+temp;
//       }
//
//        return result.equals("") ? "/" : result;
//    }

    public String simplifyPath(String path) {
        // Split the path by '/' into components
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String component : components) {
            if (component.equals("..")) {
                // Go back to the previous directory (if possible)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component);
            }
        }

        // Reconstruct the canonical path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // Return "/" if the stack is empty
        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {

        SimplifyPath sp = new SimplifyPath();
//        System.out.println(sp.simplifyPath("/home/"));
//        System.out.println(sp.simplifyPath("/home//foo/"));
//        System.out.println(sp.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(sp.simplifyPath("/../"));
        System.out.println(sp.simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(sp.simplifyPath("/a/../../b/../c//.//"));

    }
}
