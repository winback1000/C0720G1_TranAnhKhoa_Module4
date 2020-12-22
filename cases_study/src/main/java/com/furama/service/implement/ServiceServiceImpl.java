package com.furama.service.implement;

import com.furama.repository.ServiceRepository;
import com.furama.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public List<com.furama.entity.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public com.furama.entity.Service selectServiceById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Page<com.furama.entity.Service> findAllWithPage(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<com.furama.entity.Service> searchService(String searchData, Pageable pageable) {
        return serviceRepository.findAllByNameContains(searchData, pageable);
    }

    @Override
    public void save(com.furama.entity.Service service) {
        if (service.getImage().equals("") && service.getId() != null) {
            service.setImage(serviceRepository.getOne(service.getId()).getImage());
        }

        switch (service.getServiceType().getId()) {
            case 1:
                service.setStandard("only available with villas and houses");
                service.setDescriptionOtherConvenience("only available with villas and houses");
                service.setPoolArea(0d);
                service.setNumberOfFloor(0);
                break;
            case 2:
                service.setPoolArea(0d);
                break;
        }
        serviceRepository.save(service);
    }

    @Override
    public void delete(int deleteID) {
        serviceRepository.deleteById(deleteID);
    }
}
