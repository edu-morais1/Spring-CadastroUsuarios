package dev.java.CadastroUsuarios.Users;
import dev.java.CadastroUsuarios.Appointments.AppointmentModel;
import jakarta.persistence.*;
import java.util.List;
import dev.java.CadastroUsuarios.Appointments.AppointmentModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    //@ManyToOne um usuario tem um unico agendamento
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private AppointmentModel appointment;

}
