package com.api.endereco.model;

import com.api.endereco.Dto.UsuarioDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;

    @Column(name="CEP")
    private String cep;

    @Column(name = "Rua")
    private String rua;

    @Column(name = "Número")
    private int numero;

    @ManyToOne(cascade = CascadeType.ALL) //muitos enderecos Um usuario
    @JoinColumn(name = "usuario_id") //chave estrangeira
    //    @JsonIgnore
    private Usuario usuario;

    public Endereco(UsuarioDto usuarioDto) {
        this.cep = usuarioDto.getCep();
        this.rua = usuarioDto.getRua();
        this.numero = usuarioDto.getNumero();
    }

    //Mét mostra id do usuario daquele endereço -> gambiarra!!
    public Long getUsuario() {

        return usuario.getId();
    }

}
