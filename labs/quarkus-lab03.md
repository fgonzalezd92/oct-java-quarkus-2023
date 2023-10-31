### In this lab you will practice making two quarkus containers interact with each other


##### Service 01

* Create a Quarkus application, say __client-api__ running on **8081**
* Create an endpoint **http://localhost:8081/word/{word}** 
* When you hit this endpoint, programmatically connect to Service 02 **http://localhost:8082/palindrome/{word}** and print the output
* **Containerize this application**


##### Service 02

* Create a Quarkus application, say __palindrome-api__ running on **8082**
* Create an endpoint **http://localhost:8082/palindrome/{word}** 
* This endpoint computes if the given word is a palindrome or not; ie., return a boolean
* **Containerize this application**

<br/>

* Use appropriate **ENV** variables wherever required
* You can use **HttpClient** if you use Java 11 or above
