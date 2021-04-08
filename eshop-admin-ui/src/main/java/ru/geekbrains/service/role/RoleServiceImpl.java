package ru.geekbrains.service.role;

import ru.geekbrains.controller.DTO.RoleDTO;
import ru.geekbrains.persist.model.Role;
import ru.geekbrains.persist.model.User;
import ru.geekbrains.persist.repo.RoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoleServiceImpl implements  RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> showAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(RoleDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoleDTO> findRoleById(Long id) {
        return roleRepository.findById(id)
                .map(RoleDTO::new);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void save(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setTitle(roleDTO.getTitle());
        role.setUsers(roleDTO.getUsers());
        roleRepository.save(role);
    }
}
