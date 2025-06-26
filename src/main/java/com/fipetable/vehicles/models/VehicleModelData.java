package com.fipetable.vehicles.models;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record VehicleModelData(
        @JsonAlias("modelos") List<Data> models ,
        @JsonAlias("anos") List<Data> years
        )
{
}
