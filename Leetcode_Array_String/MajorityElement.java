package Leetcode_Array_String;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = (nums.length)/2;
        int kq = 0;
        for(int i=0;i<nums.length;i++){
            int dem = 1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] == nums[i]){
                    dem++;
                }
            }
            if(dem > n){
                kq = nums[i];
                break;
            }
        }
        return kq;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int kq = majorityElement(nums);
        System.out.println(kq);
        return;
    }
}
