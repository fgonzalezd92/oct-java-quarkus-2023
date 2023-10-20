* Create Lab10.java. In this lab you will practice working with Http requests, JSON and JDBC
* Input to the application will be the name of a movie. Say, Spectre or Barbie or Top Gun

* You can fetch the details of the movie by connecting to this API

```
http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=<movieName>
```

* For example, if you want information about __Spectre__ movie use this URL **http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=Spectre**

* Print the **title, year, language and genre** of the movie names on the console

* Use any HTTP and Json library of your choice (__You need to configure Gradle dependency for this__)
* You can also use  __HttpClient__ class introduced in Java 11 like shown below

``` java
		HttpRequest req = HttpRequest
					.newBuilder(new URI("url"))
					.GET()
					.build();
		HttpResponse<String> response = HttpClient.newBuilder().build().send(req, HttpResponse.BodyHandlers.ofString());
		String result = response.body();
```

* Create a table **movies(id, title, year, language, genre)** in training database
* Store all the movie details you fetch from OMDB API in movies table. 
* Let's keep it simple and not worry about duplications

* **Note**: Use **PreparedStatement** instead of Statement
