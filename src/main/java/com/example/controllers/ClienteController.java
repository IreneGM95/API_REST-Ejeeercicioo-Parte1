package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//En lugar de controller usamos un restcontroller
//En una api rest se gestiona un recurso y en dependencias de http sera la peticion u otra
@RestController
@RequestMapping("/productos") // todas las peticiones se hacen a traves de productos, no hace falta crear
                              // /listar, /alta...
public class ClienteController {

     /**IMPORTANTE: El método que recupera los clientes, tiene que ser capaz de hacerlo por pagina y siempre con
ordenamiento */
    
}
