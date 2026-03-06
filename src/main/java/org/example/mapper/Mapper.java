package org.example.mapper;

public interface Mapper<T, F> {
    T from(F f);
}
