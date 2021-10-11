package com.ttn.spring.springRest.webServices.RestWebServices1.springWelcome;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Welcome to spring")
public class WelcomeToSpring {
    private String msg;

    public WelcomeToSpring(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
