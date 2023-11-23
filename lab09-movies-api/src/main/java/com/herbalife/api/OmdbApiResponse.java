package com.herbalife.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OmdbApiResponse {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Language")
    private String language;
    @JsonProperty("Actors")
    private String actors;
    @JsonProperty("Year")
    private int year;
}
