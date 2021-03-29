
package com.crackbyte.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Episode {
    @JsonProperty("season")
    public Integer season;
    @JsonProperty("episode")
    public Integer episode;
    @JsonProperty("name")
    public String name;
    @JsonProperty("air_date")
    public String airDate;

}
