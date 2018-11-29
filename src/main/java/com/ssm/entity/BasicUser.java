package com.ssm.entity;

import java.io.Serializable;
import java.util.Date;

public class BasicUser implements Serializable{

	private static final long serialVersionUID = 3812792947518747375L;

	/**
     * 主键自增
     */
    private Integer id;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 用户类型 0管理员1普通用户
     */
    private Integer utype;

    /**
     * 用户名
     */
    private String username;

    /**
     * MD5加密密码
     */
    private String password;

    /**
     * 头像
     */
    private String headimg;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮件地址
     */
    private String email;

    /**
     * 创建时间
     */
    private Date credate;

    /**
     * 更新时间
     */
    private Date upddate;

    /**
     * 主键自增
     * @return id 主键自增
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键自增
     * @param id 主键自增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户ID
     * @return userId 用户ID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 用户ID
     * @param userid 用户ID
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 用户类型 0管理员1普通用户
     * @return utype 用户类型 0管理员1普通用户
     */
    public Integer getUtype() {
        return utype;
    }

    /**
     * 用户类型 0管理员1普通用户
     * @param utype 用户类型 0管理员1普通用户
     */
    public void setUtype(Integer utype) {
        this.utype = utype;
    }

    /**
     * 用户名
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * MD5加密密码
     * @return password MD5加密密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * MD5加密密码
     * @param password MD5加密密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 头像
     * @return headimg 头像
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * 头像
     * @param headimg 头像
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    /**
     * 真实姓名
     * @return realname 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 真实姓名
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 性别
     * @return sex 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 手机号
     * @return mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 邮件地址
     * @return email 邮件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮件地址
     * @param email 邮件地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 创建时间
     * @return credate 创建时间
     */
    public Date getCredate() {
        return credate;
    }

    /**
     * 创建时间
     * @param credate 创建时间
     */
    public void setCredate(Date credate) {
        this.credate = credate;
    }

    /**
     * 更新时间
     * @return upddate 更新时间
     */
    public Date getUpddate() {
        return upddate;
    }

    /**
     * 更新时间
     * @param upddate 更新时间
     */
    public void setUpddate(Date upddate) {
        this.upddate = upddate;
    }

	@Override
	public String toString() {
		return "BasicUser [id=" + id + ", userid=" + userid + ", utype=" + utype + ", username=" + username
				+ ", password=" + password + ", headimg=" + headimg + ", realname=" + realname + ", sex=" + sex
				+ ", age=" + age + ", mobile=" + mobile + ", email=" + email + ", credate=" + credate + ", upddate="
				+ upddate + "]";
	}
    
}