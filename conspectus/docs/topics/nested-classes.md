---
slug: /nested-classes
title: Nested Classes 🪆
description: Sealed and nested classes.
sidebar_position: 7
sidebar_custom_props:
  emoji: 🪆
---

# Nested Classes 

A class can contain other types within the class body, such as other `classes`, `interfaces`, `enums`, and `records`

## Nested Classes

| Type                    | Description                                                                                                 |
|-------------------------|-------------------------------------------------------------------------------------------------------------|
| static nested class     | declared in class body. Much like a static field, access to this class is through the Class name identifier |
| instance or inner class | declared in class body. This type of class can only be accessed through an instance of the outer class      |
| local class             | declared within a method body                                                                               |
| anonymous class         | unnamed class, declared and instantiated in same statement.                                                 |

* As of JDK16, all four types of nested classes can have static members of any type, including static methods

### Static Nested Class

```java
InnerClass innerClass = new OutherClass.InnerClass();
```

### Inner Classes

```java
OuterClass outerClass = new OuterClass();
OuterClass.InnerClass innerClass = outerClass.new InnerClass();
```

### Local Classes

* They don't have access modifiers
* Can access local variables and method arguments, that are `final` or effectively final

#### Local Class's 'Captured Variables'

* When we create an instance of a local class, referenced variables used in the class, from the enclosing code, are '
  captured'
* This means a copy is made of them, and the copy is stored with the instance
* This is done because the instance is stored in a different memory area, then the local variables in the method
* For this reason, if a local class uses local variables, or method arguments, from the enclosing code, these must be
  final or effectively final

#### Effectively Final

Local variable or a method argument are effectively final, if a value is assigned to them, and then never changed after
that

### Anonymous Classes

```java
var comparator = new Comparator<Employee>() { };
```

On the place of `Comparator` can be the `super` class of the anonymous class, or the `interface` this anonymous class
will implement
