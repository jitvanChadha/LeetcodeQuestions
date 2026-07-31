class Solution {
    public int minSubArrayLen(int target, int[] nums)
    { 
           int low = 0 , high = 0 , sum = 0;
            int res = Integer.MAX_VALUE;
            while ( high < nums.length)
            {
                sum = sum + nums[high];
                while( sum>= target ){
                    int len = high - low + 1;
                    res = Math.min(res,len);
                    sum = sum - nums[low];
                    low++;
                }
                high++;
             }
             return res == Integer.MAX_VALUE? 0 : res;
     }
     /*
---------------- AMAZON HIRE - FIRE LOGIC ----------------

Think of the sliding window as Amazon building a team.

1. HIRE (Expand the Window)
   - The 'high' pointer hires one employee at a time.
   - Every hired employee contributes to the team's total performance (sum).
   - Keep hiring until the team's performance reaches or exceeds the target.

2. FIRE (Shrink the Window)
   - Once the target is achieved, start firing employees from the left
     using the 'low' pointer.
   - After each firing, check if the team still meets the target.
   - This helps find the smallest possible team (minimum subarray length)
     that still satisfies the target.

3. Repeat
   - Hire more employees.
   - Fire unnecessary employees.
   - Continue until all employees (array elements) have been considered.

----------------------------------------------------------

Time Complexity: O(n)

Reason:
- The 'high' pointer moves from left to right exactly once.
- The 'low' pointer also moves from left to right at most once.
- Each element is added to the window once and removed from the window once.

Therefore,
O(n) + O(n) = O(2n) = O(n).

----------------------------------------------------------

Space Complexity: O(1)

Reason:
- Only a constant number of variables are used
  (low, high, sum, len, and res).
- No extra array, list, or other data structure is created.

Therefore, the auxiliary space complexity is O(1).
*/
}