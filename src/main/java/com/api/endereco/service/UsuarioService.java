package com.api.endereco.service;

import com.api.endereco.Dto.NewUsuarioResponseDto;
import com.api.endereco.Dto.UsuarioDto;
import com.api.endereco.model.Endereco;
import com.api.endereco.model.Usuario;
import com.api.endereco.repository.EnderecoRepository;
import com.api.endereco.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    // Atributos externos
    UsuarioRepository usuarioRepository;
    EnderecoRepository enderecoRepository;

    //Construtor
    public UsuarioService(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.enderecoRepository = enderecoRepository;
    }

    //Métodos

    // Met lista todos usuarios
    public List<Usuario> findAll() {

        return this.usuarioRepository.findAll();
    }

    //Met cadastra novo usuario
    public NewUsuarioResponseDto cadastrarNovoUsuario(UsuarioDto usuarioDto) {

        //Instancias
        Usuario usuario = new Usuario();
        Endereco endereco = new Endereco();

        usuario.setNome(usuarioDto.getNome());
        Usuario usuarioCadastrado = this.usuarioRepository.save(usuario); //salva no repository

        endereco.setRua(usuarioDto.getRua());
        endereco.setNumero(usuarioDto.getNumero());
        endereco.setCep(usuarioDto.getCep());
        endereco.setUsuario(usuarioCadastrado);
        Endereco enderecoCadastrado = this.enderecoRepository.save(endereco);

        return new NewUsuarioResponseDto(usuarioCadastrado, enderecoCadastrado);

    }

}
