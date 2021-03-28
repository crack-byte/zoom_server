package com.crackbyte.controller;

import com.crackbyte.dto.ShowsDTO;
import com.crackbyte.services.TvShowsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@RestController
@RequestMapping("/shows")
public class ShowsController {
    RestTemplate restTemplate;
    TvShowsService tvShowsService;

    @GetMapping
    public ResponseEntity<Object> getShows(@RequestParam(defaultValue = "") String q, @RequestParam(defaultValue = "1") int page) {
        ShowsDTO data;
        if (!q.isEmpty()) {
            data = tvShowsService.searchShows(q, page);
        } else {
            data = tvShowsService.mostPopularShows(page);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
