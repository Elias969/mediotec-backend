package com.seuprojeto.alunos.controller;

import com.seuprojeto.alunos.model.Coordenador;
import com.seuprojeto.alunos.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coordenadores")
@CrossOrigin(origins = "https://mediotec.netlify.app")
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    // Listar todos os coordenadores
    @GetMapping
    public List<Coordenador> listarCoordenadores() {
        return coordenadorService.listarTodos();
    }

    // Buscar coordenador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Coordenador> buscarCoordenadorPorId(@PathVariable Long id) {
        Optional<Coordenador> coordenador = coordenadorService.buscarPorId(id);
        return coordenador.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar novo coordenador
    @PostMapping
    public ResponseEntity<Coordenador> criarCoordenador(@RequestBody Coordenador coordenador) {
        Coordenador novoCoordenador = coordenadorService.salvar(coordenador);
        return ResponseEntity.ok(novoCoordenador);
    }

    // Atualizar coordenador existente
    @PutMapping("/{id}")
    public ResponseEntity<Coordenador> atualizarCoordenador(@PathVariable Long id, @RequestBody Coordenador coordenadorAtualizado) {
        return ResponseEntity.ok(coordenadorService.atualizar(id, coordenadorAtualizado));
    }

    // Excluir coordenador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCoordenador(@PathVariable Long id) {
        coordenadorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
