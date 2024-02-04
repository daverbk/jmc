# Notes

<!-- TOC -->
* [Notes](#notes)
  * [Object Oriented Programming](#object-oriented-programming)
  * [Organizing classes](#organizing-classes)
  * [Access modifiers for the class](#access-modifiers-for-the-class)
  * [Access modifiers for class members](#access-modifiers-for-class-members)
  * [Encapsulation](#encapsulation)
  * [What is null?](#what-is-null)
  * [Getters / setters](#getters--setters)
  * [`this`](#this)
  * [Constructor](#constructor)
    * [Default constructor](#default-constructor)
    * [Constructor chaining with this()](#constructor-chaining-with-this)
  * [Static vs Instance Members](#static-vs-instance-members)
    * [Static Variables](#static-variables)
      * [Can be used for](#can-be-used-for)
    * [Instance Variables](#instance-variables)
    * [Instance Methods](#instance-methods)
    * [Advice from Tim](#advice-from-tim)
  * [Plain Old Java Object](#plain-old-java-object)
  * [Record](#record)
    * [Implicit code](#implicit-code)
    * [Why have an immutable record?](#why-have-an-immutable-record)
    * [POJO vs. Record](#pojo-vs-record)
  * [Inheritance](#inheritance)
    * [`extends`](#extends)
    * [`super()`](#super)
    * [this vs super](#this-vs-super)
    * [Constructor chaining](#constructor-chaining)
    * [Code Re-use](#code-re-use)
      * [Overriding a method](#overriding-a-method)
      * [Overridden method](#overridden-method)
  * [java.lang.Object](#javalangobject)
  * [Polymorphism](#polymorphism)
    * [Method Overloading vs Overriding](#method-overloading-vs-overriding)
<!-- TOC -->

## Object Oriented Programming

* Object-oriented programming is a way to model real world objects, as software objects, which contain both data and
  code

## Organizing classes

* Classes can be organized into logical groupings, which are called packages
* You declare a package name in the class using the `package` statement
* If you don't declare a package, the class implicitly belongs to the default package

## Access modifiers for the class

* A top-level class has only two valid access modifier options: public, or none

| Keyword  | Description                                                                         |
|----------|-------------------------------------------------------------------------------------|
| `public` | public means any other class in any package can access this class                   |
| ` `      | package access, meaning the class is accessible only to classes in the same package |

## Access modifiers for class members

* The valid access modifiers are shown in this table from the least restrictive, to the most restrictive

| Keyword     | Description                                                                          |
|-------------|--------------------------------------------------------------------------------------|
| `public`    | any other class in any package can access this class                                 |
| `protected` | allows classes in the same package, and any subclasses in other packages             |
| ` `         | package access, meaning the member is accessible only to classes in the same package |
| `private`   | no other class can access this member                                                |

## Encapsulation

* Encapsulation in Object-Oriented Programming usually has two meanings
* One is the bundling of behavior and attributes on a single object
* The other is the practice of hiding fields, and some methods, from public access

## What is null?

* Means that the variable or attribute has a type, but no reference to an object
* This means that no instance, or object, is assigned to the variable or field
* Fields with primitive data types are never null

Default values for fields on classes

| Data type                              | Default value |
|----------------------------------------|---------------|
| `boolean`                              | `false`       |
| `byte`, `short`, `int`, `long`, `char` | `0`           |
| `double`, `float`                      | `0.0`         |

## Getters / setters

* The purpose of these methods is to control, and protect, access to private fields

## `this`

* `this` is a special keyword in Java
* It really refers to is the instance that was created when the object was instantiated
* So this is a special reference name for the object or instance, which it can use to describe itself

## Constructor

* A constructor is used in the creation of an object, that's an instance of a class

### Default constructor

* If a class contains no constructor declarations, then a default constructor is implicitly declared
* This constructor has no parameters, and is often called the no-args (no arguments) constructor
* If a class contains any other constructor declarations, then a default constructor is NOT implicitly declared

### Constructor chaining with this()

* Constructor chaining is when one constructor explicitly calls another overloaded constructor
* You can call a constructor only from another constructor
* You must use the special statement this() to execute another constructor, passing it arguments if required
* And this() must be the first executable statement, if it's used from another constructor

## Static vs Instance Members

### Static Variables

* Declared by using the keyword `static`
* Every instance of the class shares the same static variable
* So if changes are made to that variable, all other instances of that class will see the effect of that change

> [!NOTE]
> It is considered best practice to use the Class name, and not a reference variable to access a static variable

#### Can be used for

* Storing counters
* Generating unique ids
* Storing a constant value that doesn't change, like PI for example
* Creating, and controlling access, to a shared resource

### Instance Variables

* Also known as fields, or member variables
* Instance variables belong to a specific instance of a class
* Instance variables represent the state, of a specific instance of a class

### Instance Methods

* To use an instance method, we have to instantiate the class first
* They can access instance methods and instance variables directly
* They can also access static methods and static variables directly

### Advice from Tim

> [!NOTE]
> Whenever you see a method that doesn't use instance variables / methods, that method should probably be declared as
> a `static` method

## Plain Old Java Object

* `POJO` is a class that generally only has instance fields.
* Another acronym is `DTO`, for Data Transfer Object
* It's used to house data, and pass data, between functional classes

## Record

_Became officially part of Java in JDK 16_

* Record's purpose is to replace the boilerplate code of the POJO, but to be more restrictive
* The `record` is a special class that contains data, that's not meant to be altered
* In other words, it seeks to achieve immutability, for the data in its members
* It contains only the most fundamental methods, such as constructors and accessors
* Best of all, you the developer, don't have to write or generate any of this code

### Implicit code

```java
public record Person(String id, String name, String dateOfBirth) {
}
```

* First, it's important to understand that the part that's in parentheses, is called the record header
* The record header consists of record components, a comma delimited list of components

For each component in the header, Java generates:

* A field with the same name and declared type as the record component
* The field is declared private and final
* The field is sometimes referred to as a component field
* A public accessor method. This method has the same name and type of the component.

* Java generates a toString method that prints out each attribute in a formatted String

### Why have an immutable record?

* We want to protect the data from unintended mutations

### POJO vs. Record

> [!NOTE]
> If you want to modify data on your class, you won't be using the record
> If you're reading a lot of records, from a database or file source, and simply passing this data around, then the
> record is a big improvement

## Inheritance

A way to organize classes into a parent-child hierarchy, which lets the child inherit (re-use), fields and methods from
its parent

### `extends`

* Using `extends` we specify the superclass (or the parent class) of the class we're declaring
* A class can specify one, and only one, class in its extends clause

### `super()`

* A way to call a constructor on the super class, directly from the subclass's constructor
* Like `this()`, it has to be the first statement of the constructor
* Because of that rule, `this()` and `super()` can never be called from the same constructor.
* If you don't make a call to super(), then Java makes it for you, using super's default constructor
* If your super class doesn't have a default constructor, then you must explicitly call super() in all of your
  constructors, passing the right arguments to that constructor

### this vs super

> [!NOTE]
> We can use either of them anywhere in a class, except for static elements, like a static method. Any attempt to do so
> there, will lead to compile time errors

### Constructor chaining

> [!NOTE]
> Constructor chaining is a practice of reusing a few (one) constructors with the initialization logic inside other
> constructor overloads passing additional necessary arguments to it. Constructor chaining is an example of a good
> programming practice

### Code Re-use

* We can use code, from the parent
* Or we can change that code for the subclass

#### Overriding a method

* Overriding a method is when you create a method on a subclass, which has the same signature as a method on a super
  class
* You override a parent class method, when you want the child class to show different behavior for that method

#### Overridden method

The overridden method can do one of three things:

1. It can implement completely different behavior, overriding the behavior of the parent
2. It can simply call the parent class's method, which is somewhat redundant to do
3. Or the method can call the parent class's method, and include other code to run, so it can extend the functionality

## java.lang.Object

* Every class you create in Java, intrinsically extends `java.lang.Object`

## Polymorphism

Polymorphism simply means 'many forms’
Advantages:

* It makes code simpler
* It encourages code extensibility

### Method Overloading vs Overriding

| Method Overloading                                                      | Method Overriding                                                               |
|-------------------------------------------------------------------------|---------------------------------------------------------------------------------|
| Provides functionality to reuse a method name with different parameters | Used to override a behavior which the class has inherited from the parent class |
| Usually in a single class but may also be used in a child class         | Always in two classes that have a child-parent or IS-A relationship             |
| Must have different parameters                                          | Must have the same parameters and same name                                     |
| May have different return types                                         | Must have the same return type or covariant return type(child class)            |
| May have different access modifiers(private, protected, public)         | Must NOT have a lower modifier but may have a higher modifier                   |
| May throw different exceptions                                          | Must NOT throw a new or broader checked exception                               |
