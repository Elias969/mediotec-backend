package com.seuprojeto.alunos.controller;

import com.seuprojeto.alunos.model.Conceito;
import com.seuprojeto.alunos.service.ConceitoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://mediotec.netlify.app")
@RequestMapping("/api/conceitos")
public class ConceitoController {

    private final ConceitoService conceitoService;

    public ConceitoController(ConceitoService conceitoService) {
        this.conceitoService = conceitoService;
    }

    // Método POST para criar um novo conceito
    @PostMapping
    public ResponseEntity<Conceito> create(@RequestBody Conceito conceito) {
        // Validação do campo aluno
        if (conceito.getAluno() == null || conceito.getAluno().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        
        Conceito novoConceito = conceitoService.save(conceito);

        // Retorna 201 Created com o URI do novo recurso
        return ResponseEntity
                .created(URI.create("/api/conceitos/" + novoConceito.getId()))
                .body(novoConceito);
    }

    // Método GET para buscar todos os conceitos
    @GetMapping
    public List<Conceito> getAll() {
        return conceitoService.findAll();
    }

    // Método GET para buscar um conceito pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Conceito> getById(@PathVariable Long id) {
        Optional<Conceito> conceito = conceitoService.findById(id);
        return conceito.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método PUT para atualizar um conceito existente
    @PutMapping("/{id}")
    public ResponseEntity<Conceito> update(@PathVariable Long id, @RequestBody Conceito conceito) {
        return ResponseEntity.ok(conceitoService.update(id, conceito));
    }

    // Método DELETE para deletar um conceito pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        conceitoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
