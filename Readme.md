## Online Podcast Library
This is an online podcast library service that allows users to browse and stream podcasts from a variety of sources. The service is written in Java 11 and uses Spring Boot for the application framework, Gradle for the build system, and GraphQL for the API.

### Prerequisites
```Java 11 or later
Gradle 6.5 or later
```

### Building and Running the Service
To build the service, run the following command from the root directory of the project:</br>
```gradle build```

####  To start the service, run the following command from the root directory of the project:

```gradle bootRun```

The service will start up on port 8080 by default.

### Using the API
The service exposes a GraphQL API at http://localhost:8080/api/v1/sample.

Example of GraphQL query that retrieves a list of podcasts:

```
query {
podcasts {
title
description
genre
language
publisher
imageUrl
websiteUrl
feedUrl
explicit
episodes {
title
description
duration
releasedAt
audioUrl
}
}
}
```
And here is an example GraphQL mutation that adds a new podcast to the library:

`mutation {
addPodcast(input: {
title: "The Daily"
description: "This is a daily news podcast from The New York Times, delivering the day's top stories in a concise, conversational format."
genre: "News"
language: "English"
publisher: "The New York Times"
imageUrl: "https://www.example.com/podcasts/the-daily/image.jpg"
websiteUrl: "https://www.example.com/podcasts/the-daily"
feedUrl: "https://www.example.com/podcasts/the-daily/feed.xml"
explicit: false
}) {
title
}
}`