package com.example.android.basicblocks;

import java.io.Serializable;

/**
 * Created by pc on 11/26/2017.
 */

public class Users implements Serializable {
    String name;
    String lastname;
    String username;
    boolean isMale;

    public Users() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMale(boolean male) {
        isMale = male;

    }

    @Override
    public String toString() {
        return username;
    }
}
