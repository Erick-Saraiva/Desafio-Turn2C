package com.desafio.desafioturn2c.dominio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
@Entity
@Table(name = "Cliente_Endereco")
public class ClienteEndereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    @NotBlank
    @Size(min = 3)
    private String bairro;
    @NotBlank
    private String logradouro;
    @NotNull
    private Integer cep;
    @NotNull
    private Integer numero;
    @NotBlank
    @Size(min = 3)
    private String cidade;
    @NotBlank
    private String uf;

    public ClienteEndereco(Integer id, Cliente cliente, String bairro,
                           String logradouro, Integer cep, int numero, String cidade, String uf) {
        this.id = id;
        this.cliente = cliente;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }

    public ClienteEndereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "ClienteEndereco: " +
                "Id: " + id +
                "Cliente: " + cliente +
                "Bairro: " + bairro + '\'' +
                "Logradouro: " + logradouro + '\'' +
                "Cep: " + cep +
                "Número: " + numero +
                "Cidade: " + cidade + '\'' +
                "Uf: " + uf + '\'';
    }
}
