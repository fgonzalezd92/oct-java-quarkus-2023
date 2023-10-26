* In your existing project, create a new package __com.herbalife.labs.lab01__ and implement the following
* In this lab we will practice configuring your beans and accessing them. The objective of this lab is to get familiar with the basics of configuration.

* You want to schedule the sessions for a __Conference__. The Conference uses a __SessionPlanner__ for the same. The SessionPlanner loads the topics from a collection.

* Inject SessionPlanner into Conference

* The topics are given below. You can configure these topics the way you want in your application.properties file

```
Functional programming with Erlang - 60 min
Scala Tricks - 45 min
Spring unit testing - 90 min
Unit testing JavaScript - 90 min
Concurrency on the JVM - 60 min
Goroutines - 45 min
RoR - 90 min
```

* The SessionPlanner splits the data to 60 min topics, 45 min topics and 90 min topics.
* Design the Conference and SessionPlanner classes and configure the beans. Configure the topics in a collection
* In the main class autowire Conference object and print the total number of 60 min/90 min/45 min topics.

* **Note:** You can configure the topics in the properties file, the way you want