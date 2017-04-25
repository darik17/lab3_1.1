package main.models.pojo;

/**
 * Created by admin on 22.04.2017. 1
 */
public class Person {
    private int person_id;
    private String fio;
    private String email;
    private String phone;
    private String nickname;
    private String password;
    private boolean moderator;

    public Person(){

    }

    public Person(int person_id, String fio, String email, String phone, String nickname, String password, boolean moderator) {
        this.person_id = person_id;
        this.fio = fio;
        this.email = email;
        this.phone = phone;
        this.nickname = nickname;
        this.password = password;
        this.moderator = moderator;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isModerator() {
        return moderator;
    }

    public void setModerator(boolean moderator) {
        this.moderator = moderator;
    }
}
