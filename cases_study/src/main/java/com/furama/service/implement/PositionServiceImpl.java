package com.furama.service.implement;

import com.furama.entity.Position;
import com.furama.repository.PositionRepository;
import com.furama.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position selectPositionById(int id) {
        return positionRepository.findById(id).orElse(null);
    }
}
