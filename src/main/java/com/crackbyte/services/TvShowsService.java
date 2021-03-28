package com.crackbyte.services;

import com.crackbyte.dto.ShowsDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static com.crackbyte.utility.UrlMapping.HOST;

@AllArgsConstructor
@Service
public class TvShowsService {
    RestTemplate restTemplate;

    public ShowsDTO searchShows(String searchKey, int page) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(HOST)
                .path("api/search")
                .queryParam("q", searchKey)
                .queryParam("page", page);
        return restTemplate.getForObject(builder.encode().toUriString(), ShowsDTO.class);
    }

    public ShowsDTO mostPopularShows(int page) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(HOST)
                .path("api/most-popular")
                .queryParam("page", page);
        return restTemplate.getForObject(builder.encode().toUriString(), ShowsDTO.class);
    }
}
