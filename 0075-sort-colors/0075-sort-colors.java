class Solution {
    public void sortColors(int[] nums) {
        int left = 0 ,mid = 0, right = nums.length-1;  
        while(mid <= right){
            if(nums[mid] == 0){
                swap(nums,mid,left);
                mid++;
                left++;
            }else if(nums[mid] == 2){
                swap(nums,mid,right);
                right--;
            }
            else{
                mid++;
            }
        }
    }
    public void swap(int nums[], int a  , int b){
        //This prevents the failure of XOR when two elements are same.
        if (a==b) return;
        // This piece of code does bit manipulation to swap the elements.
        nums[a] = nums[a]^nums[b];
        nums[b] = nums[a]^nums[b];
        nums[a] = nums[a]^nums[b];
    }
    /*    Dutch National Flag Algorithm

    We use three pointers:
    left  -> position where the next 0 should be placed.
    mid   -> current element being examined.
    right -> position where the next 2 should be placed.

    Initially:
    left = 0
    mid = 0
    right = nums.length - 1

    We run the loop while (mid <= right) because every element
    between mid and right is still unprocessed.

    Cases:
    1. nums[mid] == 0
       - Swap nums[left] and nums[mid]
       - Increment both left and mid
       - This places 0 in its correct position at the beginning.

    2. nums[mid] == 1
       - Simply increment mid
       - 1 already belongs in the middle section.

    3. nums[mid] == 2
       - Swap nums[mid] and nums[right]
       - Decrement right
       - Do NOT increment mid immediately because the element
         that came from the right side has not been examined yet.

    This algorithm sorts the array in a single traversal with:
    Time Complexity  : O(n)
    Space Complexity : O(1)
    */
}