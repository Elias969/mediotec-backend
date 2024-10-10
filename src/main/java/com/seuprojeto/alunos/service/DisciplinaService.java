package com.seuprojeto.alunos.service;

import com.seuprojeto.alunos.model.Disciplina;
import com.seuprojeto.alunos.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    // Listar todas as disciplinas
    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    // Buscar uma disciplina por ID
    public Optional<Disciplina> buscarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    // Criar ou atualizar uma disciplina
    public Disciplina salvarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    // Deletar uma disciplina
    public void deletarDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
