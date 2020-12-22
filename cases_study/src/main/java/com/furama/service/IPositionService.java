package com.furama.service;

import com.furama.entity.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
    Position selectPositionById(int id);
}
