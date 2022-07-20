// Day 3
import java.util.*;

class Solution{

    // 1. Search in a 2d Matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        for(int []row : matrix){
            if(row[0] <= target && row[n-1] >= target){
                return binarySearch(row , target);
            }
        }
        return false;
    }
    private boolean binarySearch(int []a ,int target){
        
        int st = 0 ,en = a.length-1;
        
        while(st <= en){
            int mid = (st + en)/2;
            if(a[mid] == target){
                return true;
            }
            if(a[mid] > target){
                en = mid-1;
            }
            else{
                st = mid + 1;
            }
        }
        
        return false;
    }



    //2. Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

    public double myPow(double x, int n) {
        long N;
         N = (n<0)?-1L*n:n;
         double ans=1.0;
         while (N>0) {
             if(N % 2 == 1){
                 ans *= x;
             }
             x*=x;
             N>>=1;
         }
         return (n<0)? (double)(1.0/ans) : ans; 
     }


    //3. The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    public int majorityElement(int[] a) {
        int cnt = 1;
        int ele = a[0];
        int n = a.length;
        for(int i=1; i<n; i++ ){
            if(a[i] == ele){
                cnt++;
            }
            else{
                cnt--;
                if(cnt == 0){
                    cnt=1;
                    ele = a[i];
                }
            }
            
        }
        cnt = 0;
        for(int num:a){
            if(num == ele){
                cnt++;
            }
        }
        if(cnt > n/2){
            return ele;
        }
        return -1;
    }


    //4.Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

    public List<Integer> majorityElement2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int a: nums){
            map.put(a , map.getOrDefault(a , 0) + 1);
        }
        int n = nums.length;
        List<Integer> list =  new ArrayList<>();
        for(int x: map.keySet()){
            if(map.get(x)*3 > n ){
                list.add(x);
            }
        }
        return list;
    }


    //5. Grid Unique Paths

    public int uniquePaths(int m, int n) {
        int [][]dp = new int [m][n];
        
        for(int i=0; i< m ; i++){
            for(int j=0; j< n ;j++ ){
                if(i == 0 || j== 0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    
    //6.Given an integer array nums, return the number of reverse pairs in the array.
    //A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

    int []arr;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        
        return mergeSort(nums , 0 , n-1);
    }
    
    private int mergeSort(int []nums , int st , int en ){
        if(st >= en )return 0;
        
        int mid = (st + en)/2;
        int revPairs = 0;
        revPairs += mergeSort(nums ,st , mid);
        revPairs += mergeSort(nums ,mid + 1 , en );
        
        revPairs += merge(nums , st , mid , en);
        
        return revPairs;
    }
    
    private int merge(int []nums , int st , int mid , int en ){
        
        int i  , j = mid + 1 , k = st;
        int revPairs = 0;
        for ( i = st ; i <= mid; i++)
        {
            while ( j<= en && (nums[i]*1L) > (2L* nums[j]) )
            {
                j++;
            }
            revPairs += (j-mid-1);
        }
        
        i = st ; j = mid + 1;
        
        while(i <= mid && j <= en ){
            if(nums[i] <= nums[j]){
                arr[k++] = nums[i++]; 
            }
            else {
                arr[k++] = nums[j++];
            }
        }
        
        while( i <= mid){
            arr[k++] = nums[i++];
        }
        while( j <= en){
            arr[k++] = nums[j++];
        }
        
        for(int pos = st ; pos <= en ; pos++){
            nums[pos] = arr[pos];
        }
        
        return revPairs;
    }

}