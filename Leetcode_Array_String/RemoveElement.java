package Leetcode_Array_String;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int[] expectNums = new int[nums.length];
        int k=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {

    }
}
