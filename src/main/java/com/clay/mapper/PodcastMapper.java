package com.clay.mapper;

import com.clay.entity.Episode;
import com.clay.entity.Podcast;
import com.clay.model.EpisodeDTO;
import com.clay.model.PodcastDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PodcastMapper {

    @Mapping(target = "episodes", source = "podcast.episodes")
    PodcastDTO podcastToPodcastDTO(Podcast podcast);

    @Mapping(target = "episodes", source = "podcastDTO.episodes")
    Podcast podcastDTOToPodcast(PodcastDTO podcastDTO);

    EpisodeDTO episodeToEpisodeDTO(Episode episode);

    Episode episodeDTOToEpisode(EpisodeDTO episodeDTO);

    @IterableMapping(elementTargetType = Podcast.class)
    List<Podcast> mapTo(List<PodcastDTO> roles);

    @IterableMapping(elementTargetType = PodcastDTO.class)
    List<PodcastDTO> mapFrom(List<Podcast> roles);

    @IterableMapping(elementTargetType = EpisodeDTO.class)
    List<EpisodeDTO> mapToDTO(List<Episode> roles);

    @IterableMapping(elementTargetType = Episode.class)
    List<Episode> mapFromEntity(List<EpisodeDTO> roles);

}

