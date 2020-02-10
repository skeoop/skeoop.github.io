## Questions about Inheritance and Polymorphism

Use this code in the questions below.

```java
public class Person {
	private String name;
	private long id;

	public Person(String name, long id) {
		this.name = name;
		this.id = id;
	}

	public int compareTo(Person other) {
		// order people by their id
		return Long.compare(this.id, other.id);
	}

	public boolean equals(Object other) {
		// no two people are the same!
		return this == other;
	}

	public long getId() { return this.id; }

	public String toString() { return this.name; }
}

public class Student extends Person {
	private long studentId;

	public boolean equals(Student other) {
		// students are same if they have same id
		return this.studentId == other.studentId;
	}

	public String toString() { return Long.toString(studentId); }
}
```

### 1. What type(s) can be used in the blank to declare x?

```java
__________  x = new Person("Nok", 1409900111222L);
```
* [] Object
* [] Person
* [] Student

### 2. What type(s) can be used to declare y?

```java
__________ y = new Student("Nok", 1409900111222L);
```
* [] Object
* [] Person
* [] Student

### 3. What type(s) can be used as argument to compareTo?
```java
Person nok = new Person("Nok", 1409900111222L);
__________ x = ... ; // another object
nok.compareTo(x);
```
* [] Object
* [] Person
* [] Student
* [] any type

### 4. Which class's toString will be invoked?

```java
Person p = new Student("Nisit", 620154123456L);
System.out.println( p.toString() );
```

* [] Object's toString()
* [] Person's toString()
* [] Student's toString()
* [] illegal assignment of p to Student object


### 5. Which class's equals will be invoked?

```java
Person p = new Student("Nisit", 620154123456L);
Student s = new Student("Nerd", 600155000000L);
System.out.println( p.equals(s) );
```

* [] Object's equals()
* [] Person's equals()
* [] Student's equals()
* [] illegal assignment of p to Student object

### 6. What Visibility can an override method have?

If we write a `getId()` method in the Student class (overrides Person getId()), what visibility can the method have?
```java
public class Student extends Person {
	...
	____?____ long getId() { return this.studentId; }
}
```

Check all possible visibility for Student `getId()`:

* [] private
* [] default (leave blank for package scope)
* [] protected
* [] public


**Hint:** Apply the substitution principle. 
 
> Any application that expects an object of type T should work correctly when given an object from any subclass of T.
