package com.techkshetrainfo.loginotp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by savsoft-3 on 31/1/17.
 */

public class ComplaintList {

    @SerializedName("complaint_id")
    @Expose
    private String complaintId;
    @SerializedName("complait_status")
    @Expose
    private String complaitStatus;

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaitStatus() {
        return complaitStatus;
    }

    public void setComplaitStatus(String complaitStatus) {
        this.complaitStatus = complaitStatus;
    }

}