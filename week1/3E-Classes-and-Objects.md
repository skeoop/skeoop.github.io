Exercises on classes and objects. 

## 1. Three fundamentals of OOP (fill in the blanks)

________________ means that an object contains both data (state) and methods that operate on the data.

________________ conceptually means that one type of object can be substituted for another type as long
as both types of object provide the same behavior.

________________ allows one class to reuse all the behavior from another class. In can optionally redefine (override) some methods and add new methods.

________________ in code, this means we can invoke a method of an object reference without knowing
(or caring) that actual class of the object that will perform it.  `System.out.println(object)` is an example.  `println` invokes `object.toString()` for any object, without knowing what class the object belongs to.


## 2. Data Hiding

In OO programming, we usually *hide* the attributes of an object by declaring them as **private**.
We provide `get` and `set` methods to access the values.
This is called **data hiding**.

There are many advantages to this, including (a) protect integrity of an object's own data, 
(b) we can change how an objects stores its state without affecting the rest of the program.

1. Data Hiding uses which one of the 3 fundamentals of OOP?

2. Give an example of a class you wrote in OOP1 where you can use data hiding to change
the way the class is implemented without changing the external interface.

## 3. Which fundamental characteristic of OOP is used in each of these situations?

1. A BankAccount class knows its balance and has methods for deposit, withdraw, and get the balance.

2. A bank application has a SavingAccount and CheckingAccount class.  In the banking application, most of the code works exactly the same for both SavingAccount and CheckingAccount; for example, deposit, withdraw, getBalance, getOwner, and many other methods.

3. Give your own example of an application you wrote that uses encapsulation, polymorphism, or inheritance.

## 4. What are the classes and attributes in this problem?

An Exam consists of one or more Questions.  Each Question has a question text.
Some Questions are true/false, and other questions are multiple choice.

The Exam displays each question in the user interface and accepts an answer from the user.  
The exam collects the user's answers to the questions.

When the user is done, the user interface submits the exam to a grader for evaluation.

What classes should this application have?  What are there methods and attributes?

