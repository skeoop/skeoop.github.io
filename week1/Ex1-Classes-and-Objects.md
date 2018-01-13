## Exercises on classes and objects. 

### 1. Three fundamentals of OOP (fill in the blanks)

________________ means that an object contains both data (state) and methods that operate on the data.

________________ conceptually means that one type of object can be substituted for another type as long
as both types of object provide the same behavior.

________________ allows one class to reuse all the behavior from another class. In can optionally redefine (override) some methods and add new methods.

________________ in code, this means we can invoke a method of an object reference without knowing
(or caring) that actual class of the object that will perform it.  `System.out.println(object)` is an example.  `println` invokes `object.toString()` for any object, without knowing what class the object belongs to.


### 2. Data Hiding

OO programs usually *hide* the attributes of an object by declaring them to be **private**.
We provide `get` and `set` methods to access the values.
This is called **data hiding**.

Advantages of data hiding include: (a) protect integrity of an object's own data, 
(b) we can change how an objects stores its state (change its attributes) without affecting the rest of the program.

1. Data Hiding uses which one of the 3 fundamentals of OOP?

2. Give an example of a class you wrote in OOP1 where you can use data hiding to change
the way the class is implemented without changing the external interface.


### 3. Which fundamental characteristic of OOP is used in each of these situations?

1. A BankAccount class knows its balance and has methods for deposit, withdraw, and get the balance.

2. A bank application has a SavingAccount and CheckingAccount class.  Most of the code is exactly the same for both SavingAccount and CheckingAccount; for example, deposit, withdraw, getBalance, getOwner, and many other methods.  How can we avoid making 2 copies of the same methods?

3. Give your own example of an application you wrote that uses encapsulation, polymorphism, or inheritance.



