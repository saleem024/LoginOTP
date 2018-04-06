package com.techkshetrainfo.loginotp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by savsoft-3 on 31/1/17.
 */

public class ComplaintDetailResponse {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("complaintdetail")
    @Expose
    private Complaintdetail complaintdetail;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Complaintdetail getComplaintdetail() {
        return complaintdetail;
    }

    public void setComplaintdetail(Complaintdetail complaintdetail) {
        this.complaintdetail = complaintdetail;
    }

}
