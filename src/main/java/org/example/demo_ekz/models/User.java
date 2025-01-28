package org.example.demo_ekz.models;

public class User {
    private Integer userID; // Идентификатор пользователя
    private String fio; // ФИО пользователя
    private String phone; // Телефон пользователя
    private String login; // Логин пользователя
    private String password; // Пароль пользователя
    private String type; // Тип пользователя

    // Конструктор без параметров
    public User() {
    }

    // Конструктор для создания нового пользователя
    public User(String login, String password, String fio, String phone, String type) {
        this.login = login;
        this.password = password;
        this.fio = fio;
        this.phone = phone;
        this.type = type;
    }

    // Конструктор для получения пользователя из базы данных (с userID)
    public User(Integer userID, String fio, String phone, String login, String password, String type) {
        this.userID = userID;
        this.fio = fio;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.type = type;
    }

    // Геттеры и сеттеры
    public Integer getUserID() {
        return userID; // Возвращает идентификатор пользователя
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getFio() {
        return fio; // Возвращает ФИО пользователя
    }

    public void setFio(String fio) {
        this.fio = fio; // Устанавливает ФИО пользователя
    }

    public String getPhone() {
        return phone; // Возвращает номер телефона пользователя
    }

    public void setPhone(String phone) {
        this.phone = phone; // Устанавливает номер телефона пользователя
    }

    public String getLogin() {
        return login; // Возвращает логин пользователя
    }

    public void setLogin(String login) {
        this.login = login; // Устанавливает логин пользователя
    }

    public String getPassword() {
        return password; // Возвращает пароль пользователя
    }

    public void setPassword(String password) {
        this.password = password; // Устанавливает пароль пользователя
    }

    public String getType() {
        return type; // Возвращает тип пользователя
    }

    public void setType(String type) {
        this.type = type; // Устанавливает тип пользователя
    }
}