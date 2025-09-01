package dev.java.CadastroUsuarios.Agendamento;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/agendas")
public class AgendaControllerUI {

    private final AgendaService agendaService;

    public AgendaControllerUI(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public String listarAgendas(Model model) {
        model.addAttribute("agendas", agendaService.listarAgendas());
        return "agenda/list-agendas"; // -> templates/agendas/list-agendas.html
    }

    @GetMapping("/new")
    public String showFormularioCriacao(Model model) {
        model.addAttribute("agenda", new AgendaDTO());
        return "agenda/form-agenda"; // -> templates/agendas/form-agenda.html
    }

    @PostMapping("/save")
    public String salvarAgenda(@ModelAttribute("agenda") AgendaDTO agendaDTO) {
        if (agendaDTO.getId() == null) {
            agendaService.criarAgenda(agendaDTO);
        } else {
            agendaService.atualizarAgenda(agendaDTO.getId(), agendaDTO);
        }
        return "redirect:/web/agendas";
    }

    @GetMapping("/edit/{id}")
    public String showFormularioEdicao(@PathVariable Long id, Model model) {
        model.addAttribute("agenda", agendaService.buscarPorId(id));
        return "agenda/form-agenda";
    }

    @GetMapping("/delete/{id}")
    public String deletarAgenda(@PathVariable Long id) {
        agendaService.deletarAgenda(id);
        return "redirect:/web/agendas";
    }
}