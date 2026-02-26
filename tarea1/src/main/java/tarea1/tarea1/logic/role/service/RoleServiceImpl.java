package tarea1.tarea1.logic.role.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tarea1.tarea1.logic.role.dto.response.RoleResponse;
import tarea1.tarea1.logic.role.mapper.RoleMapper;
import tarea1.tarea1.logic.role.repository.RoleRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;


    @Override
    public List<RoleResponse> findAll() {
        return roleRepository.findAll().stream().map(roleMapper::toResponse).toList();
    }
}
