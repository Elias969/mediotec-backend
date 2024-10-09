package com.seuprojeto.alunos.controller;

import com.seuprojeto.alunos.model.Aluno;
import com.seuprojeto.alunos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoService.buscarPorId(id);
        return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aluno> adicionar(@RequestBody Aluno aluno) {
        try {
            Aluno novoAluno = alunoService.salvar(aluno);
            return ResponseEntity.status(201).body(novoAluno);
        } catch (Exception e) {
            e.printStackTrace(); 
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Optional<Aluno> alunoExistente = alunoService.buscarPorId(id);
        if (alunoExistente.isPresent()) {
            alunoAtualizado.setId(id);
            Aluno aluno = alunoService.salvar(alunoAtualizado);
            return ResponseEntity.ok(aluno);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (alunoService.buscarPorId(id).isPresent()) {
            alunoService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
