package dev.java.CadastroUsuarios.Agendamento;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentWebController {

    private final AppointmentService appointmentService;

    public AppointmentWebController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public String showAppointmentList(Model model) {
        model.addAttribute("agendas", appointmentService.getAllAppointments());
        return "agenda/list-agendas"; // -> templates/agendas/list-agendas.html
    }

    @GetMapping("/new")
    public String showAppointmentCreate(Model model) {
        model.addAttribute("agenda", new AppointmentDTO());
        return "agenda/form-agenda"; // -> templates/agendas/form-agenda.html
    }

    @PostMapping("/save")
    public String saveAppointment(@ModelAttribute("agenda") AppointmentDTO appointmentDTO) {
        if (appointmentDTO.getId() == null) {
            appointmentService.createAppointment(appointmentDTO);
        } else {
            appointmentService.updateAppointment(appointmentDTO.getId(), appointmentDTO);
        }
        return "redirect:/appointments";
    }

    @GetMapping("/edit/{id}")
    public String showFormularioEdicao(@PathVariable Long id, Model model) {
        model.addAttribute("agenda", appointmentService.getAppointmentById(id));
        return "agenda/form-agenda";
    }

    @GetMapping("/delete/{id}")
    public String deletarAgenda(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}