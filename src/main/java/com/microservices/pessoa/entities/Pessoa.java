package com.microservices.pessoa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobreNome;

    @CPF
    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private Date dataNascimento;

    @OneToOne
    private Endereco endereco;

    @Email
    private String email;

    @OneToMany
    private List<Telefone> telefones;

    /**
     * @deprecated uso exclusivo do hibernate
     * */
    @Deprecated
    public Pessoa() {}

    public Pessoa(String nome, String sobreNome, String cpf, Date dataNascimento, Endereco endereco, String email, List<Telefone> telefones) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(sobreNome, pessoa.sobreNome) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(dataNascimento, pessoa.dataNascimento) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(email, pessoa.email) && Objects.equals(telefones, pessoa.telefones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobreNome, cpf, dataNascimento, endereco, email, telefones);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco=" + endereco +
                ", email='" + email + '\'' +
                ", telefones=" + telefones +
                '}';
    }
}
