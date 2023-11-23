### To Do

* **Does the GC clean up the string pool?**-> Prior to Java 8, GC wasn't cleaning up string pool; But after Java 1.8 and now, GC cleans up the string pool; String pool used to be in a space(PermGen space) outside the heap; But now String pool is also on the heap, so GC cleans it

* **Discussions on @SessionScoped**  - You need to an extension **quarkus-undertow** to enable session scoped beans
* **REST Client reactive dependency** - Done
* Why don't you get a 404 error in quarkus rest api deployed in a container?

* Redis Tags