package dev.java.CadastroUsuarios.Agendamento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas") // Alterado para /api/agendas para diferenciar da UI
public class AgendaController {

    private final AppointmentService appointmentService;

    public AgendaController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> listarTodas() {
        List<AppointmentDTO> agendas = appointmentService.listarAgendas();
        return ResponseEntity.ok(agendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> buscarPorId(@PathVariable Long id) {
        AppointmentDTO agenda = appointmentService.buscarPorId(id);
        if (agenda != null) {
            return ResponseEntity.ok(agenda);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> criar(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO novaAgenda = appointmentService.criarAgenda(appointmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAgenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> atualizar(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO agendaAtualizada = appointmentService.atualizarAgenda(id, appointmentDTO);
        if (agendaAtualizada != null) {
            return ResponseEntity.ok(agendaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (appointmentService.deletarAgenda(id)) {
            return ResponseEntity.noContent().build(); // Sucesso, sem conteúdo para retornar
        }
        return ResponseEntity.notFound().build();
    }
}