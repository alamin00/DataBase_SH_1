package com.crackbrain.tanveen.database_sh_1;

/**
 * Created by Al on 1/19/2016.
 */
public class EmplyeData
{
    public  int id;
    private  String name,email,phone,address;


    public EmplyeData()
    {
    }

    public EmplyeData( int id,String name, String email, String phone, String address) {

        this.id = id;
        this.name = name;

       this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public EmplyeData(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmplyeData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
