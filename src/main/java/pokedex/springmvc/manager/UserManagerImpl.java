package pokedex.springmvc.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.pokedex.springmvc.model.User;
import com.pokedex.springmvc.service.UserServiceImpl;
import com.pokedex.springmvc.view.UserViewImpl;

public class UserManagerImpl implements UserManager {
	
	@Autowired
	private UserServiceImpl userService;

	public UserViewImpl convertToView(User user) {
		UserViewImpl userView = new UserViewImpl();
		BeanUtils.copyProperties(user, userView);
		return userView;
	}
	
	// (Integer id, String username, String email, String password, String switchfc, String threedsfc)
	public User convertToImpl (UserViewImpl user) {
		User userImpl = new User();
		BeanUtils.copyProperties(user, userImpl);
		return userImpl;
	}
	
	@Override
	public UserViewImpl createUser(UserViewImpl user) {
		User userImpl = convertToImpl(user);
		User serviceUserImpl = userService.createUser(userImpl);
		UserViewImpl retUserView = convertToView(serviceUserImpl);
		return retUserView;
	}

	@Override
	public UserViewImpl findUserById(Integer userID) {
		User userImpl = userService.findById(userID);
		UserViewImpl userView = convertToView(userImpl);
		return userView;
	}

	@Override
	public Boolean isUserExist(UserViewImpl user) {
		User userImpl = convertToImpl(user);
		return userService.isUserExist(userImpl);
	}

	@Override
	public UserViewImpl updateUser(UserViewImpl user) {
		User userImpl = convertToImpl(user);
		User updatedUserImpl = userService.updateUser(userImpl);
		UserViewImpl userView = convertToView(updatedUserImpl);
		return userView;
	}

	@Override
	public void deleteUserById(Integer id) {
		userService.deleteUserById(id);
	}

	@Override
	public List<UserViewImpl> getAllUsers() {
		List<User> userList = userService.findAllUsers();
		List<UserViewImpl> userViewList = new ArrayList<UserViewImpl>();
		for (User user : userList) {
			UserViewImpl userView = new UserViewImpl();
			BeanUtils.copyProperties(user, userView);
			userViewList.add(userView);
		}
		return userViewList;
	}

}
