package com.spring.backend.model;

public class ChangePass {
    private int idCus;
    private String pass;
    private String newpass;
    private String repeat;

    public ChangePass(int idCus, String pass, String newpass, String repeat) {
        this.idCus = idCus;
        this.pass = pass;
        this.newpass = newpass;
        this.repeat = repeat;
    }

    public int getIdCus() {
        return idCus;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }
}
