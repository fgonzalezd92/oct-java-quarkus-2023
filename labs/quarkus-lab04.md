* Create a new quarkus project or module __quarkus-lab04-orm__. Add the required dependencies to work with Hibernate ORM panache.

<br/>


* Create a table __topics__ in __training__ database with the following fields
* __id__ int(primary key, auto increment), __title__(varchar) and __duration__ (number)

<br/>



<br/>

* Define Topic and TopicRepository classes
* Implement a __ConferenceService__ class that uses __TopicRepository__

``` java 

public class ConferenceService {
	
	public void addTopic(String title, int duration) {
		//Do not allow duplicate topics
		//Throw TopicFoundException if the topic exists
	}
	
	public List<Topic> getAllTopics() {
	
	} 
	
	public void removeTopic(String title) {
		//Throw TopicNotFoundException if the topic doesn't exist
	}
	
}

```

* Inject __ConferenceService__ in your **ConferenceResource** with GET, POST, DELETE paths etc
* Insert the following topics and check the operations

```
Functional programming with Erlang - 60 min
Scala Tricks - 45 min
Spring unit testing - 90 min
Unit testing JavaScript - 90 min
Concurrency on the JVM - 60 min
Goroutines - 45 min
RoR - 90 min
```