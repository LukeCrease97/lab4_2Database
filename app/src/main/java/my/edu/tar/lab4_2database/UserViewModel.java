package my.edu.tar.lab4_2database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

//TODO 7: Create an Android View Model class to link data to UI

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<User>> allUsers; // A cache copy of record

    public UserViewModel(@NonNull Application application) {
        super(application);
        //create a instance of the repository
        userRepository = new UserRepository(application);
        //retrieve all user records
        allUsers = userRepository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {

        return allUsers;
    }

    public  void insertUser(User user){

        userRepository.insertUser(user);
    }
}
