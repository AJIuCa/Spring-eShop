package ru.geekbrains.service.role;

import ru.geekbrains.controller.DTO.RoleDTO;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<RoleDTO> showAllRoles();

    Optional<RoleDTO> findRoleById(Long id);

    void delete(Long id);

    void save(RoleDTO roleDTO);

}
