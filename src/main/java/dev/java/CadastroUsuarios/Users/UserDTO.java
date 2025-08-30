package dev.java.CadastroUsuarios.Users;
import dev.java.CadastroUsuarios.Agendamento.AgendaModel;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private String rank;
    private AgendaModel agenda;

}
