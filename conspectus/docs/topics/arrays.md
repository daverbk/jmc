---
slug: /arrays
title: Arrays 🔗
description: Arrays. Multi-dimensional arrays.
sidebar_position: 3
sidebar_custom_props:
  emoji: 🔗
---

# Arrays

## Arrays

* Allows you to store a sequence of values, all the same type
* Are 0 indexed
* If we try to access an index that is out of range, Java will give us
  an `ArrayIndexOutOfBoundsException`

### Declaring an Array

| Array Variable Declaration |
|----------------------------|
| `int[] integerArray;`      |
| `String[] nameList;`       |
| `String courseList[];`     |

### Instantiating an Array

| Array Creation                                     |
|----------------------------------------------------|
| `int[] integerArray = new int[10];`                |
| `int[] firstFivePositives = new int[] {1,2,3,4,5}` |
| `int[] firstFivePositives = {1,2,3,4,5}`           |

## What is an array, really?

* An array is a special class in Java
* It's still a class
* The array, like all other classes, ultimately inherits from java.lang.Object

:::note
When you don't use an array initializer statement, all array elements get initialized to the default
value for that type
:::

## java.util.Arrays

* Java's array type is very basic, it comes with very little built-in functionality
* Java provides a helper class named `java.util.Arrays`, providing common functionality, for many
  array operations

## Reference Types vs Value Types

* When we assign an object to a variable, the variable becomes a reference to that object
* This is true of arrays, but the array has yet another level of indirection, if it's an array of
  objects
* This means every array element is also a reference

## Varargs

```java
public static void main(String... args) {

}
```

* There can be only one variable argument in a method
* The variable argument must be the last argument

## Two-Dimensional Array

A two-dimensional array can be thought of, as a table or matrix of values, with rows and columns

```java
int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
```

| indexes | `j = 0` | `j = 1` | `j = 2` |
|---------|---------|---------|---------|
| `i = 0` | 1       | 2       | 3       |
| `i = 1` | 4       | 5       | 6       |
| `i = 2` | 7       | 8       | 9       |

`i` is usually represented in the outer for and `j` in the inner

:::note
A 2-dimensional array doesn't have to be a uniform matrix though
:::

## Multi Dimensional Array

```java
int[][][] array = {{{1}, {2}, {3}}, {{4}, {5}, {6}}, {{7}, {8}, {9}}};
```

The visual representation would look like a 3x3x1 cube
