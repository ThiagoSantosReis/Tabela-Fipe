package com.fipetable.vehicles.services;

import java.util.List;

public interface IConverter {
    <T> T getData(String json, Class<T> cls);

    <T> List<T> getList(String json, Class<T> cls);
}
