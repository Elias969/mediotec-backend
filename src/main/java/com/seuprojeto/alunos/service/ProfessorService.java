package com.seuprojeto.alunos.service;

import com.seuprojeto.alunos.model.Professor;
import com.seuprojeto.alunos.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    // Listar todos os professores
    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    // Buscar professor por ID
    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    // Salvar um novo professor
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    // Deletar professor por ID
    public void deletarPorId(Long id) {
        professorRepository.deleteById(id);
    }
}
