package com.fipetable.vehicles.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Data(
        @JsonAlias("codigo") String code,
        @JsonAlias("nome") String name) {
    @Override
    public String toString() {
        return code+" - "+name;
    }
}
