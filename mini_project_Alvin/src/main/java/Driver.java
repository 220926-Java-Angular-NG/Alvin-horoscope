import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.repos.UserRepo;
import com.revature.services.UserServices;
import com.sun.media.jfxmedia.AudioClip;
import io.javalin.Javalin;
import io.javalin.core.util.Header;
public class Driver {
    public static <Javelin> void main(String[] args) {
        System.out.println("Hello world!");

        Javalin app = Javalin.create(config->{config.enableCorsForAllOrigins();}).start(8080);

        UserController userController = new UserController();
        UserServices userServices = new UserServices();


        app.post("/user", userController.createNewUser);
        app.get("/users", userController.getAllUsers);
        app.get("/user/{id}",userController.getUserById);
        app.post("login", userController.logInUser);
        app.put("/user", userController.updateUserZodiac);
        app.delete("/user", userController.deleteUser);
        app.delete("/user/{id}", userController.deleteUserById);

//        User user = new User("Alvin",
//                "Stilley",
//                "AStilley",
//                "ASpassword",
//                "Capricorn");
//
//
//        System.out.println(user.getMood());
        //System.out.println(user.getUserName());//Test to see if User Model was correctly made


        //userRepo.create(user);//Test to see if create user worked.


    }

}