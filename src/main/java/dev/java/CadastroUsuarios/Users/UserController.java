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
    public UserDTO addUser(@RequestBody UserDTO user){
        return userService.createUser(user);
    }
    // Mostrar todos os usuarios(LIST)
    @GetMapping("/ListUsers")
    public List<UserDTO> listarUsers(){
        return userService.listarUsers();
    }
    // Procurar Usuarios por ID(READ)
    @GetMapping("/ShowId/{id}")//path variable
    public UserDTO showById(@PathVariable Long id){
        return userService.listarUserById(id);
    }
    // Alterar dados dos usuarios(UPDATE)
    @PutMapping("/change/{id}")
    public UserDTO changeUserById(@PathVariable Long id, @RequestBody UserDTO userUpdated){
        return userService.updateUser(id, userUpdated);
    }
    // Deletar usuarios(DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}
