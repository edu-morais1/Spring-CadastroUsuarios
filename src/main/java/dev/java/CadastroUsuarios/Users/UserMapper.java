package dev.java.CadastroUsuarios.Users;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel map(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setImgUrl(userDTO.getImgUrl());
        userModel.setRank(userDTO.getRank());
        userModel.setAge(userDTO.getAge());
        userModel.setAppointment(userDTO.getAppointment());
        return userModel;
    }

    public UserDTO map(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setImgUrl(userModel.getImgUrl());
        userDTO.setRank(userModel.getRank());
        userDTO.setAge(userModel.getAge());
        userDTO.setAppointment(userModel.getAppointment());
        return userDTO;
    }
}
