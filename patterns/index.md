---
title: Design Patterns
---

*Design Patterns* are reusable designs for common situations. 

Each design pattern consists of:

* Context - a situation where a design solution is needed
* Forces (or Motivation) - motivation or "needs" of the situation
* Solution - a design that solves the problem
* Applicability - when the pattern applies.  There may be many solutions to a particular context; the applicability can help.
* Consequences - good and back effects of this solution
* Example - each pattern has at least one example of its use

### Principles & Goals Motivate Patterns

Design Patterns are motivated by some design Goals and Principles.

Software is plagued by:

* change - requirements change, technology changes, the environment where software is used changes
* bugs (errors)
* complexity
* difficult to maintain or evolve over time

These forces have given rise to some *principles* for good design and coding.

You can become a better programmer by studying the principles behind the patterns,
and how they lead to some Design Patterns.

Slides: [Intro to Design Patterns](Intro-Design-Patterns.pdf)

## Specific Patterns (Presentation files)

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

[Design Patterns](OOSE-ch6-Design-Patterns.pdf) chapter 6 from *Object-Oriented Software Engineering*, 2E.

[Python Patterns Guide](https://python-patterns.guide/) explains how and "why" to apply patterns in Python. Some good insight but I think you need to know a particular pattern before reading his explanation.

Lots of design patterns material on the web.    
[Wikipedia](https://en.wikipedia.org/wiki/Software_design_pattern) has a list of patterns with a page describing each one,
[Refactoring Guru](https://refactoring.guru/design-patterns) has a
[catalog of patterns](https://refactoring.guru/design-patterns/catalog) with very visual examples and pseudocode,
and
[Geekforgeeks](https://www.geeksforgeeks.org/software-design-patterns/) has good descriptions with UML and Java examples.


Good books for Java programmers are:

* _Design Patterns Explained_ by Shalloway and Trott.
* _Head First Design Patterns_. Memorable and entertaining examples, but the example code is too simple.
* _Design Patterns: Elements of Reusable O-O Software_ by Gamma, Helm, Johnson, and Vlissides.
  - the original design patterns book, aka "*The Gang of Four Book*"
  - valuable learning, but maybe a bit hard at first. Uses C++ for examples.
