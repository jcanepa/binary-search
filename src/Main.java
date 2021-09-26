/**
 * Binary search a sorted array: recursively and iteratively.
 * https://www.youtube.com/watch?v=P3YID7liBug
 *
 */
public class Main
{
    public static void main(String[] args) {
        int[] sortedArray = {0, 2, 19, 27, 44, 93, 105};
        int needle = 48;

        System.out.println(
                binarySearchIterative(sortedArray, needle));
    }

    /**
     * Search an array for a given element using binary search, return whether it was found.
     * @param array An array to search.
     * @param x An element to seek out.
     * @param left The index of the left bound.
     * @param right The index of the right bound.
     * @return whether the element was located within the array.
     */
    public static boolean binarySearchRecursive(int[] array, int x, int left, int right)
    {
        if (left > right) return false;

        // divide the array in half.
        // int mid = (left + right) / 2; // May cause an overflow.
        int mid = left + ((right - left) / 2);

        // get the value at the midpoint.
        int middleValue = array[mid];

        // the element we're looking for is found at the midpoint.
        if (middleValue == x) return true;

        /*
         * If the element we're looking for is less than the value in the middle,
         * inspect the left-half of the array.
         */
        if (x < middleValue)
            return binarySearchRecursive(array, x, left, mid - 1);

        /*
         * The element we're looking for must be greater than the value in the middle,
         * inspect the right-half of the array.
         */
        return binarySearchRecursive(array, x, mid + 1, right);
    }

    /**
     * Delegate the recursive binary search to an overloaded sibling method. Define inclusive endpoints.
     * @param array An array to search.
     * @param x An element to seek out.
     * @return boolean
     */
    public static boolean binarySearchRecursive(int[] array, int x) {
        return binarySearchRecursive(
                array,
                x,
                0,
                array.length - 1);
    }

    public static boolean binarySearchIterative(int[] array, int x)
    {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int middleValue = array[mid];

            if (middleValue == x)
                return true;

            if (x < middleValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }
}
