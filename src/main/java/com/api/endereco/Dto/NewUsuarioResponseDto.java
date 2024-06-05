package com.api.endereco.Dto;

import com.api.endereco.model.Endereco;
import com.api.endereco.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewUsuarioResponseDto {
    private Long id;
    private String nome;
    private Endereco endereco;

    public NewUsuarioResponseDto(Usuario usuario, Endereco endereco) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.endereco = endereco;
    }

}
