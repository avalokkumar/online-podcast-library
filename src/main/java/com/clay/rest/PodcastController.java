package com.clay.rest;

import com.clay.exception.ResourceNotFoundException;
import com.clay.model.PodcastDTO;
import com.clay.service.PodcastService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/podcasts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PodcastController {
    private final PodcastService podcastService;

    public PodcastController(PodcastService podcastService) {
        this.podcastService = podcastService;
    }

    @PostMapping
    public ResponseEntity<PodcastDTO> createPodcast(@RequestBody PodcastDTO podcastDTO) {
        PodcastDTO createdPodcast = podcastService.createPodcast(podcastDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPodcast);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PodcastDTO> getPodcast(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        PodcastDTO podcast = podcastService.getPodcast(id);
        return ResponseEntity.ok().body(podcast);
    }

    @GetMapping
    public ResponseEntity<List<PodcastDTO>> getAllPodcasts() {
        List<PodcastDTO> podcasts = podcastService.getAllPodcasts();
        return ResponseEntity.ok().body(podcasts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PodcastDTO> updatePodcast(@PathVariable(value = "id") Long id, @Validated @RequestBody PodcastDTO podcastDTO) throws ResourceNotFoundException {
        PodcastDTO updatedPodcast = podcastService.updatePodcast(id, podcastDTO);
        return ResponseEntity.ok().body(updatedPodcast);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePodcast(@PathVariable(value = "id") Long id) {
        podcastService.deletePodcast(id);
        return ResponseEntity.ok().build();
    }
}
