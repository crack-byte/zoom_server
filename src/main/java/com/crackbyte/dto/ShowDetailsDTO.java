package com.crackbyte.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowDetailsDTO {
    @JsonProperty("tvShow")
    public TvShowDTO tvShow;
}
