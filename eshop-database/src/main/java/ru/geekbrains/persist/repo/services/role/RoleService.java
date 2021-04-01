package ru.geekbrains.persist.repo.services.role;

import ru.geekbrains.persist.repo.services.category.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<RoleDTO> showAllRoles();

    Optional<RoleDTO> findRoleById(Long id);

    void delete(Long id);

    void save(RoleDTO roleDTO);

}
