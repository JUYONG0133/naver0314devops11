package data.dto;

import java.sql.Timestamp;

public class UserDto {
    private String userid;
    private String userpassword;
    private String username;
    private String usergender;
    private String carname;
    private String wheel;
    private String nav;
    private String carkey;
    private String caroption;
    private String etc;
    private Timestamp writeday;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsergender() {
        return usergender;
    }

    public void setUsergender(String usergender) {
        this.usergender = usergender;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getCarkey() {
        return carkey;
    }

    public void setCarkey(String carkey) {
        this.carkey = carkey;
    }

    public String getCaroption() {
        return caroption;
    }

    public void setCaroption(String caroption) {
        this.caroption = caroption;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public Timestamp getWriteday() {
        return writeday;
    }

    public void setWriteday(Timestamp writeday) {
        this.writeday = writeday;
    }
}
