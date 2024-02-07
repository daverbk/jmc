# Notes

<!-- TOC -->
* [Notes](#notes)
  * [The Lambda Expression](#the-lambda-expression)
  * [Anonymous class and the lambda expression](#anonymous-class-and-the-lambda-expression)
    * [Anonymous Class](#anonymous-class)
    * [Lambda Expression](#lambda-expression)
      * [Lambda expression variations](#lambda-expression-variations)
        * [For a single parameter](#for-a-single-parameter)
        * [The lambda body](#the-lambda-body)
          * [Single expression](#single-expression)
          * [Code block](#code-block)
        * [With multiple parameters](#with-multiple-parameters)
        * [The lambda body](#the-lambda-body-1)
          * [Single expression](#single-expression-1)
          * [Code block](#code-block-1)
  * [`java.util.function`](#javautilfunction)
    * [Basic categories of Functional Interfaces](#basic-categories-of-functional-interfaces)
      * [The `Consumer` interface](#the-consumer-interface)
      * [The `Predicate` Interface](#the-predicate-interface)
      * [The `Function` Interface](#the-function-interface)
      * [The Supplier Interface](#the-supplier-interface)
    * [Valid Lambda Declarations](#valid-lambda-declarations)
    * [Method Reference](#method-reference)
      * [Deferred Method Invocation](#deferred-method-invocation)
      * [For static methods](#for-static-methods)
      * [For a Bounded Receiver](#for-a-bounded-receiver)
      * [For an Unbounded Receiver](#for-an-unbounded-receiver)
  * [Convenience Methods](#convenience-methods)
  * [Comparator's additional helper methods](#comparators-additional-helper-methods)
<!-- TOC -->

* A lambda expression can be thought of as implicit code for an anonymous class, using a special kind of interface, as
  the
  mechanics to do this
* The method reference goes even further, and is a shortcut for the lambda expression syntax, for existing methods

## The Lambda Expression

| Lambda Expression                                    | Comparator’s Abstract Method |
|------------------------------------------------------|------------------------------|
| `(o1, o2) -> o1.lastName().compareTo(o2.lastName())` | `int compare(T o1, T o2)`    |

* The lambda expression parameters are determined by the associated interface's method, the functional method
* A lambda expression consists of a formal parameter list, usually but not always declared in parentheses; the arrow
  token; and either an expression or a code block after the arrow token
* The expression should return a value, if the associated interface's method returns a value

## Anonymous class and the lambda expression

### Anonymous Class

```java
new Comparator<Person>() {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.lastName().compareTo(o2.lastName());
    }
}
```

### Lambda Expression

```java
(o1,o2)->o1.lastName().compareTo(o2.lastName());
```

* Lambda expression has no reference to an enclosing method, the method is inferred by Java
* Java requires types which support lambda expressions, to be something called a functional interface
* A functional interface is an interface that has one, and only one, abstract method
* A functional interface is the target type for a lambda expression

#### Lambda expression variations

##### For a single parameter

| Lambda Expression                                  | Description                                                |
|----------------------------------------------------|------------------------------------------------------------|
| `element -> System.out.println(element);`          | A single parameter without a type can omit the parentheses |
| `(element) -> System.out.println(element);`        | Parentheses are optional                                   |
| `(String element) -> System.out.println(element);` | Parentheses required if a reference type is specified      |
| `(var element) -> System.out.println(element);`    | A reference type can be `var`                              |

##### The lambda body

###### Single expression

```java
element ->System.out.println(element);
```

###### Code block

```java
element -> {
    char first = element.chartAt(0);
    System.out.println(element + " means " + first);
}; 
```

##### With multiple parameters

| Lambda Expression                  | Description                                                                                       |
|------------------------------------|---------------------------------------------------------------------------------------------------|
| `(a, b) -> a + b;`                 | Parentheses are always required. Explicit types are not                                           |
| `(Integer a, Integer b) -> a + b;` | If you use an explicit type for one parameter, you must use explicit types for all the parameters |
| `(var a, var b) -> a + b;`         | If you use var for one parameter, you must use var for all parameters                             |

##### The lambda body

###### Single expression

```java
(a,b) -> a +b;
```

###### Code block

```java
(a,b) -> {
    var c = a + b;
    return c;
};
```

## `java.util.function`

* Java provides a library of functional interfaces in the `java.util.function` package

### Basic categories of Functional Interfaces

| Interface Category | Basic Method Signature | Purpose                                     |
|--------------------|------------------------|---------------------------------------------|
| `Consumer`         | `void accept(T t)`     | execute code without returning data         |
| `Function`         | `R apply(T t)`         | return a result of an operation or function |
| `Predicate`        | `boolean test(T t)`    | test if a condition is true or false        |
| `Supplier`         | `T get()`              | return an instance of something             |

#### The `Consumer` interface

The two most common:

| Interface Name | Method Signature        |
|----------------|-------------------------|
| `Consumer`     | `void accept(T t)`      |
| `BiConsumer`   | `void accept(T t, U u)` |

Example:

```java
s -> System.out.println(s)
```

#### The `Predicate` Interface

The two most common:

| Interface Name | Method Signature         |
|----------------|--------------------------|
| `Predicate`    | `boolean test(T t)`      |
| `BiPredicate`  | `boolean test(T t, U u)` |

Example:

```java
s -> s.equalsIgnoreCase("Hello")
```

#### The `Function` Interface

The four most common:

| Interface Name        | Method Signature       |
|-----------------------|------------------------|
| `Function<T, R>`      | `R apply(T t)`         |
| `BiFunction<T, U, R>` | `R apply(T t, U u)`    |
| `UnaryOperator<T>`    | `T apply(T t)`         |
| `BinaryOperator<T>`   | `T apply (T t1, T t2)` |

Example:

```java
Function<String, String[]> function = s -> s.split(",")
```

#### The Supplier Interface

Takes no argument, but lambda expressions can use final or effectively final variables in their expressions

Example:

```java
() -> random.nextInt(1,100)
```

### Valid Lambda Declarations

| Arguments in Functional Method                                                                                                               | Valid lambda syntax                                                                              |
|----------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| None                                                                                                                                         | `() -> statement`                                                                                |
| One                                                                                                                                          | `s -> statement`<br/>`(s) -> statement`<br/>`(var s) -> statement`<br/>`(String s) -> statement` |
| Two<br/> 1. When using `var`, all arguments must use `var`<br/> 2. When specifying explicit types, all arguments must specify explicit types | `(s, t) -> statement`<br/>`(var s, var t) -> statement`<br/>`(String s, List t) -> statement`    |

### Method Reference

* Methods which can be used, are based on the context of the lambda expression
* This means the method reference, is again dependent on the targeted interface's method
* We can reference a `static` method on a class
* We can reference an instance method from either an instance external to the expression, or an instance passed as one
  of the arguments
* Or you can reference a constructor, by using `new` as the method

| Lambda Expression            | Method Reference      |
|------------------------------|-----------------------|
| `s -> System.out.println(s)` | `System.out::println` |

#### Deferred Method Invocation

* When you create variables that are lambda expressions or method references, it's important to remember that the code
  isn't invoked at that point
* The statement or code block gets invoked at the point in the code that the targeted functional method is called

#### For static methods

```java
Integer::sum
```

#### For a Bounded Receiver

An instance derived from the enclosing code, used in the lambda expression, on which the method will be invoked

```java
System.out::println
```

#### For an Unbounded Receiver

The first argument becomes the instance used, on which the method gets invoked

```java
String::concat
```

| Type                                                                     | Syntax                                                 | Method Reference Example | Corresponding Lambda Expression |
|--------------------------------------------------------------------------|--------------------------------------------------------|--------------------------|---------------------------------|
| static method                                                            | `ClassName::staticMethodName(p1, p2, ... pn)`          | `Integer::sum`           | `(p1, p2) -> p1 + p2`           |
| instance method of a particular (Bounded) object                         | `ContainingObject::instanceMethodName(p1, p2, ... pn)` | `System.out::println`    | `p1 -> System.out.println(p1)`  |
| instance method of an arbitrary (Unbounded) object (as determined by p1) | `ContainingType[=p1]::instanceMethodName(p2, ... pn)`  | `String::concat`         | `(p1, p2) -> p1.concat(p2)`     |
| constructor                                                              | `ClassName::new`                                       | `Player::new`            | `() -> new Player()`            |

## Convenience Methods

| Category of Interface | Convenience method example     | Notes                                                        |
|-----------------------|--------------------------------|--------------------------------------------------------------|
| `Function`            | `function1.andThen(function2)` | Not implemented on IntFunction, DoubleFunction, LongFunction |
| `Function`            | `function2.compose(function1)` | Only implemented on Function & UnaryOperator                 |
| `Consumer`            | `consumer1.andThen(consumer2)` |                                                              |
| `Predicate`           | `predicate1.and(predicate2)`   |                                                              |
| `Predicate`           | `predicate1.or(predicate2)`    |                                                              |
| `Predicate`           | `predicate1.negate()`          |                                                              |

## Comparator's additional helper methods

| Type of Method | Method Signature                                  |
|----------------|---------------------------------------------------|
| `static`       | `Comparator comparing(Function keyExtractor)`     |
| `static`       | `Comparator naturalOrder()`                       |
| `static`       | `Comparator reverseOrder()`                       |
| `default`      | `Comparator thenComparing(Comparator other)`      |
| `default`      | `Comparator thenComparing(Function keyExtractor)` |
| `default`      | `Comparator reversed()`                           |
