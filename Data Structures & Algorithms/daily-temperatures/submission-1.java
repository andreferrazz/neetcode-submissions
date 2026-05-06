class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var result = new int[temperatures.length];
        var stack = new Stack<Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }


        // var result = new int[temperatures.length];

        // for (int i = 0; i < temperatures.length; i++) {
        //     for (int j = i + 1; j < temperatures.length; j++) {
        //         if (temperatures[j] > temperatures[i]) {
        //             result[i] = j - i;
        //             break;
        //         }
        //     }
        // }

        return result;
    }
}
