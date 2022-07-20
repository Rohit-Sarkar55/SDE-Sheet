#include<bits/stdc++.h>
using namespace std;

class Solution{

    //1. 2-Sum-Problem
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> mp;   
        for(int i=0;i< nums.size(); i++){
            if( mp.count(target-nums[i]) ){
                return { mp[target - nums[i]] , i };
            }
            mp[nums[i]] = i;
        }
        return {-1};
    }

    //2. 4 Sum Problem
    
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
       vector<vector<int>> res;
    if(nums.size()==0) {return res;}
    int n= nums.size();
    sort(nums.begin(),nums.end());
    long long t = target*1LL;
    for (int i = 0; i < n; i++)
    {
        for (int j  = i+1; j < n; j++)
        {
            int front = j+1, back = n-1;
            long long target_2 = target - nums[i]*1LL - nums[j]*1LL;
            while (front < back)
            {
                if(nums[front]+nums[back] < target_2){
                    front++;
                }
                else if(nums[front] + nums[back] > target_2){
                    back--;
                }
                else{
                    vector<int> quad(4);
                    quad[0]=nums[i];
                    quad[1]=nums[j];
                    quad[2]=nums[front];
                    quad[3]=nums[back];

                    res.push_back(quad);
                    
                    while(front < back && nums[front] == quad[2] ) front++; // skipping the duplicates

                    while(front < back && nums[back] == quad[3] ) back--;
                }

            }
            while( j+1 < n && nums[j+1] == nums[j] ) ++j;
            
        }
        while(i+1 < n && nums[i] == nums[i+1]) ++i;
        
    }
    return res;
        
    }

    //3. Longest Consecutive Sequence

    int longestConsecutive(vector<int>& nums) {
       unordered_map<int,int> s;
        for(auto e:nums){
            s[e]++;
        }
        int maxCnt = 0;
        for(auto e: s){
            int cnt = 1;
            int d = e.first - 1, i = e.first+1;
            while(s.count(d) ){
                cnt++;
                s.erase(d);
                d--;
            }
            while(s.count(i)){
                cnt++;
                s.erase(i);
                i++;
            }
            maxCnt = max(cnt , maxCnt);
        }
        return maxCnt;
        
    }

    // 4. Largest subarray with 0 sum
    int maxLen(vector<int>&A, int n)
    {   
        unordered_map<int,int> mp;
        int sum = 0, ans =0 ;
        mp[0] = -1;
        for(int i=0; i< n; i++ ){
            sum += A[i];
            if(mp.count(sum)){
                ans = max(ans , i - mp[sum]);
            }
            else{
                mp[sum ] =i ;
            }
            
        }
        return ans;
    } 

    // 5 .Subarray with given XOR

    int SubarraywithgivenXOR(vector<int> &A, int B) {
        unordered_map<int,int> mp;
        
        int cnt = 0 , xorsum = 0 ;
        mp[0] = 1;
        for(int i=0; i< A.size(); i++){
            xorsum ^= A[i];
            int target = xorsum ^ B;
            
            if(mp.count(target)){
                cnt+= mp[target];
            }
            mp[xorsum ]++;
        }
        return cnt;
    }


    //6.  Longest Substring Without Repeating Characters

    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int> mp;
        int n =s.size();
        int ans = 0, j = 0;
        for(int i=0; i< n ; i++ ){
            if(mp.count(s[i])){
                if(j <= mp[s[i]]){
                    j = mp[s[i]];
                }
            }
            
            mp[s[i]] = i+1;
            ans = max(ans, i-j + 1);
            
        }
        return ans;
    }





};