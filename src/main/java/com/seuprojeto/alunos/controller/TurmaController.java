package com.seuprojeto.alunos.controller;

import com.seuprojeto.alunos.model.Turma;
import com.seuprojeto.alunos.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<Turma> listarTurmas() {
        return turmaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarTurmaPorId(@PathVariable Long id) {
        Optional<Turma> turma = turmaService.buscarPorId(id);
        return turma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Turma> criarTurma(@RequestBody Turma turma) {
        Turma novaTurma = turmaService.salvar(turma);
        return ResponseEntity.ok(novaTurma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable Long id, @RequestBody Turma turma) {
        Optional<Turma> turmaExistente = turmaService.buscarPorId(id);
        if (turmaExistente.isPresent()) {
            turma.setId(id); // Certifique-se de que o ID está correto
            Turma turmaAtualizada = turmaService.salvar(turma);
            return ResponseEntity.ok(turmaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Long id) {
        if (turmaService.deletarPorId(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
