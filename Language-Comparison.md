## Which Programming Language to Use in Programming 2 (*aka* OOP)?

We want:

* Good support for object-oriented programming
* Good documentation and available high-quality learning material
* Not too difficult to learn
* Valuable for jobs and useful in other SKE courses

### 2019 Most Popular Languages

1. [Tiobe Index][] 
   * based on "number of skilled engineers, courses and 3rd party vendors." Search engines are used to calculate results.
   * Dec 2019 Rankings:

    | Language  | Rating |
    |:----------|-------:|
    | Java      | 17.25% |
    | C         | 16.09% |
    | Python    | 10.31% |
    | C++       |  6.20% |
    | C#        |  4.80% |
    | VB .Net   |  4.74% |
    | Javascript|  2.09% |

2. [IEEE 2019 Language Survey][ieee-language-survey-article] has [interactive rankings][ieee-language-interactive] where you can customize criteria for rankings, e.g. number of jobs, number of apps, kind of applications.    
   ![IEEE Language Rankings](images/ieee-language-rankings.png)

### Interesting Cases

* KU Computer Science OOP course used Python for 5 years, but decided it wasn't good for teaching object-oriented programming and switched to Java.
* Twitter was originally built using Ruby on Rails, but switched to the JVM platform (Java and Scala) for scalability.
* edX.org and Pinterest are built using Django, a Python web framework.
* [Programming Languages used in Popular Websites][web-sites-wikipedia] - both Python and Java are widely used.


### Top Choices: Java, Python, Kotlin

Java and Python are both widely used in professional programming.
Java is a top choice for server-side applications and for Android apps.
Python is the language of choice for AI and Machine Learning, and also used on server-side web apps.
microPython can be used on micro-controllers.

Kotlin is based on Java with a simpler syntax. It uses type inference and emphasizes some good
design practices such as immutable data and nullable object references.  Google has declared that
Kotlin is the preferred language for new Android app development.

A downside of Kotlin is: a) not as much tool support or learning material as Java and Python,
b) less demand in job market (but growing), c) adds some conceptual complexity for beginners.


Java is a common choice for OOP courses. Kotlin, Scala, and Groovy are all based on Java
and run on the JVM.  If you know Java, they are easy to learn.

* [Kotlin][] is based on Java but with simpler syntax and type system. There are tools to translate Java source into Kotlin.
    - Google has made Kotlin the [primary language for Android apps][kotlin-for-android]; DZone calls it [the future of Android][].  Google offers some free courses:
    - [Kotlin Bootcamp Course][]
    - [Kotlin Android Fundamentals][]
* [Scala][] is a functional, object-oriented language based on Java. The Play, Akka, and Spark frameworks are written in Scala.
* [Groovy][] is similar to Kotlin. Its used by the Grails web framework and the [Spock][] testing framework. Groovy's popularity has been stable (not growing) for a few years.


### My View

As a *primary language* Java, Kotlin, and Python are all serious choices for OOP. 
Java has more complex syntax and some complexities like primitive types and checked exceptions.
But, Java also is more widely used and has much more learning material.  

Python is much easier to learn and more productive to code.
Since Python is very flexible and dynamic, the programmer must obey *conventions* to write good code,
such as not directly accessing object attributes from other classes,
using type hints, and using O-O constructs as they were intended.


Comparing Java and Python

| Java                             | Python                                |
|:---------------------------------|:--------------------------------------|
| Statically typed                 | Dynamic typing, "*duck typing*"       |
| Compile before run               | No pre-compile, uses JIT compilation  |
| Compiler checks for syntax errors| Errors found at run-time; use type    |
|                                  | hints and mypy to find type errors    |
| Platform independent             | Platform independent                  |
| All code is in classes           | Code in classes, top-level functions, or scripts |
| Verbose syntax                   | Very concise syntax                   |
| Primitive types are value types  | All data types are objects            |
| Data & code can be private       | Everything is public                  |
| Great API documentation          | Very good API documentation           |

### "Hello, Nerd" Application

Ask a person for his name and say hello.

