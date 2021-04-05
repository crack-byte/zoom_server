package com.crackbyte.controller;

import com.crackbyte.dto.ShowsDTO;
import com.crackbyte.services.TvShowsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Shows Controller",tags = "shows")
@AllArgsConstructor
@RestController
@RequestMapping("/shows")
public class ShowsController {
    private static final Logger log = LoggerFactory.getLogger(ShowsController.class);
    TvShowsServiceImpl tvShowsService;

    @GetMapping
    public ResponseEntity<Object> getShows(@RequestParam(defaultValue = "") String q, @RequestParam(defaultValue = "1") int page) {
        log.info("searching {}......", q);
        ShowsDTO data;
        if (!q.isEmpty()) {
            data = tvShowsService.searchShows(q, page);
        } else {
            data = tvShowsService.mostPopularShows(page);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
