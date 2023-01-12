package com.clay.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EpisodeDTO {

    private Long id;
    private String title;
    private String description;
    private String duration;
    private LocalDateTime releasedAt;
    private String audioUrl;
}

