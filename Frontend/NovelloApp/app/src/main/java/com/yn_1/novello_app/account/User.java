package com.yn_1.novello_app.account;

import com.yn_1.novello_app.book.Book;

import java.util.List;

/**
 * User interface <br>
 * The creation of a user account should be done in user implementation constructor.
 * @author Roba Abbajabal
 */
public interface User {

    void setUsername(String username);
    void setPassword(String password);
    void setUserType(UserType type);


    int getUserId();
    String getUsername();
    String getPassword();
    UserType getUserType();
    List<User> getFriends();
    List<Book> getLibrary();
    String getUserUrlPath();


    void addUserToFriendsList(User user);
}
