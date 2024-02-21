/*
Day One(Easy):
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

I decided to also return true if any of the numbers is INDIVIDUALLY equal to k, and if 
any of the numbers added to itself will equal k.
Removing both of these to more strictly fit the original problem is trivial, especially for the "one-pass" solution.

The Easy solution is Time Complexity O(n^2) and Space Complexity O(n)
The One-Pass solution is Time Complexity O(sum of (n)) or something like that, and Space Complexity O(2n)
 */
public class AddToK{
    public static void main(String[] args) {
        int[] nums = new int[]{10,15,3,7};
        int k = 17;
        int[] nums2 = new int[]{1,2,3,4,5};
        int l = 3;
        int[] nums3 = new int[]{15,20,33,47};
        int m = 50;
        int[] nums4 = new int[]{1};
        int n = 3;
        int[] nums5 = new int[]{1};
        int o = 1;
        System.out.println("Easy:");
        System.out.println(addEasy(nums,k)==true);
        System.out.println(addEasy(nums2,l)==true);
        System.out.println(addEasy(nums3,m)==false);
        System.out.println(addEasy(nums4,n)==false);
        System.out.println(addEasy(nums5,o)==true);
        System.out.println("One Pass:");
        System.out.println(addOnePass(nums,k)==true);
        System.out.println(addOnePass(nums2,l)==true);
        System.out.println(addOnePass(nums3,m)==false);
        System.out.println(addOnePass(nums4,n)==false);
        System.out.println(addOnePass(nums5,o)==true);
    }
    public static boolean addEasy(int[] nums, int k){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]==k){
                    return true;
                }
                if(nums[i]+nums[j]==k){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean addOnePass(int[] nums, int k){
        int[] complement=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==k){
                return true;
            }
            complement[i]=(k-nums[i]);
            for(int j=0;j<=i;j++){
                if(complement[j]==nums[i]){
                    return true;
                }
            }
        }
        return false;
    }
}