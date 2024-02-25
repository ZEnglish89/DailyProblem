/*
(Hard)
 * This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
 */

class LowestInt{
    public static void main(String[] args){
        int[] test1 = {3,4,-1,1};
        int[] test2 = {1,2,0};
        int[] test3 = {1,3,2};
        int[] test4 = {-4,10,1,6,4,2};
        int[] test5 = {10,8,7,6,5,4,3,2,1};
        int[] test6 = {1,2,3,4,5,6,7,8,9,10,11,12,13,15,14,16};
        System.out.println(Solution(test1)==2); //2
        System.out.println(Solution(test2)==3); //3
        System.out.println(Solution(test3)==4); //4
        System.out.println(Solution(test4)==3); //3
        System.out.println(Solution(test5)==9); //9
        System.out.println(Solution(test6)==17); //17
    }
    public static int Solution(int[] arr){
        int answer=1; //if no positive ints are found, the answer is 1
        int size=arr.length;
        //First: "sort" arr so that it is ordered 1,2,3....,n
        //it does not matter if data, especially duplicates and negatives, are lost, as long as the final list is ordered that way and no elements are outright missing.
        //because we can afford to lose that data, we can "sort" this array in one pass.
        for(int i=0;i<size;i++){
            int temp=arr[i]; //save the current arr value
            int index=temp-1; //this is what index the current arr value belongs in
            if(index>=0&&index<size){ //only proceed if that index actually exists. If the value is negative, then it is not a positive integer, and if the value is out of bounds, then the answer must be less than it, so it can be forgotten.
                arr[i]=arr[index];
                arr[index]=temp; //swap the current value with the one in the index where it belongs.
                temp=arr[i];
                index=temp-1;
                if(index>=0&&index<i){ // if the new, post-swap value belongs somewhere earlier in the list than where we currently are, put it there now, because there won't be a second pass.
                    arr[index]=temp;
                }
            }
        }
        //the array is now "1,2,3,4,etc" and the point at which that pattern is interrupted will be our answer.
        //the for loop checks through the list to find where the pattern breaks, and returns what would have been the next number.
        for(int i=0;i<size;i++){
            if(arr[i]!=answer){
                return answer;
            }
            answer++;
        }
        //if the entire array does not break the pattern, then the next integer that would have followed the pattern will be the answer.
        return size+1;
    }
}