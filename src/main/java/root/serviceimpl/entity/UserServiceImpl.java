package root.serviceimpl.entity;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import root.dto.entity.UserDTO;
import root.entity.User;
import root.repository.entity.IUserRepository;
import root.repositoryextended.entity.UserRepositoryExtended;
import root.service.entity.IUserService;
import root.util.dto.entity.UserDTOUtil;
import root.util.entity.UserUtil;

@Service
@Qualifier("user_service_impl_qualifier")
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {

	@Autowired
    private IUserRepository iUserRepository;
	
	@Autowired
    private UserRepositoryExtended userRepositoryExtended;	

	@Override
	@Transactional
	public UserDTO saveUser(
			UserDTO userDTO) {

		   if(userDTO == null) {
			   return null;
		   }
		   
		   User userToSave = UserUtil.valueOf(userDTO);
		   User userSaved = iUserRepository.save(userToSave);
		   
		   if(userSaved == null) {
			   
			   return null;
		   }

		   UserDTO userDTOToReturn = UserDTOUtil.valueOf(userSaved);

		return userDTOToReturn;
	}

	@Override
	public Boolean emailExists(String email) {
		
		User user = userRepositoryExtended.userByEmail(email);
		if(user == null) {
			return null;
		}
		
		if(user.getId() == null) {
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean emailExistsWithOtherId(String email, UUID id) {
		User user = userRepositoryExtended.userByEmailWithOtherId(email, id);
		if(user == null) {
			return null;
		}
		
		if(user.getId() == null) {
			return false;
		}
		

		
		System.out.println("El id  es: "+id);
		System.out.println("El id  es: "+user);
		return true;
	}

	@Override
	public UserDTO userByEmail(String email) {
		User user = userRepositoryExtended.userByEmail(email);
		if(user == null) {
			return null;
		}
		
		UserDTO userDTO = UserDTOUtil.valueOf(user);
		return userDTO;
		
	}

	


}
