package com.example.airtel.repository;

import java.util.Optional;

public interface DAO<T> {
    int save(T t);
}
