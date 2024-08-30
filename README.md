## Recursive

- **Time complexity**: `O(2^n)`
- **Space complexity**: `O(n)`

```mermaid
flowchart TD

    A[Start]
    B1["solveFibonacci(n)"]
    B2{"check if n <= 1"}
    B3["return n"]
    C["`return
solveFibonacci(n - 1) +
solveFibonacci(n - 2)`"]
    D[End]
    A --> B1
    B1 --> B2
    B2 -- "n <= 1" --> B3 --> D
    B2 -- "n > n" --> C
    C -."`recursive call
solveFibonacci(n-1),
recursive call
solveFibonacci(n-2)`".-> B1
B1 -."result".-> C
C --> D
```

## Iterative

- **Time complexity**: `O(n)`
- **Space complexity**: `O(1)`

```mermaid
flowchart TD
    A[Start]
    A --> A1["solveFibonacci(n)"]
    A1 --> B{check if n <= 1}
    B -- " n <= 1 " --> C["return n"]
    B -- " n > 1 " --> D["`initialize
    prev1 = 0, prev2 = 1`"]
    D --> E{i = 2 .. n}
    E -- " i = n " --> K[return prev2]
    E -- " i < n " --> F["`Calculate
    current = prev1 + prev2`"]
    F --> H["`update prev1 = prev2,
    prev2 = current`"]
    H --> J[increment i by 1]
    J --> E
    C --> L[End]
    K --> L
```

## Dynamic programming

- **Time complexity**: `O(n)`
- **Space complexity**: `O(n)`

```mermaid
flowchart TD

A[Start] --> A1["solveFibonacci()"]
E("`Map<> memo`")
A -- initialise caching --> E
A1 --> B{check if n <= 1}
B -- "n > 1" --> D["`put Fib(0) = 0, Fib(1) = 1
into memo`"]
D -."caching".-> E
D --"n > 1"--> I{i = 2 .. n}
I --"i < n"--> K1["`get Fib(n-1), Fib(n-2)
from memo`"]
E -..-> K1
K1 --> K2["Fib(n) = Fib(n-1) + Fib(n-2)"]
K2 --> K3["put Fib(n) into memo"]
K3 -."`caching`".->E
K3 --> M[increment i by 1]
M --> I
B -- "n <= 1" --> C[return n]
C --> P[End]
I -- "i = n"--> O["return Fib(n)"]
O --> P
```

## Matrix exponentiation

- **Time complexity**: `O(n)`
- **Space complexity**: `O(n)`

```mermaid
flowchart TB

    A[Start] --> A1["solveFibonacci(n)"]
    A1 --> B{check if n <= 1}
    B -- "n <= 1" --> C[return n]
    B -- "n > 1" --> E("`check Map<> memo:
    Fib(n)=memo.get(n)`")

    E -- "Fib(n) is not in memo" --> F1["`initialise matrix
F = {{1, 1}, {1, 0}}`"]
    F1 --> G["call power(F, n-1)"]
    G --> G1["initialize matrix M = {{1, 1}, {1, 0}}"]
    G1 --> G2{i = 2 .. n}
    G2 -- "i < n" --> G4["multiply F by M)"]
    G4 --> G5["increment i by 1"]
    G5 --> G2
    G2 -- "i = n" --> H["`store result
F[0][0]=Fib(n) in memo`"]
    H --> I["return Fib(n)"]
    E -- "Fib(n) is in memo" --> O1["return Fib(n)"] --> P
    I --> P[End]
    C --> P

    H -."caching".-> E
```

## Matrix Exponentiation with Recursive Divide and Conquer Approach

- **Time complexity**: `O(log n)` - due to the logarithmic depth of the recursive calls.
- **Space complexity**: `O(log n)` - results from the space consumed by the recursive call stack.

The core technique used in this algorithm is matrix exponentiation. The Fibonacci sequence is calculated by raising a specific 2x2 matrix to the power of `n-1`, where `n` is the Fibonacci number's index.

The algorithm uses a divide and conquer strategy to efficiently perform matrix exponentiation. The `matrixPower` function reduces the problem size by half with each recursive call (via `n >> 1` or `n/2`), leading to `O(logn)` recursive calls.

Each recursive step involves a constant-time `O(1)` matrix multiplication, as it involves only a fixed number of operations (multiplying and adding elements) for the 2x2 matrices. Given that the recursion occurs in `O(log n)`, the overall time complexity is `O(log n)`.

The space complexity is dictated by the recursion depth, with each recursive call consuming stack space. Consequently, the space complexity due to the call stack is `O(log n)`. The matrices F and M are of fixed size (2x2), requiring constant space, i.e., `O(1)`.

```mermaid
flowchart TB

    A[Start] --> A1["solveFibonacci(n)"]
    A1 --> B{check if n <= 1}
    B -- "n <= 1" --> C["return n"]
    C --> G
    B -- "n > 1" --> D["`initialize matrix
    F = {{1, 1}, {1, 0}}`"]
    D --> E1["call matrixPower(F, n-1)"]
    E1 --> F1{"`check
        n == 1 or
        n == 0`"}
    F1 -- "true" --> F2["return control to previous call"]
    F2 --> G
    F1 -- "false" --> M["`initialize matrix
    M = {{1, 1}, {1, 0}}`"]
    M --> F3["call matrixPower(F, n/2)"]
    F3 -."recursive call".-> E1
    F3 --> F4["multiply F by F"]
    F4 --> F5{check n % 2 != 0}
    F5 -- "true" --> F6["multiply F by M"]
    F6 --> F["return F[0][0]=Fib(n)"]
    F5 -- "false" --> F
    F --> G[End]

```