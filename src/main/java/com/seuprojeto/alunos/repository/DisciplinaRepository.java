package com.seuprojeto.alunos.repository;

import com.seuprojeto.alunos.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
