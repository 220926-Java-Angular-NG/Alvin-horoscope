package com.revature.controllers;

import com.revature.models.CurrentUser;
import com.revature.models.User;
import com.revature.services.UserServices;
import io.javalin.http.Handler;
import org.omg.CORBA.Current;

public class UserController {

    UserServices service;

    public UserController()
    {
        service = new UserServices();
    }
    public UserController(UserServices userService)
    {
        service = userService;
    }

    public Handler createNewUser = context->
    {
        User user = context.bodyAsClass(User.class);
        int id = service.createUser(user);

        if (id>0)
        {
            user.setUserId(id);
            context.json(user).status(200);
        }
        else
            context.result("User not created").status(400);
    };
    public Handler getAllUsers = context ->
    {
        System.out.println("Testing Get all");
        context.json(service.getAllUsers());
    };
    public Handler getUserById = context ->
    {
        String param = context.pathParam("id");
        User user = context.bodyAsClass(User.class);

        try
        {
            int id = Integer.parseInt(param);
            user = service.getUserById(id);

            if(user != null)
                context.json(user).status(200);
            else
                context.result("User not found").status(400);
        }
        catch(NumberFormatException numberFormatException)
        {
            System.out.println(numberFormatException.getMessage());
        }
    };
    public Handler logInUser = context->
    {
        User user = context.bodyAsClass(User.class);
        user = service.logInUser(user);

        if(user != null)
        {
            CurrentUser.currentUser = user;
            System.out.println(CurrentUser.currentUser.getFirstName());
            context.json(user);
        }
        else
            context.result("Incorrect user name or password").status(404);
    };
    public Handler updateUserZodiac = context->
    {
        System.out.println("Caught In controller");
      User user = context.bodyAsClass(User.class);
      user = service.updateUser(user);

      if(user != null)
          context.json(user).status(200);
      else
          context.result("Can't update user").status(400);
    };
    public Handler deleteUser = context ->
    {
        User user = context.bodyAsClass(User.class);

        if(user != null)
            context.status(200).json(service.deleteUser(user));
        else
            context.status(400).result("Can't delete the user");
    };
    public Handler deleteUserById = context->
    {
        String param = context.pathParam("id");
        try
        {
            int id = Integer.parseInt(param);
            context.json(service.deleteUserById(id)).status(200);
        }
        catch(NumberFormatException numberFormatException)
        {
            System.out.println(numberFormatException.getMessage());
        }
    };
}
