package com.clay.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "podcast")
public class Podcast extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "podcast", cascade = CascadeType.ALL)
    private List<Episode> episodes;
}
