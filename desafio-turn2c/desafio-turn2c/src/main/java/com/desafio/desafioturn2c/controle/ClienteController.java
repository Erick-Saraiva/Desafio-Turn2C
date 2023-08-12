package com.desafio.desafioturn2c.controle;

import com.desafio.desafioturn2c.dominio.Cliente;
import com.desafio.desafioturn2c.repositorio.ClienteEnderecoRepository;
import com.desafio.desafioturn2c.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteEnderecoRepository clienteEnderecoRepository;

    @PostMapping
    public ResponseEntity<Cliente> post(@RequestBody Cliente novoCliente) {
        if (novoCliente != null) {
            clienteRepository.save(novoCliente);
            return ResponseEntity.status(201).body(novoCliente);
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> put(@PathVariable int id, @RequestBody Cliente clienteAtualizado) {
        if (clienteRepository.existsById(id)) {
            clienteAtualizado.setId(id);
            clienteRepository.save(clienteAtualizado);
            return ResponseEntity.status(200).body(clienteAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable int id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
