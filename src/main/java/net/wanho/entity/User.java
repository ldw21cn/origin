package net.wanho.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {


//    @NotBlank(message = "Username can not be empty")
//    private String username;
//    @NotBlank(message = "password can not be blank")
//    @Length(min = 6, max = 16, message = "The length of the password must be between 6 and 16
//            bits")
//   private String password;
//   @Range(min = 18, max = 60, message = "Age must be between 18 and 60 years old")
//    private Integer age;
//     @Pattern(regexp = "^1[3|4|5|7|8][0-9]{9}$", message = "Please enter the correct format of the phone number")
//    private String phone;
//    @Email(message = "Please enter a valid email address")
//    private String email;

    private int id;

    @NotNull
    private String account;
//    @Length(min = 6, max = 16, message = "The length of the password must be between 6 and 16 bits")
    private String passwd;
    private Date regDate;
    private Date lastLoginDate;


    public User() {
    }

    public User(int id, String account, String passwd, Date regDate, Date lastLoginDate) {
        this.id = id;
        this.account = account;
        this.passwd = passwd;
        this.regDate = regDate;
        this.lastLoginDate = lastLoginDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
