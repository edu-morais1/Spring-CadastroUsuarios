package dev.java.CadastroUsuarios.Agendamento;

import org.springframework.stereotype.Component;

@Component
public class AgendaMapper {

    // Converte de DTO para Model
    public AgendaModel toModel(AgendaDTO dto) {
        AgendaModel model = new AgendaModel();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setDescription(dto.getDescription());
        model.setAgendaDate(dto.getAgendaDate());
        model.setAgendaTime(dto.getAgendaTime());
        return model;
    }

    // Converte de Model para DTO
    public AgendaDTO toDTO(AgendaModel model) {
        AgendaDTO dto = new AgendaDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setDescription(model.getDescription());
        dto.setAgendaDate(model.getAgendaDate());
        dto.setAgendaTime(model.getAgendaTime());
        return dto;
    }
}