class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if( nums.length < 3 ) return -1;
        else{
            int max = nums[0] + nums[2] + nums[1];
            Arrays.sort(nums);
            for( int i = 0 ; i< nums.length-2 ; i++){
                if(i>0 && nums[i] == nums[i-1]){
                    continue;
                }
                int left = i+1 , right = nums.length -1;
                while(left<right)
                {
                    int sum = nums[left]+nums[right]+nums[i];
                    if( sum == target ) return sum;
                    else if ( Math.abs(sum-target) < Math.abs(max-target)){
                        max = sum;
                    }
                    if(sum > target) right--;
                    else if(sum < target) left++;
                    else return sum;
                }
                
            }
            return max;
        }
        
    }
    /*    We first sort the array because the two-pointer technique only works
    when the elements are in sorted order. After sorting, moving the left
    pointer increases the sum, while moving the right pointer decreases it.

    The variable 'max' stores the closest triplet sum found so far.
    It is initialized using the first three elements so that we always
    compare against a valid triplet sum rather than an arbitrary value.

    The outer loop fixes one element of the triplet at index i.
    Once one element is fixed, the problem reduces to finding two other
    elements whose sum makes the total as close as possible to the target.

    We skip duplicate values of nums[i] to avoid repeating the same search
    multiple times, which reduces unnecessary computations.

    The 'left' pointer starts immediately after i, and the 'right' pointer
    starts at the end of the array. This allows us to examine all possible
    pairs for the fixed element in linear time.

    For every triplet, we compute:
        sum = nums[i] + nums[left] + nums[right]

    We compare the current difference:
        |sum - target|
    with the best difference found so far:
        |max - target|

    If the current difference is smaller, the current triplet is closer
    to the target, so we update 'max'.

    When sum is greater than the target, we decrement 'right' because the
    array is sorted and moving right leftward gives a smaller value, which
    reduces the sum.

    When sum is smaller than the target, we increment 'left' because moving
    left rightward gives a larger value, which increases the sum.

    If sum becomes exactly equal to the target, we return immediately because
    an exact match has a difference of 0, and no other triplet can be closer
    than that.

    The algorithm checks all meaningful triplets using a fixed element and
    a shrinking two-pointer search, giving a time complexity of O(n^2) and
    constant extra space usage. */
}