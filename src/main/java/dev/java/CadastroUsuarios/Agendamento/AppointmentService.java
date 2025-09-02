package dev.java.CadastroUsuarios.Agendamento;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .map(appointmentMapper::toDTO)
                .orElse(null);
    }

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        AppointmentModel agenda = appointmentMapper.toModel(appointmentDTO);
        agenda = appointmentRepository.save(agenda);
        return appointmentMapper.toDTO(agenda);
    }

    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        if (appointmentRepository.existsById(id)) {
            AppointmentModel agenda = appointmentMapper.toModel(appointmentDTO);
            agenda.setId(id); // Garante que estamos atualizando a agenda correta
            agenda = appointmentRepository.save(agenda);
            return appointmentMapper.toDTO(agenda);
        }
        return null; // Retorna nulo se não encontrar a agenda
    }

    public boolean deleteAppointment(Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}