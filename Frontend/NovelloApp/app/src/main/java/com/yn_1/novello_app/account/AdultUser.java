package com.yn_1.novello_app.account;

import com.yn_1.novello_app.library.Book;

import java.io.Serializable;
import java.util.List;

public class AdultUser implements User, Serializable {

    String username;
    String password;
    UserType userType = UserType.ADULT;
    int id;

    /**
     * Constructor
     * @param username
     * @param password
     * @param id
     */
    public AdultUser(String username, String password, int id) {

        this.username = username;
        this.password = password;
        this.id = id;

    }

    @Override
    public void setUsername(String username) {

        this.username = username;

    }

    @Override
    public void setPassword(String password) {

        this.password = password;

    }

    @Override
    public void setUserType(UserType type) {

        this.userType = type;

    }

    @Override
    public int getUserId() {

        return id;

    }

    @Override
    public String getUsername() {

        return username;

    }

    @Override
    public String getPassword() {

        return password;

    }

    @Override
    public UserType getUserType() {

        return userType;

    }

    @Override
    public List<User> getFriends() {

        //store friends as sorted list
        return null;

    }

    @Override
    public List<Book> getLibrary() {

        //store library as sorted list
        return null;

    }

    @Override
    public String getUserUrlPath() {

        return null;

    }

    @Override
    public void addUserToFriendsList(User user) {



    }

}
