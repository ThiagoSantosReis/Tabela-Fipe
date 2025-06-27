package com.fipetable.vehicles.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleData(
        @JsonAlias("TipoVeiculo") Integer type,
        @JsonAlias("Valor") String value,
        @JsonAlias("Marca") String brand,
        @JsonAlias("Modelo") String model,
        @JsonAlias("AnoModelo") Integer year,
        @JsonAlias("Combustivel") String fuel,
        @JsonAlias("CodigoFipe") String fipeCode
) {
}
