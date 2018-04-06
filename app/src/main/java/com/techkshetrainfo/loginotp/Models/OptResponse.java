package com.techkshetrainfo.loginotp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OptResponse {

    @SerializedName("status")
    @Expose
    private Status status;

    @SerializedName("opt")
    @Expose
    private Opt opt;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Opt getOpt() {
        return opt;
    }

    public void setOpt(Opt opt) {
        this.opt = opt;
    }
}