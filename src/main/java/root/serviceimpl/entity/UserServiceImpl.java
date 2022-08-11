package root.serviceimpl.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import root.dto.entity.UserDTO;
import root.entity.User;
import root.repository.entity.IUserRepository;
import root.service.entity.IUserService;
import root.util.dto.entity.UserDTOUtil;
import root.util.entity.UserUtil;

@Service
@Qualifier("user_service_impl_qualifier")
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {

	@Autowired
    private IUserRepository iUserRepository;

	@Override
	@Transactional
	public UserDTO saveDTO(
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

	


}
