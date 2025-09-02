package dev.java.CadastroUsuarios.Agendamento;

import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    // Converte de DTO para Model
    public AppointmentModel toModel(AppointmentDTO dto) {
        AppointmentModel model = new AppointmentModel();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setAppointmentDate(dto.getAppointmentDate());
        model.setAppointmentTime(dto.getAppointmentTime());
        return model;
    }

    // Converte de Model para DTO
    public AppointmentDTO toDTO(AppointmentModel model) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setAppointmentDate(model.getAppointmentDate());
        dto.setAppointmentTime(model.getAppointmentTime());
        return dto;
    }
}