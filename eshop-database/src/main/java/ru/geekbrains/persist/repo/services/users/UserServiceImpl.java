package ru.geekbrains.persist.repo.services.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.model.User;
import ru.geekbrains.persist.repo.UserRepository;
import ru.geekbrains.persist.repo.specification.UserSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserRepr> showAllUsers() {
        return userRepository.findAll().stream()
                .map(UserRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserRepr> findById(long id) {
        return userRepository.findById(id)
                .map(UserRepr::new);
    }

    @Override
    public void save(UserRepr user) {
//        User userToSave = new User(user);
//        userToSave.setPassword(passwordEncoder.encode(userToSave.getPassword()));
//        userRepository.save(userToSave);
//        if (user.getId() == null) {
//            user.setId(userToSave.getId());
//        }

    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<UserRepr> findWithFilter(String userLoginFilter,
                                         Integer page,
                                         Integer tableSize,
                                         String sort) {

        Specification<User> spec = Specification.where(null);

        if (userLoginFilter != null && !userLoginFilter.isBlank()) {
            spec = spec.and(UserSpecification.userLoginLike(userLoginFilter));
        }
        if (sort != null && !sort.isBlank()) {
            return userRepository.findAll(spec, PageRequest.of(page, tableSize, Sort.by(sort)))
                    .map(UserRepr::new);
        }
        return userRepository.findAll(spec, PageRequest.of(page, tableSize))
                .map(UserRepr::new);
    }
}
