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


### Java Alternatives

Java is a common choice for OOP courses. But there are other languages based on Java that maybe better.  These languages compile to Java byte code, and run on the JVM.  

If you know Java, they are easy to learn.

* [Kotlin][] is based on Java but with simpler syntax and type system. There are tools to translate Java source into Kotlin.
    - Google has made Kotlin the [primary language for Android apps][kotlin-for-android]; DZone calls it [the future of Android][].  Google offers some free courses:
    - [Kotlin Bootcamp Course][]
    - [Kotlin Android Fundamentals][]
* [Scala][] is a functional, object-oriented language based on Java. The Play, Akka, and Spark frameworks are written in Scala.
* [Groovy][] is similar to Kotlin. Its used by the Grails web framework and the [Spock][] testing framework. Groovy's popularity has been stable (not growing) for a few years.

### My View

As a *primary language* only Java and Kotlin are serious choices, due to their mainstream applicability. Java has more complex syntax and some blemishes like primitive types and checked exceptions, which complicate learning.  But, Java also is more widely used and has much more learning material.  If you know Java, learning Kotlin is easy (and educational); going from Kotlin to Java is harder, I think.


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
