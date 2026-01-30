class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int peak = low;

        int left = searchAsc(mountainArr, target, 0, peak);
        if (left != -1) return left;

        return searchDesc(mountainArr, target, peak + 1, n - 1);
    }

    private int searchAsc(MountainArray arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);
            if (val == target) return mid;
            if (val < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private int searchDesc(MountainArray arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);
            if (val == target) return mid;
            if (val > target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
