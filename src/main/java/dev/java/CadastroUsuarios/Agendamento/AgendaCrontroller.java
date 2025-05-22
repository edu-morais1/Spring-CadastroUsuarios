package dev.java.CadastroUsuarios.Agendamento;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Agenda")
public class AgendaCrontroller {

    // GET -- Mandar uma requisisao para alterar as mmissoes
    @GetMapping("/show")
    public String showAgenda(){
        return "Agenda found successfully!";
    }
    //Post -- Mandar uma requisicao para criar uma missao
    @PostMapping("/create")
    public String createAgenda(){
        return "Agenda created successfully!";
    }
    //PUT -- Mandar uma requisicao para alterar uma missao
    @PutMapping("/alter")
    public String alterAgenda(){
        return "Agenda altered successfully!";
    }
    //Delete -- Mandar uma requisicao para deletar uma missao
    @DeleteMapping("/delete")
    public String deleteAgenda(){
        return "Agenda deleted successfully!";
    }

}
