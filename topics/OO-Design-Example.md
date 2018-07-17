## Design Example

Example of how to apply some OO design principles
and design patterns.  Don't try to *force* patterns
into your application.  Design patterns are to help
achieve design goals or apply to some situation.

## Situation

We are writing an e-commerce application with Products,
Orders, Sales, and Customers.

In our controller we need to get product info by id
from a database.  So initially we wrote something like this:

```java
class ProductViewController {

   public void handleFindProduct(ActionEvent event) {
       String productId = inputField.getText();
       if (! validId(productId) ) {
           showErrorMessage(...);
           return;
       }
       // JDBC ResultSet containing query result
       ResultSet rs = dbmanager.find("products", productId);
       // get the results
       while( rs.next() ) {
           String name = rs.getString("name");
           double price = rs.getDouble("price");
           Product p = new Product(productId,name,price);
           // show the product
           tableView.getItems().add( p );
       }
       ...
    }
```

### Why this is not a good design

1. The ProductViewController depends on how data is
stored (ResultSet is part of JDBC) and the database schema.
2. The controller's responsibility is handling user input,
relaying what the user wants to the rest of the app, and
displaying results.  Its not responsible for retrieving data fields and creating products.

### How Design Principles Can Help

Some design principles we can apply here are:

1. Single Responsbility - controller is responsible for
receiving intent from the user and translating it into method calls to the rest of the app, not performing the logic itself.
2. Encapsulation and Low Coupling - we like to encapsulate parts of how the program works.  In this case, encapsulate how Product objects are created or stored. 

### How Design Patterns Can Help



The "Data Access Object" pattern would help.
Design one class, called a "Data Access Object", that is
responsible for persisting and retrieving objects.
The rest of your program just sees objects that are
part of the application (like Order, Product, Sale, Player).
Only the DAO knows how the objects are stored.

How do you create DAO objects?  The Factory Method
pattern would help.  For example:

  ProductDao productDao = DaoFactory.getInstance().getProductDao();
  Product p = productDao.findById( 12345 );



For testing you might want to use fake data instead
of a database.  So, just create a special subclass of
the DAO the creates and saves fake data, maybe using
a plain text file.
