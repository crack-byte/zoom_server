package com.crackbyte.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvShowDTO {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("permalink")
    public String permalink;
    @JsonProperty("start_date")
    public String startDate;
    @JsonProperty("end_date")
    public Object endDate;
    @JsonProperty("country")
    public String country;
    @JsonProperty("network")
    public String network;
    @JsonProperty("status")
    public String status;
    @JsonProperty("image_thumbnail_path")
    public String imageThumbnailPath;

}
