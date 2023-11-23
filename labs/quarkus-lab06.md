### Quarkus Lab06

* Create a new Empty project __quarkus-lab06-kafka__ in IntelliJ

#####  Calculator

* Create a Module __calculator-app__ which is a **quarkus scheduler** application
* Add **quarkus-scheduler** extension while creating the application
* It has two methods square() and increment() with the annotation **@Scheduled(every="1s")** and **@Scheduled(every="3s")**
<br/>

* The methods generate a random number and post a message IN **JSON format** to a topic **calculator-topic**
* The JSON message is of the following format 

``` json
{
	"number" : 10
}
```

* Add a **key** for each message which will be **square** or **increment**


##### Calculator consumers

* Create a Module __calculator-consumer__ which is a Kafka consumer application
* This consumer listens to **calculator-topic** and compute the result (square or increment) and print it on the console
* You can use ConsumerRecord or ConsumerRecords

#### Note

* You can create a record or a class that corresponds to the JSON message and send and consume
* Play with the scheduler time and publish multiple messages
