package com.techkshetrainfo.loginotp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by savsoft-3 on 31/1/17.
 */

public class ComplaintListResponse {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("complaintList")
    @Expose
    private List<ComplaintList> complaintList = null;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ComplaintList> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<ComplaintList> complaintList) {
        this.complaintList = complaintList;
    }

}
