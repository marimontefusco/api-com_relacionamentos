package com.api.endereco.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    //um usuario tem varios enderecos
    @OneToMany(mappedBy = "usuario") //usuario -> mesmo nome do atributo usuario da tb_endereco
    //@JsonIgnore
    private List<Endereco> enderecos = new ArrayList<>();

}
