package com.fipetable.vehicles.services;

public interface IConverter {
    <T> T getData(String json, Class<T> cls);

    <T> T getList(String json, Class<T> cls);
}
