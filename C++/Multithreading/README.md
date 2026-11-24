# C++ Multithreading

## Topics
- std::thread and joining
- Data races and synchronization
- std::mutex, std::lock_guard and std::unique_lock
- std::condition_variable
- std::async, std::future and std::promise
- Atomics and memory-order fundamentals

Every started thread must be joined or detached before its thread object is destroyed. Prefer RAII-based synchronization guards.

Run:
`g++ -std=c++17 -pthread -Wall -Wextra -pedantic ThreadExample.cpp -o thread_example && ./thread_example`
