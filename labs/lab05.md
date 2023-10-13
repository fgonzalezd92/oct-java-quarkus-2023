* You have a Calculator class as given below for reference 

```java
	public class Calculator {
		public int add(int num1, int num2) {
			return num1 + num2;
		}
		
		public int square(int num) {
			return num * num;
		}
		
	}
```

* Convert add and square methods to separate functional interfaces Adder and Square
* Create Lab05.java with a **main()** method. 
* In the __main()__ create Lambda expressions for Adder and Square
* Create new methods called __operate(Adder adder)__ and  __compute(Square square)__ in Lab05 and pass your lambdas as arguments. Use numbers 5, 10, or 15 for all the operations