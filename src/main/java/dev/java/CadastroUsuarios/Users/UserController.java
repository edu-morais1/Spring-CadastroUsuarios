package dev.java.CadastroUsuarios.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Bem-vindo ao sistema de cadastro de usuários!";
    }

    // Adicionar Usuarios(CREATE)
    @PostMapping("/add")
    public String addUser(){
        return "Usuario adicionado com sucesso!";
    }
    // Procurar Usuarios por ID(READ)
    @GetMapping("/ShowId")
    public String showId(){
        return "Usuario encontrado com sucesso!";
    }
    // Alterar dados dos usuarios(UPDATE)
    @PutMapping("/ChangeById")
    public String changeById(){
        return "Dados alterados com sucesso!";
    }
    // Deletar usuarios(DELETE)
    @DeleteMapping("/DeleteId")
    public String deleteById(){
        return "Usuario deletado com sucesso!";
    }
    // Mostrar todos os usuarios(LIST)
    @GetMapping("/ListUsers")
    public List<UserModel> listarUsers(){
        return userService.listarUsers();
    }
}
