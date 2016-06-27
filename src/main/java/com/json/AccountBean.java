package com.json;

/**
 * Created by Eric on 2016/6/20.
 */
public class AccountBean {

    private int id;
    private String address;
    private String name;
    private String email;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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
    @Override
    public String toString() {
        return "AccountBean [id=" + id + ", address=" + address + ", name=" + name + ", email=" + email + "]";
    }

}
