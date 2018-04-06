package com.techkshetrainfo.loginotp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Navdeep on 12/16/2016.
 */

public class CategoryResponse {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("detail")
    @Expose
    private List<Detail> detail = null;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }

}