package Leetcode_Array_String;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;
        for(int i=0;i<n;i++){
            if(i > maxJump){
                return false;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return true;
    }
    public static int jump(int[] nums){
        int n = nums.length;
        if (n <= 1) return 0; // đã ở đích

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                if (currentEnd >= n - 1) break;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,1};
        int kq = jump(nums);
        System.out.println(kq);
    }
}
