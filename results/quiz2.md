## Results and Feedback on Assignments

### Quiz 2

The scores were low.

|                 |    |    |
|:----------------|---:|:---|
| Total Quizzes   | 48 |    |
| Possible Points | 24 |    |
| Average Score   | 8.4|    |
| Q.1 Correct     | 28 | TA gave you the answer before class.  |
| Q.2 Correct     |  3 | You have used iterators before, right?  |
| Q.3 Correct or nearly | 4 | ArrayIterator was code you wrote yourself.  |
| Q.4 6/6 Interfaces correct | 3 | Excellect if you know them all. |
| Q.4 5/6 Interfaces correct | 6 | Good if you know at least 5.    |

* Question 4: no credit for incorrect capitals, such as `comparable` instead of `Comparable`, `Iterator()` instead of `iterator()` (method).
* In Q.4 no credit if you write same answer for 2 interfaces (except last 2). It shows you are guessing.
* Deduct 1 point for writing nonsense. That means something that you should know is syntactically impossible or makes no sense in this context.
* Examples of "nonsense":
```java
// This Java statement was given in Question 3:
String [] students = Registrar.getStudentNames("01219113");

// array does not have an Iterator() method. 
Iterator<String> iter = students.Iterator();

// array does not have a a getInstance() method.
Iterator<String> iter = students.getInstance();

// Array (students) does not have "next" attribute, and no toArray() method.
Iterator<String> iter = students.next.toArray();

// ArrayIterator (class) does not have a static attribute.
Iterator<String> iter = ArrayIterator.students;

// You cannot create instances from an interface. 
Iterator<String> iter = new Iterator<>( );
```

### On exam, points are deducted for nonsense answers.

That means writing things you should know are incorrect syntax, incorrect semantic, or make no sense.

### Suggestion: Read a book!

*Big Java* and all the books in course description are excellent. Some Thai Java books are good, too.

