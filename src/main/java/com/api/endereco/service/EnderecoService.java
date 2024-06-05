package com.api.endereco.service;

import com.api.endereco.model.Endereco;
import com.api.endereco.repository.EnderecoRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    // Atributo externo
    EnderecoRepository enderecoRepository;

    // Construtor
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    // Métodos

    // Met salvar endereco no repository
    public void salvarEndereco(Endereco endereco) {

        this.enderecoRepository.save(endereco);
    }

    // Met busca por id
    public Endereco buscarEnderecoPeloId(Long id) {
        Optional<Endereco> endereco = this.enderecoRepository.findById(id);

        if(endereco.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(404), "Endereço não encontrado");
        }

        return endereco.get();
    }

    // Met listar todos enderecos
    public List<Endereco> listarEnderecos() {
        List<Endereco> listaEnderecos = this.enderecoRepository.findAll();

        return listaEnderecos;
    }

    //Mét verifica se endereco existe
    public void verificarEndereco(Long id){
        Boolean isEnderecoValido = this.enderecoRepository.existsById(id);

        if(!isEnderecoValido) {
            throw new ResponseStatusException (
                    HttpStatusCode.valueOf(404), "Endereço inexistente");
        }
    }

    // Mét atualiza endereco
    public void atualizarEndereco(Endereco endereco) {
        verificarEndereco(endereco.getId());

        this.enderecoRepository.save(endereco);
    }

    // Mét exclui endereco
    public void excluirEndereco(Long id){
        verificarEndereco(id); //chama mét

        this.enderecoRepository.deleteById(id);
    }

}
