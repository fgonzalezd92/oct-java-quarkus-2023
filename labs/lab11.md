* Refer to the solution for Lab10. And build upon it. **You can ignore the DB tasks**
* Work with the __movies.txt__ file in the repo
* For each movie you have to connect to the following site __**http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f**__ and print the year of release, genre and language details
* Design using **parallel streams** to load the movies and invoke the URLs
* Print those movie names, whose details you are not able to fetch, on the console.

* Use any HTTP and Json library of your choice (__You need to configure Gradle dependency for this__)
* You can use the following code to connect to an external service

``` java
		HttpRequest req = HttpRequest
					.newBuilder(new URI("url"))
					.GET()
					.build();
		HttpResponse<String> response = HttpClient.newBuilder().build().send(req, HttpResponse.BodyHandlers.ofString());
		String result = response.body();
```

