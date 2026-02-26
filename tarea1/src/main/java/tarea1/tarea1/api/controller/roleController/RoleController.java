package tarea1.tarea1.api.controller.roleController;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tarea1.tarea1.logic.role.dto.response.RoleResponse;
import tarea1.tarea1.logic.role.service.RoleService;


import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PreAuthorize("hasAuthority('SUPER-ADMIN-ROLE')")
    @GetMapping
    public List<RoleResponse> findAll(){
        return roleService.findAll();
    }

}
