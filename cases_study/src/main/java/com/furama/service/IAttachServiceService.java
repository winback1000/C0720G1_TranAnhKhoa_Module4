package com.furama.service;

import com.furama.entity.AttachService;

import java.util.List;

public interface IAttachServiceService {
    List<AttachService> findAll();
    AttachService selectAttachServiceById(int id);
}
