package dev.java.CadastroUsuarios.Agendamento;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/agendas")
public class AgendaControllerUI {

    private final AppointmentService appointmentService;

    public AgendaControllerUI(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public String listarAgendas(Model model) {
        model.addAttribute("agendas", appointmentService.listarAgendas());
        return "agenda/list-agendas"; // -> templates/agendas/list-agendas.html
    }

    @GetMapping("/new")
    public String showFormularioCriacao(Model model) {
        model.addAttribute("agenda", new AppointmentDTO());
        return "agenda/form-agenda"; // -> templates/agendas/form-agenda.html
    }

    @PostMapping("/save")
    public String salvarAgenda(@ModelAttribute("agenda") AppointmentDTO appointmentDTO) {
        if (appointmentDTO.getId() == null) {
            appointmentService.criarAgenda(appointmentDTO);
        } else {
            appointmentService.atualizarAgenda(appointmentDTO.getId(), appointmentDTO);
        }
        return "redirect:/web/agendas";
    }

    @GetMapping("/edit/{id}")
    public String showFormularioEdicao(@PathVariable Long id, Model model) {
        model.addAttribute("agenda", appointmentService.buscarPorId(id));
        return "agenda/form-agenda";
    }

    @GetMapping("/delete/{id}")
    public String deletarAgenda(@PathVariable Long id) {
        appointmentService.deletarAgenda(id);
        return "redirect:/web/agendas";
    }
}