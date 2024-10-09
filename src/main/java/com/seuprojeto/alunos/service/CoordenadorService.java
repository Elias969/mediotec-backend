package com.seuprojeto.alunos.service;

import com.seuprojeto.alunos.model.Coordenador;
import com.seuprojeto.alunos.repository.CoordenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    public List<Coordenador> listarTodos() {
        return coordenadorRepository.findAll();
    }

    public Optional<Coordenador> buscarPorId(Long id) {
        return coordenadorRepository.findById(id);
    }

    public Coordenador salvar(Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }

    public Coordenador atualizar(Long id, Coordenador coordenadorAtualizado) {
        return coordenadorRepository.findById(id).map(coordenador -> {
            coordenador.setNome(coordenadorAtualizado.getNome());
            coordenador.setCodigoCoordenador(coordenadorAtualizado.getCodigoCoordenador());
            coordenador.setNivelAcesso(coordenadorAtualizado.getNivelAcesso());
            coordenador.setTelefone(coordenadorAtualizado.getTelefone());
            coordenador.setEmail(coordenadorAtualizado.getEmail());
            coordenador.setStatus(coordenadorAtualizado.getStatus());
            coordenador.setEndereco(coordenadorAtualizado.getEndereco());
            coordenador.setDataContratacao(coordenadorAtualizado.getDataContratacao());
            return coordenadorRepository.save(coordenador);
        }).orElseThrow(() -> new RuntimeException("Coordenador não encontrado"));
    }

    public void excluir(Long id) {
        coordenadorRepository.deleteById(id);
    }
}
