package dev.java.CadastroUsuarios.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AppointmentModel, Long> {

}
