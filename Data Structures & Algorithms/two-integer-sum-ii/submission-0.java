class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {++i, ++j};
                }
            }
        }

        throw new RuntimeException("There will always be exactly one valid solution");
    }
}
