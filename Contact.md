---
layout: page
title: Contact
description: Contact Us
---

### How to Contact Instructor and TAs

**Instructor**:  James Brucker, CPE Room 417    
**TAs**: to be announced

Get their email addresses using this Java method:
```java
/**
 * Compute someone's KU Email address based on real name.
 *
 * @return the person's email
 */
public String getEmail(String firstName, String lastName, boolean isThaiName) {
    final String DOMAIN = "ku.th";
    final char AT = (char)0x40;
    StringBuilder sb = new StringBuilder();
    if (isThaiName) 
        // for Thai names, but not reliable due to name collisions
        sb.append(firstName).append('.').append(lastName.charAt(0)); 
    else 
        sb.append(firstName.charAt(0)).append('.').append(lastName); 
    return sb.append(AT).append(DOMAIN).toString();
}
```

[StringBuilder](https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html) is a mutable object for building and editing strings. Its much more efficient than concatenating Strings.

