package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dao.ClienteDao;
import com.example.entities.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

    /** Creamos la variable de tipo Dao para poder inyectarle la capa DAO, puede resolverse con un @Autowire o mediante constructor: */
    @Autowired
    private ClienteDao ClienteDao;

    @Override
    public List<Cliente> findAll(Sort sort) {
        return ClienteDao.findAll(sort);

    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        
        return ClienteDao.findAll(pageable);
    }

    @Override
    public Cliente findById(long id) {
        return ClienteDao.findById(id);
    }

    @Override
    public Cliente save(Cliente Cliente) {
       return ClienteDao.save(Cliente);
    }

    @Override
    public void delete(Cliente Cliente) {
        ClienteDao.delete(Cliente);
    }


}
