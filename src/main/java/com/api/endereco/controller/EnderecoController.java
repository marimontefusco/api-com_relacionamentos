package com.api.endereco.controller;

import com.api.endereco.model.Endereco;
import com.api.endereco.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    // Atributo externo
    EnderecoService enderecoService;

    // Construtor
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    // Endpoints
    @PostMapping("/salvar")
    public ResponseEntity<String> salvarEndereco(@RequestBody Endereco endereco) {
        this.enderecoService.salvarEndereco(endereco);

        return ResponseEntity.status(201).body("Endereco salvo");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPeloId(@PathVariable Long id) {
        Endereco endereco = this.enderecoService.buscarEnderecoPeloId(id);

        return ResponseEntity.status(200).body(endereco);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarEndereco(@PathVariable Long id,
                                                    @RequestBody Endereco novoEndereco) {
        Endereco endereco = this.enderecoService.buscarEnderecoPeloId(id);

        endereco.setCep(novoEndereco.getCep());
        endereco.setRua(novoEndereco.getRua());
        endereco.setNumero(novoEndereco.getNumero());

        this.enderecoService.atualizarEndereco(endereco);

        return ResponseEntity.status(200).body("Endereço atualizado");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarEndereco(@PathVariable Long id) {

        this.enderecoService.excluirEndereco(id);

        return ResponseEntity.status(200).body("Endereço deletado");
    }

    @GetMapping("listar")
    public ResponseEntity<List<Endereco>> listarEnderecos() {

        List<Endereco> enderecos = this.enderecoService.listarEnderecos();

        return ResponseEntity.status(200).body(enderecos);
    }

}
