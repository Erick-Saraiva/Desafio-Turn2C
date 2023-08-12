package com.desafio.desafioturn2c.controle;

import com.desafio.desafioturn2c.dominio.Cliente;
import com.desafio.desafioturn2c.dominio.ClienteEndereco;
import com.desafio.desafioturn2c.repositorio.ClienteEnderecoRepository;
import com.desafio.desafioturn2c.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class ClienteEnderecoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteEnderecoRepository clienteEnderecoRepository;

    @PostMapping
    public ResponseEntity<ClienteEndereco> post(@RequestBody ClienteEndereco endereco) {
        if (endereco != null) {
            clienteEnderecoRepository.save(endereco);
            return ResponseEntity.status(201).body(endereco);
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteEndereco>> getAll() {
        List<ClienteEndereco> enderecos = clienteEnderecoRepository.findAll();

        return enderecos.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(enderecos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEndereco> put(@PathVariable int id, @RequestBody ClienteEndereco enderecoAtualizado) {
        if (clienteEnderecoRepository.existsById(id)) {
            enderecoAtualizado.setId(id);
            clienteEnderecoRepository.save(enderecoAtualizado);
            return ResponseEntity.status(200).body(enderecoAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable int id) {
        if (clienteEnderecoRepository.existsById(id)) {
            clienteEnderecoRepository.deleteById(id);

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
