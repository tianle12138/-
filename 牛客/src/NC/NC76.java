package NC;

import java.util.Stack;

// NC76 用两个栈实现队列
public class NC76 {

    //stack1只用来入栈， stack2只用来出栈
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
        // if(!stack2.isEmpty()){
        //     return stack2.pop();
        // }
        // else{
        //     while(!stack1.isEmpty()){
        //         stack2.push(stack1.pop());
        //     }
        //     return stack2.pop();
        // }
    }
}
