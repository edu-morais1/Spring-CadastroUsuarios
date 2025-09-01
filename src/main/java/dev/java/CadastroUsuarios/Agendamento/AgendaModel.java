package dev.java.CadastroUsuarios.Agendamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "tb_agenda")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AgendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "agenda_data")
    private LocalDate AgendaDate;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "Agenda_time")
    private LocalTime AgendaTime;

    private String description;

    //@OneToMany - um agendamento tem muitos usuarios
    @OneToMany(mappedBy = "agenda")
    @JsonIgnore
    private List<UserModel> users;

}
