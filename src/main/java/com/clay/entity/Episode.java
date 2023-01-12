package com.clay.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "episode")
public class Episode extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String duration;
    private LocalDateTime releasedAt;
    private String audioUrl;

    @ManyToOne
    @JoinColumn(name = "podcast_id")
    private Podcast podcast;
}
