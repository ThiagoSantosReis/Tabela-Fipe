package com.fipetable.vehicles.models;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record BrandData(
        @JsonAlias("modelos") List<Data> models ,
        @JsonAlias("anos") List<Data> years
        )
{
}
