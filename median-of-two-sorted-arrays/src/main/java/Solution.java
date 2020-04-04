class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] shorterArray = findShorterArray(nums1, nums2);
        int[] longerArray = findLongerArray(nums1, nums2);
        int shorterArrayLength = shorterArray.length;
        int longerArrayLength = longerArray.length;
        int totalLength = shorterArrayLength + longerArrayLength;
        int shorterArrayFlag = 0;
        int longerArrayFlag = totalLength / 2;
        int path = (shorterArrayLength + 1) / 2;
        boolean evenFlag = totalLength % 2 == 0 ? true : false;
        return findFinalShortArrayFlag(shorterArray, longerArray, shorterArrayFlag, longerArrayFlag, path, evenFlag);

    }

    public static int[] findShorterArray(int[] nums1, int[] nums2) {
        return nums1.length <= nums2.length ? nums1 : nums2;
    }

    public static int[] findLongerArray(int[] nums1, int[] nums2) {
        return nums1.length > nums2.length ? nums1 : nums2;
    }

    public static double findFinalShortArrayFlag(int[] shorterArray, int[] longerArray, int shorterArrayFlag, int longerArrayFlag, int path, boolean evenFlag) {
        int shorterFlagLeftValue = findBoundaryLeftValue(shorterArray, shorterArrayFlag);
        int shorterFlagRightValue = findBoundaryRightValue(shorterArray, shorterArrayFlag);
        int longerFlagLeftValue = findBoundaryLeftValue(longerArray, longerArrayFlag);
        int longerFlagRightValue = findBoundaryRightValue(longerArray, longerArrayFlag);
        if (shorterFlagLeftValue <= longerFlagRightValue && longerFlagLeftValue <= shorterFlagRightValue) {
            return evenFlag ? evenArrayResult(shorterFlagLeftValue, longerFlagLeftValue, shorterFlagRightValue, longerFlagRightValue) : oddArrayResult(shorterFlagRightValue, longerFlagRightValue);
        } else if (shorterFlagLeftValue > longerFlagRightValue) {
            shorterArrayFlag -= path;
            longerArrayFlag += path;
            path = (path + 1) / 2;
            return findFinalShortArrayFlag(shorterArray, longerArray, shorterArrayFlag, longerArrayFlag, path, evenFlag);
        } else if (longerFlagLeftValue > shorterFlagRightValue) {
            shorterArrayFlag += path;
            longerArrayFlag -= path;
            path = (path + 1) / 2;
            return findFinalShortArrayFlag(shorterArray, longerArray, shorterArrayFlag, longerArrayFlag, path, evenFlag);
        } else {
            return 0;
        }
    }

    public static double oddArrayResult(int shorterFlagRightValue, int longerFlagRightValue) {
        return shorterFlagRightValue < longerFlagRightValue ? (double) shorterFlagRightValue : (double) longerFlagRightValue;
    }

    public static double evenArrayResult(int shorterFlagLeftValue, int longerFlagLeftValue, int shorterFlagRightValue, int longerFlagRightValue) {
        int leftValue = shorterFlagLeftValue > longerFlagLeftValue ? shorterFlagLeftValue : longerFlagLeftValue;
        int rightValue = shorterFlagRightValue < longerFlagRightValue ? shorterFlagRightValue : longerFlagRightValue;
        return (double) (leftValue + rightValue) / 2;
    }

    public static int findBoundaryLeftValue(int[] array, int arrayFlag) {
        return arrayFlag <= 0 ? Integer.MIN_VALUE : array[arrayFlag - 1];
    }

    public static int findBoundaryRightValue(int[] array, int arrayFlag) {
        return arrayFlag >= array.length ? Integer.MAX_VALUE : array[arrayFlag];
    }

}