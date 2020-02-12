/*先找到第一个顺序位，若没有则直接逆序整个*/
/*然后从后往前找比他大的第一个数，交换位置然后逆序后半部分*/

class Solution {
    public void nextPermutation(int[] nums) {
       if(nums == null || nums.length == 0) return;
       int Firstsmall = -1;
       for(int i = nums.length - 2; i > Firstsmall; i--) {
           if(nums[i] < nums[i+1]) {
               /*注意这里是记录索引的值*/
               Firstsmall = i;
               break;
           }
       }
       if (Firstsmall == -1) {
           reverse(nums, 0, nums.length-1);
           return;
       }
       int Firstlarge = -1;
       for(int i = nums.length - 1; i > Firstsmall; i--) {
           if(nums[i] > nums[Firstsmall]){
               /*注意这里是记录索引的值*/
               Firstlarge = i;
               break;
           }
       }
       swap(nums, Firstsmall, Firstlarge);
       reverse(nums,Firstsmall+1, nums.length-1);
       return;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i++] = nums[j];
        nums[j--] = tmp;
    }
    public void reverse(int[] nums, int i, int j) {
        while(i<j){
            swap(nums,i++,j--);
        }

    }
}