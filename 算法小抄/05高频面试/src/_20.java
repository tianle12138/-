import javafx.scene.layout.StackPaneBuilder;

import java.util.Stack;

// 20. 有效的括号
public class _20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') stack.push(')');
            if(ch == '{') stack.push('}');
            if(ch == '[') stack.push(']');
            else{
                if(stack.isEmpty()) return  false;
                Character pop = stack.pop();
                if(pop != ch){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
