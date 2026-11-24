# DSA Practice Set — 30 Problems
All problems have Java and C++ implementations in this repository.

| # | Problem | Pattern | Complexity |
|---:|---|---|---|
|1|Maximum Subarray Sum|Kadane|O(n)|
|2|Rotate Array Right by K|Reversal|O(n)|
|3|Move Zeroes to End|Two pointers|O(n)|
|4|Product Except Self|Prefix/suffix|O(n)|
|5|Merge Intervals|Sort + sweep|O(n log n)|
|6|Valid Anagram|Frequency count|O(n)|
|7|Longest Common Prefix|String scan|O(total chars)|
|8|Reverse Words|Parsing|O(n)|
|9|Longest Palindromic Substring|Expand centers|O(n²)|
|10|Two Sum|Hash map|O(n) average|
|11|Group Anagrams|Canonical key|O(n·k log k)|
|12|Subarray Sum Equals K|Prefix sum + map|O(n) average|
|13|3Sum|Sort + two pointers|O(n²)|
|14|Container With Most Water|Two pointers|O(n)|
|15|Remove Duplicates from Sorted Array|Slow/fast pointers|O(n)|
|16|Longest Substring Without Repeats|Sliding window|O(n)|
|17|Minimum Window Substring|Sliding window|O(n)|
|18|Binary Search|Binary search|O(log n)|
|19|Search Rotated Sorted Array|Modified binary search|O(log n)|
|20|First and Last Position|Bounds|O(log n)|
|21|Reverse Linked List|Pointers|O(n)|
|22|Linked List Cycle|Floyd detection|O(n)|
|23|Merge Two Sorted Lists|Merge|O(n+m)|
|24|Valid Parentheses|Stack|O(n)|
|25|Next Greater Element|Monotonic stack|O(n)|
|26|Maximum Depth of Binary Tree|DFS|O(n)|
|27|Level Order Traversal|BFS|O(n)|
|28|Subsets|Backtracking|O(n·2^n) output|
|29|Combination Sum|Backtracking|Output-dependent|
|30|Permutations|Backtracking|O(n·n!)|

Assumptions: binary-search arrays are sorted; rotated array values are distinct; Combination Sum uses positive candidates; permutations expects distinct values. C++ string examples use byte/ASCII semantics, not Unicode grapheme clusters. Widen arithmetic for large constraints. Linked-list merge reuses nodes; inputs must not share nodes.

Practice rule: solve independently, state invariants and complexity, test edge cases, then compare with the reference implementation.
