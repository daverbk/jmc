# Notes

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
Arrays.sort(array);
```

> [!NOTE]
> You can only sort arrays of elements that implement Comparable

### ArrayList

```java
ArrayList<String> arrayList = new ArrayList<>(List.of("first", "second", "third"));
arrayList.sort(Comparator.naturalOrder());
arrayList.sort(Comparator.reverseOrder());
```

> [!NOTE]
> You can use the sort method with static factory methods to get Comparators

## Creating Lists from Arrays

### Using `Arrays.asList()`

Returned List is NOT resizeable, but is mutable

```java
String[] days = new String[] {"Sunday", "Monday", "Tuesday"};
List<String> newList = Arrays.asList(days);
```

### Using `List.of()`

Returned List is IMMUTABLE

```java
String[] days = new String[] {"Sunday", "Monday", "Tuesday"};
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

## Array of primitive values


