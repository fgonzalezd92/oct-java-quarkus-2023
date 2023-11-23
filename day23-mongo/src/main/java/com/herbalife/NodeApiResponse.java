package com.herbalife;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeApiResponse {
    private String data;
}
