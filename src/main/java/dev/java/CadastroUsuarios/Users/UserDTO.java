package dev.java.CadastroUsuarios.Users;
import dev.java.CadastroUsuarios.Agendamento.AppointmentModel;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;
    private String name;
    private String email;
    private String imgUrl;
    private int age;
    private String rank;
    private AppointmentModel appointment;

}
