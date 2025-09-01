package dev.java.CadastroUsuarios.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //Listar todos os meus users
    public List<UserDTO> listarUsers(){
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    //Lista todos os mus users por ID
    public UserDTO listarUserById(Long id) {
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.map(userMapper::map).orElse(null);
    }

    //Criar um novo Usuario
    public UserDTO createUser(UserDTO userDTO) {
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<UserModel> userExisting = userRepository.findById(id);
        if (userExisting.isPresent()) {
            UserModel userUpdated = userMapper.map(userDTO);
            userUpdated.setId(id);
            UserModel userSaved = userRepository.save(userUpdated);
            return userMapper.map(userSaved);
        }
        return null;
    }
}
