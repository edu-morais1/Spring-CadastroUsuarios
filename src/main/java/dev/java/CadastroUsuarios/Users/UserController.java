package dev.java.CadastroUsuarios.Users;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {
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
    // 
}
