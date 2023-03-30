package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dao.HotelDao;
import com.example.entities.Hotel;

public class HotelServiceImpl implements HotelService {

    /**
     * Creamos la variable de tipo Dao para poder inyectarle la capa DAO, puede
     * resolverse con un @Autowire o mediante constructor:
     */
    @Autowired
    private HotelDao hotelDao;

    @Override
    public List<Hotel> findAll(Sort sort) {
        return hotelDao.findAll(sort);

    }

    @Override
    public Page<Hotel> findAll(Pageable pageable) {

        return hotelDao.findAll(pageable);
    }

    @Override
    public Hotel findById(long id) {
        return hotelDao.findById(id);
    }

    @Override
    public Hotel save(Hotel Hotel) {
        return hotelDao.save(Hotel);
    }

    @Override
    public void delete(Hotel Hotel) {
        hotelDao.delete(Hotel);
    }

}