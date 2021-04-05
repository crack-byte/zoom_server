package com.crackbyte.services;

import com.crackbyte.dto.ImageDTO;
import com.crackbyte.dto.ShowDetailsDTO;
import com.crackbyte.dto.ShowsDTO;
import com.crackbyte.dto.TvShowDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.crackbyte.utility.UrlMapping.HOST;

@AllArgsConstructor
@Service
public class TvShowsServiceImpl implements TvShowsService {
    RestTemplate restTemplate;

    /**
     * @param searchKey
     * @param page
     * @return
     */
    @Override
    public ShowsDTO searchShows(String searchKey, int page) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(HOST)
                .path("api/search")
                .queryParam("q", searchKey)
                .queryParam("page", page);
        return restTemplate.getForObject(builder.encode().toUriString(), ShowsDTO.class);
    }

    /**
     * @param page
     * @return
     */
    @Override
    public ShowsDTO mostPopularShows(int page) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(HOST)
                .path("api/most-popular")
                .queryParam("page", page);
        return restTemplate.getForObject(builder.encode().toUriString(), ShowsDTO.class);
    }

    /**
     * @param searchKey
     * @return
     */
    @Override
    public ShowDetailsDTO searchShowDetails(String searchKey) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(HOST)
                .path("api/show-details")
                .queryParam("q", searchKey);
        ShowDetailsDTO showDetailsDTO = restTemplate.getForObject(builder.encode().toUriString(), ShowDetailsDTO.class);
        if (showDetailsDTO != null && showDetailsDTO.getTvShow() != null && showDetailsDTO.getTvShow().getPictures() != null) {
            TvShowDTO tvShow = showDetailsDTO.getTvShow();
            List<String> pictures = tvShow.getPictures();
            if (pictures != null && !pictures.isEmpty()) {
                tvShow.setImages(pictures.parallelStream()
                        .map(ImageDTO::getImageObject)
                        .collect(Collectors.toList()));
            } else {
                tvShow.setImages(Collections.singletonList(ImageDTO.getImageObject(tvShow.getImagePath())));
            }
        }
        return showDetailsDTO;
    }

}
