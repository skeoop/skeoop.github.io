---
layout: page
title: How to Contact Instructor and TAs
---

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

* Triwit Muthitakul `triwith.m@your_favorite_university`
* Pawat Nakpiphatkul `pawat.nak@your_favorite_university`
* Dacharat Pankong `dacharat.p@your_favorite_university`

For Student emails we need a slightly different function:

```java
public String getEmail(String firstname, String lastname, int count) {
    StringBuilder sb = ew StringBuilder();
    sb.append(firstname.toLowerCase())
	  .append(".")
	  .append(lastname.substring(0,count).toLowerCase())
	  .append(\u0026)  // Unicode character
      .append(DOMAIN_NAME); // domain of your favorite unisersity
    return sb.toString();
}
```

In Java its legal to have two methods with the same name (`getEmail`)
provided that they have different parameters.
