---
layout: page
title: Contact
description: Contact Us
---

### How to Contact Instructor and TAs

**Instructor**:  James Brucker, CPE Room 417
```java
final String COUNTRY = "th";

public String getEmail(String firstname, String lastname) {
    StringBuilder sb = ew StringBuilder();
    sb.append(firstname.charAt(0)).append(".").append(lastname);
    sb.append("@").append("ku").append(".").append(COUNTRY); // the domain
    return sb.toString();
}
getEmail("James","Brucker")
```

**TAs**: 

* Triwit Muthitakul `triwith.m@your_favorite_university.th`
* Pawat Nakpiphatkul `pawat.nak@your_favorite_university.th`
* Dacharat Pankong `dacharat.p@your_favorite_university.th`

For Student emails we need a slightly different function:

```java
public String getEmail(String firstname, String lastname, int count) {
    //TODO
}
```
