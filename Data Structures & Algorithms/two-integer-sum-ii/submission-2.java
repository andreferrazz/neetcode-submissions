class Solution {
    public int[] twoSum(int[] numbers, int target) {
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            var answer = map.get(numbers[i]);
            if (answer != null) {
                return new int[] {answer, i + 1};
            }
            map.put(target - numbers[i], i + 1);
        }

        throw new RuntimeException("No solution found");
    }
}
