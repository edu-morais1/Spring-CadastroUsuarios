package dev.java.CadastroUsuarios.Users;

import dev.java.CadastroUsuarios.Agendamento.AppointmentModel;
import dev.java.CadastroUsuarios.Agendamento.AppointmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserWebController {

    private final UserService userService;
    private final AppointmentRepository appointmentRepository;

    public UserWebController(UserService userService, AppointmentRepository appointmentRepository) {
        this.userService = userService;
        this.appointmentRepository = appointmentRepository;
    }
    //Localhost:8080/users/ui/listarUsers
    @GetMapping//("/showUserList")
    public String showUserList(Model model){
        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/listarUsers"; // Nome do arquivo list-users.html
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        List<AppointmentModel> agendas = appointmentRepository.findAll();
        model.addAttribute("user", new UserDTO()); // Objeto para o formulário preencher
        model.addAttribute("allAgendas", agendas); // Lista de agendas para o <select>
        return "users/add-user"; // Nome do arquivo add-user.html
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") UserDTO user) {
        userService.createUser(user);
        return "redirect:/users"; // Redireciona para a lista de usuários após salvar
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        UserDTO user = userService.getUserById(id);
        List<AppointmentModel> agendas = appointmentRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("allAgendas", agendas); // Lista de agendas para o <select>
        return "users/edit-users"; // Nome do arquivo edit-user.html
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") UserDTO user) {
        userService.updateUser(id, user);
        return "redirect:/users"; // Redireciona para a lista de usuários após atualizar
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users"; // Redireciona para a lista de usuários após deletar
    }
}
