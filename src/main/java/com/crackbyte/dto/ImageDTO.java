package com.crackbyte.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageDTO {

    @JsonProperty("image")
    private String image;
    @JsonProperty("thumbImage")
    private String thumbImage;
    @JsonProperty("alt")
    private String alt;
    @JsonProperty("title")
    private String title;

    public static ImageDTO getImageObject(String s) {
        return ImageDTO.builder().image(s).thumbImage(s).alt("").title("").build();
    }
}
