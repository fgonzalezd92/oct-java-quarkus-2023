* You have a collection of items with their names and prices

```java


public class Item {
	private String name;
	private double price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
}
```

```java
	List<Item> items = Arrays.asList(new Item("Nike", 20.45), new Item("Adidas", 31.45), new Item("Reebok", 29.25), new Item("Puma", 25.15), new Item("Fila", 15.15));
```


## To Do - Declarative Style

* Create Lab08.java
* Print the name and price of the costliest shoe
* Print the name and price of the cheapest shoe
* Concatenate all the item names using comma and print the value (ie., Nike, Adidas, Reebok, Puma, Fila) You can use **collect()** method on Stream. Refer to the API documentation
