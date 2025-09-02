package dev.java.CadastroUsuarios.Agendamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java.CadastroUsuarios.Users.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    @JsonIgnore
    private List<UserModel> users;

}
