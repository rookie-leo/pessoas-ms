package com.microservices.pessoa.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ddd;

    @Column(nullable = false)
    private String numero;

    /**
     * @deprecated uso exclusivo do hibernate
     * */
    @Deprecated
    public Telefone() {
    }

    public Telefone(Long id, String ddd, String numero) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(id, telefone.id) && Objects.equals(ddd, telefone.ddd) && Objects.equals(numero, telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ddd, numero);
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", ddd='" + ddd + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
