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
}