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
     * 3. Consulta para recuperar las mascotaes con sus Mascotas
     * correspondientes sin tener que realizar una subconsultala cual sería menos
     * eficiente que un join a las entidades utilizando HQL (Hibernate Query
     * Language)
     */

//CORREGIR

    // // Recuperar la lista de Mascotas ordenados:

    // @Query(value = "select c from mascota c inner join fetch c.cliente inner join fetch c.mascotas")
    // public List<Mascota> findAll(Sort sort);

    // // Recuperar listado de mascotas paginados:

    // @Query(value = "select c from mascota c inner join fetch c.cliente inner join fetch c.mascotas", countQuery = "select count(c) from mascota c left join c.cliente left join c.mascotas")
    // public Page<Mascota> findAll(Pageable pageable);
    // // devuelve el numero de mascotas fijados por el pageable

    // // Consulta para recuperar las clientees con sus mascotas utilizando HQL
    // // (Hibernate Quer Language), se recupera por el id:

    // @Query(value = "select c from mascota c left join fetch c.cliente left join fetch c.mascotas where c.id = :id")
    // public Mascota findById(long id);

}
