# Things to know about development and Java

## OOP

Programming paradigm based on the concept of objects, which can contain data and code: data in the form of
fields (often known as attributes or properties), and code in the form of procedures (often known as methods)

### Polymorphism

One interface, multiple implementations

#### Parametric

In Java, it is implemented using inheritance. The child class inherits the method signatures of the parent class, but the
implementation of these methods can be different to suit the specifics of the child class. This is called method
overriding. Other functions can operate on the parent class object, but one of the child classes will be substituted for
it at runtime - late binding

#### Ad hock

When methods with the same signature take different parameters as input. This is called method
overloading

### Inheritance

An abstract data type can inherit the data and functionality of some existing type, facilitating the reuse of software
components

### Encapsulation

Hiding the internal implementation of the class and separating it from the external user interface

### Abstraction

Highlighting significant information and excluding insignificant information from consideration. OOP considers only data
abstraction, implying a set of the most significant characteristics of an object that are available to the rest of the
program

## SOLID

[The S.O.L.I.D Principles in Pictures](https://medium.com/backticks-tildes/the-s-o-l-i-d-principles-in-pictures-b34ce2f1e898)

### S — Single Responsibility

`A class should have a single responsibility`

If a Class has many responsibilities, it increases the possibility of bugs because making changes to one of its
responsibilities, could affect the other ones without you knowing

### O — Open-Closed

`Classes should be open for extension, but closed for modification`

Changing the current behaviour of a Class will affect all the systems using that Class. If you want the Class to perform
more functions, the ideal approach is to add to the functions that already exist NOT change them

### L — Liskov Substitution

`If S is a subtype of T, then objects of type T in a program may be replaced with objects of type S without altering
any of the desirable properties of that program`

The child Class should be able to process the same requests and deliver the same result as the parent Class or it could
deliver a result that is of the same type

### I — Interface Segregation

`Clients should not be forced to depend on methods that they do not use`

This principle aims at splitting a set of actions into smaller sets so that a Class executes ONLY the set of actions it
requires

### D — Dependency Inversion

`High-level modules should not depend on low-level modules. Both should depend on the abstraction`

`Abstractions should not depend on details. Details should depend on abstractions`

This principle says a Class should not be fused with the tool it uses to execute an action. Rather, it should be fused
to the interface that will allow the tool to connect to the Class

It also says that both the Class and the interface should not know how the tool works. However, the tool needs to meet
the specification of the interface


