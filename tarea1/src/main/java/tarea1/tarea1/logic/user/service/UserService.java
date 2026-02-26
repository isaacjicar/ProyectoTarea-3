package tarea1.tarea1.logic.user.service;




import tarea1.tarea1.logic.user.dto.response.UserResponse;

import java.util.List;


public interface UserService {
    List<UserResponse> findAll();
    UserResponse findById (Long id);
    UserResponse findByEmail(String email);
}

