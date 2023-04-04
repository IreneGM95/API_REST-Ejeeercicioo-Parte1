package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "clientes")

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellidos;

    @PastOrPresent //evita que la fecha sea superior/posterior a la fecha de hoy
    @DateTimeFormat(pattern =  "yyyy-MM-dd")
    private LocalDate fechaAlta;

    private String imagenCliente;

    //Relaciones entre tablas:
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    // @JsonManagedReference
    private Hotel hotel;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
    //Hace falta la anotación
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Mascota> mascotas;

   
}
