package ru.geekbrains.persist.repo.services.users;

import ru.geekbrains.persist.model.User;

import javax.validation.constraints.NotEmpty;

public class UserRepr {

    private Long id;

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

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

    //    private Set<Role> roles;

    public UserRepr() {
    }

    public UserRepr(String login) {
        this.login = login;
        this.password = password;
    }

    public UserRepr(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
//        this.roles = new HashSet<>(user.getRoles());
    }



}
