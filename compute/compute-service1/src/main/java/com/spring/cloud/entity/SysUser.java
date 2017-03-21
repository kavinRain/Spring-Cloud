package com.spring.cloud.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/3/21.
 */
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "user_name", columnDefinition = "用户名",nullable = false)
    private String userName;

    @Column(name = "password", columnDefinition = "密码")
    private String password;

    @Column(name = "real_name", columnDefinition = "真实姓名")
    private String realName;

    @Column(name = "mobile_phone", columnDefinition = "手机号")
    private String mobilePhone;

    @Column(name = "email", columnDefinition = "邮箱")
    private String email;

    @Column(name = "is_valid", columnDefinition = "是否是有效的")
    private Boolean isValid;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }
}
