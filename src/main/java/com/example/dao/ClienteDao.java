package com.example.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

    /**
     * Vamos a necesitar tres metodos adicionalesa los que genera el CRUD repository
     * (la interface) para:
     * 1. Recuperar la lista de Clientes ordenados
     * 2. Recuperar listado de Clientes paginados, es decir, que no traiga todos
     * los Clientes de golpe sino de 10 en 10, 20 en 20...
     * 3. Consulta para recuperar las hoteles con sus Clientes
     * correspondientes sin tener que realizar una subconsultala cual sería menos
     * eficiente que un join a las entidades utilizando HQL (Hibernate Query
     * Language)
     */

    // Recuperar la lista de Clientes ordenados:

    @Query(value = "select c from Cliente c inner join fetch c.hotel inner join fetch c.mascotas")
    public List<Cliente> findAll(Sort sort);

    // Recuperar listado de Clientes paginados:

    @Query(value = "select c from Cliente c inner join fetch c.hotel inner join fetch c.mascotas", countQuery = "select count(c) from Cliente c left join c.hotel left join c.mascotas")
    public Page<Cliente> findAll(Pageable pageable);
    // devuelve el numero de Clientes fijados por el pageable

    // Consulta para recuperar las hoteles con sus Clientes utilizando HQL
    // (Hibernate Quer Language), se recupera por el id:

    @Query(value = "select c from Cliente c left join fetch c.hotel left join fetch c.mascotas where c.id = :id")
    public Cliente findById(long id);

    //¿No harían falta?
/**Método que permite eliminar un cliente:*/

/**Método que permite guardar un cliente:*/

/**Método que permite actualizar un cliente:*/

    /**
     * RECORDEMOS QUE: Cuando hemos creado las relaciones hemos especificado que
     * la busqueda sea LAZY, para que no se traiga la hotel siempre que se
     * busque un Cliente, porque serian dos consultas, o una consulta con una
     * subconsulta, que es menos eficiente que lo que vamos a hacer, hacer una sola
     * consulta relacionando las entidades, y digo las entidades, porque aunque
     * de la impresión que es una consulta de SQL no consultamos a las tablas de
     * la base de datos sino a las entidades
     * (esto se llama HQL (Hibernate Query Language))
     * 
     * Ademas, tambien podremos recuperar el listado de Clientes de forma ordenada,
     * por algun criterio de ordenación, como por
     * ejemplo por el nombre del Cliente,
     * por la descripcion, etc.
     */
}
