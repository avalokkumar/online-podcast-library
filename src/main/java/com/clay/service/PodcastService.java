package com.clay.service;

import com.clay.exception.ResourceNotFoundException;
import com.clay.model.EpisodeDTO;
import com.clay.model.PodcastDTO;

import java.util.List;

public interface PodcastService {
    PodcastDTO createPodcast(PodcastDTO podcastDTO);
    PodcastDTO getPodcast(Long id) throws ResourceNotFoundException;
    List<PodcastDTO> getAllPodcasts();
    PodcastDTO updatePodcast(Long id, PodcastDTO podcastDTO) throws ResourceNotFoundException;
    void deletePodcast(Long id);
    EpisodeDTO createEpisode(Long podcastId, EpisodeDTO episodeDTO) throws ResourceNotFoundException;
    EpisodeDTO getEpisode(Long podcastId, Long episodeId) throws ResourceNotFoundException;
    List<EpisodeDTO> getAllEpisodes(Long podcastId) throws ResourceNotFoundException;
    EpisodeDTO updateEpisode(Long podcastId, Long episodeId, EpisodeDTO episodeDTO) throws ResourceNotFoundException;
    void deleteEpisode(Long podcastId, Long episodeId);
}

