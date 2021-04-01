package ru.geekbrains.persist.repo.services.users;

import ru.geekbrains.persist.model.Role;
import ru.geekbrains.persist.model.User;


import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    private Long id;


    private String login;


    private String password;


    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public UserDTO() {
    }

    public UserDTO(@NotEmpty String login, @NotEmpty Set<Role> roles) {
        this.login = login;
        this.roles = roles;
        this.password = password;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.roles = new HashSet<>(user.getRoles());
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
