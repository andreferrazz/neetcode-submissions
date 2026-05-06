class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var row = findTargetRow(matrix, target);

        if (row == null) {
            return false;
        }

        return findTarget(row, target);
    }

    int[] findTargetRow(int[][] matrix, int target) {
        var left = 0;
        var right = matrix.length - 1;

        while (left <= right) {
            var mid = (left + right) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][matrix[0].length - 1] < target) {
                left = mid + 1;
            } else {
                return matrix[mid];
            }
        }

        return null;
    }

    boolean findTarget(int[] row, int target) {
        var left = 0;
        var right = row.length - 1;

        while (left <= right) {
            var mid = (left + right) / 2;
            if (row[mid] > target) {
                right = mid - 1;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
