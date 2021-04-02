package ru.geekbrains.controller.DTO.role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<RoleDTO> showAllRoles();

    Optional<RoleDTO> findRoleById(Long id);

    void delete(Long id);

    void save(RoleDTO roleDTO);

}
