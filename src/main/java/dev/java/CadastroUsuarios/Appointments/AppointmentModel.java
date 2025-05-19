package dev.java.CadastroUsuarios.Appointments;

import dev.java.CadastroUsuarios.Users.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalTime;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "appointment_time")
    private LocalTime appointmentTime;

    private String description;

    //@OneToMany - um agendamento tem muitos usuarios
    @OneToMany(mappedBy = "appointment")
    private List<UserModel> users;


}
