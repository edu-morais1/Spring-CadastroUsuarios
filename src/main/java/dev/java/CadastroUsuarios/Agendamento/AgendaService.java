package dev.java.CadastroUsuarios.Agendamento;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final AgendaMapper agendaMapper;

    public AgendaService(AgendaRepository agendaRepository, AgendaMapper agendaMapper) {
        this.agendaRepository = agendaRepository;
        this.agendaMapper = agendaMapper;
    }

    public List<AgendaDTO> listarAgendas() {
        return agendaRepository.findAll()
                .stream()
                .map(agendaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AgendaDTO buscarPorId(Long id) {
        return agendaRepository.findById(id)
                .map(agendaMapper::toDTO)
                .orElse(null);
    }

    public AgendaDTO criarAgenda(AgendaDTO agendaDTO) {
        AgendaModel agenda = agendaMapper.toModel(agendaDTO);
        agenda = agendaRepository.save(agenda);
        return agendaMapper.toDTO(agenda);
    }

    public AgendaDTO atualizarAgenda(Long id, AgendaDTO agendaDTO) {
        if (agendaRepository.existsById(id)) {
            AgendaModel agenda = agendaMapper.toModel(agendaDTO);
            agenda.setId(id); // Garante que estamos atualizando a agenda correta
            agenda = agendaRepository.save(agenda);
            return agendaMapper.toDTO(agenda);
        }
        return null; // Retorna nulo se não encontrar a agenda
    }

    public boolean deletarAgenda(Long id) {
        if (agendaRepository.existsById(id)) {
            agendaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}