package dev.java.CadastroUsuarios.Users;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel map(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setNome(userDTO.getNome());
        userModel.setEmail(userDTO.getEmail());
        userModel.setImgUrl(userDTO.getImgUrl());
        userModel.setRank(userDTO.getRank());
        userModel.setIdade(userDTO.getIdade());
        userModel.setAgenda(userDTO.getAgenda());
        return userModel;
    }

    public UserDTO map(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(userModel.getNome());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setImgUrl(userModel.getImgUrl());
        userDTO.setRank(userModel.getRank());
        userDTO.setIdade(userModel.getIdade());
        userDTO.setAgenda(userModel.getAgenda());
        return userDTO;
    }
}
