### Model-View-Controller by [Taweerat Chaiman and Patinya Yongyai](https://Taweerat_C@bitbucket.org/oop2final/model-view-controller-pattern/)
* Does not use standard template for design patterns, which maybe why you omitted...
    * Forces - doesn't explain *why* use this pattern.  What are the forces?
    * No UML diagram
* Example is good
* Grammar is good

### Model-View-Controller by [Chinthiti Wisetsombat and Thongrapee Panyapatiphan](https://bitbucket.org/thongrapee_p/mvc_pattern)
* Does not use standard template for design patterns. 
** Please don't use Q&A style "what is it?", "why use it?", etc.
* Explanation of "what" and "why" are poor.
* Copying image from wikipedia is lazy.
* No UML diagram.
* Example is not good. Controller should **not** be an ActionListener.  The View should provide its own ActionListener that translates UI component handlers into Controller actions.
* Exercise is OK.
* Grammer is good.

### Model-View-Controller by [Jidapar Jettananurak and Salilthip Phuklang](https://bitbucket.org/b5710546542/model-view-controller-pattern)
* Brief explanation is good but doesn't explain **why use the pattern**.
* How do controller and model communicate with view? (not shown)
* Example is OK but model is anemic (doesn't do much). Since controller has methods like "removeStudent" the model layer should have a class for managing students, such as StudenDao (database access object) or Registrar.
* No exercise.
* Grammar is good.

### Factory Method by [Sorawit Sakulkalanuwat and Kasidit Phoncharoen](https://bitbucket.org/kasidit_p/factory-method/)

* Does not use standard design pattern format.
* Explanation is good but does not explain "why" use the pattern.
* Example does not show advantage of using factory (too simple).
* Exercise needs more explanation of what to do. No comments in code.
* Grammar is good.

### Factory Method by [Pipatpol Tanavongchinda and Thanawit Gerdrasert](https://bitbucket.org/b5710547182/factorypattern/)
* Uses standard design pattern template.
* Page is not well formatted. (markdown problem) Check your document!
* Explanation of situation and forces is not correct. Sounds like Singleton Pattern.
* Many grammar and punctuation errors.
* Example: you mean **Iterable** but wrote **Iterator**.  In example, "Creator" class is wrong!
* Exercise: too vague. Make it cleaner what students should do.

TODO: 1) Fix formatting of page (markdown). 2) Fix example. 3) Fix grammar and punctuation.

### Factory Method by [Apichaya Bunchongchit and Natcha Pongsupanee](https://bitbucket.org/b5710546666/factory-method)
* Does not use standard design pattern template.
* Example is good, but Shapes could be more interesting.
* No UML.
* No exercise for students.
* Grammar is good.


### Factory Method by [Supanat Pokturng and Tuangrat Mungmeerattanaworachot](https://bitbucket.org/supanat_p/factory-method)
* Does not use standard design pattern template.
* Example is too simple.
* No UML.
* Exercise is good (fill in the blanks).
* Grammar is OK.

### Command by [Arut Thanomwatana and Narut Poovorakit](https://bitbucket.org/b5710546437/commandpattern)
* Does not use standard design pattern template.
** Please *don't* use chatty Q&A style headers "What is It?", etc. Use design pattern template.
* UML looks like copy, since class names and comments don't match your text.
* Explanation is OK.
* Grammar and (especially) punctuation need improvement.
* Example needs more explanation.


### Command by [Wanchanapon Thanwaranurak and Voraton Lertrattanapaisal]( https://bitbucket.org/b5710546593/commandpattern)
* Does not use standard design pattern template.
** Please **don't** use chatty Q&A style headers "What is It?", etc. Use design pattern template.
* UML is OK but missing some associations.
* Explanation is poor.
* Grammar is poor -- please correct it.
* Exercise for students is too trivial to show advantage of using this pattern.

### Facade by [Norawit Urailertprasert and Benjapol Worakan](https://bitbucket.org/b5710546275/facade)

**Page is not readable.** Make the repo public.

### Facade by [Prin Angkunanuwat]( https://bitbucket.org/prin_a/facade_pattern)
* Explanation is good.
* UML is good.
* Doesn't use standard design pattern template.
* Example is OK, but not typical use of facade.

### Facade by [Pongsakorn Somsri and Parisa Supitayakul](https://bitbucket.org/pongsakorn_so/facade_pattern)
* Explanation is not so good.
* UML is good.
* Doesn't use standard design pattern template.
* Example is too trivial.  The objects are simple and totally independent. Facade provides a simpler interface to complex subsystems, but in this example the subsystems are simple, too.
* Many grammar and punctuation errors. Please fix.

### Singleton by [Kitipoom Kongpetch](https://bitbucket.org/b5710546160/singleton)
Copy of Wikipedia page.  No score for this assignment.

### Singleton by [Raksit Mantanacharu and Sanrasern Chaihetphon](https://bitbucket.org/raksit_m/singleton_pattern)
* Doesn't use standard design pattern format. Instead has blog-like headers "What is it?".
* UML is OK.
* Explanation is good, but example using enum is incomplete. Should have provide constructor (in enum) so the database is initialized.  Otherwise its an object with no properties.
* Example is good, but vague.

### Singleton by [Pitchaya Namchaisiri and Woramate Jumroonsilp](https://bitbucket.org/b5710546364/singletonpattern)
* Doesn't use standard design pattern format. Instead has blog-like headers "What is it?".
* UML is OK.
* Explanation is good, but example using enum is incomplete. Should have provide constructor (in enum) so the database is initialized.  Otherwise its an object with no properties.
* Example of thread-safe Singleton using synchronized method is inefficient. There is a better way, which is shown on Wikipedia page.
* No exercise for students.


### Adapter by [Chawakorn Aougsuk and Chinatip Vichian](https://bitbucket.org/Chawakorn_A/adapter-pattern)
* Copy from Wikipedia. No score for this assignment.
* Description of pattern contains irrelevant info (first 2 sections "What are design patterns" and "Benefits of design patterns").
* The **context** and **purpose** of adapters isn't clearly stated. Its buried in example of power adapter.
* Exericse for students  is vague. Questions 4 and 5 have no use.


### Adapter by [Nattapat Sukpootanan and Kundjanasith Thonglek](https://bitbucket.org/b5710546232/adapter-pattern)
* "Description" section is poor -- doesn't say anything about what pattern is, the problem it solves, or forces (motivation).
* Doesn't state motifvation and purpose of the pattern.
* Example of LengthClassAdapter inseightful, and method meterToCentimeter, centimeterToMeter are poorly written.
* UML for Class Adapter is not possible in Java (multiple inheritance). UML for Object Adapter is OK, but "adaptee" attribute should be lowercase. 
* Grammar is OK, but some errors.


### Decorator by [Pakpon Jetapai and Phasin Sarunpornkul](https://bitbucket.org/b5710546381/decorator-pattern)
* Doesn't use standard design pattern format.
* Explanation is good but too brief. Did you copy it from Internet?
* UML is good.
* Decoration can be done statically, too.  You page keeps referring to "run-time" decoration.
* ScrollableWindow example doesn't contain any real code, so hard to see the benefit of pattern.

### Decorator by [Patchara Pattiyathanee](https://bitbucket.org/b5710546348/decorator-pattern)
* Doesn't use standard design pattern format.
* Explanation of "why" is good, but please use standard section headers (Context, Motivation or Forces, Desription).
* UML copied from theserverside.de.
* Fix punctuation errors. They are quite obvious if you read the page.
* Exercise for students is vague, and too similar to coffee example by Aj. Keeratipong.

