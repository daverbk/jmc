# Notes

## The Big Picture

```mermaid
---
title: Java Collections Framework
---
classDiagram
    class Collection
    class List {
        Implementations:
        ‣ LinkedList
        ‣ ArrayList
    }
    class Set {
        Implementations:
        ‣ HashSet
        ‣ LinkedHashSet
    }
    class Queue
    class SortedSet {
        Implementations:
        ‣ TreeSet
    }
    class Deque {
        Implementations:
        ‣ ArrayDeque
        ‣ LinkedList
    }
    class Map {
        Implementations:
        ‣ HashMap
        ‣ LinkedHashMap
    }
    class SortedMap {
        Implementations:
        ‣ TreeMap
    }
    <<Interface>> Collection
    <<Interface>> List
    <<Interface>> Set
    <<Interface>> Queue
    <<Interface>> SortedSet
    <<Interface>> Deque
    <<Interface>> Map
    <<Interface>> SortedMap
    Collection <|-- List
    Collection <|-- Set
    Collection <|-- Queue
    Set <|-- SortedSet
    Queue <|-- Deque
    Map <|-- SortedMap
```

| __Interfaces__ | __Hash table Implementations__ | __Resizable array Implementations__	 | __Tree Implementations__ | __Linked list Implementations__ | __Hash table + Linked list Implementations__ |
|----------------|--------------------------------|--------------------------------------|--------------------------|---------------------------------|----------------------------------------------|
| `Set`          | `HashSet`                      |                                      | `TreeSet`                |                                 | `LinkedHashSet`                              |
| `List`         |                                | `ArrayList`                          |                          | `LinkedList`                    |                                              |
| `Queue`        |                                |                                      |                          |                                 |                                              |
| `Deque`        |                                | `ArrayDeque`                         |                          | `LinkedList`                    |                                              |
| `Map`          | `HashMap`                      |                                      | `TreeMap`                |                                 | `LinkedHashMap`                              |


## The `Collection` Interface

### `Collection` and `List`

```mermaid
classDiagram
    class Collection {
        add(E e)
        addAll(Collection)
        clear()
        contains(Object o)
        containsAll(Collection)
        iterator()
        remove(Object o)
        removeAll(Collection)
        removeIf(Predicate)
        retainAll(Collection)
    }
    class List {
        add(int index, E element)
        get(int index)
        indexOf(Object o)
        lastIndexOf(Object o)
        listIterator()
        of()
        remove(int index)
        set(int index, E element)
        sort(Comparator)
        subList(int fromIndex, int toIndex)
    }
    <<Interface>> Collection
    <<Interface>> List
    Collection <|-- List
```

### `List` implementations

* A list can be either indexed, as an ArrayList, or not, like a LinkedList, but a LinkedList is implemented to support all
    of these methods as well
* A List is An ordered collection
* `ArrayList` is sequenced in memory

```mermaid
---
title: ArrayList
---
flowchart
    0
    1
    2
    3
    4
```

```mermaid
---
title: LinkedList
---
flowchart
    element1 --> element2
    element2 --> element1
    element2 --> element3
    element3 --> element2
    element3 --> element4
    element4 --> element3
    element4 --> element5
    element5 --> element4
```

### `Queue`

* Most often these may be implemented as First In, First Out (FIFO), but can be implemented like a Stack, as Last In First
Out (LIFO)

> [!NOTE] 
> Deque supports both

### `Set`

* A Set is a collection conceptually based off of a mathematical set
* It contains no duplicate elements, and isn't naturally sequenced or ordered
* A Sorted Set is a set that provides a total ordering of the elements

#### `HashSet`, `LinkedHashSet`, `EnumSet`

| Operation    | Time complexity |
|--------------|-----------------|
| `add()`      | `O(1)`          |
| `remove()`   | `O(1)`          |
| `contains()` | `O(1)`          |
|              |                 |

All of that thanks to the internal `HashMap` implementation

#### When creating `hashCode()`

1. It should be very fast to compute
2. It should produce a consistent result each time it's called
3. Objects that are considered equal should produce the same hashCode
4. Values used in the calculation should not be mutable

## `Map`

* A Map is a collection that stores key and value pairs
* The keys are a set, and the values are a separate collection, where the key keeps a reference to a value
* Keys need to be unique, but values don't
* Elements in a tree are stored in a key value Node, also called an Entry