In Python:
```python
"""
Ask a person for his/her name and greet the person.
This code uses type hints to aid type checking.
"""

def greet(name: str) -> None:
    """Greet a person by name.

    Args:
       name - the person's name
    """
    print("Hello,", name)

if __name__ == "__main__":
    name = input("What's your name? ")
    greet(name)
```

In Java:
```java
import java.util.Scanner;
/**
 * Ask a person his/her name and greet the person.
 */
public class Greeter {
    /**
     * Greet a person by name.
     * @param name is the person's name
     */
    public static void greet(String name) {
        System.out.println("Hello, "+name);
    }

    public static void main(String[] args) {
        // Scanner is used to read input, parse it, and return values
        Scanner console = new Scanner(System.in);
        System.out.print("What's your name? ");
        String name = console.nextLine();
        greet(name);
    }
}
```
In Kotlin (written as a singleton object, for comparison with Java):
```kotlin
/**
 * Ask a person his/her name and greet the person.
 */
object Greetme {
    /**
     * Greet a person by name.
     * @param name is the person's name
     */
    fun greet(name: String?) {
        println("Hello, " + name)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("What's your name? ")
        val name = readLine()
        greet(name)
    }
}
```

## Articles 

* [Java & Python: a side-by-side comparison](https://pythonconquerstheuniverse.wordpress.com/2009/10/03/python-java-a-side-by-side-comparison/) analysis and discussion of why programming in Python is more productive than Java.  Useful side-by-side comparison of strong vs weak typing,
* [Strong versus Weak Typing: A Conversation with Guido van Rossum, Part V
](http://www.artima.com/intv/strongweak.html) why unit testing is better than static type checking at finding errors.
* Bruce Eckel [Strong Typing vs. Strong Testing](
https://docs.google.com/document/d/1aXs1tpwzPjW9MdsG5dI7clNFyYayFBkcXwRDo-qvbIk/preview), and slide presentation [Why I love Python](http://64.78.49.204/pub/eckel/LovePython.zip).  He prefers Python, claims he is 10x more productive using Python.
* Robert Martin [Are Dynamic Languages Going to Replace Static Languages?](http://www.artima.com/weblogs/viewpost.jsp?thread=4639), Martin feels that good unit testing + dynamic language is a better development environment that a cumbersome staticly typed language.
* John Ousterhout 1998 paper, [Scripting: Higher Level Programming for the 21st Century](http://home.pacbell.net/ouster/scripting.html) 
* [Comparing Python OO Code with Java](http://www.informit.com/articles/article.aspx?p=2436668) short article on InformIT. In a simple object creation benchmark Python is slightly faster, and the Python code is *much* shorter.

A 2016 article on [CodingDojo](http://www.codingdojo.com/blog/9-most-in-demand-programming-languages-of-2017/) used job ads on
Gooroo, Dice, and Tech World for 2015 reported the most ads for Java, Javascript, and C#.  Python and C++ had similarly demand but far behind the top 3.  Demand differs by country, but Java and Javascript always in the top 5.

---

[Tiobe Index]: https://www.tiobe.com/tiobe-index/
[ieee-language-survey-article]: https://spectrum.ieee.org/computing/software/the-top-programming-languages-2019
[ieee-language-interactive]: https://spectrum.ieee.org/static/interactive-the-top-programming-languages-2019
[web-sites-wikipedia]: https://en.wikipedia.org/wiki/Programming_languages_used_in_most_popular_websites
[kotlin-for-android]: https://techcrunch.com/2019/05/07/kotlin-is-now-googles-preferred-language-for-android-app-development/
[the future of Android]: https://dzone.com/articles/why-kotlin-is-the-future-of-android-app-developmen
[Groovy]: https://groovy-lang.org
[Kotlin]: https://kotlinlang.org
[Scala]: https://scala-lang.org
[Spock]: https://spockframework.org
[Kotlin Bootcamp Course]: https://codelabs.developers.google.com/kotlin-bootcamp/
[Kotlin Android Fundamentals]: https://codelabs.developers.google.com/android-kotlin-fundamentals/
