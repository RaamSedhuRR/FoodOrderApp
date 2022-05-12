package com.example.lifecycleapp.model;


import android.util.Log;

public class CMEmployee {
    public String empName;
    public String empEmail;
    public Integer type;

    public CMEmployee(String empName, String empEmail, Integer type) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.type = type;
    }

    public  void handleClick(){
        String TAG = "Employee Name";
        Log.d(TAG,this.empName);
    }
    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }


    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
