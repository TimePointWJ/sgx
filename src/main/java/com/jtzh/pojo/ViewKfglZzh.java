package com.jtzh.pojo;

import java.io.Serializable;

/**
 * ClassName: ViewKfglZzh <br/>
 * Function: 子账号实体. <br/>
 * Date: 2017年4月13日 下午4:20:53 <br/>
 *
 * @author zhucb
 * @version 1.0
 * @since JDK 1.7
 */
public class ViewKfglZzh implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /** 账号 */
    private String zh;

    /** 用户名 */
    private String username;

    /** 昵称 */
    private String nickname;

    /** 登录名 */
    private String loginname;

    /**
     * 账号
     *
     * @return zh
     */
    public String getZh() {
        return zh;
    }

    /**
     * 账号
     *
     * @param zh 账号
     */
    public void setZh(String zh) {
        this.zh = zh;
    }

    /**
     * 用户名
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 昵称
     *
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 登录名
     *
     * @return loginname
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * 登录名
     *
     * @param loginname 登录名
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

}
