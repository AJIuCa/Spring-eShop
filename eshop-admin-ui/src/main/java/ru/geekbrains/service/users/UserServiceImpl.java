package ru.geekbrains.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.controller.DTO.UserDTO;
import ru.geekbrains.persist.model.User;
import ru.geekbrains.persist.repo.UserRepository;
import ru.geekbrains.persist.repo.specification.UserSpecification;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> showAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(long id) {
        return userRepository.findById(id)
                .map(UserDTO::new);
    }

    @Override
    public void save(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setLogin(userDTO.getLogin());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(userDTO.getRoles());
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<UserDTO> findWithFilter(String userLoginFilter,
                                        Integer page,
                                        Integer tableSize,
                                        String sort) {

        Specification<User> spec = Specification.where(null);

        if (userLoginFilter != null && !userLoginFilter.isBlank()) {
            spec = spec.and(UserSpecification.userLoginLike(userLoginFilter));
        }
        if (sort != null && !sort.isBlank()) {
            return userRepository.findAll(spec, PageRequest.of(page, tableSize, Sort.by(sort)))
                    .map(UserDTO::new);
        }
        return userRepository.findAll(spec, PageRequest.of(page, tableSize))
                .map(UserDTO::new);
    }
}
