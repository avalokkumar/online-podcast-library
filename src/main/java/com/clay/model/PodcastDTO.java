package com.clay.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PodcastDTO {

    private Long id;
    private String title;
    private String description;
    private String genre;
    private String language;
    private String publisher;
    private String imageUrl;
    private String websiteUrl;
    private String feedUrl;
    private boolean explicit;

    private List<EpisodeDTO> episodes;
}

