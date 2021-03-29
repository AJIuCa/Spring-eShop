package ru.geekbrains.persist.repo.services.users;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserRepr> showAllUsers();

    Optional<UserRepr> findById(long id);

    void save(UserRepr user);

    void delete(long id);

    Page<UserRepr> findWithFilter(String usernameFilter,Integer page, Integer tableSize, String sort);
}
