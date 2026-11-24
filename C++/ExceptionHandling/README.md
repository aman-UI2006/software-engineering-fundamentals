# C++ Exception Handling

## Topics
- try, throw and catch
- Standard exception classes
- Custom exception types
- Stack unwinding and destructors
- RAII and exception safety guarantees

Catch polymorphic standard exception types by const reference. Use RAII to ensure resources are released when exceptions unwind the stack.

Run `g++ -std=c++17 -Wall -Wextra -pedantic CustomException.cpp -o custom_exception && ./custom_exception`.
