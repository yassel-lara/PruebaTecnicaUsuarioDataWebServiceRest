package root.service.entity;


import java.util.UUID;

import root.dto.entity.UserDTO;



public interface IUserService {
	

	public UserDTO saveUser(UserDTO userDTO);
	public Boolean emailExists(String email);
	public Boolean emailExistsWithOtherId(String email, UUID id);
	public UserDTO userByEmail(String email);

}
