package com.crackbyte.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShowsDTO {
    @JsonProperty("total")
    public String total;
    @JsonProperty("page")
    public Integer page;
    @JsonProperty("pages")
    public Integer pages;
    @JsonProperty("tv_shows")
    public List<TvShowDTO> tvShows;
}
