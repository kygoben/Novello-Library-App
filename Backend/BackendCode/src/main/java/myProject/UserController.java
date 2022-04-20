package myProject;

import io.swagger.annotations.*;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@Api(value = "UserController")
@RestController
public class UserController {

    @Autowired
	UserInterface db;

    @Autowired
    UserInfoInterface userInfoInterfaceDB;

    @ApiOperation(value = "Get a user from a userID", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/user/{id}")
	User getUser(@ApiParam(value = "ID of the user you are looking for") @PathVariable Integer id) {
        return db.findById(id).
                orElseThrow(RuntimeException::new);
    }

    @ApiOperation(value = "Gets the username if login is successful", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/login")
    JSONObject login(@ApiParam (value = "json opject that has the username and password entered by user to check if they can log in")@RequestBody JSONObject json){

        User user;
        JSONObject jsonReturn = new JSONObject();
        int i;
        for(i = 1; i<=db.count(); i++){
            user = db.findById(i).orElseThrow(RuntimeException::new);
            if(user.username.equals(json.getAsString("username"))){
                if(user.password.equals(json.getAsString("password"))){
                    jsonReturn.put("userId",i);
                    return jsonReturn;
                }
            }
        }
        return null;
    }

    @ApiOperation(value = "Creates all the users at once and adds them to the data base", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/addAllUsers")
    void createAllPersons(@ApiParam (value = "All of the users jsonObjects")@RequestBody JSONObject[] jsonObject) {
        for(int i = 0; i < jsonObject.length; i++)
        {
            User u = new User();
            u.setAccountType((Integer) jsonObject[i].getAsNumber("accountType"));
            u.setUsername(jsonObject[i].getAsString("username"));
            u.setPassword(jsonObject[i].getAsString("password"));
            u.setSecurityQuestion(jsonObject[i].getAsString("securityQuestion"));
            u.setSecurityAnswer(jsonObject[i].getAsString("securityAnswer"));

            UserInfo ui = new UserInfo();
            ui.setUser(u);
            ui.setAge((Integer) jsonObject[i].getAsNumber("age"));
            ui.setEmail(jsonObject[i].getAsString("email"));
            ui.setName(jsonObject[i].getAsString("name"));

            u.setUserInfo(ui);

            db.save(u);
            userInfoInterfaceDB.save(ui);
        }
    }
    @ApiOperation(value = "Gets all users", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/users")//was request mapping
    List<User> getPersons() {
        return db.findAll();
    }

    @ApiOperation(value = "Creates a specific user", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/user")
	User createPerson(@ApiParam (value = "jsonObject with all of the info of a user", example = "{foo: whatever, bar: whatever2}") @RequestBody JSONObject jsonObject) {
        User u = new User();
        u.setAccountType((Integer) jsonObject.getAsNumber("accountType"));
        u.setUsername(jsonObject.getAsString("username"));
        u.setPassword(jsonObject.getAsString("password"));
        u.setSecurityQuestion(jsonObject.getAsString("securityQuestion"));
        u.setSecurityAnswer(jsonObject.getAsString("securityAnswer"));

        UserInfo ui = new UserInfo();
        ui.setUser(u);
        ui.setAge((Integer) jsonObject.getAsNumber("age"));
        ui.setEmail(jsonObject.getAsString("email"));
        ui.setName(jsonObject.getAsString("name"));

        u.setUserInfo(ui);

        db.save(u);
        userInfoInterfaceDB.save(ui);
        return u;
    }
    @ApiOperation(value = "updating a user via a userID", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping("/user/{id}")
	User updatePerson(@ApiParam (value = "The Jason object of the updated person")@RequestBody JSONObject jsonObject, @ApiParam (value = "The ID of the person we are updating")@PathVariable Integer id) {
        User old_u = db.findById(id).orElseThrow(RuntimeException::new);
        UserInfo old_ui = old_u.getUserInfo();
        if (jsonObject.getAsString("name") != null)
            old_ui.setName(jsonObject.getAsString("name"));
        if ((Integer) jsonObject.getAsNumber("accountType") != null)
            old_u.setAccountType((Integer) jsonObject.getAsNumber("accountType"));
        if (jsonObject.getAsString("username") != null)
            old_u.setUsername(jsonObject.getAsString("username"));
        if (jsonObject.getAsString("password") != null)
            old_u.setPassword(jsonObject.getAsString("password"));
        if (jsonObject.getAsString("securityAnswer")!= null)
            old_u.setSecurityAnswer(jsonObject.getAsString("securityAnswer"));
        if (jsonObject.getAsString("securityQuestion") != null)
            old_u.setSecurityQuestion(jsonObject.getAsString("securityQuestion"));
        if (jsonObject.getAsString("email") != null)
            old_ui.setEmail(jsonObject.getAsString("email"));
        if ((Integer) jsonObject.getAsNumber("age") != null)
            old_ui.setAge((Integer) jsonObject.getAsNumber("age"));
        db.save(old_u);
        userInfoInterfaceDB.save((old_ui));
        return old_u;
    }

    @ApiOperation(value = "Deletes a user from a userID", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/user/{id}")
    String deletePerson(@ApiParam (value = "The ID of the user you want to delete")@PathVariable Integer id) {
        db.deleteById(id);
        return "deleted " + id;
    }



}
