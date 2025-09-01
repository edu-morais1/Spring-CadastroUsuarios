package dev.java.CadastroUsuarios.Agendamento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas") // Alterado para /api/agendas para diferenciar da UI
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public ResponseEntity<List<AgendaDTO>> listarTodas() {
        List<AgendaDTO> agendas = agendaService.listarAgendas();
        return ResponseEntity.ok(agendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaDTO> buscarPorId(@PathVariable Long id) {
        AgendaDTO agenda = agendaService.buscarPorId(id);
        if (agenda != null) {
            return ResponseEntity.ok(agenda);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AgendaDTO> criar(@RequestBody AgendaDTO agendaDTO) {
        AgendaDTO novaAgenda = agendaService.criarAgenda(agendaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAgenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendaDTO> atualizar(@PathVariable Long id, @RequestBody AgendaDTO agendaDTO) {
        AgendaDTO agendaAtualizada = agendaService.atualizarAgenda(id, agendaDTO);
        if (agendaAtualizada != null) {
            return ResponseEntity.ok(agendaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (agendaService.deletarAgenda(id)) {
            return ResponseEntity.noContent().build(); // Sucesso, sem conteúdo para retornar
        }
        return ResponseEntity.notFound().build();
    }
}