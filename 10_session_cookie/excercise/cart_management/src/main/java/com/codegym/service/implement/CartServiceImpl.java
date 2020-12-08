package com.codegym.service.implement;

import com.codegym.model.Cart;
import com.codegym.repository.ICartRepository;
import com.codegym.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public void save(Cart cart) {
        iCartRepository.save(cart);
    }
}
