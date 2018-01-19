## UML Practice

Draw a UML class diagram of this code.
Show relationships between classes and multiplicity of association.
```java
class Person {
    private String name;
    public String getName() { return name; }
}

public interface Gradable {
    public void assignGrade(long courseid, String grade);
}
// This means Student extends Person
//        AND Student implements Gradable
public class Student extends Person implements Gradable {
    private Long id;
    private List<Course> courseList; 
    public Student(String name, Long id) { /* code omitted. */ }
    // other methods omitted
}

public class Course {
    private String courseId;
    private String title;
    private int    credits;
}
```
    
