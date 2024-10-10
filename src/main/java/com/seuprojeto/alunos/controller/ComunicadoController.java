package com.seuprojeto.alunos.controller;

import com.seuprojeto.alunos.model.Comunicado;
import com.seuprojeto.alunos.service.ComunicadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://mediotec.netlify.app")
@RequestMapping("/api/comunicados")
public class ComunicadoController {

    @Autowired
    private ComunicadoService comunicadoService;

    @GetMapping
    public List<Comunicado> getComunicados() {
        return comunicadoService.getAllComunicados();
    }

    @PostMapping
    public ResponseEntity<Comunicado> createComunicado(@RequestBody Comunicado comunicado) {
        Comunicado newComunicado = comunicadoService.createComunicado(comunicado);
        return ResponseEntity.ok(newComunicado);
    }

    // Atualizar Comunicado
    @PutMapping("/{id}")
    public ResponseEntity<Comunicado> atualizarComunicado(@PathVariable Long id, @RequestBody Comunicado comunicadoAtualizado) {
        Optional<Comunicado> comunicadoExistente = comunicadoService.getComunicadoById(id);
        if (comunicadoExistente.isPresent()) {
            Comunicado comunicado = comunicadoExistente.get();
            comunicado.setTitulo(comunicadoAtualizado.getTitulo());  // Exemplo de atualização
            // Adicione mais campos conforme necessário
            Comunicado comunicadoSalvo = comunicadoService.createComunicado(comunicado);
            return ResponseEntity.ok(comunicadoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar Comunicado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComunicado(@PathVariable Long id) {
        Optional<Comunicado> comunicadoExistente = comunicadoService.getComunicadoById(id);
        if (comunicadoExistente.isPresent()) {
            comunicadoService.deleteComunicado(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
