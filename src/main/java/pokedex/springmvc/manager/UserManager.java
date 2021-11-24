package pokedex.springmvc.manager;

import java.util.List;
import com.pokedex.springmvc.view.UserViewImpl;

public interface UserManager {
	
	public UserViewImpl createUser(UserViewImpl user);
	public UserViewImpl findUserById(Integer userID);
	public Boolean isUserExist(UserViewImpl user);
	public UserViewImpl updateUser(UserViewImpl user);
	public void deleteUserById(Integer userID);
	public List<UserViewImpl> getAllUsers();
}
