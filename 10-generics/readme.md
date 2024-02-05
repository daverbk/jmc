# Notes

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

