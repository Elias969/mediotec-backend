package com.seuprojeto.alunos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String periodo;
    private String nomeProfessor; // Novo campo adicionado
    private int numeroDeAlunos; // Novo campo adicionado

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Aluno> alunos;

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

    public int getNumeroDeAlunos() {
        return numeroDeAlunos;
    }

    public void setNumeroDeAlunos(int numeroDeAlunos) {
        this.numeroDeAlunos = numeroDeAlunos;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
