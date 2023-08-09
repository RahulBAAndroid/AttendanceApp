package com.example.attendenceapplication;

import android.util.Log;

public class SeeInfoModule {
    public SeeInfoModule() {}

    public SeeInfoModule(String name, String address, String mobile, String id, long absentCount, long presentCont, long leaveCount) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.id = id;
        this.absentCount = absentCount;
        this.presentCont = presentCont;
        this.leaveCount = leaveCount;
    }

    String name,address,mobile,id,present;
    long absentCount, presentCont, leaveCount;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAbsentCount(long absentCount) {
        this.absentCount = absentCount;
    }

    public void setPresentCont(long presentContt) {
        String prresent=""+ presentContt;
        this.present = prresent;
    }

    public void setLeaveCount(long leaveCount) {
        this.leaveCount = leaveCount;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getId() {
        return id;
    }

    public long getAbsentCount() {
        return absentCount;
    }

    public String getPresentCont() {
        return present;
    }

    public long getLeaveCount() {
        return leaveCount;
    }



}
