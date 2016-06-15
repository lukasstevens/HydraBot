/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corbi.robot.objects;

import com.corbi.robot.main.Main;
import sx.blah.discord.handle.obj.IUser;

/**
 * identifies a user that ever was or is currently on the server
 * @author PogChamp
 */
public class User{
private long uptime;
private String id;
private String guildID;
private IUser iUser;
private final long loginTime;

    public User(long uptime, String id, String guildID) {
        this.uptime = uptime;
        this.id = id;
        this.iUser = Main.client.getUserByID(id);
        this.loginTime = System.currentTimeMillis();
    }

    public long getLoginTime() {
        return loginTime;
    }

    public String getGuildID() {
        return guildID;
    }

    public void setGuildID(String guildID) {
        this.guildID = guildID;
    }

    public IUser getiUser() {
        return iUser;
    }

    public void setiUser(IUser iUser) {
        this.iUser = iUser;
    }

    public long getUptime() {
        return uptime;
    }
    /**
     * sets the uptime of the user
     * also updates the database
     * @param uptime new uptime
     */
    public void setUptime(long uptime) {
        this.uptime = uptime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IUser getIUser() {
        return iUser;
    }

    public void setIUser(IUser iUser) {
        this.iUser = iUser;
    }

}
