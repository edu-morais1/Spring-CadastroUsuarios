package dev.java.CadastroUsuarios.Appointments;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentCrontroller {

    // GET -- Mandar uma requisisao para alterar as mmissoes
    @GetMapping("/show")
    public String showAppointment(){
        return "Appointment found successfully!";
    }
    //Post -- Mandar uma requisicao para criar uma missao
    @PostMapping("/create")
    public String createAppointment(){
        return "Appointment created successfully!";
    }
    //PUT -- Mandar uma requisicao para alterar uma missao
    @PutMapping("/alter")
    public String alterAppointment(){
        return "Appointment altered successfully!";
    }
    //Delete -- Mandar uma requisicao para deletar uma missao
    @DeleteMapping("/delete")
    public String deleteAppointment(){
        return "Appointment deleted successfully!";
    }

}
