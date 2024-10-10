package com.seuprojeto.alunos.model;

import jakarta.persistence.*;


@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String periodo;
    private String nomeProfessor; // Novo campo adicionado
    private Integer numerodealunos; // Novo campo adicionado

   

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public Integer getnumerodealunos() {
        return numerodealunos;
    }

    public void setumeroDealunos(Integer numerodealunos) {
        this.numerodealunos = numerodealunos;
    }


}
