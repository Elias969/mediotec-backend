package com.seuprojeto.alunos.repository;

import com.seuprojeto.alunos.model.Conceito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConceitoRepository extends JpaRepository<Conceito, Long> {
}
