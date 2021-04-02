package ru.geekbrains.controller.DTO;

import ru.geekbrains.persist.model.Product;
import ru.geekbrains.persist.model.Role;
import ru.geekbrains.persist.model.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class RoleDTO {

    @Id
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    private List<User> users;

    public RoleDTO() {
    }

    public RoleDTO(@NotEmpty String title, List<User> users) {
        this.title = title;
        this.users = users;
    }

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.title = role.getTitle();
        this.users = role.getUsers();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
