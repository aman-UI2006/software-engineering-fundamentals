# Java Collections Framework

## Core interfaces and common implementations

| Interface | Implementations | Typical use |
|---|---|---|
| List | ArrayList, LinkedList | Ordered elements; duplicates allowed |
| Set | HashSet, LinkedHashSet, TreeSet | Unique elements |
| Map | HashMap, LinkedHashMap, TreeMap | Key-value lookup |
| Queue / Deque | ArrayDeque, PriorityQueue | Scheduling and FIFO/LIFO operations |

Also study generics, iteration, equals/hashCode, Comparable and Comparator.

Do not assume every operation is constant time: complexity depends on the collection and operation. Understand ordering, null handling and iterator invalidation where applicable.

Run `javac CollectionsExample.java && java CollectionsExample`.
