package com.example.lifecycleapp.utils;

import com.example.lifecycleapp.model.CMEmployee;

import java.util.ArrayList;
import java.util.List;

public class RequiredDataSet{

    public int i;

    public List<CMEmployee> employeeDetails = new ArrayList<>();


    public List<CMEmployee> employeeDetailsDuplicate= new ArrayList<>();

    public String[] employeeName={"Raam Sedhu RR", "Nandha Kumar", "Chaithanya", "Mohan", "Dhanasekar",
            "Stephan John", "Mani", "Kumar", "Babu", "Gokul", "Sumedh", "Gautham", "Subramani", "Siva",
            "Satheesh", "Somu", "Kavin", "Kavin Raja", "Raam Sedhu RR", "Nandha Kumar", "Chaithanya",
            "Mohan", "Dhanasekar", "Stephan John", "Mani", "Kumar", "Babu", "Gokul", "Sumedh", "Gautham",
            "Subramani", "Siva", "Satheesh", "Somu", "Kavin", "Kavin Raja", "Raam Sedhu RR",
            "Nandha Kumar", "Chaithanya", "Mohan", "Dhanasekar", "Stephan John", "Mani", "Kumar",
            "Babu", "Gokul", "Sumedh", "Gautham", "Subramani", "Siva", "Satheesh", "Somu", "Kavin",
            "Kavin Raja", "Raam Sedhu RR", "Nandha Kumar", "Chaithanya", "Mohan", "Dhanasekar",
            "Stephan John", "Mani", "Kumar", "Babu", "Gokul", "Sumedh", "Gautham", "Subramani", "Siva",
            "Satheesh", "Somu", "Kavin", "Kavin Raja", "Raam Sedhu RR", "Nandha Kumar", "Chaithanya",
            "Mohan", "Dhanasekar", "Stephan John", "Mani", "Kumar", "Babu", "Gokul", "Sumedh", "Gautham",
            "Subramani", "Siva", "Satheesh", "Somu", "Kavin", "Kavin Raja"};
    public List<CMEmployee> AddEmployees()
    {
        for(i=0;i<8;i++)

        {
            employeeDetails.add(getEmployeeItem("Raam Sedhu RR", 0, "rrraamcena2000@gmail.com"));
            employeeDetails.add(getEmployeeItem("Nandha", 0, "Nandha@gmail.com"));
            employeeDetails.add(getEmployeeItem("stephan", 0, "stephen@gmail.com"));
            employeeDetails.add(getEmployeeItem("John", 0, "John@gmail.com"));

        }
        return employeeDetails;
    }


    public List<CMEmployee> AddEmployees1(){

        for(i=0;i<2;i++)

        {
            employeeDetailsDuplicate.add(getEmployeeItem("Nandha", 1, "Nandha@gmail.com"));
            employeeDetailsDuplicate.add(getEmployeeItem("stephan", 1, "stephen@gmail.com"));
            employeeDetailsDuplicate.add(getEmployeeItem("John", 1, "John@gmail.com"));
            employeeDetailsDuplicate.add(getEmployeeItem("Raam Sedhu RR", 1,
                                                         "rrraamcena2000@gmail.com"));

        }
        return employeeDetailsDuplicate;
    }

    private CMEmployee getEmployeeItem(String name, Integer type, String email){
        return new CMEmployee(
                name,
                email,
                type
        );


    }
}