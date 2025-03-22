---
slug: /abstraction
title: Abstraction 🔮
description: Abstract classes and Interfaces.
sidebar_position: 5
sidebar_custom_props:
  emoji: 🔮
---

# Abstraction 

Java supports abstraction in several different ways:

* Java allows us to create a class hierarchy, where the top of the hierarchy, the base class, is usually an abstract
  concept, whether it's an abstract class or not
* Java lets us create abstract classes
* Java gives us a way to create interfaces

## Abstract method

* An abstract method is unimplemented
* We can think of an abstract method as a contract, that promises that all subtypes will provide the promised
  functionality, with the agreed upon name and arguments

## Concrete method

* A concrete method has a method body, usually with at least one statement
* A concrete method is said to implement an abstract method, if it overrides one

## Method Modifiers

| Modifier       | Purpose                                                                                                                                                    |
|----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `abstract`     | When we declare a method abstract, a method body is always omitted. An abstract method can only be declared on an `abstract class` or an `interface`       |
| `static`       | Sometimes called a class method, rather than an instance method, because it's called directly on the Class instance                                        |
| `final`        | Cannot be overridden by subclasses                                                                                                                         |
| `default`      | This modifier is only applicable to an interface. They allow us to add new methods to an interface that are automatically available in the implementations |
| `native`       | This is another method with no body. The method body will be implemented in platform-dependent code, typically written in another programming language     |
| `synchronized` | Indicate that a method can be accessed by only one thread at a time                                                                                        |

## Abstract class

### When

* We want to share code among several closely related classes
* We expect classes that extend our abstract class to have many
  common methods or field or require access modifiers other than public
* We want to declare non-static or non-final fields, so this enables us
  to define methods that can access and modify state of an object
* We have a requirement for our base class to provide a default implementation
  of certain methods but other methods should be open to being overridden by child classes

**Summary: An abstract class provides a common definition as a base class that multiple
derived classes can share**

## Interface

### When

* We expect that unrelated classes will implement our interface
* We want to specify the behavior of a particular data type, but we are not concerned about
  who implements its behavior
* We want to separate different behavior

**Summary: The interface decouples the "what" from the "how" and is used to make different types
behave in similar ways**

## Abstract class vs Interface

|                                                 | Abstract Class | Interface                              |
|-------------------------------------------------|----------------|----------------------------------------|
| An instance can be created from it              | ❌              | ❌                                      |
| Has a constructor                               | ✅              | ❌                                      |
| Records and enums can extend or implement       | ❌              | ✅                                      |
| Inherits from java.lang.Object                  | ✅              | ❌                                      |
| Can have both abstract and concrete methods     | ✅              | ✅ (as of JDK 8)                        |
| Abstract methods must include abstract modifier | ✅              | ❌                                      |
| Supports default modifier for it's methods      | ❌              | ✅ (as of JDK 8)                        |
| Can have instance fields                        | ✅              | ❌                                      |
| Can have static fields                          | ✅              | ✅ (implicitly **public static final**) |

## A class can use extends and implements in same declaration

```java
public class Bird extends Animal implements FlightEnabled, Trackable {
    
}
```

## `final` modifier

* `for a method`: a final means it can't be overridden by a subclass
* `for an object's field`: can't be reassigned or given a different value, after its initialization
* `for a static field`: class field that can't be reassigned, or given a different value, after the class's
  initialization process
* `for a class`: can't be overridden, meaning no class can use it, in the `extends` clause
* `for a variable, in a block of code`: once it's assigned a value, any remaining code in the block can't change it
* `for a final method parameter`: we can't assign a different value to that parameter in the method code block

## Constants

A constant variable is a final variable of primitive type, or type `String`, that is initialized with a constant
expression
