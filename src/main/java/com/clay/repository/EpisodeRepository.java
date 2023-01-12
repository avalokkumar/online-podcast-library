package com.clay.repository;

import com.clay.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {

    @Query("from Episode where podcast.id = ?1")
    List<Episode> findByPodcast(Long podcastId);
}