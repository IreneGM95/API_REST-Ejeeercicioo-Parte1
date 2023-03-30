package com.example.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Mascota;

public interface MascotaDao extends JpaRepository<Mascota, Long> {

    /**
     * Vamos a necesitar tres metodos adicionalesa los que genera el CRUD repository
     * (la interface) para:
     * 1. Recuperar la lista de Mascotas ordenados
     * 2. Recuperar listado de Mascotas paginados, es decir, que no traiga todos
     * los Mascotas de golpe sino de 10 en 10, 20 en 20...
     * 3. Consulta para recuperar las presentaciones con sus Mascotas
     * correspondientes sin tener que realizar una subconsultala cual sería menos
     * eficiente que un join a las entidades utilizando HQL (Hibernate Query
     * Language)
     */

    // Recuperar la lista de Mascotas ordenados:

    @Query(value = "select p from Mascota p left join fetch p.presentacion") // NO es una consulta de mysql, sino HQL
    public List<Mascota> findAll(Sort sort);

    // Recuperar listado de Mascotas paginados:

    @Query(value = "select p from Mascota p left join fetch p.presentacion", countQuery = "select count(p) from Mascota p left join p.presentacion")
    public Page<Mascota> findAll(Pageable pageable);
//devuelve el numero de Mascotas fijados por el pageable


    // Consulta para recuperar las presentaciones con sus Mascotas utilizando HQL
    // (Hibernate Quer Language), se recupera por el id:

    @Query(value = "select p from Mascota p left join fetch p.presentacion where p.id = :id")
    public Mascota findById(long id);

}
