package com.crackbyte.controller;

import com.crackbyte.dto.ShowDetailsDTO;
import com.crackbyte.services.TvShowsServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/show-details")
public class ShowDetailsController {
    private static final Logger log = LoggerFactory.getLogger(ShowDetailsController.class);
    TvShowsServiceImpl tvShowsService;

    @GetMapping
    public ResponseEntity<Object> getShows(@RequestParam String q) {
        log.info("fetching details for {}......", q);
        ShowDetailsDTO data = tvShowsService.searchShowDetails(q);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
