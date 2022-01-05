---
title: About
navigation_order: 4
---

## About the Course

[Introduction to the Course](intro/index)

| **Time** | Individual study, no fixed time
| -------------|--------------------------------------------------------
| **Location** | Meet **online** using [Google Classroom][google-classroom-link]
| **Github** | we use [Github](https://github.com) for programming work, so you must have a Github account.
| **Course Material** | All material is on <https://skeoop.github.io/>, with links on [Google Classroom][classroom-classwork].    
| **Discord** | For Q&A, discussions, TA meetings
| **Sign-up & Preparation** | 


[google-classroom-link]: https://classroom.google.com/c/MzczOTE1MjA0NDE4?cjc=ka25cph
[classroom-classwork]: https://classroom.google.com/u/0/w/MzczOTE1MjA0NDE4/t/all
[google-meet-link]: https://meet.google.com/lookup/gufu6342m5


### How to Join [Google Classroom][google-classroom-link] and Join a Meeting

1. Join the [Google Classroom](https://classroom.google.com).  Use class code **[ka25cph][google-classroom-link]** or click this **[invitation link][google-classroom-link]**.
2. To join a meeting, click on the "Meet" link (video icon) on the Google Classroom page:
[![classroom meet icon](images/classroom-meet-icon.png)][google-meet-link]
   - You can also click this [Google Meet Link][google-meet-link] but it may change in the future.
3. Complete this [Student Info Form](https://forms.gle/WE3jN4miDKabFBje8) so we know your Github ID.
4. What online platform do you prefer? Please complete [Online Platform Preferences](https://forms.gle/VkG5MBPjgmxRX1xi7).



```java
// Java - in Java the 3rd parameter is required, e.g. email("Santa", "Claus", 1)
static final String DOMAIN = "ku.th";
/**
 * Return the Email address for a KU person. Works only for Thai names.
 * @param firstname person's first name
 * @param lastname  person's last name
 * @param nlast number of chars from last name to use
 * @return email address, of course
 */
public static String email(String firstname, String lastname, int nlast) {
    return String.format("%s.%s\u0040%s",
           firstname,
           lastname.substring(0, nlast),
           DOMAIN);
}
```
*Why obfuscate email addresses?*    

Software "bots" constantly scan the web for email addresses 
and use them to send spam and phishing attacks.
Some people disguise their email as "santaclaus at christmas dot com",
but that is easily recognized using pattern matching.
