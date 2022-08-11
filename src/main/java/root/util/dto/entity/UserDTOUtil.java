package root.util.dto.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import root.dto.entity.UserDTO;
import root.entity.User;




public class UserDTOUtil {
	
	public static UserDTO valueOf(User User) {
		
	     	Gson gson = new GsonBuilder().create();
	        String JSON = gson.toJson(User);
	        UserDTO userDTO = gson.fromJson(JSON, UserDTO.class);
	        return userDTO;
       
	} 
	

}
