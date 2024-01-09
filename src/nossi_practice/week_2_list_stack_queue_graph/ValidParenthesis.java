package nossi_practice.week_2_list_stack_queue_graph;

import stack_queue.ValidParentheses;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // 열린 괄호는 스택에 푸시
                stack.push(c);
            } else {
                // 닫힌 괄호가 나타났을 때 스택이 비어있거나 쌍이 맞지 않으면 유효하지 않음
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
            System.out.println(stack);
        }

        // 스택이 비어있으면 유효한 괄호 문자열
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String s = "({[)}]";
        System.out.println(isValid(s));
    }
}
