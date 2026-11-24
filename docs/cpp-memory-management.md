# C++ Memory Management and Ownership

- Automatic objects are destroyed when their scope ends. Dynamic resources need explicit lifetime management.
- A pointer is an address, not an ownership policy. Dangling references, use-after-free, double deletion, and leaks are lifetime bugs.
- Prefer RAII: acquire resources in constructors and release them in destructors.
- Prefer values and standard containers; avoid raw `new`/`delete` in ordinary application code.

## Smart pointers
- `std::unique_ptr<T>`: exclusive ownership; transfer ownership with moves.
- `std::shared_ptr<T>`: shared ownership with reference counting; use only when shared lifetime is genuinely required.
- `std::weak_ptr<T>`: non-owning observer; useful for breaking shared-ownership cycles.
- Raw pointers and references are normally non-owning access paths; document lifetime assumptions.

## Copy and move
- Copy creates a value according to the type's copy semantics.
- Move transfers resources and leaves the source valid but with an unspecified state.
- Rule of Zero: compose RAII types and avoid custom resource-management functions.
- Rule of Five applies when a type manually manages a resource and needs destructor, copy/move constructors, and copy/move assignment.

## Review checklist
1. Who owns each resource?
2. At what scope boundary does its lifetime end?
3. Can an exception occur between acquisition and release?
4. Can two owners accidentally release the same resource?
5. Can a pointer outlive the object it refers to?
6. Is shared ownership necessary, or is unique ownership clearer?
