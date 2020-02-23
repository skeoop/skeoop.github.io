## Encrypting Passwords

In an application that authenticates users,
you should not store passwords as plain text.  Encrypt them using a one-way hash.

The basic steps are:

* When the user specifies a new password you encrypt it using a *one-way hash*.  The result is a String such as "$a4$10$rb85CdE5982VrAZ873". Store the encrypted string (instead of the original password).
* Each time the user enters his password you encrypt it (again) using the same algorithm, and compare it with the original encrypted string. If the encrypted Strings match, the passwords match.   
* A popular, easy-to-use library for this is [jBCrypt](http://www.mindrot.org/projects/jBCrypt/).   

There is a [JBCrypt Demo Project](https://github.com/jbrucker/jbcrypt-demo) showing how to use JBCrypt.

[Excellent explanation in Pawan's OOP2017 project docs](https://github.com/guitarpawat/course-feedback/blob/master/README.md). You should write documentation like this!

### Passwords for Services You Use

If your application uses a services that requires a password, such as a database in the clould, then you do need to store the password.

You could encrypt the password but you'd still need to store the decryption key somewhere.

The most important thing is: **don't commit sensitive data to git**.

Put passwords and other sensitive data in a configuration file, and store it outside of your project directory tree.  Heroku recommends putting sensitive data in the environment (environment variables) instead of reading it from a file.
