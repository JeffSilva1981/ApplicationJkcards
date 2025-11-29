package com.jkcards.ecommerce.DTO;


import com.jkcards.ecommerce.services.validation.UserUpdateValid;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO{

    private String password;

    public UserUpdateDTO(){
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
