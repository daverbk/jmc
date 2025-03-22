---
slug: /generics
title: Generics 🧬
description: Generic typing.
sidebar_position: 6
sidebar_custom_props:
  emoji: 🧬
---

# Generics 

* Generics allow us to create classes, to design them, in a general way, without really worrying about the specific
  details of the elements they might contain
* Java supports generic types, such as classes, records and interfaces and methods

## Convention

If we had three types, we'd probably want to declare this class as shown here, with `T`, `S`, and `U` (then would
go `V`)

```java
public class Team<T, S, U> {
}
```

The most commonly used type parameter identifiers are:

* `E` for Element (used extensively by the Java Collections Framework)
* `K` for Key (used for mapped types)
* `N` for Number
* `T` for Type
* `V` for Value
* `S`, `U`, `V` etc. for 2nd, 3rd, 4th types

## Raw use

You can still use generics classes without specifying the type

The raw use of these classes is still available, for backwards compatibility, but it's discouraged:

* Generics allow the compiler to do compile-time type checking, when adding and processing elements in the list
* Generics simplify code, because we don't have to do our own type checking and casting, as we would, if the type of our
  elements was Object

## Specifying an upper bound

```java
public class Team<T extends Player> {
}
```

This is saying the parameterized type `T`, has to be a `Player`, or a subtype of `Player`

Why:

* An upper bound permits access to the bounded type's functionality
* An upper bound limits the kind of type parameters you can use when using a generic class. The type used must be equal
  to, or a subtype of the bounded type

## Comparable

```java
public interface Comparable<T> {
    int compareTo()
}
```

| resulting Value | Meaning   |
|-----------------|-----------|
| zero            | o == this |
| negative value  | this < o  |
| positive value  | this > o  |

## Comparable vs Comparator

| `Comparable`                                                                              | `Comparator`                                                                                             |
|-------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| `int compareTo(T o)`                                                                      | `int compare(T o1, T o2)`                                                                                |
| Compares the argument with the current instance                                           | Compares two arguments of the same type with each other                                                  |
| Called from the instance of the class that implements `Comparable`                        | Called from an instance of `Comparator`                                                                  |
| Best practice is to have `this.compareTo(o) == 0` result in `this.equals(o)` being `true` | Does not require the class itself to implement `Comparator`, though you could also implement it this way |
| `Arrays.sort(T[] elements)` requires `T` to implement `Comparable`                        | `Array.sort(T[] elements, Comparator<T>)` does not require `T` to implement `Comparable`                 |

## Limitation of a reference of generic class

When we declare a variable or method parameter with:

```java
List<Student>
```

* Only List subtypes with Student elements can be assigned to this variable or method argument.

:::caution
We can't assign a list of Student subtypes to this!
:::

## Generic method

```java
public <T> String method(T input) {
    return input.toString();
}
```

### Type Parameters

A type parameter is a generic class, or generic method's declaration of the type

#### Generic class

```java
public class Team<T> {
}
```

#### Generic method

```java
public <T> void doSomething(T t) {
}
```

### Type Arguments

* Declares the type to be used
* `BasketballPlayer` in this case

```java
Team<BasketballPlayer> basketballTeam = new Team<>();
```

### Wildcards

* Means the type is unknown
* Can only be used in a type argument
* Limits what you can do

```java
List<?> unknownList; 
```

* We can't specify both an upper bound and a lower bound, in the same declaration

| Argument    | Example                          | Description                                                                                                                                         |
|-------------|----------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| unbounded   | `List<?>`                        | A `List` of any type can be passed or assigned to a List using this wildcard                                                                        |
| upper bound | `List<? extends Player>`         | A list containing any type that is a `Player` or a sub type of `Player` can be assigned or passed to an argument specifying this wildcard           |
| lower bound | `List<? super BasketballPlayer>` | A list containing any type that is an `BasketballPlayer` or a super type of `BasketballPlayer`, so in our case, that would be `Player` AND `Object` |

## Type Erasure

* Generics exist to enforce tighter type checks, at compile time
* The compiler transforms a generic class into a typed class, meaning the byte code, or class file, contains no type
parameters
* Everywhere a type parameter is used in a class, it gets replaced with either the type Object, if no upper bound was
specified, or the upper bound type itself
* This transformation process is called type erasure, because the `T` parameter (or `S`, `U`, `V`), is erased, or replaced with a
true type

## Using Multiple types to declare an Upper Bound

* We can extend only one class at most, and zero to many interfaces
* We use `extends` for either a class or an interface or both
* If we do extend a class and an interface or two, the class must be the first type listed

```java
public class GenericClass<T extends AbstractClassA & InterfaceA & InterfaceB> {}
```

:::note
`&` means any type must be a subtype of all 
:::
