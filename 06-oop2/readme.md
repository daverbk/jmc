# Notes

<!-- TOC -->
* [Notes](#notes)
  * [Inheritance vs Composition](#inheritance-vs-composition)
    * [Advice from Tim](#advice-from-tim)
      * [Why is Composition preferred?](#why-is-composition-preferred)
      * [Why is Inheritance less flexible?](#why-is-inheritance-less-flexible)
  * [Encapsulation](#encapsulation)
    * [Encapsulation Principles](#encapsulation-principles)
  * [Polymorphism](#polymorphism)
    * [Ad-hock](#ad-hock)
    * [Parametric](#parametric)
  * [Local Variable Type Inference](#local-variable-type-inference)
    * [Compile Time Typing](#compile-time-typing)
    * [Run Time Typing](#run-time-typing)
    * [`instanceof` operator](#instanceof-operator)
  * [`package`](#package)
<!-- TOC -->

## Inheritance vs Composition

* Inheritance defines an `IS A` relationship
* Composition defines a `HAS A` relationship

### Advice from Tim

* As a general rule, when you're designing your programs in Java, you probably want to look at composition first
* Most of the experts will tell you, that as a rule, look at using composition before implementing inheritance

#### Why is Composition preferred?

* Composition is more flexible. You can add parts in, or remove them, and these changes are less likely to have a
  downstream effect
* Composition provides functional reuse outside the class hierarchy, meaning classes can share attributes & behavior, by
  having similar components, instead of inheriting functionality from a parent or base class
* Java's inheritance breaks encapsulation, because subclasses may need direct access to a parent's state or behavior

#### Why is Inheritance less flexible?

* Adding a class to, or removing a class from, a class hierarchy, may impact all subclasses from that point
* In addition, a new subclass may not need all the functionality or attributes of its parent class

## Encapsulation

Means hiding things, by making them private, or inaccessible

Why?

* To make the interface simpler, we may want to hide unnecessary details
* To protect the integrity of data on an object, we may hide or restrict access to some of the data and operations
* To decouple the published interface from the internal details of the class, we may hide actual names and types of
  class members

### Encapsulation Principles

To create an encapsulated class, you want to:

* Create constructors for object initialization, which enforces that only objects with valid data will get created
* Use the `private` access modifier for your fields
* Use setter and getter methods sparingly, and only as needed
* Use access modifiers that aren't `private`, only for the methods that the calling code needs to use

## Polymorphism

Polymorphism lets us write code to call a method, but at runtime, this method's behavior can be different, for different
objects

"Single interface, many implementations"

### Ad-hock

polymorphism of methods, when methods with the same signature take different parameters as input. This is called _method
overloading_.

### Parametric

Is implemented using inheritance. A pot class inherits the method signatures of its parent class, but the implementation
of these methods can be different to suit the specifics of the child class. This is called _method overriding_. Other
functions can operate on the parent class object, with one of the child classes replacing it at runtime. This is called
late binding.

## Local Variable Type Inference

### Compile Time Typing

* Compile time type is the declared type
* This type is declared either as a variable reference, or a method return type, or a method parameter, for example

### Run Time Typing

* We don't declare a type for the compiled reference type, it gets inferred, but the byte code is the same, as if we had
declared it

### `instanceof` operator

* The `instanceof` operator, lets you test the type of object or instance
* The reference variable you are testing, is the left operand
* The type you are testing for, is the right operand

If the JVM can identify that the object matches the type, it can extract data from the object, without casting

```java
public void someMethod(Object unknownObject) {
  if (unknownObject instanceof Person person) {
      // we can now use person without casting
  }
}
```

## `package`

Packages let us re-use common class names across different libraries or applications, and provide a way to identify the
correct class, either with an import statement, or a qualifying name

* A package is a namespace that organizes a set of related types
* In general, a package corresponds to a folder or directory, on the operating system, but this isn't a requirement
* Common practice has package names as all lower case
* The period separates the hierarchical level of the package

It is common practice, to use the reverse domain name to start your own package naming conventions

> [!NOTE]
> The package statement needs to be the first statement in the code, except for comments
> 
> The package statement comes before any import statements

> [!CAUTION]
> If we don't specify a package statement our class is put to the "Unnamed package" (default one)
> 
> We can't qualify the name, if it's in the default package, and can't import classes from the default package
