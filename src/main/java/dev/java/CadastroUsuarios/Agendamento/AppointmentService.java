package dev.java.CadastroUsuarios.Agendamento;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaService {

    private final AppointmentRepository appointmentRepository;
    private final AgendaMapper agendaMapper;

    public AgendaService(AppointmentRepository appointmentRepository, AgendaMapper agendaMapper) {
        this.appointmentRepository = appointmentRepository;
        this.agendaMapper = agendaMapper;
    }

    public List<AppointmentDTO> listarAgendas() {
        return appointmentRepository.findAll()
                .stream()
                .map(agendaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDTO buscarPorId(Long id) {
        return appointmentRepository.findById(id)
                .map(agendaMapper::toDTO)
                .orElse(null);
    }

    public AppointmentDTO criarAgenda(AppointmentDTO appointmentDTO) {
        AppointmentModel agenda = agendaMapper.toModel(appointmentDTO);
        agenda = appointmentRepository.save(agenda);
        return agendaMapper.toDTO(agenda);
    }

    public AppointmentDTO atualizarAgenda(Long id, AppointmentDTO appointmentDTO) {
        if (appointmentRepository.existsById(id)) {
            AppointmentModel agenda = agendaMapper.toModel(appointmentDTO);
            agenda.setId(id); // Garante que estamos atualizando a agenda correta
            agenda = appointmentRepository.save(agenda);
            return agendaMapper.toDTO(agenda);
        }
        return null; // Retorna nulo se não encontrar a agenda
    }

    public boolean deletarAgenda(Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}