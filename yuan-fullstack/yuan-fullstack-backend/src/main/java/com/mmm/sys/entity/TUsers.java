package com.mmm.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author mmm13123
 * @since 2022-10-16
 */
@TableName("t_users")
@ApiModel(value = "TUsers对象", description = "")
public class TUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;
    private String username;
    private String password;
    private String email;
    @TableField(exist = false)
    private String homeUrl;
    @TableField(exist = false)
    private String screenName;
    private Integer created;
    private Integer activated;
    private Integer logged;
    @TableField(exist = false)
    private String groupName;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public Integer getLogged() {
        return logged;
    }

    public void setLogged(Integer logged) {
        this.logged = logged;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "TUsers{" +
        ", uid = " + uid +
        ", username = " + username +
        ", password = " + password +
        ", email = " + email +
        ", homeUrl = " + homeUrl +
        ", screenName = " + screenName +
        ", created = " + created +
        ", activated = " + activated +
        ", logged = " + logged +
        ", groupName = " + groupName +
        "}";
    }
}
