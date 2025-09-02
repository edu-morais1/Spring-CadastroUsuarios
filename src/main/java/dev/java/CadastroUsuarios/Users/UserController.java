package dev.java.CadastroUsuarios.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Bem-vindo ao sistema de cadastro de usuários!";
    }

    // Adicionar Usuarios(CREATE)
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserDTO user){
        UserDTO newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário " + newUser.getName() + " com o id" + newUser.getId() + " criado com sucesso!");
    }
    // Mostrar todos os usuarios(LIST)
    @GetMapping("/ListUsers")
    public ResponseEntity<List<UserDTO>> listarUsers(){
        List<UserDTO> users =userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    // Procurar Usuarios por ID(READ)
    @GetMapping("/ShowId/{id}")//path variable
    public ResponseEntity<?> showById(@PathVariable Long id){
        UserDTO user = userService.getUserById(id);

        if (user != null){
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com o id " + id + " não encontrado.");
        }
    }
    // Alterar dados dos usuarios(UPDATE)
    @PutMapping("/change/{id}")
    public ResponseEntity<?> changeUserById(@PathVariable Long id, @RequestBody UserDTO userUpdated){
        UserDTO user = userService.updateUser(id, userUpdated);
        if (user != null){
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com o id " + id + " não encontrado.");
        }
    }
    // Deletar usuarios(DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
         if (userService.getUserById(id) != null){
             userService.deleteUserById(id);
             return ResponseEntity.status(HttpStatus.OK)
                     .body("Usuário com o id " + id + " deletado com sucesso!");
         } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("Usuário com o id " + id + " não encontrado.");
         }
    }
}
