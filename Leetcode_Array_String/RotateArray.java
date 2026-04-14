package Leetcode_Array_String;

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums , int k){

        swap(nums,0,nums.length-1);
        swap(nums,0,k-1);
        swap(nums,k,nums.length-1);
    }
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        rotate(nums,2);

        for (int i : nums) {
            System.out.println(i);

        }
    }

    public static void swap(int[] nums, int i, int j){
            int n = nums.length;
            while (i <j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
    }

}
