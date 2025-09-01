package dev.java.CadastroUsuarios.Users;

import dev.java.CadastroUsuarios.Agendamento.AgendaModel;
import dev.java.CadastroUsuarios.Agendamento.AgendaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users/ui")
public class UserControllerUI {

    private final UserService userService;
    private final AgendaRepository agendaRepository;

    public UserControllerUI(UserService userService, AgendaRepository agendaRepository) {
        this.userService = userService;
        this.agendaRepository = agendaRepository;
    }
    //Localhost:8080/users/ui/listarUsers
    @GetMapping("/listarUsers")
    public String listarUsers(Model model){
        List<UserDTO> users = userService.listarUsers();
        model.addAttribute("users", users);
        return "users/listarUsers"; // Nome do arquivo list-users.html
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        List<AgendaModel> agendas = agendaRepository.findAll();
        model.addAttribute("user", new UserDTO()); // Objeto para o formulário preencher
        model.addAttribute("allAgendas", agendas); // Lista de agendas para o <select>
        return "users/add-user"; // Nome do arquivo add-user.html
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") UserDTO user) {
        userService.createUser(user);
        return "redirect:/users/ui/listarUsers"; // Redireciona para a lista de usuários após salvar
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        UserDTO user = userService.listarUserById(id);
        List<AgendaModel> agendas = agendaRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("allAgendas", agendas); // Lista de agendas para o <select>
        return "users/edit-users"; // Nome do arquivo edit-user.html
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") UserDTO user) {
        userService.updateUser(id, user);
        return "redirect:/users/ui/listarUsers"; // Redireciona para a lista de usuários após atualizar
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users/ui/listarUsers"; // Redireciona para a lista de usuários após deletar
    }
}
