# Design and Implement a Calculator

A calculator provides a good opportunity to practice design
and use several design patterns.  We will write the calculator
in steps. At least step we will add new functionality and
improve the design.

To get started, try the basic Windows calculator.
It seems to have only 2 registers for storing operands,
and always performs pending operations before accepting
new operands.

## 1. Simple Calculator

### calculator.model.Calculator.java
The calculator has 2 registers and can perform + - * / and ^ (exponentiation).

The interface is:
``` #!java
void setValue(double arg) - set a register value
double getValue( )        - get current register value
void setOperand(char op)  - set operation to perform, '+', '-', '*', '/', '^'
void perform( )           - perform operator and save result (to register 1)
                            use getValue() to get result
```

### CalculatorDemo.java
Demo the use of calculator using a console UI.

### Exercise
The Calculator has a problem.  `2 + 3 + 4` should be 9 but it is not.
Fix the Calculator class.

## 2. BinaryOperators as objects
Represent operators as objects.

We'll use a superclass named `BinaryOperator`.
### Exercises
2.1 Write operators for Add, Subtract, Multiply, Divide, and Power.
2.2 Modify the Calculator class to use these operators instead of `char`.
2.3 What design pattern is this?

### NullObject Pattern


## 3. Operator Factory