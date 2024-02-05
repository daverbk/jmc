# Notes

<!-- TOC -->
* [Notes](#notes)
  * [Arrays vs ArrayLists](#arrays-vs-arraylists)
  * [Instantiating with Values](#instantiating-with-values)
  * [Element information](#element-information)
  * [Finding an element](#finding-an-element)
  * [Sorting](#sorting)
    * [Array](#array)
    * [ArrayList](#arraylist)
  * [Creating Lists from Arrays](#creating-lists-from-arrays)
    * [Using `Arrays.asList()`](#using-arraysaslist)
    * [Using `List.of()`](#using-listof)
  * [Creating Arrays from ArrayLists](#creating-arrays-from-arraylists)
  * [List](#list)
    * [ArrayList operations](#arraylist-operations)
    * [LinkedList operations](#linkedlist-operations)
  * [ArrayList](#arraylist-1)
    * [Bottlenecks](#bottlenecks)
    * [Benefits](#benefits)
  * [LinkedList](#linkedlist)
    * [Bottlenecks](#bottlenecks-1)
    * [Benefits](#benefits-1)
  * [Advice from Tim](#advice-from-tim)
  * [LinkedList's the Queue and Stack methods](#linkedlists-the-queue-and-stack-methods)
  * [Iterator](#iterator)
  * [Iterator vs ListIterator](#iterator-vs-listiterator)
  * [Why does Java have primitive data types?](#why-does-java-have-primitive-data-types)
  * [Boxing](#boxing)
    * [Autoboxing](#autoboxing)
    * [Automatic unboxing](#automatic-unboxing)
  * [Enumeration](#enumeration)
<!-- TOC -->

## Arrays vs ArrayLists

| Feature                        | Array                        | ArrayList |
|--------------------------------|:-----------------------------|-----------|
| primitives types supported     | Yes                          | No        |
| indexed                        | Yes                          | Yes       |
| ordered by index               | Yes                          | Yes       |
| duplicates allowed	            | Yes                          | Yes       |
| nulls allowed                  | Yes, for non-primitive types | Yes       |
| resizable                      | No                           | Yes       |
| mutable                        | Yes                          | Yes       |
| inherits from java.util.Object | Yes                          | Yes       |
| implements List interface      | No                           | Yes       |

## Instantiating with Values

```java
import java.util.ArrayList;
import java.util.List;

// ...
ArrayList<String> arrayList = new ArrayList<>(List.of("first", "second", "third"));
// ...
```

## Element information

|                                | Accessing Array Element data	                   | Accessing ArrayList Element data                                                      |
|--------------------------------|-------------------------------------------------|---------------------------------------------------------------------------------------|
| Example                        | `String[] array = {"first", "second", "third"}` | `ArrayList<String> arrayList = new ArrayList<>(List.of("first", "second", "third"));` |
| Index value of first element   | 0                                               | 0                                                                                     |
| Index value of last element    | `array.length - 1`                              | `arrayList.size() - 1`                                                                |
| Retrieving number of elements: | `array.length;`                                 | `arrayList.size();`                                                                   |
| Setting (assigning an element) | `array[0] = "one";`                             | `arrayList.set(0, "one");`                                                            |
| Getting an element             | `array[0];`                                     | `arrayList.get(0);`                                                                   |

## Finding an element

| Array                                                                                                                                      | ArrayList                                                                                                                           |
|--------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------|
| `int binarySearch(array, element)`<br/> Array MUST BE SORTED <br/> Not guaranteed to return index of first element if there are duplicates | `boolean contains(element)`<br/> `boolean containsAll(list of elements)`<br/> `int indexOf(element)`<br/>`int lastIndexOf(element)` |

## Sorting

### Array

```java
String[] array = {"first", "second", "third"};
Arrays.

sort(array);
```

> [!NOTE]
> You can only sort arrays of elements that implement Comparable

### ArrayList

```java
ArrayList<String> arrayList = new ArrayList<>(List.of("first", "second", "third"));
arrayList.

sort(Comparator.naturalOrder());
        arrayList.

sort(Comparator.reverseOrder());
```

> [!NOTE]
> You can use the sort method with static factory methods to get Comparators

## Creating Lists from Arrays

### Using `Arrays.asList()`

Returned List is NOT resizeable, but is mutable

```java
String[] days = new String[]{"Sunday", "Monday", "Tuesday"};
List<String> newList = Arrays.asList(days);
```

### Using `List.of()`

Returned List is IMMUTABLE

```java
String[] days = new String[]{"Sunday", "Monday", "Tuesday"};
List<String> newList = List.of(days);
```

## Creating Arrays from ArrayLists

```java
ArrayList<String> stringList = new ArrayList<>(List.of("Jan", "Feb", "Mar"));
String[] stringArray = stringList.toArray(new String[0]);
```

* If the length of the array you pass, has more elements than the list, extra elements will be filled with the default
  values for that type
* If the length of the array you pass, has fewer elements than the list, the method will still return an array, with the
  same number of elements in it, as the list

## List

* There are two general-purpose List implementations — ArrayList and LinkedList

### ArrayList operations

| Operation                    | Worst Case | Best Case |
|------------------------------|------------|-----------|
| `add()`	                     | O(1)*      |           |
| `add(int index, E element)`	 | O(n)       | O(1)*     |
| `contains(E element)`        | O(n)       | O(1)      |
| `get(int index)`             | O(1)       |           |
| `indexOf(E Element)`         | O(n)       | O(1)      |
| `remove(int index)`          | O(n)       | O(1)      |
| `remove(E element)`          | O(n)       |           |
| `set(int index, E element)`	 | O(1)       |           |

### LinkedList operations

| Operation                    | Worst Case | Best Case |
|------------------------------|------------|-----------|
| `add()`	                     | O(1)       |           |
| `add(int index, E element)`	 | O(n)       | O(1)      |
| `contains(E element)`        | O(n)       | O(1)      |
| `get(int index)`             | O(1)       | O(1)      |
| `indexOf(E Element)`         | O(n)       | O(1)      |
| `remove(int index)`          | O(n)       | O(1)      |
| `remove(E element)`          | O(n)       | O(1)      |
| `set(int index, E element)`	 | O(1)       | O(1)      |

> [!NOTE]
> O(1)  - constant time - operation's cost (time) should be constant regardless of number of elements
>
> O(n) - linear time - operation's cost (time) will increase linearly with the number of elements n
>
> O(1)* - constant amortized time - somewhere between O(1) and O(n), but closer to O(1) as efficiencies are gained

## ArrayList

### Bottlenecks

Either of these operations can be expensive

* When removing an element, the referenced addresses have to be re-indexed, or shifted, to remove an empty space
* When adding an element, the array that backs the ArrayList might be too small, and might need to be reallocated (with
  the copying of the previous array under the hood)

### Benefits

* Our objects aren't stored contiguously in memory, but their addresses are, in the array behind the ArrayList.
  The addresses can be easily retrieved with a bit of math, if we know the index of the element

## LinkedList

* The LinkedList is not indexed at all
* Each element that's added to a linked list, forms a chain
* Can also be considered a queue, a double ended queue, because we can traverse both backwards and forwards

### Bottlenecks

* Retrieval of an Element costs more than an ArrayList retrieval (because the index isn't stored as part of the list)
* The element still needs to be found, using the traversal mechanism, which is why deletion and insertion is O(n)

### Benefits

* Inserting and removing an element, is much simpler than with ArrayList (just a matter of breaking two links in the
  chain, and re-establishing two different links)

* Reallocation of memory to accommodate all existing elements, is never required

## Advice from Tim

* The ArrayList is usually the better default choice for a List, especially if the List is used predominantly for
  storing and reading data
* If you know the maximum number of possible items, then it's probably better to use an ArrayList, but set its capacity

> [!NOTE]
> ArrayList's index is an int type, so an ArrayList's capacity is limited to the maximum number of elements an int can
> hold, Integer.MAX_VALUE = 2,147,483,647

* Consider using a LinkedList if you're adding and processing or manipulating a large amount of elements, and the
  maximum elements isn't known, but may be great, or if your number of elements may exceed Integer.MAX_VALUE.
* A LinkedList can be more efficient, when items are being processed predominantly from either the head or tail of the
  list

## LinkedList's the Queue and Stack methods

> [!NOTE]
> Queue is a First-In, First-Out (FIFO) -> Offer (Insert) / Poll (Remove)
>
> Stack is a Last-In, First-Out (LIFO) -> Push (Insert) / Pop (Remove)

## Iterator

Iterator contains two main methods: `hasNext()` & `next()`

> [!NOTE]
> When an iterator is created, its cursor position is pointed at a position before the first element
>
> The first call to the next method gets the first element, and moves the cursor position, to be between the first and
> second elements
>
> When hasNext() = false the iterator or cursor position is past the last element

## Iterator vs ListIterator

* An Iterator is forwards only, and only supports the remove method
* ListIterator can be used to go both forwards and backwards, and in addition to the remove method, it also supports the
  add and set methods

> [!NOTE]
> It's really important to understand that the iterator's cursor positions, are between the elements

## Why does Java have primitive data types?

* Primitive types generally represent the way data is stored on an operating system
* Primitives have some advantages over objects, especially as the magnitude, or number of elements increase
* Objects take up additional memory, and may require a bit more processing power

> [!NOTE]
> Local primitive variables and references to object (i.e. variable declared in method) are stored in stack. Others are
> stored in heap

## Boxing

We need to box primitives into appropriate objects to pass them as generic types

| Wrapper Classes |
|-----------------|
| `Boolean`       |
| `Byte`          |
| `Character`     |
| `Double`        |
| `Float`         |
| `Integer`       |
| `Long`          |
| `Short`         |

* Each wrapper has a static overloaded factory method, `valueOf()`

### Autoboxing

We can simply assign a primitive to a wrapper variable

```java
Integer boxedInt = 15;
```

### Automatic unboxing

We can assign an instance of a wrapper class, directly to a primitive variable

```java
Integer boxedInt = 15;
int unboxedInt = boxedInt;
```

## Enumeration

`enum` : special data type that contains predefined constants

```java
public enum DayOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
```
