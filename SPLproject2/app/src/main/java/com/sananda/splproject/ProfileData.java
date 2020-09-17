package com.sananda.splproject;

public class ProfileData {
     String Name;

     String Address;
     String Phone;
     String Length;
     String Body;

    public ProfileData()
     {

     }

    ProfileData(String Name,String Address,String Phone,String Length,String Body)
    {
        this.Name=Name;
        this.Address=Address;
        this.Phone=Phone;
        this.Length=Length;
        this.Body=Body;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLength() {
        return Length;
    }

    public void setLength(String length) {
        Length = length;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }
}
