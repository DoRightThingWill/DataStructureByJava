## this is notes taken via learning Data Structure Design and Analysis by Java

** I am going to introduce implementations of several very popular data structure

## array basics

- array initiation
`int[] arr = new int[10]`
  
- get length of the array
`arr.length`
 
- array with specific elements
`int[] arr = new int[]{1,2,3}`
  
- retrieve value from the array
`for loop`
  `for(int element : arr)`
  
- capacity of an array, max number it could contain

- to comment some lines
`/******
  */`
- code block: if the in the `{}` there is only one line,
you do skip the {}. like 
  `for (int x : arr)
      x++; `
  
- placeholder `%d`
- throw an error `throw new IllegalArgumentException()`
- string append something at the end `string.append("")"`
- `String.format(""%d")` as placeholder
- resize of an array, or dynamic array
  - copy a to b (with a resized capacity), and copy back
## Type parameters
- element could be any "type"
- element can only be objects, rather than any fundamental type, like int, char, boolean etc
- all basic types have their own wrapper class, like Integer, Boolean
    - autoboxing
- then specify the object type
    - `Class<Integer> class = new Class<>();`
  
- T, K, V, E are the symbols that could be used as type parameters. T means type, k =key, v = value, e=element. Theoretically, they do not have much difference
  
## Time complexity
- the worst situation
- amortized time complexity
  - resize for array, add N times, resize once (instruction N times) O(1)
- expected time complexity 
  - add or remove in array without resize O(n)
  
## Common data structure
- list 
  - array
    - static array, java generic, find by index, add\delete O(n)
    - dynamic array, resize the capacity, add\delete O(n)
    - loop array, index % length, add\delete, O(1)
    - sparse array
    - `ArrayList` in java is an arrayBased list (not a linked list). 
      - static array, capacity can not be automatically changed. 
      - static array, can store, generic data type, + objects;
      - `ArrayList` automatically resize, and can only store objects.
  - linked list
    - singly linked list
      - linked list has one or two pointers, like next , prev. They are also nodes
      - to initiate the linked list, we could assign value (node) to next, or prev;
      - or assign them as null, like `next=null`
      - or simply leave there, do not touch, they will be automatically assigned null;
      - but not, use `next = new Node()`, which will lead to infinite iteration. 
    - doubly linked list 
  - stack
    - implemented by array
      - array stack
      - fast array stack
      - rootish array stack
  - queue
    - implemented by array
        - array queue
        - array deque
        - dual array deque
    - deque
    - priority queue
- tree
- graph

## java syntax
- in front a class or method with parameters, `/**` enter, will show `/** 
  *@parra thisparameter
  */`
## tree
- binary tree, shang gui gu, video 90;
- basic concept
  - root
  - leaf
  - node? 
  - level 
  - branch
  - height, max levels
  - forest

## searching method
- linear search
- binary search
    - has to be ordered list or array
    - left and right
    - mid value
    - if value not exists, end the recursion by checking left > right
- interpolation search
    - improved binary search
    - the factor is not 1/2, but depends on the actual values
    - when element not evenly distributed, interpolation may not be much better than binary search
- fibonacci search

## Java syntax
- static variable or method does not rely on objects to be initiated. With the `className.method()`, the static method could run
- another line

## hash table
  - a-z, 26 letter, build an array to index them
  - int[] test = int[26]; int[i] =  char(i) - 'a'. ascII code
  - hash function design
    - small int, directly us
    - negative int, + a number, convert to positive
    - big int, %
      - get the last four digit, % 10000
      - hash collision
      - % a prime number, reduce collision somehow
      - then which prime number to use
        - http://planetmath.org/goodhashtableprimes
    - float 
    - string
      - code = c*26^3 + o*26^2 + d*26^1 + e*26^0
      - hash(code) = (c*26^3 + o*26^2 + d*26^1 + e*26^0) % M (M is prime)
        - if the code has 100 letters, you need to calculate 26^99, crazy
        - then we convert,
          - hash(code) = (((c*26 +o)*26+d)*26+e)%  M (M is prime)
          - as per number theory, B = 26
          - hash(code) = ((((c%M)*B+o)%M*B+d)%M +e)%M 
          - code implementation
          - `int hash=0
            for(int i=0; i<s.length(); i++
                 hash = (hash*B + s.charAt(i)) % M;`
    - in java, Object has a method, hashCode(), convert the object to int;
      - `int a =42;
        (Integer)a.hashCode();`