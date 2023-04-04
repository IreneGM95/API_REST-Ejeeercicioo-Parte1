package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "mascotas")
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String raza;

    @Enumerated(EnumType.STRING)
    private Genero genero;
    
    @PastOrPresent
    @DateTimeFormat(pattern =  "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    public enum Genero {
        HOMBRE, MUJER, OTRO
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnore // para evitar recursibidad entre mascota y clientes (mascota llama a clientes,
                // que a su vez llama a mascota)
    // @JsonManagedReference // evita recursividad, con este no haria falta ignore
    // @JsonIgnoreProperties
    private Cliente cliente;
}
