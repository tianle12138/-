package exam2;

import sun.tools.tree.ShiftLeftExpression;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class problem01 {
    public static void main(String[] args) {
        // problem01 clazz = new problem01();
        // String s = clazz.unique_string("hellowelcometoxiaomi");
        // System.out.println(s);
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(')');
            }else if(ch == ')'){
                if(!stack.isEmpty()) stack.pop();
                else {
                    flag=false;
                    return;
                }
            }
            else {
                flag=false;
                return;
            }


        }
        if(flag && stack.isEmpty())
            System.out.println("YES");
        else
            System.out.println("FALSE");

    }

    public String unique_string (String s) {
        HashSet<Character> hset = new HashSet<>();
        char[] chars = s.toCharArray();
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            if(!hset.contains(chars[i])){
                chars[end] = chars[i];
                end ++;
                hset.add(chars[i]);
            }
        }
        return new String(chars,0,end);
    }
}
