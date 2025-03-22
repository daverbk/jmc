---
slug: /immutables
title: Immutables 🐛
description: Immutability and how to support it.
sidebar_position: 10
sidebar_custom_props:
  emoji: 🐛
---

# Immutables

## Mutable vs Immutable

* An immutable object is an object whose internal state remains constant
* A mutable object is an object whose internal state does not remain constant

### Immutable Objects - Advantages

* An immutable class is inherently thread-safe, because no threads at all can change it, once it's been constructed
* An immutable object isn't subject to unwanted, unplanned and unintended modifications, known as side effects

### Immutable Objects - Disadvantages

* When a new value is needed, we're probably going to need to make a copy of the object with the new value

## `final`

* A `final` method means it can't be overridden by a subclass
* A `final` field means an object's field can't be reassigned or given a different value, after its initialization
* A `final` static field is a class field that can't be reassigned, or given a different value, after the class's
  initialization process. A field declared on an Interface is always `public`, `static` and `final`
* A `final` class can't be overridden, meaning no class can use it, in the extends clause
* A `final` variable, in a block of code, means that once it's assigned a value, any remaining code in the block can't
  change it
* A `final` method parameter means, we can't assign a different value to that parameter in the method code block

### `final` on methods

* Using `final` on an instance method means subclasses can't **override** it
* Using `final` on a class (static) method means subclasses can't **hide** it

### `final` on variables

* When we use `final`, it doesn't mean the variable is immutable at that point, it means you can't assign or reassign a
  new instance, or variable or expression to it, after the initialization
* If we use `final` for method parameters, this means we cannot assign any values to the method parameters in the code

## How to declare a class to produce immutable objects

* Make instance fields `private` and `final`
* Do not define any setter methods
* Create defensive copies in any getters
* Use a constructor or factory method to set data, making copies of mutable reference data
* Mark the class final, or make all constructors `private`

## Defensive Copies

* When we pass mutable types to an immutable object, a defensive copy should be made. The defensive copy should then be
  assigned to the instance field
* When we retrieve data, you should first make a defensive copy, and pass the defensive copy back to the calling code

## Shallow Copy vs Deep Copy

* A shallow copy only makes a copy of the structure, and not a copy of the elements in the structure
* A deep copy makes a copy of both the structure, and copies of each element in that structure

## Unmodifiable Collections vs Unmodifiable Collection Views

* It is very important to understand that unmodifiable collections are **NOT** immutable collections. They become
  immutable
  collections, if the elements in the collections themselves are fully immutable

They are collections with limited functionality that can help us minimize mutability:

* We can't remove, add or clear elements from an immutable collection
* We also can't replace or sort elements
* Mutator methods will throw an UnsupportedOperationException
* We can't create this type of collection with nulls

|        | Unmodifiable Copy of Collection                                | Unmodifiable View of Collection                                                                              |
|--------|----------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|
| `List` | `List.copyOf`, `List.of`                                       | `Collections.unmodifiableList`                                                                               |
| `Set`  | `Set.copyOf`, `Set.of`                                         | `Collections.unmodifiableSet`, `Collections.unmodifiableNavigableSet`, `Collections.unmodifiableSortedSet`   |
| `Map`  | `Map.copyOf`, `Map.entry(K k, V v)`, `Map.of`, `Map.ofEntries` | `Collections.unmodifiableMap`, `Collections.unmodifiableNavigableMap`, `Collections.unmodifiableSortableMap` |

## The instance initializer block

* An instance initializer is a block of code declared directly in a class body
* This code gets executed when an instance of the class is created
* Instance initializers are executed, before any code in class constructors is executed
* We can have multiple initializer blocks. They will be executed in the order they are declared

### Static Initializers

* A static initializer is called the first time a class is referenced or constructed
* A class can have any number of static initialization blocks
* They can be declared anywhere in the class body
* They're called in the order they appear in the source code
* This will get executed only during the class's construction and not each instance's construction

## Record Constructors

* The `Canonical`, or Long constructor is the implicitly generated constructor. We can explicitly declare our own,
  which means the implicit one won't get generated. If we do declare our own, we must make sure fields all get
  assigned a value
* The `Custom` constructor is just an overloaded constructor. It must explicitly call the canonical constructor as it's
  first statement
* The `Compact`, or Short constructor is a special kind of constructor, used only on records. It's a succinct way of
  explicitly declaring a canonical constructor

### `Compact`

* We can't have both a compact constructor and an explicit canonical constructor
* This constructor is declared with no parentheses, so no arguments
* It has access to all the arguments of the canonical constructor. Don't confuse the arguments with the instance fields
* We can't do assignments to the instance fields in this constructor
* The implicit canonical constructor's assignments occur after the execution of this code

## `javap`

It lists class members, by default just public and protected members in the class file. This helps us 'see' implicit
code in the compiled class file

```shell
javap path/to/.class/file
```

Example output: 

```shell
Compiled from "Card.java"
public final class games.Card extends java.lang.Record {
  public games.Card(games.Card$Suit, java.lang.String, int);
  public static java.util.Comparator<games.Card> sortRankReversedSuit();
  public java.lang.String toString();
  public static games.Card getNumericCard(games.Card$Suit, int);
  public static games.Card getFaceCard(games.Card$Suit, char);
  public static java.util.List<games.Card> getStandardDeck();
  public static void printDeck(java.util.List<games.Card>);
  public static void printDeck(java.util.List<games.Card>, java.lang.String, int);
  public final int hashCode();
  public final boolean equals(java.lang.Object);
  public games.Card$Suit suit();
  public java.lang.String face();
  public int rank();
}
```

## `final` classes

* Using the `final` keyword on a class means it can't be extended
* We declare a class `final` if its definition is complete, and no subclasses are desired or required
* `Enums` and `Records` are `final` classes
* Subclasses can take advantage of mutable fields on parent classes, if the parent classes aren't implementing defensive
  code. One of the easiest ways to prevent this, is to make your class `final`

| Operations                              | `final` class | `abstract` class | `private` constructors only | `protected` constructors only                         |
|-----------------------------------------|---------------|------------------|-----------------------------|-------------------------------------------------------|
| Instantiate a new instance	             | yes           | no               | no                          | yes, but only subclasses, and classes in same package |
| A subclass can be declared successfully | no            | yes              | no                          | yes                                                   |

## `sealed` classes

* JDK17 introduced a new modifier, `sealed`, for our classes and interfaces
* This modifier can be used for both outer types and nested types
* When used, a `permits` clause is also required in most cases, which lists the allowed subclasses
* Subclasses can be nested classes, classes declared in the same file, classes in the same package, or if using Java's modules, in the same module
* A sealed class and its direct subclasses create a circular reference
* In addition, the sealed keyword puts a requirement on all the subclasses that were declared in the `permits` clause. It
  requires each subclass to declare one of the three valid modifiers for a class extending a `sealed` class. These are
  `final`, `sealed` or `non-sealed`.
