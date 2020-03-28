## Recursion with Backtracking

## Example Problem

Let's do the [splitOdd10][] problem on [codingbat.com][].

The problem is:

> `boolean splitOdd10(int[] nums)`    
> Given an array of integers, determine if it is possible to
> divide them into two groups such that the sum of the first
> group is a multiple of 10 and the sum of the second group is odd

A couple of things to note about this problem:

1. we have to look at every element before we know the answer.  This is different from the `groupSum` problem where you can return as soon as you find the sum you want.
2. we need a *helper method* to pass some information, such as the sum so far of elements in the first group and second group.

### Think in Code

Before writing the code, write some comments for what you want to do.

```java
public boolean splitOdd10(int[] nums) {
    // call the helper method with initial values for parameters
    // return whatever result the helper finds

}

/**
 * Helper for splitOdd10
 * @param start is the index of current element to examine
 * @param nums array of values to assign to two groups
 * @param sumGroupOne the sum of elements in first group
 * @param sumGroupTwo the sum of elements in the second group
 * @return true of the group sums are correct
 */
public boolean splitOdd(int start, int[] nums, int sumFirstGroup, int sumSecondGroup) {
    // 1. Base case: if all elements have been assigned then
    //    check if first group sum is multiple of 10 and
    //    second group sum is odd.

    // 2. Recursive step
    // 2.1 Assign current element to first group and use recursion
    //     If it succeeds then we found a solution, else try the other case


    // 2.2 Assign current element to second group and use recursion
    //     Since this is the last case, return whatever result the
    //     recursive call returns (success or failure).

    // 3. Review: can we guarantee recursion will stop?
}
```

Now add the code.  After planning the solution by *thinking in code*, its
not hard.

```java
public boolean splitOdd10(int[] nums) {
    return splitOdd(0, nums, 0, 0);
}

public boolean splitOdd(int start, int[] nums, int sumFirstGroup, int sumSecondGroup) {
    // 1. base case: when all numbers have been assigned. Check the sums.
    if (start >= nums.length) {
        return sumFirstGroup%10 == 0 && sumSecondGroup%2 == 1;
    }
    
    // 2. Recursive case: assign a number to either first group or second group.
    // 2.1 Try assigning it to first group
    int thisElement = nums[start];
    if ( splitOdd(start+1, nums, sumFirstGroup+thisElement, sumSecondGroup) )
        return true; // success!

    // 2.2 Try assigning it to second group
    // this is the last case, so return whatever the recursive call returns
    return splitOdd(start+1, nums, sumFirstGroup, sumSecondGroup+thisElement);

    // 3. Guarantee termination?
    // YES - since we increase start by 1 at each recursive call, 
    // we must eventually have start >= nums.length (the base case).
}
```

## Another Example

Let's do the [groupSum5][] problem on [codingbat.com][].

The problem is:

> `groupSum5[int start, int[] nums, int target)`    
> Given an array (nums) of integers, is it possible to select
> some elements from the array so that the sum equals the `target` value?    
> An additional constraint is that you must include array elements 
> that are a multiple of 5.  And, after a multiple of 5 if the next
> element is 1, it must be skipped.

This uses recursion with backtracking.

1. The requirement "must include array elements that are multiple of 5" means we need to examine every element in the array (can't stop early).
2. The requirement to "skip a 1 value after a multiple of 5" means we either need some state information or look-ahead one element.  I'll use look ahead, even though its ugly code.

### Think in Code

Before writing the code, write comments for what we want to do.

```java
public boolean groupSum5(int start, int[] nums, int target) {
    // 1. base case - check stopping criteria (success or failure)
    //    When start >= nums.length check if we reduced the target to zero
    
    
    // 2. recursive case: examine one array value (start) 
    //    and either use it to reduce the target amount
    //    or don't use the element.  Either way, perform 
    //    a recursive call to check the remaining elements.

    // 2.1 If element is multple of 5 then it must be used.

	// 2.2 Else, try to use this element if value <= target
    
    // 2.3 Otherwise, don't use this element as part of sum
    
    // 3. Review: can we guarantee recursion will stop?
}
```


---

[codingbat.com]: https://codingbat.com.
[groupSum5]: https://codingbat.com/prob/p138907
[splitOdd10]: https://codingbat.com/prob/p171660
