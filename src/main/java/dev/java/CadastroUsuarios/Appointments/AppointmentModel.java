package dev.java.CadastroUsuarios.Appointments;


import dev.java.CadastroUsuarios.Users.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private String hour;
    private String description;

    //@OneToMany - um agendamento tem muitos usuarios
    @OneToMany(mappedBy = "appointment")
    private List<UserModel> users;


}
