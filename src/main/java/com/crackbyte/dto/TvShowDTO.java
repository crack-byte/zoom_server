package com.crackbyte.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

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
    @JsonProperty("url")
    public String url;
    @JsonProperty("description")
    public String description;
    @JsonProperty("description_source")
    public String descriptionSource;
    @JsonProperty("runtime")
    public Integer runtime;
    @JsonProperty("youtube_link")
    public Object youtubeLink;
    @JsonProperty("image_path")
    public String imagePath;
    @JsonProperty("rating")
    public String rating;
    @JsonProperty("rating_count")
    public String ratingCount;
    @JsonProperty("countdown")
    public Object countdown;
    @JsonProperty("genres")
    public List<String> genres = null;
    @JsonProperty("pictures")
    public List<String> pictures = null;
    @JsonProperty("episodes")
    public List<Episode> episodes = null;

}
