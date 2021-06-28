## this is notes taken via learning Data Strcture Design and Analysis by Java

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
  
## Time complexity
- worst situation
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
  - linked list
    - singly linked list
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

