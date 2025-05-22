package dev.java.CadastroUsuarios.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
