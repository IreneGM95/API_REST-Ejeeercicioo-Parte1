package com.example.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.entities.Hotel;


public interface HotelService  {
    
    public List<Hotel> findAll(Sort sort);
    public Page<Hotel> findAll(Pageable pageable);
    /** Encontrar un hotel concreto por su id: */
    public Hotel findById (long id);

    public Hotel save (Hotel hotel);
    public Hotel delete(Hotel hotel);
}