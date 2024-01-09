package nossi_practice.week_2_list_stack_queue_graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DailyTemperature {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            System.out.println("stack" + stack);
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = i - prevDay;
            }
            System.out.println("answer" + Arrays.toString(answer));
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures = {25, 26, 27, 22, 30, 29, 28, 31};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
