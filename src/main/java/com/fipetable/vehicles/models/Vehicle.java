package com.fipetable.vehicles.models;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_1.JavaDoubleParser;

public class Vehicle {
    private Integer type;
    private Double value;
    private String brand;
    private String model;
    private Integer year;
    private String fuel;
    private String fipeCode;

    public Vehicle(VehicleData data){
        this.type = data.type() != null ? data.type() : 1;
        if(data.value() == null){
            value = 0.0;
        }else{
            this.value = JavaDoubleParser.parseDouble(data.value().split(" ")[1]
                    .replace(".", "")
                    .replace(",", "."));
        }
        this.brand = data.brand() != null ? data.brand() : "Desconhecido";
        this.model = data.model() != null ? data.model() : "Desconhecido";
        this.year = data.year() != null ? data.year() : 0;
        this.fuel = data.fuel() != null ? data.fuel() : "Desconhecido";
        this.fipeCode = data.fipeCode();

    }

    public Vehicle(Integer type, double value, String brand, String model, Integer year, String fuel, String fipeCode) {
        this.type = type;
        this.value = value;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.fipeCode = fipeCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFipeCode() {
        return fipeCode;
    }

    @Override
    public String toString() {
        return """
                Tipo de veículo: %d
                Valor: %.2f
                Marca: %s
                Modelo: %s
                Ano modelo: %d
                Combustível: %s
                Código FIPE: %s
                """.formatted(type, value, brand, model, year, fuel, fipeCode);
    }
}
