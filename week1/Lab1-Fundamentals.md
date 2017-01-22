## Lab1: Java Fundamentals Practice

|   |   |
|---------|--------------------------------------------------|
|Objective: |Practice writing common Java methods and good Javadoc.|
|What to Submit: |Create a Git repository named **fixcode**. Submit your Java code to this repo. Include a README.md and .gitignore.            |

In this lab you will do these things:

1. Fix some bad code in the "fixcode" project.
2. Write an "equals" method, and discover why it should always be declared as `equals(Object other)`.
3. Write good Javadoc for classes and methods.
4. Commit your code to git and upload (push).

## Files for this lab.

1. Go to the class git repository. In the **week1** directory download Lab1-fixcode.zip.
2. Unzip the file in your workspace.  It will create a directory named "fixcode".
3. Create an IDE (Eclipse) project using the source code.


## 1. Exploring and Writing `equals`

1. Run the Main class in the fixcode project.
2. equals does not behave the way it should. When the references are declared as type Object (instead of Person or Student), equals returns the wrong answer.  Why? Write your answer in the project README.md file.
3. Look at the "Java Fundamental Methods" document (online) for the correct way to write equals and implement it in both Person and Student.
 `Person.equals` - two Person are equal if they have the same name
 `Student.equals` - two Students are equal if they have the same student id and name.
4. Demonstate that your `equals` method works correctly.  Here are some tests:
```java
Person a = new Person("Cat");
Person b = new Student("Cat", 1111);
Object c = new Student("Cat", 1111);
Object t = new Student("Cat", 1112);
a.equals( b )   // false - a and b are not the same class
b.equals( c )   // true - name and id are the same (uses Student.equals)
b.equals( d )   // false - id is different (uses Student.equals)
d.equals( b )   // true - attributes are same and equals is symmetric
```

## Write Good Javadoc

1. Write good Javadoc in the Person and Student classes. There are several errors and omissions.
2. The class Javadoc must be written as complete sentences that describe the purpose of the class.  Include an `@author` tag.
3. Method Javadoc must describe what the method does and include `@param` and `@return` where needed (if a method returns void then do not write `@return`).

## Upload your Code to Github

1. Use repo name `fixcode`.

