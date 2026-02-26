package tarea1.tarea1.logic.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tarea1.tarea1.logic.user.dto.response.UserResponse;
import tarea1.tarea1.logic.user.mapper.UserMapper;
import tarea1.tarea1.logic.user.repository.UserRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream().map(userMapper::toResponse).toList();
    }

    @Override
    public UserResponse findById(Long id) {
        return userRepository.findById(id).map(userMapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Producto no existe con el id" + id));
    }

    @Override
    public UserResponse findByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("No existe un usuario con el correo dijitado"));
    }
}
