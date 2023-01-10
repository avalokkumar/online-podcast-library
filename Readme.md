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

Sample Json:

```
{
  "podcast": {
    "title": "The Daily",
    "description": "This is a daily news podcast from The New York Times, delivering the day's top stories in a concise, conversational format.",
    "genre": "News",
    "language": "English",
    "publisher": "The New York Times",
    "episodes": [
      {
        "title": "January 9, 2021: The Threat of Domestic Terrorism",
        "description": "In the wake of the deadly attack on the U.S. Capitol, President-elect Joe Biden has called for national unity and an end to 'this uncivil war.' We discuss the threat of domestic terrorism and what can be done to address it.",
        "duration": "24:57",
        "released_at": "2021-01-09T00:00:00Z",
        "audio_url": "https://www.example.com/podcasts/the-daily/january-9-2021.mp3"
      },
      {
        "title": "January 8, 2021: The Aftermath of the Capitol Attack",
        "description": "The violent attack on the U.S. Capitol by a pro-Trump mob has sent shockwaves around the world. We discuss the aftermath of the attack and the efforts to hold those responsible accountable.",
        "duration": "26:48",
        "released_at": "2021-01-08T00:00:00Z",
        "audio_url": "https://www.example.com/podcasts/the-daily/january-8-2021.mp3"
      }
    ],
    "image_url": "https://www.example.com/podcasts/the-daily/image.jpg",
    "website_url": "https://www.example.com/podcasts/the-daily",
    "feed_url": "https://www.example.com/podcasts/the-daily/feed.xml",
    "explicit": false
  }
}
```
