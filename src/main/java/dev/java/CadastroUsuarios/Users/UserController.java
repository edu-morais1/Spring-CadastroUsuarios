package dev.java.CadastroUsuarios.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
    public UserModel addUser(@RequestBody UserModel user){
        return userService.createUser(user);
    }
    // Mostrar todos os usuarios(LIST)
    @GetMapping("/ListUsers")
    public List<UserModel> listarUsers(){
        return userService.listarUsers();
    }
    // Procurar Usuarios por ID(READ)
    @GetMapping("/ShowId/{id}")//path variable
    public UserModel showById(@PathVariable Long id){
        return userService.listarUserById(id);
    }
    // Alterar dados dos usuarios(UPDATE)
    @PutMapping("/ChangeById")
    public String changeById(){
        return "Dados alterados com sucesso!";
    }
    // Deletar usuarios(DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}
