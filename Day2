1: Rotate Matrix

//Code 
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}


2: Merge OverLapping Interval

//Code

class Solution {
    public:
        vector<vector<int>> merge(vector<vector<int>>& intv) {
            sort(intv.begin(), intv.end());
            vector<vector<int>> ans;
            vector<int> v = {intv[0][0] ,intv[0][1]};
            for(int i=1; i< intv.size(); i++){
                if( (intv[i][0] >= v[0] && intv[i][0] <= v[1]) or (intv[i][1] <= v[1] && 
                                                                   intv[i][1] >= v[0]  )){
                    //merging
                    v[0] = min(v[0] , intv[i][0]);
                    v[1] = max(v[1] , intv[i][1]);
                }
                else{
                    ans.push_back(v);
                    v = intv[i];
                }
            }
            ans.push_back(v);
            return ans;
        }
};


3: Merge Two Sorted Array WithOut Extra Space
//Code
 void merge(long long arr1[], long long arr2[], int n, int m) 
        { 
            int k = n-1 ,  j = 0;
             for(int i=0; i<= k && j < m ; i++){
                if(arr1[i] > arr2[j] ){
                    swap(arr1[k--] , arr2[j++]);
                    i--;
                }
             }
             
             sort(arr1 , arr1 + n);
             sort(arr2 , arr2 + m);
     
        } 


4: Find Duplicate in Array 
// 1 <= Arr[i] <= N-1
// Code
int findDuplicate(vector<int> &nums, int n){
	int fast=nums[nums[0]],slow= nums[0];

    while ( fast != slow){
        slow = nums[slow];
        fast = nums[nums[fast]];
    }
    fast=0;
    while(fast!=slow){
        fast=nums[fast];
        slow=nums[slow];
    }
    return slow;
}


5: Repeat and Missing Number

pair<int,int> missingAndRepeating(vector<int> &arr, int n)
{
	// Write your code here 
    pair<int,int> p;
    for(int i=0; i< n; i++){
        int t = abs(arr[i]);
        if(arr[t-1] < 0) {
            p.second = t;
        }
        else{
            arr[t-1] *= -1;
        }
    }
	for(int i=0; i< n; i++){
        if(arr[i] > 0 ) p.first = i+1 ;
    }
    return p;
}


6 : Count Inversion 

class Solution {
public:
    int merge(vector<int> &v ,int l, int mid,int r){
    int j=mid+1; // pointing to the first element of the sorted right sub array
    int cnt=0;
    for (int i = l; i <= mid; i++)
    {
        while ( j<= r && v[i] > 2LL* v[j] )
        {
            j++;
        }
        cnt+= (j-mid-1);
    }
    vector<int> a;
    int m=l,n=mid+1;
    while(m<=mid && n<= r){
        if(v[m]<=v[n]){
            a.push_back(v[m++]);
        }
        else{
            a.push_back(v[n++]);
        }
    }

    while ( m <= mid)
    {
        a.push_back(v[m++]);
    }
    while ( n <= r)
    {
        a.push_back(v[n++]);
    }
    for (int i = l; i <= r; i++)
    {
        v[i]= a[i-l];
    }

    return cnt;
}

int mergesort(vector<int> &v,int l,int r){
    if(l>=r) return 0;

    int mid=(l + r) /2;
    int inv(0);
    inv+= mergesort(v,l,mid);
    inv+= mergesort(v,mid+1,r);
    inv+= merge(v,l,mid,r);

    return inv;

}
    int reversePairs(vector<int>& nums) {
        return mergesort(nums,0, nums.size()-1 ); 
    }
};
