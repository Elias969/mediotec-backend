package com.seuprojeto.alunos.service;

import com.seuprojeto.alunos.model.Conceito;
import com.seuprojeto.alunos.repository.ConceitoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConceitoService {

    private final ConceitoRepository conceitoRepository;

    public ConceitoService(ConceitoRepository conceitoRepository) {
        this.conceitoRepository = conceitoRepository;
    }

    // Salvar um novo conceito
    public Conceito save(Conceito conceito) {
        // Verifica se o campo aluno não está nulo ou vazio
        if (conceito.getAluno() == null || conceito.getAluno().isEmpty()) {
            throw new IllegalArgumentException("O campo 'aluno' não pode ser nulo ou vazio.");
        }
        
        return conceitoRepository.save(conceito);
    }

    // Encontrar todos os conceitos
    public List<Conceito> findAll() {
        return conceitoRepository.findAll();
    }

    // Encontrar um conceito por ID
    public Optional<Conceito> findById(Long id) {
        return conceitoRepository.findById(id);
    }

    // Atualizar um conceito existente
    public Conceito update(Long id, Conceito conceito) {
        // Verifica se o conceito existe
        if (!conceitoRepository.existsById(id)) {
            throw new EntityNotFoundException("Conceito não encontrado com o ID: " + id);
        }
        // Atualiza os dados do conceito
        conceito.setId(id);
        return conceitoRepository.save(conceito);
    }

    // Deletar um conceito
    public void delete(Long id) {
        // Verifica se o conceito existe antes de deletar
        if (!conceitoRepository.existsById(id)) {
            throw new EntityNotFoundException("Conceito não encontrado com o ID: " + id);
        }
        conceitoRepository.deleteById(id);
    }
}
