package com.seuprojeto.alunos.service;

import com.seuprojeto.alunos.model.Comunicado;
import com.seuprojeto.alunos.repository.ComunicadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComunicadoService {

    @Autowired
    private ComunicadoRepository comunicadoRepository;

    // Método para obter todos os comunicados
    public List<Comunicado> getAllComunicados() {
        return comunicadoRepository.findAll();
    }

    // Método para criar ou atualizar um comunicado
    public Comunicado createComunicado(Comunicado comunicado) {
        return comunicadoRepository.save(comunicado);
    }

    // Buscar um comunicado por ID
    public Optional<Comunicado> getComunicadoById(Long id) {
        return comunicadoRepository.findById(id);
    }

    // Deletar um comunicado
    public void deleteComunicado(Long id) {
        comunicadoRepository.deleteById(id);
    }
}
