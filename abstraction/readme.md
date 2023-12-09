# Abstract class

### When:

* We want to share code among several closely related classes
* We expect classes that extend our abstract class to have many
common methods or field or require access modifiers other than public
* We want to declare non-static or non-final fields, so this enables us
to define methods that can access and modify state of an object
* We have a requirement for our base class to provide a default implementation 
of certain methods but other methods should be open to being overridden by child classes

**Summary: An abstract class provides a common definition as a base class that multiple 
derived classes can share**

# Interface

### When:

* We expect that unrelated classes will implement our interface
* We want to specify the behavior of a particular data type, but we are not concerned about
who implements its behavior
* We want to separate different behavior

**Summary: The interface decouples the "what" from the "how" and is used to make different types 
behave in similar ways**

# Abstract class vs Interface

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
