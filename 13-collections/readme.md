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
| `add()`      | `O(1)`*         |
| `remove()`   | `O(1)`          |
| `contains()` | `O(1)`          |

* All of that thanks to the internal `HashMap` implementation
* `O(1)`* - amortized (as in the worst case scenario it will take `O(n)` if the rehashing of all elements is required when
    the `Initial Capacity` is reached)

#### When creating `hashCode()`

1. It should be very fast to compute
2. It should produce a consistent result each time it's called
3. Objects that are considered equal should produce the same hashCode
4. Values used in the calculation should not be mutable


#### `TreeSet`

##### Time complexity

| Operation    | Time complexity |
|--------------|-----------------|
| `add()`      | `O(long(n))`    |
| `remove()`   | `O(long(n))`    |
| `contains()` | `O(long(n))`    |

* The `O(long(n))` time complexity is caused by the Btree structure and the need to traverse the tree and keep it
  balanced

##### Interface hierarchy

```mermaid
classDiagram
    class Collection
    class Set
    class SortedSet {
        first()
        last()
        headSet()
        tailSet()
        comparator()
    }
    class NavigableSet {
        ceiling()
        floor()
        higher()
        lower()
        descendingSet()
        
        Implementations:
        ‣ TreeSet
    }
    <<Interface>> Collection
    <<Interface>> Set
    <<Interface>> SortedSet
    <<Interface>> NavigableSet
    Collection <|-- Set
    Set <|-- SortedSet
    SortedSet <|-- NavigableSet
```

* Elements which implement Comparable (said to have a natural order sort, like Strings and numbers) can be elements of a
  TreeSet
* If our elements don't implement Comparable, you must pass a Comparator to the constructor

##### `SortedSet` methods

| sub set methods                                                                                                           | inclusive                                                                                  | description                                                                                                   |
|---------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| `headSet(E toElement)`<br/>`headSet(E toElement, boolean inclusive)`                                                      | `toElement` is exclusive if not specified                                                  | returns all elements less than the passed `toElement` (unless `inclusive` is specifically included)           |
| `tailSet(E fromElement)`<br/>`tailSet(E toElement, boolean inclusive)`                                                    | `fromElement` is inclusive if not specified                                                | returns all elements greater than or equal to the `fromElement` (unless `inclusive` is specifically included) |
| `subSet(E fromElement, E toElement)`<br/>`subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)` | `fromElement` is inclusive if not specified,<br/>`toElement` is exclusive if not specified | returns elements greater than or equal to `fromElement` and less than `toElement`                             |


* All three methods, headSet, tailSet and subSet return a subset of elements, backed by the original set

##### `NavigableSet` methods

|            | `floor(E)`  (<=)       | `lower(E)`  (<)                                   | `ceiling(E)` (>=)	     | `higher(E)`  (>)                                   |
|------------|------------------------|---------------------------------------------------|------------------------|----------------------------------------------------|
| In Set     | Matched Element        | Next Element < Element<br/> or null if none found | Matched Element	       | Next Element > Element<br/>or null if none found   |
|
| Not In Set | Next Element < Element | Next Element < Element<br/> or null if none found | Next Element > Element | Next Element > Element <br/> or null if none found |

##### When to use

* If the number of elements is not large, or we want a collection that's sorted, and continuously re-sorted as we add
  and remove elements, and that shouldn't contain duplicate elements, the `TreeSet` is a good alternative to
  the `ArrayList`

## `Map`

* A Map is a collection that stores key and value pairs
* The keys are a set, and the values are a separate collection, where the key keeps a reference to a value
* Keys need to be unique, but values don't
* Elements in a tree are stored in a key value Node, also called an Entry
