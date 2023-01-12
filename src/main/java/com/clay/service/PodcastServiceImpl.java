package com.clay.service;

import com.clay.entity.Episode;
import com.clay.entity.Podcast;
import com.clay.exception.ResourceNotFoundException;
import com.clay.mapper.PodcastMapper;
import com.clay.model.EpisodeDTO;
import com.clay.model.PodcastDTO;
import com.clay.repository.EpisodeRepository;
import com.clay.repository.PodcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PodcastServiceImpl implements PodcastService{

    @Autowired
    private PodcastRepository podcastRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private PodcastMapper podcastMapper;

    @Override
    public PodcastDTO createPodcast(PodcastDTO podcastDTO){
        Podcast podcast = podcastMapper.podcastDTOToPodcast(podcastDTO);
        podcast = podcastRepository.save(podcast);
        for (Episode episode : podcast.getEpisodes()) {
            episode.setPodcast(podcast);
        }
        episodeRepository.saveAll(podcast.getEpisodes());
        return podcastMapper.podcastToPodcastDTO(podcast);
    }

    @Override
    public PodcastDTO getPodcast(Long id) throws ResourceNotFoundException {
        Podcast podcast = podcastRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Podcast not found with id: " + id));
        return podcastMapper.podcastToPodcastDTO(podcast);
    }

    @Override
    public List<PodcastDTO> getAllPodcasts() {
        List<Podcast> podcasts = podcastRepository.findAll();
        return podcasts.stream().map(podcastMapper::podcastToPodcastDTO).collect(Collectors.toList());
    }

    @Override
    public PodcastDTO updatePodcast(Long id, PodcastDTO podcastDTO) throws ResourceNotFoundException {
        if (!podcastRepository.existsById(id)) {
            throw new ResourceNotFoundException("Podcast not found with id: " + id);
        }

        Podcast podcast = podcastRepository.save(podcastMapper.podcastDTOToPodcast(podcastDTO));
        return podcastMapper.podcastToPodcastDTO(podcast);
    }

    @Override
    public void deletePodcast(Long id) {
        podcastRepository.deleteById(id);
    }

    @Override
    public EpisodeDTO createEpisode(Long podcastId, EpisodeDTO episodeDTO) throws ResourceNotFoundException {
        Podcast podcast = podcastRepository.findById(podcastId).orElseThrow(() -> new ResourceNotFoundException("Podcast not found with id: " + podcastId));
        Episode episode = podcastMapper.episodeDTOToEpisode(episodeDTO);
        episode.setPodcast(podcast);
        episode = episodeRepository.save(episode);
        return podcastMapper.episodeToEpisodeDTO(episode);
    }

    @Override
    public EpisodeDTO getEpisode(Long podcastId, Long episodeId) throws ResourceNotFoundException {
        Podcast podcast = podcastRepository.findById(podcastId).orElseThrow(() -> new ResourceNotFoundException("Podcast not found with id: " + podcastId));
        Episode episode = episodeRepository.findById(episodeId).orElseThrow(() -> new ResourceNotFoundException("Episode not found with id: " + episodeId));
        return podcastMapper.episodeToEpisodeDTO(episode);
    }

    @Override
    public List<EpisodeDTO> getAllEpisodes(Long podcastId) throws ResourceNotFoundException {
        Podcast podcast = podcastRepository.findById(podcastId).orElseThrow(() -> new ResourceNotFoundException("Podcast not found with id: " + podcastId));
        List<Episode> episodes = episodeRepository.findByPodcast(podcast.getId());
        return episodes.stream().map(podcastMapper::episodeToEpisodeDTO).collect(Collectors.toList());
    }

    @Override
    public EpisodeDTO updateEpisode(Long podcastId, Long episodeId, EpisodeDTO episodeDTO) throws ResourceNotFoundException {
        podcastRepository.findById(podcastId).orElseThrow(() -> new ResourceNotFoundException("Podcast not found with id: " + podcastId));
        episodeRepository.findById(episodeId).orElseThrow(() -> new ResourceNotFoundException("Episode not found with id: " + episodeId));

        return podcastMapper.episodeToEpisodeDTO(podcastMapper.episodeDTOToEpisode(episodeDTO));
    }

    @Override
    public void deleteEpisode(Long podcastId, Long episodeId) {
        episodeRepository.deleteById(episodeId);
    }
}

