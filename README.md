# Software Engineering Fundamentals

A practical Java and C++ learning repository covering OOP, collections, data structures and algorithms, concurrency, STL, memory ownership, and design principles.

## Modules
- **Java:** OOP, Collections Framework, Multithreading, exceptions, and DSA.
- **C++:** OOP, STL, exceptions, multithreading, DSA, and memory ownership.
- **DSA:** 30 curated problems implemented in both Java and C++.
- **Engineering practice:** focused examples, complexity notes, documented assumptions, and GitHub Actions compilation checks.

## Quick start (JDK 17+, C++17)
```bash
javac Java/DSA/DsaPracticeSet30.java
java -cp Java/DSA DsaPracticeSet30

g++ -std=c++17 -Wall -Wextra -pedantic C++/DSA/dsa_practice_set_30.cpp -o /tmp/dsa
/tmp/dsa
```

## Other examples
```bash
javac Java/OOP/OopConcepts.java && java -cp Java/OOP OopConcepts
javac Java/Collections/CollectionsPractice.java && java -cp Java/Collections CollectionsPractice
javac Java/Multithreading/ConcurrencyPractice.java && java -cp Java/Multithreading ConcurrencyPractice
g++ -std=c++17 -Wall -Wextra -pedantic C++/STL/STLPractice.cpp -o /tmp/stl && /tmp/stl
```

## Learning path
Follow [ROADMAP.md](ROADMAP.md). [DSA/README.md](DSA/README.md) lists the 30 exercises, patterns, complexity, and assumptions.

## Quality conventions
Keep examples runnable and focused. State assumptions and complexity. Test edge cases. Prefer RAII and standard abstractions in C++, and executors/concurrency utilities in Java. Never commit credentials, build output, IDE state, or personal data. CI is a safety net, not proof of correctness.

A sample implementation is not evidence of mastery; use the roadmap exit tasks to assess understanding.
