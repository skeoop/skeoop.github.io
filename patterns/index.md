---
title: Design Patterns
---

Presentation: [Intro to Design Patterns](Intro-Design-Patterns.pdf)

*Design Patterns* are reusable designs for common, recurring situations. 

Each design pattern consists of:

* **Context** - a situation where a design solution is needed
* **Forces** (or Motivation) - motivation or "needs" of the situation
* **Solution** - a design that solves the problem
* **Applicability** - when the pattern applies.  The "applicability" can help you choose between multiple possible solutions and avoid misusing a pattern.
* **Consequences** - good and back effects of this solution
* **Example** - an example of using the pattern

### Principles & Goals Motivate Patterns

Design Patterns are motivated by design **Goals** and **Principles**.


The Need: Software is plagued by these problems

* change - requirements change, technology changes, the environment where software is used changes
* bugs (errors)
* complexity
* difficult to maintain and evolve over time

These forces have given rise to **principles** for good design and coding.

## Principles and Goals for Software Design

These "principles" for good design have emerged 
from experience solving common problems with software,
through repeated application.

These principles are what motivate the design patterns.

This is only a brief summary.
Please read the references to learn in more depth.

* **Single Responsibility** - a class should have one responsibility. Robert Martin explains this as *a class has only one reason to change*, e.g. one driver or boss that decides what it should do.

* **Open-Closed Principle** - you can extend the functionality of a class without modifying the class itself

* **Liskov Substtitution Principle** - in an application, you should be able to use a subclass object anywhere it's superclass is expected and the application will behave as expected. Subclasses should pass the "*is a*" test.

* **Don't Repeat Yourself** - avoid duplicate logic and duplicate code (applies to design *and* coding)

* **Prefer delegation over inheritance**. It is more flexible to design objects so that A delegates behavior to B, and set B as an attribute of A, rather than make B a subclass of A that specializes some behavior. The Adapter, State, and Strategy patterns all use delegation.

* **Code to a specification, not an implementation**.  Write code based on the specification (or public interface) for how an object or method *should* behave rather than details of how it's implemented. In Java, depend on the *List* API rather than *ArrayList* (an implementation). 
* **Depend on abstractions, not on concretions**. Similar to the previous principle, but at a higher (more abstract) level.

* **Don't Reinvent the Wheel**.  Don't write code for something that the language already provides, or something that can be provided by an existing, well-tested and maintained package.  For example, don't write your own CSV file parser or password encrypter. There are lots of these and they contain fewer (if any) flaws that what you would write yourself.

* **Separate what Varies from what Stays the Same, and Encapsulate the part that Varies**.  "What" means "a part of the code or some behavior of the code". 

* **Information Expert** - put a method in the class that has most of the information needed to perform the method.

* **Separation of Concerns** - classes and components (groups of classes) should each be concerned with a single aspect of the program. A Data Access Object is concerned with saving and retrieving objects to/from a database, but doesn't manipulate the objects itself. Separating object creation from object use is often helpful -- e.g. use a Factory for objects.

* **Dependency Injection** - If an object depends on some other object, try to *inject* that dependency from other code, esp if the dependent part may change.  This helps with *Separation of Concerns*, *Separate what changes from what stays the same*, and reduces coupling.
  - Example: in Coin Purse we *inject* a WithdrawStrategy using a `set` method.

* **Strive for Loosely Coupled Objects** (Low Coupling), especially. coupling to unstable or unrelated things. Coupling to essential, stable APIs (the Java or Python API, the JDBC API) isn't a problem because these are quite stable and well maintained.

* **Command-Query Separation** - queries should not change the state of an object

* **Simplicity** - complexity is the enemy of correctness and security. Strive for simple designs.
 


## Goals for Class Design

Some **goals** for class design (the 5 "C"s of class interface design)

- High Cohension
- Consistency - be consistent in naming of methods, variables, and classes. Be consistent in their behavior, too.
- Completeness - a class should provide enough methods for it's intended use.
- Convenience - try to provide an API that's *convenient* for the programmer, but don't create lots of redundant methods.
- Clarity - a method or class's name and interface should clearly suggest it's purpose


## Specific Design Patterns 

The links are presentation slides.

* [Adapter Pattern](Adapter-Pattern.pdf) adapt the iterface of an object
* [Command Pattern](Command-Pattern.pdf) separate the requester of a behavior from the invoker of the behavior by encapsulating it
* [Composite Pattern](Composite-Pattern.pdf) use a collection of objects the same way as a single object of the same type
* [Decorator Pattern](Decorator-Pattern.pdf) add or enhance a behavior without modifying existing classes
* [Factory Method Pattern](Factory-Method-Slides.pdf) and [Factory Methods](Factory-Methods.pdf) encapsulate object creation and make it polymorphic
* Iterator - a mechanism for iterating over a group of objects without knowing the structure of the group
* [Model-View-Controller (MVC) Pattern](MVC-Pattern.pdf) the "king" of design patterns, typically used in web apps. Can be a bit hard to grasp at first.
* [Observer Pattern](Observer-Pattern.pdf) also called Publish - Subscribe
* [Singleton Pattern](Singleton-Pattern.pdf) ensure that only one instance of a class is created
* State Pattern - change an object's behavior depending on state (without using "if")
* [Strategy Pattern](Strategy-Pattern.pdf) an interchangeable set of algorithms for performing some task
* [Graphics Patterns](Graphics-Patterns.pdf) that occur frequently in graphical user interfaces

## Exercises

[Design Pattern Exercises](Patterns-Exercises.pdf)

## Learn More


* [Refactoring Guru](https://refactoring.guru/design-patterns) has a [catalog of patterns](https://refactoring.guru/design-patterns/catalog) with very visual examples and pseudocode, 

* [Python Patterns Guide](https://python-patterns.guide/) explains how and "why" to apply patterns in Python. Some good insight but I think you need to know a particular pattern before reading his explanation.

* [Wikipedia](https://en.wikipedia.org/wiki/Software_design_pattern) has a list of patterns with a page describing each one,

* [Geekforgeeks](https://www.geeksforgeeks.org/software-design-patterns/) has good descriptions with UML and Java examples.

* [Game Programming Patterns](https://gameprogrammingpatterns.com/contents.html) application of patterns to games. Examples use C++.
Good books for Java programmers are:

* [Design Patterns](OOSE-ch6-Design-Patterns.pdf) chapter 6 from *Object-Oriented Software Engineering*, 2E.
* _Design Patterns Explained_ by Shalloway and Trott.
* _Head First Design Patterns_. Memorable and entertaining examples, but the example code is too simple.
* _Design Patterns: Elements of Reusable O-O Software_ by Gamma, Helm, Johnson, and Vlissides.
  - the original design patterns book, aka "*The Gang of Four Book*"
  - valuable learning and has design principles. Uses C++ for examples.
