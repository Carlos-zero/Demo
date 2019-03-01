package servlet;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String telephone;
    private String user_name;
    private String password;
    private String sex;
    private String birthday;
    private String location;
    private String personalized_signature;
    private String qq;
    private String email;
    private String relationship_status;
    private String hobby;
    
/*    private String attention;
    private String fans;
    private String micro_blog;*/

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPersonalized_signature() {
        return personalized_signature;
    }

    public void setPersonalized_signature(String personalized_signature) {
        this.personalized_signature = personalized_signature;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelationship_status() {
        return relationship_status;
    }

    public void setRelationship_status(String relationship_status) {
        this.relationship_status = relationship_status;
    }

    /*public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getMicro_blog() {
        return micro_blog;
    }

    public void setMicro_blog(String micro_blog) {
        this.micro_blog = micro_blog;
    }*/

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /*public String getHobby1() {
        return hobby1;
    }

    public void setHobby1(String hobby1) {
        this.hobby1 = hobby1;
    }

    public String getHobby2() {
        return hobby2;
    }

    public void setHobby2(String hobby2) {
        this.hobby2 = hobby2;
    }

    public String getHobby3() {
        return hobby3;
    }

    public void setHobby3(String hobby3) {
        this.hobby3 = hobby3;
    }

    public String getHobby4() {
        return hobby4;
    }

    public void setHobby4(String hobby4) {
        this.hobby4 = hobby4;
    }

    
    private String hobby1;
    private String hobby2;
    private String hobby3;
    private String hobby4;*/

    public User() {
    }

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
