package io.github.xNicolosox.spring_data.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    private String nome;

    public Cliente() {
    }


    public Cliente( Integer id,String nome) {
        this.nome = nome;
        this.id = id;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "nome= " + nome + '\'' +
                ", id= " + id;
    }
}
