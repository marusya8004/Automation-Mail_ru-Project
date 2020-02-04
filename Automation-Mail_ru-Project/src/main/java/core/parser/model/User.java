package core.parser.model;

public class User {
    private int id;
    private String login;
    private String password;
    private String e_mail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    @Override
    public String toString() {
        return "model.User: ID=" + this.id + " Login=" + this.login + " Password="
                + this.password + " E_mail=" + this.e_mail;
    }


}
