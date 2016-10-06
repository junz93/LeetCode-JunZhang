# Symmary: X-Sum Problem
X-Sum problem refers to a category of problems that try to find X numbers in a sequence that add up to a given target number.
The required results may be the indices of the X numbers, tuples of the X numbers, the number of all the tuples, etc.

The method signature of such problem is usually:

    Xsum(int[] nums, int target)

There are sereval common approaches to solving these problems.

## 1. Brutal search
Maybe this is the most straightforward way to solve X-Sum problem. 
It just tries all the posssible combinations of X numbers in the given sequence, and compares the sum with the target number.

The Java-style code pattern is (take 3-Sum as an example):

    for(int i = 0; i < N; i++)
        for(int j = i+1; j < N; j++)
            for(int k = j+1; k < N; k++)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target)
                {
                    // do something
                }
            }           

<b>The time-complexity is <img src="http://www.forkosh.com/mathtex.cgi?O\left(n^X\right)"></b>

Although it is easy to come up with and implement, this approach is inefficient.

## 2. Binary search
First, we have to <b>sort</b> the sequence. 
Then, we can try all the combinations of X-1 numbers, and use binary search to look for the last number in the rest of the sequence.

The Java-style code pattern is (take 3-Sum as an example):

    for(int i = 0; i < N; i++)
        for(int j = i+1; j < N; j++)
        {
            int lo = j+1, hi = N-1;
            while(lo <= hi)
            {
                int mid = (lo+hi) / 2;
                int sum = nums[i] + nums[j] + nums[mid];
                if(target < sum)
                    hi = mid - 1;
                else if(target > sum)
                    lo = mid + 1;
                else
                    // do something
            }
        }        

<b>The time-complexity is <img src="http://www.forkosh.com/mathtex.cgi?O\left(n^{X-1}logn\right)"></b>

This approach reduces the cost of inner search from O(n) to O(logn). However, it requires a sort operation before search, 
which usually has a time-complexity O(n*logn).

## 3. Hash table

## 4. Two pointers
