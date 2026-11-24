# Software Engineering Fundamentals

A practical learning portfolio for Java and C++: object-oriented programming, core language features, standard libraries, concurrency, data structures, and algorithms.

The aim is to build a reliable reference of small, understandable, runnable examples—not simply collect code. Examples should be compiled and tested before being described as verified.

## Repository structure

```text
Java/
  OOP/
  Collections/
  ExceptionHandling/
  Multithreading/
  DSA/
C++/
  OOP/
  STL/
  ExceptionHandling/
  Multithreading/
  DSA/
```

## Topics

| Area | Java | C++ |
|---|---|---|
| OOP | Classes, encapsulation, inheritance, polymorphism, interfaces | Classes, encapsulation, inheritance, virtual functions, RAII |
| Collections / STL | List, Set, Map, Queue, generics, comparators | Vector, map, set, unordered containers, iterators, algorithms |
| Exceptions | Checked/unchecked, custom exceptions, try-with-resources | try/throw/catch, standard/custom exceptions, RAII |
| Multithreading | Thread, Runnable, synchronization, executors | std::thread, mutex, condition_variable, future |
| DSA | Arrays, strings, hashing, trees, graphs, DP | Arrays, strings, hashing, trees, graphs, DP |

## Compile and run

### Java
Requires a JDK (Java 17 or later recommended).

```bash
javac Example.java
java Example
```

### C++
Examples use C++17.

```bash
g++ -std=c++17 -Wall -Wextra -pedantic Example.cpp -o example
./example
```

## Contribution and quality conventions

For each new example:
1. Explain the concept and the problem it solves.
2. Keep each example focused and readable.
3. Include edge cases and expected output where useful.
4. For DSA, explain the approach and time/space complexity.
5. Compile and run the example before marking it verified.

## Learning status

This repository is being built incrementally. A topic folder or example is not a claim that the entire topic has been mastered.

## Author

[aman-UI2006](https://github.com/aman-UI2006)
