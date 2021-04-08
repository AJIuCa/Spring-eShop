package ru.geekbrains.service.users;

import org.springframework.data.domain.Page;
import ru.geekbrains.controller.DTO.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> showAllUsers();

    Optional<UserDTO> findById(long id);

    void save(UserDTO user);

    void delete(long id);

    Page<UserDTO> findWithFilter(String usernameFilter, Integer page, Integer tableSize, String sort);
}
