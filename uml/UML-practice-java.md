---
layout: page
title: UML Practice
description: 
---

## UML Practice

Problem 1. Draw a UML class diagram of this code.  Show relationships between classes and multiplicity of association.

```java
class Person {
    private String name;
    public String getName() { return name; }
}

public class Student extends Person implements Comparable<Student> {
    private Long id;
    private List<Enrollment> courseList; 
    public Student(String name, Long id) { /* code omitted. */ }

    public int compareTo(Student other) { /* code omitted */ }

    // an unmodifiable (immutable) view of the student's course list
    public List<Enrollment> getCourseList() {
        return Collections.unmodifiableList( courseList );
    }
}

public class Enrollment {

}
```

Problem 2. Add add some detail for grades, including an Enum for grades.

    * The example on [UMLDiagrams.org](https://www.uml-diagrams.org/class-diagrams-overview.html) shows how to draw an enum (enumeration type).  
    * In UML class diagram, OK to write `<<enum>>` instead of `<<enumeration>>`.

> An Enum (enumeration) is a type with a fixed set of static members.
> You access them using Grade.A, Grade.B, etc.
> The members have type Grade and are public, but you can't create new objects from an enum.
> You can use enum type in assignments and as parameters, e.g.:    
> `Grade g = Grade.A;`
    
```java
public class Enrollment {
    private Course course;
    private Student student;
    private Grade grade;

    public Enrollment(Course course) ...;

    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
}

public class Course {
    private long courseId;
    private int credits;
    private String title;
}

public enum Grade {
    // static members of the enum
    A,
    B,
    C,
    D,
    F,
    I,
    N, // for enrollment with no grade yet
    W;
    // behavior and attributes omitted
} 
```

Problem 3. Difference between *association* and *dependency* (uses).  This is one of the most **common errors** made by students.

What are the relationships between Main, Game, and GameConsole?

```java
public class Game {
    private int secret;
    private int upperBound;
    public Game(int upperbound) { ... }

    public boolean guess(int number) { ... }
}

public class GameConsole {
    // no attributes!

    public int play(Game game) {
        // play the game and return the secret number
    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game(1000000);
        GameConsole console = new GameConsole();
        int secret = console.play(game);
        ...
    }
}
```

Problem 4. Factory method. The `Registrar` class is a Factory for creating enrollments.

```java
public class Registrar {

    // prevent creating new instances
    private Registrar() { }

    /** Get a singleton instance */
    public static Registrar getInstance() {
        // return a singleton instance of registrar.
        // See "Singleton" design pattern slides for how to
        return instance;
    }

    /** Get an enrollment for student.
     *  @throws EnrollmentException if can't enroll is course
     */
    public Enrollment makeEnrollment(Student s, Course course) {
        // details omitted
    }
}
```
 
