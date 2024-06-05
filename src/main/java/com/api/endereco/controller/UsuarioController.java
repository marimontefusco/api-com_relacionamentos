package com.api.endereco.controller;

import com.api.endereco.Dto.NewUsuarioResponseDto;
import com.api.endereco.Dto.UsuarioDto;
import com.api.endereco.model.Usuario;
import com.api.endereco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // Atributo externo
    //@Autowired
    UsuarioService usuarioService;

    // Construtor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoints
    @PostMapping("/cadastrar")
    public ResponseEntity<NewUsuarioResponseDto> cadastrar(@RequestBody UsuarioDto usuarioDto) {
        NewUsuarioResponseDto usuarioCadastrado = this.usuarioService.cadastrarNovoUsuario(usuarioDto);

        return ResponseEntity.created(null).body(usuarioCadastrado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> listaUsuarios = this.usuarioService.findAll();

        return ResponseEntity.ok(listaUsuarios);
    }


}
