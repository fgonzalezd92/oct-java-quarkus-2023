## Develop a calculator resource to do the following.


* Sum of two numbers:  GET -> http://localhost:8081/calc/sum/1/3

* Square of a number: PUT -> http://localhost:8081/calc/square/60

* Product of two numbers: POST -> http://localhost:8081/calc/product?num1=12&num2=14

* Return a list of operations  ['Sum', 'Square', 'Product']: GET -> http://localhost:8081/calc/operations

* After completing the code, build your application to generate a **fat jar(uber jar)**; We'll dockerize it :)

#### Note:

* **Do not** write your Logic inside a Resource class.
* Write it separately and **inject** it with the Resource
* Modify the port in application.properties
* _Though some of the mappings like PUT, POST don't really make sense in this example, you'll just practice using them._

