package dev.java.CadastroUsuarios.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Listar todos os meus users
    public List<UserModel> listarUsers(){
        return userRepository.findAll();
    }

    //Lista todos os mus users por ID
    public UserModel listarUserById(Long id) {
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.orElse(null);
    }
}
