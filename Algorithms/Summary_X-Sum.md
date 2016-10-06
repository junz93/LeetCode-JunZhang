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

<b>The time-complexity is <img src="http://www.forkosh.com/mathtex.cgi?O\left(n^X\right)">.</b>

Although it is easy to come up with and implement, this approach is inefficient and usually not used in practice.

## 2. Binary search
First, we have to <b>sort</b> the sequence. 
Then, we can try all the combinations of X-1 numbers, and use binary search to look for the last number in the rest of the sequence.

The Java-style code pattern is (take 3-Sum as an example):

    Arrays.sort(nums);
    for(int i = 0; i < N; i++)
        for(int j = i+1; j < N; j++)
        {
            int lo = j+1, hi = N-1;
            while(lo <= hi)
            {
                int mid = (lo+hi) / 2;
                int key = target - nums[i] - nums[j];
                if(key < nums[mid])
                    hi = mid - 1;
                else if(key > nums[mid])
                    lo = mid + 1;
                else
                {
                    // do something
                }
            }
        }        

<b>The time-complexity is <img src="http://www.forkosh.com/mathtex.cgi?O\left(n^{X-1}\log%20n\right)">.</b>

This approach reduces the cost of the inner search from <img src="http://www.forkosh.com/mathtex.cgi?O\left(n\right)"> to <img src="http://www.forkosh.com/mathtex.cgi?O\left(\log%20n\right)">. However, it requires a sort operation before search, 
which usually has a time-complexity <img src="http://www.forkosh.com/mathtex.cgi?O\left(\log%20n\right)">.

## 3. Hash table
We can also use hash table to look for the last number after determining the first X-1 numbers. 
This requires us to create a hash table for the sequence, whose time cost is <img src="http://www.forkosh.com/mathtex.cgi?O\left(n\right)">.

The Java-style code pattern is (take 3-Sum as an example):

    HashMap<Integer, Integer> ht = new HashMap<>();
    for(int i = 0; i < N; i++)
        ht.put(nums[i], i);
    
    for(int i = 0; i < N; i++)
        for(int j = i+1; j < N; j++)
        {
            int key = target - nums[i] - nums[j];
            if(ht.containsKey(key))
            {
                int k = ht.get(key);
                if(k > j)
                {
                    // do something
                }
            }
        }

<b>The time-complexity is <img src="http://www.forkosh.com/mathtex.cgi?O\left(n^{X-1}\right)">.</b>

This approach reduces the cost of the inner search to <img src="http://www.forkosh.com/mathtex.cgi?O\left(1\right)">. 
Note that cost of creating hash table is lower than sorting the sequence. For 2-Sum problem, hash table is the most efficient way to solve it.

## 4. Two pointers
This name might not be formal, but it implies the key features. This approach uses two pointers that move towards each other. 

By using it, we also have to <b>sort</b> the sequence first. Then we try every combinations of the first X-2 numbers, 
and use this approach to look for the last two numbers. 

Specifically, we set two pointers (usually indices) to the first and last element of the rest of the sequence respectively. 
Then we compare the sum of the X numbers with the target. If the sum is smaller, we increment the first pointer, 
or if the sum is greater, we decrement the pointer. Otherwise, we find a combination that fulfills the requirement.

The Java-style code pattern is (take 3-Sum as an example):

    Arrays.sort(nums);
    for(int i = 0; i < N; i++)
    {
        int left = i+1, right = N-1;
        while(left < right)
        {
            int sum = nums[i] + nums[left] + nums[right];
            if(sum < target)
                left++;
            else if(sum > target)
                right--:
            else
            {
                // do something
                j++; k--;           // if you want to continue searching
            }
        }
    }
    
<b>The time-complexity is <img src="http://www.forkosh.com/mathtex.cgi?O\left(n^{X-1}\right)">.</b>

This approach is often used in situations where we need to choose two elements that meet some requirements. 
Instead of iterating over all the combinations of two elements, we can just proceed bi-directionally.
In each step, we do something (such as computing some values), and decide accordingly how to move the two pointers. 
Finally, the two pointers meet each other, and the loop terminates.
