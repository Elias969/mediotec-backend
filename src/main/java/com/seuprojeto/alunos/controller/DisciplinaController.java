package com.seuprojeto.alunos.controller;

import com.seuprojeto.alunos.model.Disciplina;
import com.seuprojeto.alunos.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://mediotec.netlify.app")
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> listarDisciplinas() {
        return disciplinaService.listarDisciplinas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarDisciplinaPorId(@PathVariable Long id) {
        Optional<Disciplina> disciplina = disciplinaService.buscarDisciplinaPorId(id);
        return disciplina.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Disciplina> criarDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina novaDisciplina = disciplinaService.salvarDisciplina(disciplina);
        return ResponseEntity.ok(novaDisciplina);
    }

    // Atualizar Disciplina
    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplinaAtualizada) {
        Optional<Disciplina> disciplinaExistente = disciplinaService.buscarDisciplinaPorId(id);
        if (disciplinaExistente.isPresent()) {
            Disciplina disciplina = disciplinaExistente.get();
            disciplina.setNome(disciplinaAtualizada.getNome());  // Exemplo de atualização
            // Adicione mais campos conforme necessário
            Disciplina disciplinaSalva = disciplinaService.salvarDisciplina(disciplina);
            return ResponseEntity.ok(disciplinaSalva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar Disciplina
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDisciplina(@PathVariable Long id) {
        Optional<Disciplina> disciplinaExistente = disciplinaService.buscarDisciplinaPorId(id);
        if (disciplinaExistente.isPresent()) {
            disciplinaService.deletarDisciplina(id);
            return ResponseEntity.noContent().build();  // Retorna status 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
