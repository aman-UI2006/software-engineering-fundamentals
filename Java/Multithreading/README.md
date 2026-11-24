# Java Multithreading and Concurrency

## Topics
- Thread lifecycle, Thread and Runnable
- Race conditions and visibility
- synchronized and intrinsic locks
- volatile (visibility; not a substitute for atomic compound operations)
- ExecutorService and thread pools
- Callable, Future and CompletableFuture
- Concurrent collections and atomic variables

Prefer executor services for managing groups of tasks. Shut down executors you create and do not assume a specific thread scheduling order.

Run `javac ExecutorExample.java && java ExecutorExample`.
