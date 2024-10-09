package com.seuprojeto.alunos.controller;

import com.seuprojeto.alunos.model.Comunicado;
import com.seuprojeto.alunos.service.ComunicadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/comunicados")
public class ComunicadoController {

    @Autowired
    private ComunicadoService comunicadoService;

    // Endpoint para obter todos os comunicados
    @GetMapping
    public List<Comunicado> getComunicados() {
        return comunicadoService.getAllComunicados();
    }

    // Endpoint para cadastrar um novo comunicado
    @PostMapping
    public ResponseEntity<Comunicado> createComunicado(@RequestBody Comunicado comunicado) {
        Comunicado newComunicado = comunicadoService.createComunicado(comunicado);
        return ResponseEntity.ok(newComunicado);
    }
}
