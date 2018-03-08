## Using TableView

A TableView shows data in a table. Unlike the Swing JTable,
the JavaFX TableView is dynamically updated when the underlying
data changes.  To do this, the underlying data must be **Observable**,
so that TableView gets notified when something changes.

The table data itself much be Observable, such as ObservableList
(that's an interface, use `FXCollections.observableArrayList()` or
other method in `FXCollections` to get an observable collection).

The data in each column must also be observable.  JavaFX has a
bunch of ridiculously complicated Properties classes for that,
but I think its crazy to complicate (and pollute) your domain classes
just for the sake of UI code.  Instead, when building the code
for TableView, use some "wrapper" or "adapter" objects.

The `TableColumn` Javadoc writes:
> In situations where a TableColumn must interact with classes created 
> before JavaFX, or that generally do not wish to use JavaFX apis for 
> properties, it is possible to wrap the returned value in a 
> ReadOnlyObjectWrapper instance. For example:
```java  
firstNameCol.setCellValueFactory(
     new Callback<CellDataFeatures<Person,String>,ObservableValue<String>>( ) 
     {
		public ObservableValue<String> call(CellDataFeatures<Person,String> p) 
		{
        	return new ReadOnlyObjectWrapper(p.getValue().getFirstName());
		}
	 }
);
```

The `tableColumn.setCellValueFactory()` method wants a CallBack of type matching data in the cell.

An easier way to create one is `PropertyValueFactory`.  The constructor
for PropertyValueFactory has 2 type parameters:
```java
new PropertyValueFactory<ObjectType,ColumnType>("attribute_name")
```
where `ObjectType` is the name of the type (class) of the data being
shown in the table. ColumnType is the type (class) of the attribute that
is to shown in this column.  This constructor requires that the ObjectType
use the JavaBeans convention (for get/set of attributes).  For the Person example:
```java
firstNameCol.setCellValueFactory(
     new PropertyValueFactory<Person,String>("firstName")  );
lastNameCol.setCellValueFactory(
     new PropertyValueFactory<Person,String>("lastName") );
```

According to TableColumn.setCellValueFactory Javadoc, 
this works for classes that are JavaBeans. 


### TableView with Checkbox in a cell

Suppose that an attribute of the data you are showing in a table is boolean.
Instead of displaying "true" or "false", you can display it as checkboxes.

For the Todo example, Todo has a boolean `done` attribute.

```java
doneColumn.setCellFactory(new Callback<TableColumn<Todo, Boolean>, 
                        TableCell<Todo, Boolean>>() {
            public TableCell<Todo, Boolean> call(TableColumn<Todo, Boolean> p) {

                return new CheckBoxTableCell<Todo, Boolean>();
            }
        });
```
See the Javadoc for TableView.

