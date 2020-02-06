## Why BigDecimal?

`BigDecimal` stores numeric values in **decimal** format with arbitrary precisoin. `double` or `Double` which store values in **binary** format with fixed precision (52 bit mantissa plus 1 implicit bit, or approx. 15 decimal digits).

This is an important difference in financial applications, where values (like money) are *inheritantly* expressed in decimal.

Consider the value of 0.1 (base 19).

* In binary it is:  `0.00011001100110011...` (infinite)
* In decimal it is: `0.1000` (finite)

Storing decimal numbers in binary results in loss of precision and round-off error.  It can cause errors in financial calculations and lead to errors in programs if you are not careful.  

Since `BigDecimal` stores numbers in decimal format, there is no error in converting to binary.  The "price" for this is that arithmetic using BigDecimal is a lot slower than arithmetic involving `double` or `Double`.

### Experiment

Using `double` or `Double`, add 0.1 to a sum 10-million times.    
The answer *should be* 1,000,000.  Is it?
```java
double x = 0.1;
double sum = 0.0;
for(int n=0; n<10_000_000; n++) sum = sum + x;
System.out.println("The sum is "+sum);
```
If you think this is trivial, below is a real financial application (mutual funds).

Here's a loop that will operate incorrectly:

```java
double x = 0.0;
while( x < 1.0 ) {
   System.out.println(x);
   x = x + 0.1;
}
```
the loop should execute 10 times and the last value printed is 0.9.
Due to rounding error, it executes 11 times and the last value printed in 0.9999999999999.

### Computing Mutual Fund Prices and Shares

Mutual fund prices are expressed as Net Asset Value (NAV) per unit,
calculated every day after the stock market (and bond market) closes.

To purchase a mutual fund, you place an order before 15:30 or 16:00
(depends on the fund) for the amount you want to purchase.
After the market closes, the fund company will compute the fund's
NAV accurate to 4-decimal places.
For example, the [Krungsri Active Fixed Income][KFAFIX] fund on 30 Jan 2020
had a NAV of 10.9610 Baht/unit.

The price you pay to buy a fund is usually 0.0001 higher than the NAV 
(called the *spread*).  Some funds charge a 1% or 2% fee ("front end load"),
so the buy price is (for a 1% load) `101% x NAV`.

The number of units you receive is also computed to 4 decimal places.

If you submit an order to buy 10,000.00 Baht of KFAFIX you would get:

```
exact units = 10,000/(NAV+0.0001) = 10,000/10.9611 = 912.317194442
# actual units is rounded down to 4 decimal places:
actual units = 912.3171
```

Notice that Krungsri removed the extra 0.000094442 units.
Extra 0.10 profit for them -- if they do ten million transactions
per year (easily), that's an extra 100,000 Baht profit.

Its important to the company that these **decimal** values
be computed correctly!  
Most of the time, using `double` (binary format) would give the correct
result, but *occasionally* it will be slightly incorrect, especially
for adding many small values.

That's why binary floating point with fixed precision (like `double`)
is not recommended for financial applications.

### BigDecimal for Decimal Values

`BigDecimal` stores values in **decimal format** with **arbitrary precision**
and does **decimal arithmetic**.  Its a lot slower than binary,
but already produces the correct decimal result (for a given precision).

"Arbitrary precison" does **not** mean "infinite precision".
The programmer can specify how many digits he wants when he creates the objects.


### Creating a Big Decimal Object

If you enter:
```java
BigDecimal d = new BigDecimal(0.1);
```
then the value of `d` contains some error already!
Don't believe it?  Try this:
```java
BigDecimal d = new BigDecimal(0.1);
System.out.println( d.toString() );
```

A better way to create BigDecimal for an **exact** value is using Strings:
```java
BigDecimal d = new BigDecimal("0.1");
System.out.println( d.toString() );
```

An even better way is to use the `valueOf()` factory method.
This method will cache and reuse objects when possible, saving memory:
```java
BigDecimal d = BigDecimal.valueOf("0.1");
```

[KFAFIX]: http://www.thaifundstoday.com/en/funds/978-krungsri-active-fixed-income-fund
