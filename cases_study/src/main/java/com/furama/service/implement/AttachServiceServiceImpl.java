package com.furama.service.implement;

import com.furama.entity.AttachService;
import com.furama.repository.AttachServiceRepository;
import com.furama.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceServiceImpl implements IAttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public AttachService selectAttachServiceById(int id) {
        return attachServiceRepository.findById(id).orElse(null);
    }
}
