package com.example.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Cliente;
import com.example.services.ClienteService;

//En lugar de controller usamos un restcontroller
//En una api rest se gestiona un recurso y en dependencias de http sera la peticion u otra
@RestController
@RequestMapping("/Clientes") // todas las peticiones se hacen a traves de Clientes, no hace falta crear
                              // /listar, /alta...
public class ClienteController {

     /**IMPORTANTE: El método que recupera los clientes, tiene que ser capaz de hacerlo por pagina y siempre con
ordenamiento */
  
// No basta devolver la información, hay que confirmar la petición
@Autowired
private ClienteService clienteService;

/**
 * Este método va a responder a una petición (request) del tipo
 * http://localhost:8080/Clientes?page=1&size=4, pagina uno con 4 Clientes
 * Debe ser capaz de devolver un listado un listado de Clientes paginados o no,
 * pero en cualquier caso ordenado por un criterio (nombre, descripción, etc.)
 * La petición anterior iplica un @RequestParam
 * "page" es el número de pagina
 * 
 * @PathVariable sirve para peticiones del tipo /Clientes/3
 */
@GetMapping // le hacemos la petición por get
public ResponseEntity<List<Cliente>> findAll(
        @RequestParam(name = "page", required = false) Integer page,
        @RequestParam(name = "size", required = false) Integer size) {

    ResponseEntity<List<Cliente>> responseEntity = null;
    List<Cliente> clientes = new ArrayList<>();

    Sort sortByNombre = Sort.by("nombre");

    // comprobamos si tenemos paginas y Clientes:
    if (page != null && size != null) {
        // con paginación y ordenación:
        try {
            Pageable pageable = PageRequest.of(page, size, sortByNombre);
            Page<Cliente> clientesPaginados = clienteService.findAll(pageable);
            clientes = clientesPaginados.getContent();
            responseEntity = new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    } else {
        // sin paginación, pero con ordenamiento:
        try {
        clientes = clienteService.findAll(sortByNombre);
            responseEntity = new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    return responseEntity;

}
}
