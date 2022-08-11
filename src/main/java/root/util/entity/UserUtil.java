package root.util.entity;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import root.dto.entity.UserDTO;
import root.entity.User;




public class UserUtil {
	
	public static User valueOf(UserDTO UserDTO) {
		
	     	Gson gson = new GsonBuilder().create();
	        String JSON = gson.toJson(UserDTO);
	        User user = gson.fromJson(JSON, User.class);
	        return user;
       
	} 
	

}
